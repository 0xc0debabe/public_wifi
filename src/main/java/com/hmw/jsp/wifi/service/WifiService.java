package com.hmw.jsp.wifi.service;

import com.hmw.jsp.wifi.dao.BookMarkDao;
import com.hmw.jsp.wifi.dao.SearchWifi;
import com.hmw.jsp.wifi.dao.WifiData;
import com.hmw.jsp.wifi.dto.BookMarkGroupDto;
import com.hmw.jsp.wifi.dto.WifiDto;

import java.io.IOException;
import java.util.List;

public class WifiService {
    private WifiData wifiData = new WifiData();
    private SearchWifi searchWifi = new SearchWifi();
    private BookMarkDao bookMarkDao = new BookMarkDao();

    public int getDataBases() {
        try {
            return wifiData.getDatabases();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public WifiDto findOne(String mgrNo, double dist) {
        WifiDto wifiDto = searchWifi.findOne(mgrNo, dist);
        return wifiDto;
    }

    public List<BookMarkGroupDto> findAll() {
        List<BookMarkGroupDto> list = bookMarkDao.findAll();
        return list;
    }

    public void addBookMarkGroup(String bookmarkName, String order) {
        bookMarkDao.addBookMarkGroup(bookmarkName, order);
    }

    public BookMarkGroupDto findGroupById(long id) {
        BookMarkGroupDto bookMarkGroupDto = bookMarkDao.findGroupById(id);
        return bookMarkGroupDto;
    }

    public void bookMarkGroupEdit(long id, String bookMarkName, String order) {
        bookMarkDao.bookMarkGroupEdit(id, bookMarkName, order);
    }

    public void bookMarkGroupDel(long id) {
        bookMarkDao.bookMarkGroupDel(id);
    }
}
