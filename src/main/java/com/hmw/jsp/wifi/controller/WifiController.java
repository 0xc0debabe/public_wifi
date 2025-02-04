package com.hmw.jsp.wifi.controller;

import com.hmw.jsp.wifi.Rq;
import com.hmw.jsp.wifi.dao.HistoryDao;
import com.hmw.jsp.wifi.dto.BookMarkGroupDto;
import com.hmw.jsp.wifi.dto.BookmarkListDto;
import com.hmw.jsp.wifi.dto.HistoryDto;
import com.hmw.jsp.wifi.dto.WifiDto;
import com.hmw.jsp.wifi.service.WifiService;

import java.awt.datatransfer.FlavorListener;
import java.util.ArrayList;
import java.util.List;


public class WifiController {
    private WifiService wifiService = new WifiService();

    public void getDataBases(Rq rq) {
        int wifiTotalCnt = wifiService.getDataBases();
        rq.setAttr("wifiTotalCnt", wifiTotalCnt);
        rq.view("wifi/load-wifi");
    }

    public void showDetail(Rq rq) {
        String mgrNo = rq.getParam("mgrNo", "");
        double distance = Double.parseDouble(rq.getParam("distance", ""));
        WifiDto wifiDto = wifiService.findOne(mgrNo, distance);

        List<BookMarkGroupDto> bookMarkGroupDtoList = wifiService.findAll();
        rq.setAttr("list", bookMarkGroupDtoList);
        rq.setAttr("wifiDto", wifiDto);
        rq.setAttr("mgrNo", mgrNo);
        rq.view("wifi/detail");
    }

    public void showBookMarkGroup(Rq rq) {
        List<BookMarkGroupDto> list = wifiService.findAll();
        rq.setAttr("list", list);
        rq.view("wifi/bookMarkGroup");
    }

    public void addBookMarkGroupForm(Rq rq) {
        rq.view("wifi/addBookMarkGroupForm");
    }

    public void addBookMarkGroup(Rq rq) {
        String bookmarkName = rq.getParam("bookmarkName", "");
        String order = rq.getParam("order", "");
        wifiService.addBookMarkGroup(bookmarkName, order);
        rq.view("wifi/addBookMarkGroup");
    }

    public void editBookMarkForm(Rq rq) {
        long id = Long.parseLong(rq.getParam("id", ""));
        BookMarkGroupDto bookMarkGroupDto = wifiService.findGroupById(id);
        rq.setAttr("bookMarkGroupDto", bookMarkGroupDto);
        rq.view("/wifi/bookmark-group-edit");
    }

    public void editSubmitBookMark(Rq rq) {
        long id = Long.parseLong(rq.getParam("id", ""));
        String bookMarkName = rq.getParam("bookmarkName", "");
        String order = rq.getParam("order", "");
        wifiService.bookMarkGroupEdit(id, bookMarkName, order);
        rq.view("/wifi/bookmark-group-edit-submit");
    }

    public void deleteBookMarkForm(Rq rq) {
        long id = Long.parseLong(rq.getParam("id", ""));
        BookMarkGroupDto bookMarkGroupDto = wifiService.findGroupById(id);
        rq.setAttr("bookMarkGroupDto", bookMarkGroupDto);
        rq.view("/wifi/bookmark-group-delete");
    }

    public void deleteSubmitBookMark(Rq rq) {
        long id = Long.parseLong(rq.getParam("id", ""));
        wifiService.bookMarkGroupDel(id);
        rq.view("/wifi/bookmark-group-delete-submit");
    }

    public void addBookMarkList(Rq rq) {
        long bgId = Long.parseLong(rq.getParam("bgId", ""));
        long wifiId = Long.parseLong(rq.getParam("wifiId", ""));
        wifiService.saveBookMarkToList(bgId, wifiId);
        rq.view("/wifi/bookmark-add-submit");
    }

    public void showBookmarkList(Rq rq) {
        List<BookmarkListDto> bookmarkListDtos = wifiService.showBookMarkList();
        rq.setAttr("bookmarkListDtos", bookmarkListDtos);
        rq.view("/wifi/bookmark-list");
    }

    public void deleteBookMarkList(Rq rq) {
        long listId = Long.parseLong(rq.getParam("id", ""));
        BookmarkListDto bookmarkListDto = wifiService.findBookMarkListById(listId);
        rq.setAttr("bookmarkListDto", bookmarkListDto);
        rq.view("/wifi/bookmark-delete");
    }

    public void deleteSubmitBookMarkList(Rq rq) {
        long blid = Long.parseLong(rq.getParam("id", ""));
        wifiService.deleteBookMarkList(blid);
        rq.view("/wifi/bookmark-delete-submit");
    }


    public void showHistoryList(Rq rq) {
        List<HistoryDto> list = wifiService.showHistoryList();
        rq.setAttr("list", list);
        rq.view("/wifi/showHistory");
    }

    public void deleteHistory(Rq rq) {
        long id = Long.parseLong(rq.getParam("id", ""));
        wifiService.deleteHistory(id);
        rq.view("/wifi/history-delete-submit");
    }
}
