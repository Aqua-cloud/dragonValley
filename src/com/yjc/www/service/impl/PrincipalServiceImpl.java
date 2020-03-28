package com.yjc.www.service.impl;

import com.yjc.www.dao.IPrincipalDao;
import com.yjc.www.dao.IVisitorDao;
import com.yjc.www.dao.impl.PrincipalDaoImpl;
import com.yjc.www.dao.impl.VisitorDaoImpl;
import com.yjc.www.dto.Msg;
import com.yjc.www.po.Principal;
import com.yjc.www.po.Visitor;
import com.yjc.www.service.IPrincipalService;
import com.yjc.www.service.IVisitorService;
import com.yjc.www.util.ValidateUtil;

public class PrincipalServiceImpl implements IPrincipalService {

    IPrincipalDao dao = new PrincipalDaoImpl();
    //用户登录
    @Override
    public Msg login(String password, String account) {

        if (ValidateUtil.isInvalid(password,account)) {
            return new Msg("账号或密码为空", null);
        }
        Principal principal = dao.login(password, account);
        if (principal == null) {
            return new Msg("账号或密码错误", null);
        } else {
            return new Msg("登录成功", principal);
        }
    }
}
