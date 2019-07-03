package cn.len.spring.cloud.earth;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import feign.FeignException;

import static feign.Util.UTF_8;

/**
 * @author len
 * 2019-07-03
 */
public class UnFallbackFeignException extends HystrixBadRequestException {
   private final FeignException feignException;
    public UnFallbackFeignException(FeignException feignException) {
        super(feignException.getMessage(),feignException);
        this.feignException = feignException;
    }

    public byte[] content() {
        return feignException.content();
    }

    public String contentUTF8() {
        return new String(feignException.content(), UTF_8);
    }

}
