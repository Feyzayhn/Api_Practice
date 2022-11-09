package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtil {
    //new ObjectMapper().readValue(jsonInString, HashMap.class);

    private static final ObjectMapper mapper; //final

    static {

        mapper = new ObjectMapper();
    }

    public static <T> T convertJsonToJava(String json, Class<T> cls) { // Generic -> Method json'i java'ya cevir

        // T javaResult = null;
        T javaResult;
        try {
            javaResult = mapper.readValue(json, cls);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return javaResult;
    }

}