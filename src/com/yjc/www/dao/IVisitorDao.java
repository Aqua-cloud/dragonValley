package com.yjc.www.dao;

import com.yjc.www.po.Visitor;

import java.util.List;

public interface IVisitorDao {
    //增
    void save(Visitor visitor);

    //删
    void delete(Visitor visitor);

    //改
    void update(Visitor visitor);

    //id查询
    Visitor  getById(Integer visitorId);

    //List
    List<Visitor> getAll();

    Visitor login(String username, String password);
}
