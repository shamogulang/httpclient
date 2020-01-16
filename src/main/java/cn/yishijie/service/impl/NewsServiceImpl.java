package cn.yishijie.service.impl;

import cn.yishijie.common.NewsReqDto;
import cn.yishijie.common.NewsRespDto;
import cn.yishijie.domain.NewsEntity;
import cn.yishijie.service.NewsService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author chenjianhui on 2020/01/16
 */
@Service
public class NewsServiceImpl implements NewsService {

    //说明：这里是因为为了简便，没有引入数据库和redis,我这里直接用
    //线程安全的类（防止并发出现问题），用于模拟实际生活中的项目

    //存问题的内容和pk
    private Map<String,String> contentMap = null;
    //新闻的PK
    private List<Long> newsPkList = null;
    //用于产生新闻的pk
    private AtomicLong newsPk = null;
    //用于序列化
    ObjectMapper objectMapper = null;
    @PostConstruct
    private void init(){

        //存问题的内容和pk
        contentMap = new ConcurrentHashMap<>();
        //新闻的PK
        newsPkList = new CopyOnWriteArrayList<>();
        //用于产生新闻的pk
        newsPk = new AtomicLong(1L);

        objectMapper = new ObjectMapper();
        //当json串中有不知道的字段，直接忽略（如果不设置的话，如果出现跟实体类不同的字段，会抛出异常）
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,true);
    }

    @Override
    public NewsRespDto getNewsDetail(long newsPk) {
        NewsRespDto newsRespDto = null;
        if(null == contentMap){
            return newsRespDto;
        }
        String  result = contentMap.get(String.valueOf(newsPk));
        try {
          NewsEntity newsEntity   = objectMapper.readValue(result, NewsEntity.class);
          if(null != newsEntity){
              newsRespDto = new NewsRespDto(newsEntity);
          }
        }catch (Exception e){
           ;
        }
        return newsRespDto;
    }

    @Override
    public void addNews(NewsReqDto newsReqDto) {
        if(null == contentMap){
            return ;
        }

        long generateNewsPk = newsPk.get();
        NewsEntity newsEntity = new NewsEntity(newsReqDto,generateNewsPk);
        try {
            contentMap.put(String.valueOf(generateNewsPk),objectMapper.writeValueAsString(newsEntity));
            //增加pk,用于下一个请求过来时，设置新闻的pk
            newsPk.incrementAndGet();
        }catch (Exception e){
            ;
        }
    }
}
