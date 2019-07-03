package cn.len.spring.cloud.earth.feign;

import cn.len.spring.cloud.earth.bean.Friend;

/**
 * @author len
 * 2019-07-03
 */
public class FriendFallback implements FriendService {
    private Throwable throwable;
    @Override
    public Friend friend(String id) {
        final Friend friend = new Friend();
        friend.setId("1");
        friend.setName("fallbackName");
        return friend;
    }
}
