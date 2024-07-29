<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.hmw.jsp.wifi.dto.BookMarkGroupDto" %>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/style2.css">
</head>

<%
BookMarkGroupDto bm = (BookMarkGroupDto)request.getAttribute("bookMarkGroupDto");
%>

<body>
<h1>위치 히스토리 목록</h1>
<%@include file="/jsp/header.jsp"%>

<br>
북마크 그룹 이름을 삭제하시겠습니까?

<form action="http://localhost:8080/wifi/bookmark-group-delete-submit.jsp" method="get">

    <table>
        <br>
        <tr>
            <th>북마크 이름</th>
            <td><input type="text" name="bookmarkName" value="<%=bm.getName()%>"/></td>
        </tr>

        <tr>
            <th>순서</th>
            <td><input type="text" name="order" value="<%=bm.getOrder()%>"/></td>
        </tr>

        <input hidden="hidden" name="id" value="<%=bm.getId()%>">
    </table>

    <div style="text-align: center; margin-top: 10px;">
        <a href="http://localhost:8080/wifi/bookmark-group.jsp">돌아가기</a>|<button type="submit">삭제</button>
    </div>

</form>
</body>