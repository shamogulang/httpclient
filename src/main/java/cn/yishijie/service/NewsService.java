package cn.yishijie.service;

import cn.yishijie.common.NewsReqDto;
import cn.yishijie.common.NewsRespDto;

/**
 * @author chenjianhui on 2020/01/16
 */
public interface NewsService {

     NewsRespDto getNewsDetail(long newsPk);

     long addNews(NewsReqDto newsReqDto);
}
