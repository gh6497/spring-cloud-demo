package cn.len.spring.cloud.earth.controller;

import cn.len.spring.cloud.earth.bean.User;
import cn.len.spring.cloud.earth.feign.FriendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author len
 * 2019-07-03
 */
@RestController()
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final FriendService friendService;
    @GetMapping("{id}")
    public User user(@PathVariable String id) {
        val user = new User();
        user.setId(id);
        user.setUsername("username");

            val friend = friendService.friend("1");
            val friends = List.of(friend);
            user.setFriends(friends);


        return user;
    }
}
