package com.yjc.www.dao;

import com.yjc.www.po.Activity;

import java.util.List;

public interface IActivityDao {
    //增
    void save(Activity activity);

    //删
    void delete(Activity activity);

    //改
    void update(Activity activity);

    //查
    Activity getById(Integer activityId);

    List<Activity> getAll();
}
