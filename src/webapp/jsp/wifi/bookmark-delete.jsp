<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.hmw.jsp.wifi.dto.WifiDto" %>
<%@ page import="com.hmw.jsp.wifi.dao.SearchWifi" %>
<%@ page import="com.hmw.jsp.wifi.dao.BookMarkDao" %>
<%@ page import="com.hmw.jsp.wifi.dto.BookmarkListDto" %>
<%@ page import="com.hmw.jsp.wifi.dto.BookMarkGroupDto" %>
<%@ page import="java.util.ArrayList" %>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/style2.css">
</head>

<%
    BookmarkListDto bld = (BookmarkListDto)request.getAttribute("bookmarkListDto");
    SearchWifi sw = new SearchWifi();
    BookMarkDao bd = new BookMarkDao();
%>

    <body>
    <h1>위치 히스토리 목록</h1>
    <%@include file="/jsp/header.jsp"%>
    <br>
    북마크를 삭제하시겠습니까?
    <br>

    <form action="http://localhost:8080/wifi/bookmark-delete-submit.jsp" method="get">

    <table>
        <tr>
            <th>북마크 이름(km)</th>
            <td><%=bd.findGroupById(bld.getGroup_id()).getName()%></td>
        </tr>

        <tr>
            <th>와이파이명</th>
            <%
            long infoId = bld.getInfo_id();
            WifiDto wifiDto = sw.findWifiInfoById(infoId);
            String distance = String.valueOf(wifiDto.getDistance());
            String mgrNo = wifiDto.getX_SWIFI_MGR_NO();
            %>
            <td><%=wifiDto.getX_SWIFI_MAIN_NM()%></td>
        </tr>

        <tr>
            <th>등록일자</th>
            <td><%=bld.getRegister_dttm()%></td>
        </tr>

    </table>
        <div style="text-align: center; margin-top: 10px;">
            <a href="http://localhost:8080/wifi/bookmark-list.jsp">돌아가기</a>|<button type="submit">삭제</button>
        </div>

        <input hidden="hidden" name="id" value="<%=bld.getId()%>">
    </form>
    </body>