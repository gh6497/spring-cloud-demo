package cn.len.spring.cloud.earth;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author len
 * 2019-07-03
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(UnFallbackFeignException.class)
    public void feignException(UnFallbackFeignException ex, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.getWriter().write(ex.contentUTF8());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,Object> resourceNotFoundException(ResourceNotFoundException ex, ServletWebRequest webRequest) throws IOException {
        final HttpServletRequest request = webRequest.getRequest();
        final Map<String,Object> error = new LinkedHashMap<>();
        error.put("timestamp", Instant.now());
        error.put("status", HttpStatus.NOT_FOUND.value());
        error.put("error",   HttpStatus.NOT_FOUND.getReasonPhrase());
        error.put("message", ex.getMessage());
        error.put("path", request.getRequestURI());
        return error;
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseStatus()
    public Map<String,Object> resourceNotFoundException(Exception ex, ServletWebRequest webRequest) throws IOException {
        final HttpServletRequest request = webRequest.getRequest();
        final Map<String,Object> error = new LinkedHashMap<>();
        error.put("timestamp", Instant.now());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        error.put("error",   HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
        error.put("message", "unknown error");
        error.put("path", request.getRequestURI());
        return error;
    }

}
