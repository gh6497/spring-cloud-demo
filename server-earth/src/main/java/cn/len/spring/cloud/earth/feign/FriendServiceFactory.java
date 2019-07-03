package cn.len.spring.cloud.earth.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author len
 * 2019-07-03
 */
@Component
public class FriendServiceFactory implements FallbackFactory<FriendService> {

    @Override
    public FriendService create(Throwable throwable) {
        throw new RuntimeException(throwable);
    }
}
