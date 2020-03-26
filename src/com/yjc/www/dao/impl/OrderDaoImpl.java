package com.yjc.www.dao.impl;

import com.yjc.www.dao.IOrderDao;
import com.yjc.www.po.Master;
import com.yjc.www.po.Order;
import com.yjc.www.util.DbUtil;
import com.yjc.www.util.TimeUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDaoImpl implements IOrderDao {
    //增
    @Override
    public void save(Order order) {
        String sql = "insert into orders(order_time,effective_time,state,cost,visitor_id,exhibition_hall_id)values(?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, TimeUtil.dateToString(order.getOrderTime()));
            ps.setString(2, TimeUtil.dateToString(order.getEffectiveTime()));
            ps.setString(3, order.getState());
            ps.setDouble(4, order.getCost());
            ps.setInt(5, order.getVisitorId());
            ps.setInt(6, order.getExhibitionHallId());
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
    public void delete(Order order) {
        String sql = "delete from orders where id =?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, order.getId());
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
    public void update(Order order) {
        String sql = "update orders set order_time=?,effective_time=?,state=?,cost=?,visitor_id,exhibition_hall_id where id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, TimeUtil.dateToString(order.getOrderTime()));
            ps.setString(2, TimeUtil.dateToString(order.getEffectiveTime()));
            ps.setString(3, order.getState());
            ps.setDouble(4, order.getCost());
            ps.setInt(5, order.getVisitorId());
            ps.setInt(6, order.getExhibitionHallId());
            ps.setInt(7, order.getId());
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
    public Order getById(Integer orderId) {
        String sql = "SELECT*FROM orders WHERE id =?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, orderId);
            //执行sql语句
            rs = ps.executeQuery();
            if (rs.next()) {
                Date orderTime= rs.getDate("order_time");
                Date effectiveTime= rs.getDate("effective_time");
                String state = rs.getString("state");
                Double cost = rs.getDouble("cost");
                Order order = new Order(orderId,orderTime,effectiveTime,cost,state);
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public List<Order> getAll() {
        //创建list集合封装Master对象
        List<Order> orders = new ArrayList<>();
        String sql = "select*from orders";
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
                Integer orderId = rs.getInt("id");
                Date orderTime= rs.getDate("order_time");
                Date effectiveTime= rs.getDate("effective_time");
                String state = rs.getString("state");
                Double cost = rs.getDouble("cost");
                Order order = new Order(orderId,orderTime,effectiveTime,cost,state);
                //将Master对象添加到list集合
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return orders;
    }
}
