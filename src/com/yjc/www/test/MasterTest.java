package com.yjc.www.test;

import com.yjc.www.dao.IMasterDao;
import com.yjc.www.dao.IPrincipalDao;
import com.yjc.www.dao.impl.MasterDaoImpl;
import com.yjc.www.dao.impl.PrincipalDaoImpl;
import com.yjc.www.po.Master;
import com.yjc.www.po.Principal;
import org.junit.Test;

import java.util.List;

public class MasterTest {

    public Master master = new Master();

    private IMasterDao dao = new MasterDaoImpl();


    @Test
    public void testSave() {
        master.setUsername("zhangsan");
        master.setPhone("124242");
        master.setAccount("1246632");
        master.setPassword("436357624");
        dao.save(master);
    }

    @Test
    public void testDelete() {
        master.setId(1);
        dao.delete(master);
    }

    @Test
    public void testUpdate() {
        master.setId(1);
        master.setUsername("小羊");
        master.setPhone("19454331");
        master.setAccount("134234145");
        master.setPassword("124536");
        dao.update(master);
    }

    @Test
    public void testGet() {
        Master master = dao.getById(1);
        System.out.println(master);
    }

    @Test
    public void testGetAll(){
        List<Master> masters = dao.getAll();
        for (Master master:masters) {
            System.out.println(master);
        }
    }
}
