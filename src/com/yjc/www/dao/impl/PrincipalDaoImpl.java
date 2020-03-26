package com.yjc.www.dao.impl;

import com.yjc.www.dao.IPrincipalDao;
import com.yjc.www.po.Principal;
import com.yjc.www.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrincipalDaoImpl implements IPrincipalDao {
    //增
    @Override
    public void save(Principal principal) {
        String sql = "insert into principal (username,phone,account,password)values(?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, principal.getUsername());
            ps.setString(2, principal.getPhone());
            ps.setString(3, principal.getAccount());
            ps.setString(4, principal.getPassword());
            // 执行SQL语句
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, null);
        }

    }

    //删
    @Override
    public void delete(Principal principal) {
        String sql = "delete from principal where id =?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, principal.getId());
            // 执行SQL语句
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, null);
        }
    }

    //改
    @Override
    public void update(Principal principal) {
        String sql = "update principal set username =?,phone=?,account=?,password=? where id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, principal.getUsername());
            ps.setString(2, principal.getPhone());
            ps.setString(3, principal.getAccount());
            ps.setString(4, principal.getPassword());
            ps.setInt(5, principal.getId());
            // 执行SQL语句
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, null);
        }
    }

    //查
    @Override
    public Principal getById(Integer principalId) {
        String sql = "SELECT*FROM principal WHERE id =?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, principalId);
            //执行sql语句
            rs = ps.executeQuery();
            if (rs.next()) {
                String username = rs.getString("username");
                String phone = rs.getString("phone");
                String account = rs.getString("account");
                String password = rs.getString("password");
                Principal principal = new Principal(principalId, username, phone, account, password);
                return principal;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public List<Principal> getAll() {
        //创建list集合封装Principal对象
        List<Principal> principals = new ArrayList<>();
        String sql = "select*from principal";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConn();
            //创建语句对象
            ps = conn.prepareStatement(sql);
            //执行sql语句
            rs = ps.executeQuery();
            //遍历结果集，封装对象
            while (rs.next()) {
                Integer principalId = rs.getInt("id");
                String username = rs.getString("username");
                String phone = rs.getString("phone");
                String account = rs.getString("account");
                String password = rs.getString("password");
                Principal principal = new Principal(principalId, username, account, phone, password);
                //将Principal对象添加到list集合
                principals.add(principal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return principals;
    }
}

