package com.yjc.www.dao;

import com.yjc.www.po.Master;

import java.util.List;

public interface IMasterDao {
    //增
    void save(Master master);

    //删
    void delete(Master master);

    //改
    void update(Master master);

    //查
    Master getById(Integer masterId);

    List<Master> getAll();

    Master login(String username, String password);
}
