package httpclient;

import cn.yishijie.apibean.v1.NewsResp;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.utils.HttpClientUtils;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jeffchan 2020/01/16
 */
public class Client {

    public static void main(String[] args) throws  Exception{
        Map<String,Object> params = new HashMap<>();
        params.put("content","而我已经分不清，你是友情，还是错过的爱情");
        params.put("title","蒲公英的约定");
        String result = HttpclientUtils.httpPost("http://localhost:8887/v1/news/add",null,params, Charset.forName("UTF-8"));
        System.out.println(result);

//        String result = HttpclientUtils.httpGet("http://localhost:8887/v1/news/1", null, null);
//        ObjectMapper objectMapper = ObjectMapperUtils.getObjectMapper();
//        NewsResp newsResp = objectMapper.readValue(result, NewsResp.class);
//        System.out.println(newsResp);
    }
}
