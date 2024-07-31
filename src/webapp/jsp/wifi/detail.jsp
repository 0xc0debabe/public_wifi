<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.hmw.jsp.wifi.dto.WifiDto" %>
<%@ page import="com.hmw.jsp.wifi.dto.BookMarkGroupDto" %>
<%@ page import="java.util.ArrayList" %>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/style2.css">
</head>

<%
    WifiDto wifiDto = (WifiDto)request.getAttribute("wifiDto");
    ArrayList<BookMarkGroupDto> list = (ArrayList<BookMarkGroupDto>)request.getAttribute("list");
%>

<body>
<h1>와이파이 정보 구하기</h1>
<%@include file="/jsp/header.jsp"%>

    <form action="/wifi/bookmark-add-submit.jsp", method="get">
        <br>
        <select name="bgId">
            <option value="none" selected>북마크 그룹 이름 선택</option>
            <% for (BookMarkGroupDto bg : list) { %>
                <option value="<%=bg.getId()%>">
                    <%=bg.getName()%>
                </option>
            <% } %>
        </select>
        <input type="submit" value="북마크 추가하기">
        <input hidden="hidden" name="wifiId" value="<%=wifiDto.getId()%>">
        <br>
    </form>


<table>
    <tr>
        <th>거리(km)</th>
        <td><%=wifiDto.getDistance()%></td>
    </tr>

    <tr>
        <th>관리번호</th>
        <td><%=wifiDto.getX_SWIFI_MGR_NO()%></td>
    </tr>

    <tr>
        <th>자치구</th>
        <td><%=wifiDto.getX_SWIFI_WRDOFC()%></td>
    </tr>

    <tr>
        <th>와이파이명</th>
        <td><%=wifiDto.getX_SWIFI_MAIN_NM()%></td>
    </tr>

    <tr>
        <th>도로명주소</th>
        <td><%=wifiDto.getX_SWIFI_ADRES1()%></td>
    </tr>

    <tr>
        <th>상세주소</th>
        <td><%=wifiDto.getX_SWIFI_ADRES2()%></td>
    </tr>

    <tr>
        <th>설치위치(층)</th>
        <td><%=wifiDto.getX_SWIFI_INSTL_FLOOR()%></td>
    </tr>

    <tr>
        <th>설치유형</th>
        <td><%=wifiDto.getX_SWIFI_INSTL_TY()%></td>
    </tr>

    <tr>
        <th>설치기관</th>
        <td><%=wifiDto.getX_SWIFI_INSTL_MBY()%></td>
    </tr>

    <tr>
        <th>서비스구분</th>
        <td><%=wifiDto.getX_SWIFI_SVC_SE()%></td>
    </tr>

    <tr>
        <th>망종류</th>
        <td><%=wifiDto.getX_SWIFI_CMCWR()%></td>
    </tr>

    <tr>
        <th>설치년도</th>
        <td><%=wifiDto.getX_SWIFI_CNSTC_YEAR()%></td>
    </tr>

    <tr>
        <th>실내외구분</th>
        <td><%=wifiDto.getX_SWIFI_INOUT_DOOR()%></td>
    </tr>

    <tr>
        <th>WIFI접속환경</th>
        <td><%=wifiDto.getX_SWIFI_REMARS3()%></td>
    </tr>

    <tr>
        <th>X좌표</th>
        <td><%=wifiDto.getLAT()%></td>
    </tr>
    <tr>
        <th>Y좌표</th>
        <td><%=wifiDto.getLNT()%></td>
    </tr>

    <tr>
        <th>작업일자</th>
        <td><%=wifiDto.getWORK_DTTM()%></td>
    </tr>
</table>
</body>