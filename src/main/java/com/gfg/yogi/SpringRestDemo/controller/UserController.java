package com.gfg.yogi.SpringRestDemo.controller;

import com.gfg.yogi.SpringRestDemo.model.User;
import com.gfg.yogi.SpringRestDemo.userdata.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

     Map<Long,User>  userMap = UserData.userMap;


     @GetMapping("/users")
    public  List<User> getAllUsers(){

        List<User> users = new ArrayList<>();

        for(Map.Entry<Long,User> entry : userMap.entrySet()){

            User user = entry.getValue();
            users.add(user);

        }


        return users;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long id){
         User userToBeReturned = null;

         userToBeReturned = userMap.get(id);

         return userToBeReturned;
    }

    @PostMapping("/user")
    public Boolean createUser(@RequestBody User user){

         if(userMap.containsKey(user.getId())){
             return false;
         } else {
             userMap.put(user.getId(),user);
             return true;
         }

    }

    @DeleteMapping("/user/{id}")
    public Boolean deleteUser(@PathVariable("id") Long id){

         if(userMap.containsKey(id)){
             userMap.remove(id);
             return true;
         }else{
             return false;
         }
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user){
         Long id = user.getId();

         if(userMap.containsKey(id)){

             userMap.put(id,user);
             return userMap.get(id);
         }else{
             return null;
         }


    }

}
