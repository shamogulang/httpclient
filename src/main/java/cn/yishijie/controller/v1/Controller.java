package cn.yishijie.controller.v1;

import cn.yishijie.apibean.v1.NewsReq;
import cn.yishijie.apibean.v1.NewsResp;
import cn.yishijie.common.NewsReqDto;
import cn.yishijie.common.NewsRespDto;
import cn.yishijie.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author chenjianhui on 2020/01/16
 */
@RestController
@RequestMapping(value = "/v1")
public class Controller {


    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/news/{newsPk}",method = RequestMethod.GET)
    public ResponseEntity<?>  getNewsDetails(@PathVariable long newsPk,@RequestHeader HttpHeaders headers){
        NewsResp newsResp = null;
        NewsRespDto newsRespDto = newsService.getNewsDetail(newsPk);
        if(newsRespDto != null){
            newsResp = new NewsResp(newsRespDto);
        }
        return new ResponseEntity<>(newsResp, HttpStatus.OK);
    }

    @RequestMapping(value = "/news/add",method = RequestMethod.POST)
    public ResponseEntity<?>  createdNews(@RequestBody NewsReq newsReq, @RequestHeader HttpHeaders headers){
        newsService.addNews(new NewsReqDto(newsReq));
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
}
