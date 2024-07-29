<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="/css/style2.css">
</head>

<body>
    <h1>위치 히스토리 목록</h1>
    <%@include file="/jsp/header.jsp"%>
    <br>
    <form action="http://localhost:8080/wifi/bookmark-group-add-submit.jsp" method="get">

        <table>

            <tr>
                <th>북마크 이름</th>
                <td><input type="text" name="bookmarkName" /></td>
            </tr>

            <tr>
                <th>순서</th>
                <td><input type="text" name="order" /></td>
            </tr>

        </table>

        <div style="text-align: center; margin-top: 10px;">
            <button type="submit">추가</button>
        </div>

    </form>
</body>