package com.yjc.www.dao;

import com.yjc.www.po.Principal;

import java.util.List;

public interface IPrincipalDao {
    //增
    void save(Principal principal);

    //删
    void delete(Principal principal);

    //改
    void update(Principal principal);

    //查
    Principal getById(Integer principalId);

    List<Principal> getAll();

    Principal login(String username, String password);
}
