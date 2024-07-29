<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    Integer wifiTotalCnt = (Integer) request.getAttribute("wifiTotalCnt");
    System.out.println("테스트");
    if (wifiTotalCnt == null) {
        wifiTotalCnt = 0;
    }
%>

<div style="display: flex; flex-direction: column; align-items: center; justify-content: flex-start; height: 100vh; text-align: center; padding-top: 20px;">
    <h1><%= wifiTotalCnt %>건의 데이터를 성공적으로 저장했습니다.</h1>
    <a href="http://localhost:8080">홈으로 돌아가기</a>
</div>