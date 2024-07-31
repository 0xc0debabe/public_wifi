package com.hmw.jsp.wifi.service;

import com.hmw.jsp.wifi.dao.*;
import com.hmw.jsp.wifi.dto.BookMarkGroupDto;
import com.hmw.jsp.wifi.dto.BookmarkListDto;
import com.hmw.jsp.wifi.dto.HistoryDto;
import com.hmw.jsp.wifi.dto.WifiDto;

import java.io.IOException;
import java.util.List;

public class WifiService {
    private WifiData wifiData = new WifiData();
    private SearchWifi searchWifi = new SearchWifi();
    private BookMarkDao bookMarkDao = new BookMarkDao();
    private BookMarkListDao bookMarkListDao = new BookMarkListDao();
    private HistoryDao historyDao = new HistoryDao();

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

    public void saveBookMarkToList(long id, long wifiId) {
        bookMarkListDao.saveBookMarkToList(id, wifiId);
    }

    public List<BookmarkListDto> showBookMarkList() {
        List<BookmarkListDto> bookmarkListDtos = bookMarkListDao.showBookMarkList();
        return bookmarkListDtos;
    }

    public void deleteBookMarkList(long blid) {
        bookMarkListDao.deleteBookMarkList(blid);
    }

    public BookmarkListDto findBookMarkListById(long listId) {
        BookmarkListDto bookmarkListDto = bookMarkListDao.findBookMarkListById(listId);

        return bookmarkListDto;
    }

    public List<HistoryDto>  showHistoryList() {
        List<HistoryDto>  list = historyDao.showHistoryList();
        return list;
    }

    public void deleteHistory(long id) {
        historyDao.deleteHistory(id);
    }
}
