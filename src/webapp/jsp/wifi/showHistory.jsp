<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.hmw.jsp.wifi.dto.HistoryDto" %>
<%@ page import="java.util.ArrayList" %>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/style2.css">
</head>

<%
ArrayList<HistoryDto> list = (ArrayList<HistoryDto>)request.getAttribute("list");
%>

    <body>
    <h1>위치 히스토리 목록</h1>
    <%@include file="/jsp/header.jsp"%>

    <table>
            <br>
            <thead>
            <tr>
                <th>ID</th>
                <th>X좌표</th>
                <th>Y좌표</th>
                <th>조회일자</th>
                <th>비고</th>
            </tr>
            </thead>

            <tbody>
            <%
                if(list.size() > 0) {
                    for (HistoryDto historyDto : list) {
            %>
                    <tr>
                        <td><%=historyDto.getId()%></td>
                        <td><%=historyDto.getLat()%></td>
                        <td><%=historyDto.getLnt()%></td>
                        <td><%=historyDto.getSearch_dttm()%></td>
                        <td>
                        <form action="http://localhost:8080/wifi/history-delete.jsp" method="get">
                            <input type="hidden" name="id" value="<%= historyDto.getId() %>">
                            <button type="submit">삭제</button>
                        </form>
                        </td>
                    <% } %>
                <% } else { %>
                <td colspan='17'> 위치 정보를 입력한 후에 조회해 주세요. </td>
                <% } %>
            </tbody>
        </table>
</body>
