package com.yjc.www.service;

import com.yjc.www.dto.Msg;

public interface IVisitorService {

    //用户登录
    Msg login(String password, String username);
}
