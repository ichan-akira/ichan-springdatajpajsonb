package moe.ichan.springdatajpajsonb.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import org.springframework.util.StringUtils;

@UtilityClass
public class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public <T> T parseJsonOrDefault(String json, Class<T> clazz, T defaultValue) throws JsonProcessingException {
        if (!StringUtils.hasText(json)) {
            return defaultValue;
        }
        return objectMapper.readValue(json, clazz);
    }
}
