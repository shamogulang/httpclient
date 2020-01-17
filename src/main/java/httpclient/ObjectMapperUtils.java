package httpclient;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author jeffchan 2020/01/16
 */
public class ObjectMapperUtils {

    private static ObjectMapper objectMapper = null;

    static {
        objectMapper = new ObjectMapper();
        //忽略调json串中多余的字段（如果不加，json串中多出字段时会抛出异常）
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,true);
    }

    public static ObjectMapper  getObjectMapper(){
        return objectMapper;
    }
}
