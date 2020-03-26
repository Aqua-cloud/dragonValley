package com.yjc.www.dao.impl;

import com.yjc.www.dao.IMasterDao;
import com.yjc.www.po.Master;
import com.yjc.www.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MasterDaoImpl implements IMasterDao {
    //增
    @Override
    public void save(Master master) {
        String sql = "insert into master (username,phone,account,password)values(?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, master.getUsername());
            ps.setString(2, master.getPhone());
            ps.setString(3, master.getAccount());
            ps.setString(4, master.getPassword());
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
    public void delete(Master master) {
        String sql = "delete from master where id =?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, master.getId());
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
    public void update(Master master) {
        String sql = "update master set username =?,phone=?,account=?,password=? where id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, master.getUsername());
            ps.setString(2, master.getPhone());
            ps.setString(3, master.getAccount());
            ps.setString(4, master.getPassword());
            ps.setInt(5, master.getId());
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
    public Master getById(Integer masterId) {
        String sql = "SELECT*FROM master WHERE id =?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, masterId);
            //执行sql语句
            rs = ps.executeQuery();
            if (rs.next()) {
                String username = rs.getString("username");
                String phone = rs.getString("phone");
                String account = rs.getString("account");
                String password = rs.getString("password");
                Master master = new Master(masterId, username, phone, account, password);
                return master;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public List<Master> getAll() {
        //创建list集合封装Master对象
        List<Master> masters = new ArrayList<>();
        String sql = "select*from master";
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
                Integer masterId = rs.getInt("id");
                String username = rs.getString("username");
                String phone = rs.getString("phone");
                String account = rs.getString("account");
                String password = rs.getString("password");
                Master master = new Master(masterId, username, account, phone, password);
                //将Master对象添加到list集合
                masters.add(master);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return masters;
    }
}

