package com.yjc.www.service.impl;

import com.yjc.www.dao.IVisitorDao;
import com.yjc.www.dao.impl.VisitorDaoImpl;
import com.yjc.www.dto.Msg;
import com.yjc.www.po.Visitor;
import com.yjc.www.service.IVisitorService;
import com.yjc.www.util.ValidateUtil;

public class VisitorServiceImpl implements IVisitorService {

    IVisitorDao dao = new VisitorDaoImpl();

    //用户登录
    @Override
    public Msg login(String password, String userName) {

        if (ValidateUtil.isInvalidUserName(userName)) {
            return new Msg("用户名为空", null);
        }
        Visitor visitor = dao.login(password, userName);
        if (visitor == null) {
            return new Msg("用户名或密码错误", null);
        } else {
            return new Msg("登录成功", visitor);
        }
    }
}
