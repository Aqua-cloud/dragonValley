package com.yjc.www.test;

import com.yjc.www.dao.IVisitorDao;
import com.yjc.www.dao.impl.VisitorDaoImpl;
import com.yjc.www.po.Visitor;
import org.junit.Test;

import java.util.List;

public class VisitorTest {

    public Visitor visitor = new Visitor();

    private IVisitorDao dao = new VisitorDaoImpl();


    @Test
    public void testSave() {
        visitor.setUsername("aqua");
        visitor.setPhone("1882356255");
        visitor.setAccount("4563652");
        visitor.setPassword("654724");
        dao.save(visitor);
    }

    @Test
    public void testDelete() {
        visitor.setId(1);
        dao.delete(visitor);
    }

    @Test
    public void testUpdate() {
        visitor.setId(3);
        visitor.setUsername("jiaoman");
        visitor.setPhone("19860204431");
        visitor.setAccount("13452345");
        visitor.setPassword("124536");
        dao.update(visitor);
    }

    @Test
    public void testGet() {
        Visitor v = dao.getById(3);
        System.out.println(v);
    }

    @Test
    public void testGetAll(){
        List<Visitor> visitors = dao.getAll();
        for (Visitor v:visitors) {
            System.out.println(v);
        }
    }
}
