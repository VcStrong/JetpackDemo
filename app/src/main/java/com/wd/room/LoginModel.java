package com.wd.room;

import com.wd.room.databinding.ActivityMainBinding;

public class LoginModel {

    ActivityMainBinding activityMainBinding;
    public LoginModel(ActivityMainBinding activityMainBinding){
        this.activityMainBinding = activityMainBinding;
    }

    public void login(String phone,String pwd){
        //发送请求中*****
        User user = new User();
        user.name = phone+"  "+pwd;
        //得到请求结果****
        activityMainBinding.setLoginUser(user);
    }
}
