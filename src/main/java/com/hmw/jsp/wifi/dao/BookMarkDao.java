package com.hmw.jsp.wifi.dao;

import com.hmw.jsp.wifi.db.DBConnect;
import com.hmw.jsp.wifi.dto.BookMarkGroupDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookMarkDao {
    DBConnect dbConnect = new DBConnect();

    public List<BookMarkGroupDto> findAll() {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<BookMarkGroupDto> list = new ArrayList<>();

        try {
            c = dbConnect.connectionDB();

            String sql = "SELECT * FROM wifi_bookmark_group;";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                BookMarkGroupDto bmgd = BookMarkGroupDto.builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("BOOKMARK_NAME"))
                        .order(rs.getString("ORDER"))
                        .register_dttm(rs.getString("REGISTER_DTTM"))
                        .update_dttm(rs.getString("UPDATE_DTTM"))
                        .build();
                list.add(bmgd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnect.close(c, ps, rs);
        }

        return list;
    }

    public void addBookMarkGroup(String bookmarkName, String order) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = dbConnect.connectionDB();
            String sql = "INSERT INTO wifi_bookmark_group (BOOKMARK_NAME, `ORDER`, REGISTER_DTTM, UPDATE_DTTM) VALUES (?, ?, NOW(), ?)";
            ps = c.prepareStatement(sql);
            ps.setString(1, bookmarkName);
            ps.setLong(2, Long.parseLong(order));
            ps.setString(3, " ");
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnect.close(c, ps, rs);
        }
    }

    public BookMarkGroupDto findGroupById(long id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        BookMarkGroupDto bookMarkGroupDto = null;

        try {
            c = dbConnect.connectionDB();
            String sql = "SELECT * FROM wifi_bookmark_group WHERE id = ?;";
            ps = c.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                bookMarkGroupDto = BookMarkGroupDto.builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("BOOKMARK_NAME"))
                        .order(rs.getString("ORDER"))
                        .register_dttm(rs.getString("REGISTER_DTTM"))
                        .update_dttm(rs.getString("UPDATE_DTTM"))
                        .build();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnect.close(c, ps, rs);
        }

        return bookMarkGroupDto;
    }

    public void bookMarkGroupEdit(long id, String bookMarkName, String order) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = dbConnect.connectionDB();
            String sql = "UPDATE wifi_bookmark_group SET BOOKMARK_NAME = ?, `ORDER` = ?, `UPDATE_DTTM` = NOW() WHERE id = ?";
            ps = c.prepareStatement(sql);
            ps.setString(1, bookMarkName);
            ps.setString(2, order);
            ps.setLong(3, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnect.close(c, ps, rs);
        }
    }

    public void bookMarkGroupDel(long id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = dbConnect.connectionDB();
            String sql = "DELETE FROM wifi_bookmark_group WHERE id = ?";
            ps = c.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnect.close(c, ps, rs);
        }
    }
}
