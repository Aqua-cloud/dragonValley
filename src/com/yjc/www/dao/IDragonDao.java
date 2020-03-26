package com.yjc.www.dao;

import com.yjc.www.po.Dragon;

import java.util.List;

public interface IDragonDao {
    //增
    void save(Dragon dragon);

    //删
    void delete(Dragon dragon);

    //改
    void update(Dragon dragon);

    //查
    Dragon getById(Integer dragonId);

    List<Dragon> getAll();
}
