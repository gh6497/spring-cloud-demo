package cn.len.spring.cloud.earth.feign;

import cn.len.spring.cloud.earth.bean.Friend;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author len
 * 2019-07-03
 */
@FeignClient(value = "server-mars",fallbackFactory = FriendServiceFactory.class)
@RequestMapping("/friends")
public interface FriendService {
    @GetMapping("{id}")
    Friend friend(@PathVariable String id);
}
