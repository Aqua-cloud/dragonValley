package com.yjc.www.service;

import com.yjc.www.dto.Msg;

public interface IMasterService {

    //用户登录
    Msg login(String password, String username);
}