package com.yjc.www.service.impl;

import com.yjc.www.dao.IMasterDao;
import com.yjc.www.dao.IVisitorDao;
import com.yjc.www.dao.impl.MasterDaoImpl;
import com.yjc.www.dao.impl.VisitorDaoImpl;
import com.yjc.www.dto.Msg;
import com.yjc.www.po.Master;
import com.yjc.www.po.Principal;
import com.yjc.www.service.IMasterService;
import com.yjc.www.service.IVisitorService;
import com.yjc.www.util.ValidateUtil;

public class MasterServiceImpl implements IMasterService {

    IMasterDao dao = new MasterDaoImpl();
    //用户登录
    @Override
    public Msg login(String password, String userName) {
        if (ValidateUtil.isInvalidUserName(userName)) {
            return new Msg("用户名为空", null);
        }
        Master master = dao.login(password, userName);
        if (master == null) {
            return new Msg("用户名或密码错误", null);
        } else {
            return new Msg("登录成功", master);
        }
    }
}
