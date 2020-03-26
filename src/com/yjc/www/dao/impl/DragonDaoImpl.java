package com.yjc.www.dao.impl;

import com.yjc.www.dao.IDragonDao;
import com.yjc.www.po.Dragon;
import com.yjc.www.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DragonDaoImpl implements IDragonDao {
    //增
    @Override
    public void save(Dragon dragon) {
        String sql = "insert into dragon (name,type,age,state,exhibition_hall_id)values(?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, dragon.getName());
            ps.setString(2, dragon.getType());
            ps.setString(3, dragon.getAge());
            ps.setString(4, dragon.getStatue());
            ps.setInt(5, dragon.getExhibitionHallId());
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
    public void delete(Dragon dragon) {
        String sql = "delete from dragon where id =?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, dragon.getId());
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
    public void update(Dragon dragon) {
        String sql = "update dragon set name=?,type=?,age=?,state=?,exhibition_hall_id=? where id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setString(1, dragon.getName());
            ps.setString(2, dragon.getType());
            ps.setString(3, dragon.getAge());
            ps.setString(4, dragon.getStatue());
            ps.setInt(5, dragon.getExhibitionHallId());
            ps.setInt(6, dragon.getId());
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
    public Dragon getById(Integer dragonId) {
        String sql = "SELECT*FROM dragon WHERE id =?";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DbUtil.getConn();
            // 创建语句对象
            ps = conn.prepareStatement(sql);
            //设置占位符参数
            ps.setInt(1, dragonId);
            //执行sql语句
            rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String type = rs.getString("type");
                String age = rs.getString("age");
                String state = rs.getString("state");
                Dragon dragon = new Dragon(dragonId, name, type, age, state);
                return dragon;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public List<Dragon> getAll() {
        //创建list集合封装Master对象
        List<Dragon> dragons = new ArrayList<>();
        String sql = "select*from dragon";
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
                Integer dragonId = rs.getInt("id");
                String name = rs.getString("name");
                String type = rs.getString("type");
                String age = rs.getString("age");
                String state = rs.getString("state");
                Dragon dragon = new Dragon(dragonId, name, type, age, state);
                //将Master对象添加到list集合
                dragons.add(dragon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.close(conn, ps, rs);
        }
        return dragons;
    }
}
