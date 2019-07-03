package cn.len.spring.cloud.earth;

import feign.FeignException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

/**
 * @author len
 * 2019-07-03
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(FeignException.class)
    public Map<String,Object> feignException(FeignException ex) {
        ex.printStackTrace();
        return Map.of("meessage", "error");
    }
}
