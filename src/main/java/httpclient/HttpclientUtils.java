package httpclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author jeffchan 2020/01/16
 */
public class HttpclientUtils {

    private static Logger logger = LoggerFactory.getLogger(HttpclientUtils.class);
    private static CloseableHttpResponse httpResponse = null;
    private static CloseableHttpClient httpClient = null;

    static {
        httpClient = HttpClients.createDefault();
    }

    public static String httpPost(String url, Map<String, String> headers, Map<String, Object> params, Charset charset) {
        String result = null;
        try {
            URI uri = new URIBuilder().setPath(url).build();
            HttpPost httpPost = new HttpPost(uri);
            StringEntity stringEntity = new StringEntity(ObjectMapperUtils.getObjectMapper().writeValueAsString(params), charset);
            httpPost.setEntity(stringEntity);
            if (headers != null && !headers.isEmpty()) {
                headers.forEach((x, y) -> {
                    httpPost.addHeader(x, y);
                });
            }

            httpPost.addHeader("content-type","application/json");

            httpResponse = httpClient.execute(httpPost);
            if (httpResponse != null) {
                HttpEntity httpEntity = httpResponse.getEntity();
                if (httpEntity != null) {
                    result = EntityUtils.toString(httpEntity);
                }
            }
        } catch (Exception e) {
            logger.error("httpPost error,for details:", e);
        } finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (Exception e) {
                    ;
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (Exception e) {
                    ;
                }
            }
        }
        return result;
    }

    public static String httpGet(String url, Map<String, String> headers, Map<String, String> params) {
        //返回的json串
        String result = null;
        try {
            URIBuilder uriBuilder = new URIBuilder().setPath(url);

            //设置get后面的参数
            List<NameValuePair> nameValuePairs = new ArrayList<>();
            if (params != null && !params.isEmpty()) {
                for (String key : params.keySet()) {
                    String value = params.get(key);
                    nameValuePairs.add(new BasicNameValuePair(key, value));
                }
            }
            if (!nameValuePairs.isEmpty()) {
                uriBuilder.addParameters(nameValuePairs);
            }

            HttpGet httpGet = new HttpGet(uriBuilder.build());

            //设置header
            if (headers != null && !headers.isEmpty()) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    httpGet.addHeader(entry.getKey(), entry.getValue());
                }
            }
            httpResponse = httpClient.execute(httpGet);
            if (httpResponse != null) {
                HttpEntity httpEntity = httpResponse.getEntity();
                if (httpEntity != null) {
                    result = EntityUtils.toString(httpEntity);
                }
            }
        } catch (Exception e) {
            logger.error("httpGet error, for details:", e);
        } finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (Exception e) {
                    ;
                }
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (Exception e) {
                    ;
                }
            }
        }
        return result;
    }
}
