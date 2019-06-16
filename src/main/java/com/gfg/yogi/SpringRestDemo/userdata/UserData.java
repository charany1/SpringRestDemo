package com.gfg.yogi.SpringRestDemo.userdata;

import com.gfg.yogi.SpringRestDemo.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class UserData {

    public static Map<Long, User> userMap = new HashMap<>();

    static {


        User user0 = new User(0L,"Rod","Johnson");
        User user1 = new User(1L , "Eric", "Evans");
        User user2 = new User(2L,"Bill","Gates");
        User user3 = new User(3L,"Nelson","Mandela");

        userMap.put(user0.getId(),user0);
        userMap.put(user1.getId(),user1);
        userMap.put(user2.getId(),user2);
        userMap.put(user3.getId(),user3);


    }
}
