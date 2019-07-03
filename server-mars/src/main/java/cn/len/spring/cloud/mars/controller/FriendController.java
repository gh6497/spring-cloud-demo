package cn.len.spring.cloud.mars.controller;

import cn.len.spring.cloud.mars.bean.Friend;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author len
 * 2019-07-03
 */
@RestController
@RequestMapping("/friends")
public class FriendController {

    @GetMapping("{id}")
    public Friend friend(@PathVariable String id) {

        val friend = new Friend();
        friend.setId(id);
        friend.setName("name");
        return friend;
    }
}
