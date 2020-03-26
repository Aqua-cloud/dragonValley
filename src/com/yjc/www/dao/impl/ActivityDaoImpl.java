package com.yjc.www.dao.impl;

import com.yjc.www.dao.IActivityDao;
import com.yjc.www.dao.IOrderDao;
import com.yjc.www.po.Activity;
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

public class ActivityDaoImpl implements IActivityDao {
    //增
    @Override
    public void save(Activity activity) {
        String sql = "insert into activity (name,introduction,state,start_date,end_date,exhibition_hall)values(?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, activity.getName());
            ps.setString(2, activity.getIntroduction());
            ps.setString(3, activity.getState());
            ps.setString(4, TimeUtil.dateToString(activity.getStartDate()));
            ps.setString(5, TimeUtil.dateToString(activity.getEndDate()));
            ps.setInt(6, activity.getExhibitionHallId());
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
    public void delete(Activity activity) {
        String sql = "delete from activity where id =?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, activity.getId());
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
    public void update(Activity activity) {
        String sql = "update activity set name=?,introduction=?,state=?,start_date=?,end_date=?,exhibition_id=? where id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, activity.getName());
            ps.setString(2, activity.getIntroduction());
            ps.setString(3, activity.getState());
            ps.setString(4, TimeUtil.dateToString(activity.getStartDate()));
            ps.setString(5, TimeUtil.dateToString(activity.getEndDate()));
            ps.setInt(6, activity.getExhibitionHallId());
            ps.setInt(7, activity.getId());
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
    public Activity getById(Integer activityId) {
        String sql = "SELECT*FROM activity WHERE id =?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, activityId);
            //执行sql语句
            rs = ps.executeQuery();
            if (rs.next()) {
                Date startDate = rs.getDate("start_date");
                Date endDate = rs.getDate("end_date");
                String name = rs.getString("name");
                String introduction = rs.getString("introduction");
                String state = rs.getString("state");
                Activity activity = new Activity(activityId, name, state, introduction, startDate, endDate);
                return activity;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public List<Activity> getAll() {
        //创建list集合封装Master对象
        List<Activity> activities = new ArrayList<>();
        String sql = "select*from activity";
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
                Integer activityId = rs.getInt("id");
                Date startDate = rs.getDate("start_date");
                Date endDate = rs.getDate("end_date");
                String name = rs.getString("name");
                String introduction = rs.getString("introduction");
                String state = rs.getString("state");
                Activity activity = new Activity(activityId, name, state, introduction, startDate, endDate);
                //将Master对象添加到list集合
                activities.add(activity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return activities;
    }
}
