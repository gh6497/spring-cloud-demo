package cn.len.spring.cloud.earth.bean;

import lombok.Data;

import java.util.List;

/**
 * @author len
 * 2019-07-03
 */
@Data
public class User {
    private String username;
    private String id;
    private List<Friend> friends;
}
