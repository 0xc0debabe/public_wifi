package com.hmw.jsp.wifi.dao;

import com.hmw.jsp.wifi.db.DBConnect;
import com.hmw.jsp.wifi.dto.HistoryDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HistoryDao {
    DBConnect dbConnect = new DBConnect();

    public void saveHistory(String lat, String lnt) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = dbConnect.connectionDB();
            String sql = "INSERT INTO wifi_search (LAT, LNT, SEARCH_DTTM) VALUES (?, ?, NOW())";
            ps = c.prepareStatement(sql);
            ps.setString(1, lat);
            ps.setString(2, lnt);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnect.close(c, ps, rs);
        }
    }

    public List<HistoryDto>  showHistoryList() {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<HistoryDto> list = new ArrayList<>();

        try {
            c = dbConnect.connectionDB();
            String sql = "SELECT * FROM wifi_search";
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                HistoryDto historyDto = HistoryDto.builder()
                        .id(rs.getLong("id"))
                        .lat(rs.getString("LAT"))
                        .lnt(rs.getString("LNT"))
                        .search_dttm(rs.getString("SEARCH_DTTM"))
                        .build();

                list.add(historyDto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnect.close(c, ps, rs);
        }

        return list;
    }

    public void deleteHistory(long id) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = dbConnect.connectionDB();
            String sql = "DELETE FROM wifi_search WHERE id = ?";
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
