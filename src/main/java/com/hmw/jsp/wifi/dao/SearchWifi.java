package com.hmw.jsp.wifi.dao;

import com.hmw.jsp.wifi.db.DBConnect;
import com.hmw.jsp.wifi.dto.WifiDto;
import org.mariadb.jdbc.internal.com.read.dao.Results;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchWifi {
    DBConnect dbConnect = new DBConnect();

    public List<WifiDto> getNearbyWifi(String lat, String lnt) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<WifiDto> list = new ArrayList<>();

        try {
            c = dbConnect.connectionDB();
            String sql = " SELECT *, " +
                    " round(6371*acos(cos(radians(?))*cos(radians(LAT))*cos(radians(LNT) " +
                    " -radians(?))+sin(radians(?))*sin(radians(LAT))), 4) " +
                    " AS distance " +
                    " FROM wifi_info " +
                    " ORDER BY distance " +
                    " LIMIT 20;";

            ps = c.prepareStatement(sql);
            ps.setDouble(1, Double.parseDouble(lat));
            ps.setDouble(2, Double.parseDouble(lnt));
            ps.setDouble(3, Double.parseDouble(lat));

            rs = ps.executeQuery();

            while (rs.next()) {
                WifiDto wifiDto = WifiDto.builder()
                        .distance(rs.getDouble("distance"))
                        .X_SWIFI_MGR_NO(rs.getString("X_SWIFI_MGR_NO"))
                        .X_SWIFI_WRDOFC(rs.getString("X_SWIFI_WRDOFC"))
                        .X_SWIFI_MAIN_NM(rs.getString("X_SWIFI_MAIN_NM"))
                        .X_SWIFI_ADRES1(rs.getString("X_SWIFI_ADRES1"))
                        .X_SWIFI_ADRES2(rs.getString("X_SWIFI_ADRES2"))
                        .X_SWIFI_INSTL_FLOOR(rs.getString("X_SWIFI_INSTL_FLOOR"))
                        .X_SWIFI_INSTL_TY(rs.getString("X_SWIFI_INSTL_TY"))
                        .X_SWIFI_INSTL_MBY(rs.getString("X_SWIFI_INSTL_MBY"))
                        .X_SWIFI_SVC_SE(rs.getString("X_SWIFI_SVC_SE"))
                        .X_SWIFI_CMCWR(rs.getString("X_SWIFI_CMCWR"))
                        .X_SWIFI_CNSTC_YEAR(rs.getString("X_SWIFI_CNSTC_YEAR"))
                        .X_SWIFI_INOUT_DOOR(rs.getString("X_SWIFI_INOUT_DOOR"))
                        .X_SWIFI_REMARS3(rs.getString("X_SWIFI_REMARS3"))
                        .LAT(rs.getString("LAT"))
                        .LNT(rs.getString("LNT"))
                        .WORK_DTTM(rs.getString("WORK_DTTM"))
                        .build();

                list.add(wifiDto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnect.close(c, ps, rs);
        }

        return list;
    }

    public WifiDto findOne(String mgrNo, double dist) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        WifiDto wifiDto = null;
        try {
            c = dbConnect.connectionDB();
            String sql = "SELECT * FROM wifi_info" +
                    " WHERE X_SWIFI_MGR_NO = ?";

            ps = c.prepareStatement(sql);
            ps.setString(1, mgrNo);
            rs = ps.executeQuery();

            while (rs.next()) {
                wifiDto = WifiDto.builder()
                        .distance(dist)
                        .X_SWIFI_MGR_NO(rs.getString("X_SWIFI_MGR_NO"))
                        .X_SWIFI_WRDOFC(rs.getString("X_SWIFI_WRDOFC"))
                        .X_SWIFI_MAIN_NM(rs.getString("X_SWIFI_MAIN_NM"))
                        .X_SWIFI_ADRES1(rs.getString("X_SWIFI_ADRES1"))
                        .X_SWIFI_ADRES2(rs.getString("X_SWIFI_ADRES2"))
                        .X_SWIFI_INSTL_FLOOR(rs.getString("X_SWIFI_INSTL_FLOOR"))
                        .X_SWIFI_INSTL_TY(rs.getString("X_SWIFI_INSTL_TY"))
                        .X_SWIFI_INSTL_MBY(rs.getString("X_SWIFI_INSTL_MBY"))
                        .X_SWIFI_SVC_SE(rs.getString("X_SWIFI_SVC_SE"))
                        .X_SWIFI_CMCWR(rs.getString("X_SWIFI_CMCWR"))
                        .X_SWIFI_CNSTC_YEAR(rs.getString("X_SWIFI_CNSTC_YEAR"))
                        .X_SWIFI_INOUT_DOOR(rs.getString("X_SWIFI_INOUT_DOOR"))
                        .X_SWIFI_REMARS3(rs.getString("X_SWIFI_REMARS3"))
                        .LAT(rs.getString("LAT"))
                        .LNT(rs.getString("LNT"))
                        .WORK_DTTM(rs.getString("WORK_DTTM"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnect.close(c, ps, rs);
        }

        return wifiDto;
    }
}
