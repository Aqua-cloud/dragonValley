package com.yjc.www.dao.impl;

import com.yjc.www.dao.IExhibitionHallDao;
import com.yjc.www.po.ExhibitionHall;
import com.yjc.www.util.DbUtil;
import com.yjc.www.util.TimeUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExhibitionHallDaoImpl implements IExhibitionHallDao {

    //增
    @Override
    public void save(ExhibitionHall exhibitionHall) {
        String sql = "insert into exhibition_hall  (type,start_time,end_time,introduction,address,area,master_id)values(?,?,?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, exhibitionHall.getType());
            ps.setString(2, TimeUtil.timeToString(exhibitionHall.getStartTime()));
            ps.setString(3, TimeUtil.timeToString(exhibitionHall.getEndTime()));
            ps.setString(4, exhibitionHall.getIntroduction());
            ps.setString(5, exhibitionHall.getAddress());
            ps.setDouble(6, exhibitionHall.getArea());
            ps.setInt(7,exhibitionHall.getMasterId());
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
    public void delete(ExhibitionHall exhibitionHall) {
        String sql = "delete from exhibition_hall where id =?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, exhibitionHall.getId());
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
    public void update(ExhibitionHall exhibitionHall) {
        String sql = "update exhibition_hall set type=?,start_time=?,end_time=?,introduction=?,address=?,area=?,master_id=? where id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, exhibitionHall.getType());
            ps.setString(2, TimeUtil.timeToString(exhibitionHall.getStartTime()));
            ps.setString(3, TimeUtil.timeToString(exhibitionHall.getEndTime()));
            ps.setString(4, exhibitionHall.getIntroduction());
            ps.setString(5, exhibitionHall.getAddress());
            ps.setDouble(6, exhibitionHall.getArea());
            ps.setInt(7, exhibitionHall.getMasterId());
            ps.setInt(8, exhibitionHall.getId());
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
    public ExhibitionHall getById(Integer exhibitionHallId) {
        String sql = "SELECT*FROM exhibition_hall WHERE id =?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, exhibitionHallId);
            //执行sql语句
            rs = ps.executeQuery();
            if (rs.next()) {
                String type = rs.getString("type");
                Timestamp startTime = rs.getTimestamp("start_time");
                Timestamp endTime = rs.getTimestamp("end_time");
                String introduction = rs.getString("introduction");
                String address = rs.getString("address");
                Double area = rs.getDouble("area");
                ExhibitionHall exhibitionHall = new ExhibitionHall(exhibitionHallId,address,area,type,introduction,startTime,endTime);
                return exhibitionHall;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public List<ExhibitionHall> getAll() {
        //创建list集合封装Master对象
        List<ExhibitionHall> exhibitionHalls = new ArrayList<>();
        String sql = "select*from exhibition_hall";
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
                Integer exhibitionHallId = rs.getInt("id");
                String type = rs.getString("type");
                Timestamp startTime = rs.getTimestamp("start_time");
                Timestamp endTime = rs.getTimestamp("end_time");
                String introduction = rs.getString("introduction");
                String address = rs.getString("address");
                Double area = rs.getDouble("area");
                ExhibitionHall exhibitionHall = new ExhibitionHall(exhibitionHallId,address,area,type,introduction,startTime,endTime);
                //将Master对象添加到list集合
                exhibitionHalls.add(exhibitionHall);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return exhibitionHalls;
    }
}
