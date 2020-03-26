package com.yjc.www.dao;

import com.yjc.www.po.ExhibitionHall;

import java.util.List;

public interface IExhibitionHallDao {
    //增
    void save(ExhibitionHall exhibitionHall);

    //删
    void delete(ExhibitionHall exhibitionHall);

    //改
    void update(ExhibitionHall exhibitionHall);

    //查
    ExhibitionHall getById(Integer exhibitionHallId);

    List<ExhibitionHall> getAll();
}
