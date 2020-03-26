package com.yjc.www.test;

import com.yjc.www.dao.IEvaluationDao;
import com.yjc.www.dao.IExhibitionHallDao;
import com.yjc.www.dao.impl.ExhibitionHallDaoImpl;
import com.yjc.www.po.ExhibitionHall;
import com.yjc.www.util.TimeUtil;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

public class ExhibitionTest {
    public ExhibitionHall exhibitionHall = new ExhibitionHall();
    private IExhibitionHallDao dao = new ExhibitionHallDaoImpl();

    @Test
    public void testSave(){
        exhibitionHall.setAddress("广州");
        exhibitionHall.setArea(100);
        exhibitionHall.setEndTime(new Timestamp(new Date().getTime()));
        exhibitionHall.setStartTime(new Timestamp(new Date().getTime()));
        exhibitionHall.setIntroduction("这是一个好地方");
        exhibitionHall.setType("火龙馆");
        dao.save(exhibitionHall);
    }

    @Test
    public void testGet(){
        ExhibitionHall exhibitionHall = dao.getById(1);
        System.out.println(exhibitionHall);
    }
}
