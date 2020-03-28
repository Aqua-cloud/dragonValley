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
    public Msg login(String password, String account) {
        if (ValidateUtil.isInvalid(password, account)) {
            return new Msg("账号或密码为空", null);
        }
        Visitor visitor = dao.login(password, account);
        if (visitor == null) {
            return new Msg("账号或密码错误", null);
        } else {
            return new Msg("登录成功", visitor);
        }
    }

    @Override
    public String register(Visitor visitor) {
        if (dao.checkUserName(visitor.getUsername())) {
            dao.save(visitor);
            //获取id生成账号
            Integer id = dao.getId(visitor.getUsername());
            String account = "10000"+id;
            //存入账号,id
            visitor.setAccount(account);
            visitor.setId(id);
            //更新
            dao.update(visitor);
            return account;
        }
        return null;
    }
}
