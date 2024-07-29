package com.hmw.jsp.wifi.servlet;


import com.hmw.jsp.wifi.Rq;
import com.hmw.jsp.wifi.controller.WifiController;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/wifi/*")
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        Rq rq = new Rq(req, resp);

        WifiController wifiController = new WifiController();

        switch (rq.getPath()) {
            case "/wifi/load-wifi" -> wifiController.getDataBases(rq);
            case "/wifi/detail_wifi.jsp" -> wifiController.showDetail(rq);
            case "/wifi/bookmark-group.jsp" -> wifiController.showBookMarkGroup(rq);
            case "/wifi/bookmark-group-add.jsp" -> wifiController.addBookMarkGroupForm(rq);
            case "/wifi/bookmark-group-add-submit.jsp" -> wifiController.addBookMarkGroup(rq);
            case "/wifi/bookmark-group-edit.jsp" -> wifiController.editBookMarkForm(rq);
            case "/wifi/bookmark-group-edit-submit.jsp" -> wifiController.editSubmitBookMark(rq);
            case "/wifi/bookmark-group-delete.jsp" -> wifiController.deleteBookMarkForm(rq);
            case "/wifi/bookmark-group-delete-submit.jsp" -> wifiController.deleteSubmitBookMark(rq);
        }

    }
}
