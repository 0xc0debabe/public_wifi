package com.hmw.jsp.wifi.dao;

import com.hmw.jsp.wifi.db.DBConnect;
import com.hmw.jsp.wifi.dto.BookmarkListDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookMarkListDao {
    DBConnect dbConnect = new DBConnect();

    public void saveBookMarkToList(long bgid, long wifiId) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = dbConnect.connectionDB();
            String sql = "INSERT INTO wifi_bookmark_list (REGISTER_DTTM, info_ID, GROUP_ID) VALUES (NOW(), ?, ?)";
            ps = c.prepareStatement(sql);
            ps.setLong(1, wifiId);
            ps.setLong(2, bgid);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnect.close(c, ps, rs);
        }
    }

    public List<BookmarkListDto> showBookMarkList() {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<BookmarkListDto> list = new ArrayList<>();


        try {
            c = dbConnect.connectionDB();
            String sql = "SELECT * FROM wifi_bookmark_list";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                BookmarkListDto bld = BookmarkListDto.builder()
                        .id(rs.getLong("id"))
                        .register_dttm(rs.getString("REGISTER_DTTM"))
                        .info_id(rs.getLong("info_ID"))
                        .group_id(rs.getLong("GROUP_ID"))
                        .build();

                list.add(bld);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnect.close(c, ps, rs);
        }

        return list;
    }

    public void deleteBookMarkList(long blid) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = dbConnect.connectionDB();
            String sql = "DELETE FROM wifi_bookmark_list WHERE id = ?";
            ps = c.prepareStatement(sql);
            ps.setLong(1, blid);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnect.close(c, ps, rs);
        }
    }

    public BookmarkListDto findBookMarkListById(long listId) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        BookmarkListDto bookmarkListDto = null;

        try {
            c = dbConnect.connectionDB();
            String sql = "SELECT * FROM wifi_bookmark_list WHERE id = ?;";
            ps = c.prepareStatement(sql);
            ps.setLong(1, listId);
            rs = ps.executeQuery();

            while (rs.next()) {
                bookmarkListDto = BookmarkListDto.builder()
                        .id(rs.getLong("id"))
                        .register_dttm(rs.getString("REGISTER_DTTM"))
                        .info_id(rs.getLong("info_ID"))
                        .group_id(rs.getLong("group_id"))
                        .build();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnect.close(c, ps, rs);
        }

        return bookmarkListDto;
    }
}
