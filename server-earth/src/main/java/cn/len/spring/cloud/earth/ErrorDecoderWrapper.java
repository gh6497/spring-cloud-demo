package cn.len.spring.cloud.earth;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

/**
 * @author len
 * 2019-07-03
 */
@Component
public class ErrorDecoderWrapper implements ErrorDecoder {
    private final ErrorDecoder errorDecoder;

    public ErrorDecoderWrapper() {
        this.errorDecoder = new Default();
    }

    @Override
    public Exception decode(String methodKey, Response response) {
        final Exception decode = errorDecoder.decode(methodKey, response);

        if(decode.getClass() == FeignException.class) {
            return new UnFallbackFeignException((FeignException) decode);
        }
        return decode;
    }
}
