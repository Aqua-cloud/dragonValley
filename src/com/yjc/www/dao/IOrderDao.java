package com.yjc.www.dao;

import com.yjc.www.po.Order;

import java.util.List;

public interface IOrderDao {
    //增
    void save(Order order);

    //删
    void delete(Order order);

    //改
    void update(Order order);

    //查
    Order getById(Integer orderId);

    List<Order> getAll();
}
