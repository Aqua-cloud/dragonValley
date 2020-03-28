package com.yjc.www.dao.impl;

import com.yjc.www.dao.IVisitorDao;
import com.yjc.www.po.Visitor;
import com.yjc.www.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VisitorDaoImpl implements IVisitorDao {
    //增
    @Override
    public void save(Visitor visitor) {
        String sql = "insert into visitor (username,phone,account,password)values(?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, visitor.getUsername());
            ps.setString(2, visitor.getPhone());
            ps.setString(3, visitor.getPassword());
            ps.setString(4,"10000");
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
    public void delete(Visitor visitor) {
        String sql = "delete from visitor where id =?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, visitor.getId());
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
    public void update(Visitor visitor) {
        String sql = "update visitor set username =?,phone=?,account=?,password=? where id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, visitor.getUsername());
            ps.setString(2, visitor.getPhone());
            ps.setString(3, visitor.getAccount());
            ps.setString(4, visitor.getPassword());
            ps.setInt(5, visitor.getId());
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
    public Visitor getById(Integer visitorId) {
        String sql = "SELECT*FROM visitor WHERE id =?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, visitorId);
            //执行sql语句
            rs = ps.executeQuery();
            if (rs.next()) {
                String username = rs.getString("username");
                String phone = rs.getString("phone");
                String account = rs.getString("account");
                String password = rs.getString("password");
                Visitor visitor = new Visitor(visitorId, username,account,phone,password);
                return visitor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public Integer getId(String userName) {
        String sql = "SELECT*FROM visitor WHERE username =?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, userName);
            //执行sql语句
            rs = ps.executeQuery();
            if (rs.next()) {
                Integer id = rs.getInt("id");
                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return null;

    }

    @Override
    public List<Visitor> getAll() {
        //创建list集合封装Visitor对象
        List<Visitor> visitors = new ArrayList<>();
        String sql = "select*from visitor";
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
                Integer visitorId = rs.getInt("id");
                String username = rs.getString("username");
                String phone = rs.getString("phone");
                String account = rs.getString("account");
                String password = rs.getString("password");
                Visitor visitor = new Visitor(visitorId, username,account,phone,password);
                //将Visitor对象添加到list集合
                visitors.add(visitor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return visitors;
    }

    @Override
    public Visitor login(String password, String account) {
        String sql = "SELECT*FROM visitor WHERE password =? and account =? ";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, password);
            ps.setString(2, account);
            //执行sql语句
            rs = ps.executeQuery();
            if (rs.next()) {
                Integer visitorId = rs.getInt("id");
                String phone = rs.getString("phone");
                String username = rs.getString("username");
                Visitor visitor = new Visitor(visitorId, account,username,phone,password);
                return visitor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public Boolean checkUserName(String userName) {
        String sql = "SELECT*FROM visitor WHERE username=? ";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, userName);
            //执行sql语句
            rs = ps.executeQuery();
            if (rs.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return true;
    }
}

