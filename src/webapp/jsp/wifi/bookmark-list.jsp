<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.hmw.jsp.wifi.dto.BookmarkListDto" %>
<%@ page import="com.hmw.jsp.wifi.dto.WifiDto" %>
<%@ page import="com.hmw.jsp.wifi.dao.SearchWifi" %>
<%@ page import="com.hmw.jsp.wifi.dao.BookMarkDao" %>
<%@ page import="java.util.ArrayList" %>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/style2.css">
</head>

<%
    ArrayList<BookmarkListDto> list = (ArrayList<BookmarkListDto>)request.getAttribute("bookmarkListDtos");
    SearchWifi sw = new SearchWifi();
    BookMarkDao bd = new BookMarkDao();
%>

    <body>
    <h1>위치 히스토리 목록</h1>
    <%@include file="/jsp/header.jsp"%>

    <table>
        <br>
        <thead>
        <tr>
            <th>ID</th>
            <th>북마크 이름</th>
            <th>와이파이명</th>
            <th>등록일자</th>
            <th>비고</th>
        </tr>
        </thead>

        <tbody>
        <%
        if (list.size() > 0) {
            for (BookmarkListDto bl : list) {
            %>
            <tr>
                <td><%=bl.getId()%></td>
                <td><%=bd.findGroupById(bl.getGroup_id()).getName()%></td>
                <td>
                    <%
                    long infoId = bl.getInfo_id();
                    WifiDto wifiDto = sw.findWifiInfoById(infoId);
                    String distance = String.valueOf(wifiDto.getDistance());
                    String mgrNo = wifiDto.getX_SWIFI_MGR_NO();
                    %>
                    <a href="http://localhost:8080/wifi/detail_wifi.jsp?distance=<%= distance %>&mgrNo=<%= mgrNo %>"><%=wifiDto.getX_SWIFI_MAIN_NM()%></a>
                </td>
                <td><%=bl.getRegister_dttm()%></td>
                <td>
                    <a href="http://localhost:8080/wifi/bookmark-delete.jsp?id=<%=bl.getId()%>">삭제</a>
                </td>

            <% } %>
    <% } else { %>
        <td colspan='17'> 정보가 존재하지 않습니다. </td>
    <% } %>
        </tbody>
    </table>
    </body>