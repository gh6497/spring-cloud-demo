package cn.len.spring.cloud.earth.controller;

import cn.len.spring.cloud.earth.ResourceNotFoundException;
import cn.len.spring.cloud.earth.bean.User;
import cn.len.spring.cloud.earth.bean.UserDto;
import cn.len.spring.cloud.earth.feign.FriendService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
        if (id.equals("3")) {
            throw new ResourceNotFoundException("id为" + id + "的用户不存在");
        }
        val user = new User();
        user.setId(id);
        user.setUsername("username");
        val friend = friendService.friend(id);
        val friends = List.of(friend);
        user.setFriends(friends);


        return user;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@Valid UserDto userDto) {
        System.out.println(userDto);
    }
}
