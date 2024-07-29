<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.hmw.jsp.wifi.dto.BookMarkGroupDto" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>

<%
    List<BookMarkGroupDto> bg = (ArrayList<BookMarkGroupDto>)request.getAttribute("list");
%>

<body>
    <h1>위치 히스토리 목록</h1>
    <%@include file="/jsp/header.jsp"%>

    <br>

    <button id="btn_addBMG">북마크 그룹 이름 추가</button>
    <script>
        let addGroup = document.getElementById("btn_addBMG");
        addGroup.addEventListener("click", function (){
        window.location.assign("http://localhost:8080/wifi/bookmark-group-add.jsp");
        });
    </script>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>북마크 이름</th>
            <th>순서</th>
            <th>등록일자</th>
            <th>수정일자</th>
            <th>비고</th>
        </tr>
        </thead>

        <tbody>
        <%
            if(bg.size() == 0) {%></td>
                <td colspan='17'> 정보가 존재하지 않습니다.</td>
            <%} else {
                for(BookMarkGroupDto bmgd : bg) {
        %>
                <tr>
                    <td><%=bmgd.getId()%></td>
                    <td><%=bmgd.getName()%></td>
                    <td><%=bmgd.getOrder()%></td>
                    <td><%=bmgd.getRegister_dttm()%></td>
                    <td><%=bmgd.getUpdate_dttm()%></td>
                    <td>
                        <a href="http://localhost:8080/wifi/bookmark-group-edit.jsp?id=<%=bmgd.getId()%>">수정</a>
                        <a href="http://localhost:8080/wifi/bookmark-group-delete.jsp?id=<%=bmgd.getId()%>">삭제</a>
                    </td>
                </tr>
                <%}
            }%>
        </tbody>
    </table>
</body>


