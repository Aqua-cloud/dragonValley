package com.yjc.www.service;

import com.yjc.www.dto.Msg;
import com.yjc.www.po.Visitor;

public interface IVisitorService {

    //用户登录
    Msg login(String password, String account);

    //用户注册
    String register(Visitor visitor);
}
