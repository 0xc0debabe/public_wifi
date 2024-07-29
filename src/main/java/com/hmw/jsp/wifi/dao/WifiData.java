package com.hmw.jsp.wifi.dao;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hmw.jsp.wifi.db.DBConnect;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WifiData {
    private final DBConnect dbConnect = new DBConnect();

    public int getDatabases() throws IOException {
        int start = 1; int end = 1;
        String wifiURL = "http://openapi.seoul.go.kr:8088/50537452466b6f6e36354375487949/json/TbPublicWifiInfo/";
        URL url = new URL(wifiURL + start + "/" + end);

        // URL 요청
        Request build = new Request.Builder().url(url).get().build();

        OkHttpClient okHttpClient = new OkHttpClient();
        Response response = okHttpClient.newCall(build).execute();

        int cnt = 0;

        try {
            if (response.isSuccessful()) {
                ResponseBody responseBody = response.body();

                if (responseBody != null) {
                    JsonElement jsonElement = JsonParser.parseString(responseBody.string());
                    cnt = jsonElement.getAsJsonObject()
                            .get("TbPublicWifiInfo")
                            .getAsJsonObject().get("list_total_count")
                            .getAsInt();

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        try {
            for (int i = 0; i <= cnt / 1000; i++) {
                start = 1 + (1000 * i);
                end = (i + 1) * 1000;

                url = new URL(wifiURL + start + "/" + end);
                build = new Request.Builder().url(url).get().build();
                okHttpClient = new OkHttpClient();
                Response res = okHttpClient.newCall(build).execute();

                if (res.isSuccessful()) {
                    ResponseBody responseBody = res.body();

                    if (responseBody != null) {
                        JsonElement jsonElement = JsonParser.parseString(responseBody.string());

                        JsonArray jsonArray = jsonElement
                                .getAsJsonObject()
                                .get("TbPublicWifiInfo")
                                .getAsJsonObject()
                                .get("row")
                                .getAsJsonArray();

                        insertPublicWifi(jsonArray);
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cnt;
    }

    public void insertPublicWifi(JsonArray jsonArray) {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = dbConnect.connectionDB();
            c.setAutoCommit(false);

            String sql = " insert into wifi_info "
                    + " (X_SWIFI_MGR_NO, X_SWIFI_WRDOFC, X_SWIFI_MAIN_NM, X_SWIFI_ADRES1, X_SWIFI_ADRES2, "
                    + " X_SWIFI_INSTL_FLOOR, X_SWIFI_INSTL_TY, X_SWIFI_INSTL_MBY, X_SWIFI_SVC_SE, X_SWIFI_CMCWR, "
                    + " X_SWIFI_CNSTC_YEAR, X_SWIFI_INOUT_DOOR, X_SWIFI_REMARS3, LAT, LNT, WORK_DTTM) "
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?); ";

            ps = c.prepareStatement(sql);

            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject data = jsonArray.get(i).getAsJsonObject();

                ps.setString(1, data.get("X_SWIFI_MGR_NO").getAsString());
                ps.setString(2, data.get("X_SWIFI_WRDOFC").getAsString());
                ps.setString(3, data.get("X_SWIFI_MAIN_NM").getAsString());
                ps.setString(4, data.get("X_SWIFI_ADRES1").getAsString());
                ps.setString(5, data.get("X_SWIFI_ADRES2").getAsString());
                ps.setString(6, data.get("X_SWIFI_INSTL_FLOOR").getAsString());
                ps.setString(7, data.get("X_SWIFI_INSTL_TY").getAsString());
                ps.setString(8, data.get("X_SWIFI_INSTL_MBY").getAsString());
                ps.setString(9, data.get("X_SWIFI_SVC_SE").getAsString());
                ps.setString(10, data.get("X_SWIFI_CMCWR").getAsString());
                ps.setString(11, data.get("X_SWIFI_CNSTC_YEAR").getAsString());
                ps.setString(12, data.get("X_SWIFI_INOUT_DOOR").getAsString());
                ps.setString(13, data.get("X_SWIFI_REMARS3").getAsString());
                ps.setString(14, data.get("LAT").getAsString());
                ps.setString(15, data.get("LNT").getAsString());
                ps.setString(16, data.get("WORK_DTTM").getAsString());

                ps.addBatch();
                ps.clearParameters();

                if ((i + 1) % 1000 == 0) {
                    ps.executeBatch();
                    c.commit();
                }

            }

            ps.executeBatch();
            c.commit();

        } catch (SQLException e) {
            e.printStackTrace();

            try {
                if (c != null) {
                    c.rollback();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        } finally {
            dbConnect.close(c, ps, rs);
        }
    }
}
