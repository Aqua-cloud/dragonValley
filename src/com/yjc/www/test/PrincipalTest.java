package com.yjc.www.test;

import com.yjc.www.dao.IPrincipalDao;
import com.yjc.www.dao.IVisitorDao;
import com.yjc.www.dao.impl.PrincipalDaoImpl;
import com.yjc.www.dao.impl.VisitorDaoImpl;
import com.yjc.www.po.Principal;
import com.yjc.www.po.Visitor;
import org.junit.Test;

import java.util.List;

public class PrincipalTest {

    public Principal principal = new Principal();

    private IPrincipalDao dao = new PrincipalDaoImpl();


    @Test
    public void testSave() {
        principal.setUsername("小红");
        principal.setPhone("1545355");
        principal.setAccount("12352");
        principal.setPassword("rifidnng");
        dao.save(principal);
    }

    @Test
    public void testDelete() {
        principal.setId(4);
        dao.delete(principal);
    }

    @Test
    public void testUpdate() {
        principal.setId(2);
        principal.setUsername("小羊");
        principal.setPhone("19454331");
        principal.setAccount("134234145");
        principal.setPassword("124536");
        dao.update(principal);
    }

    @Test
    public void testGet() {
        Principal principal = dao.getById(1);
        System.out.println(principal);
    }

    @Test
    public void testGetAll(){
        List<Principal> principals = dao.getAll();
        for (Principal principal:principals) {
            System.out.println(principal);
        }
    }
}
