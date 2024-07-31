<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ page import="com.hmw.jsp.wifi.dao.SearchWifi" %>
<%@ page import="com.hmw.jsp.wifi.dao.HistoryDao" %>
<%@ page import="com.hmw.jsp.wifi.dto.WifiDto" %>
<%@ page import="com.hmw.jsp.wifi.dto.HistoryDto" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>

    <%
    String lat = (String)request.getParameter("lat");
    String lnt = (String)request.getParameter("lnt");
    %>

<div>
    <br>
    LAT : <input id="lat" type="text" value="0.0">
    LNT : <input id="lnt" type="text" value="0.0">
    <button id="btn_myLocation">내 위치 가져오기</button>
    <button id="btn_nearbyWifi">근처 WIFI 정보 보기</button>
</div>

<script>
    let getLocation = document.getElementById("btn_myLocation");
    let getNearByWifi = document.getElementById("btn_nearbyWifi");

    window.onload = () => {
        let lat = document.getElementById("lat").value;
        let lnt = document.getElementById("lnt").value;
    }

    getLocation.addEventListener("click", function () {
        if ('geolocation' in navigator) {
            navigator.geolocation.getCurrentPosition(function (position){
                let latitude = position.coords.latitude;
                let longitude = position.coords.longitude;
                document.getElementById("lat").value = latitude;
                document.getElementById("lnt").value = longitude;
            });
        }
    });



    getNearByWifi.addEventListener("click", function (){
        let latitude = document.getElementById("lat").value;
        let longitude = document.getElementById("lnt").value;

        if (latitude !== "" || longitude !== "") {
            window.location.assign("http://localhost:8080/?lat=" + latitude + "&lnt=" + longitude);
        } else {
            alert("위치 정보를 입력한 후에 조회해 주세요.");
        }
    });
</script>

<div>
    <table>
        <br>
        <thead>
        <tr>
            <th>거리(Km)</th>
            <th>관리번호</th>
            <th>자치구</th>
            <th>와이파이명</th>
            <th>도로명주소</th>
            <th>상세주소</th>
            <th>설치위치(층)</th>
            <th>설치유형</th>
            <th>설치기관</th>
            <th>서비스구분</th>
            <th>망종류</th>
            <th>설치년도</th>
            <th>실내외구분</th>
            <th>WIFI접속환경</th>
            <th>X좌표</th>
            <th>Y좌표</th>
            <th>작업일자</th>
        </tr>
        </thead>

    <tbody>
    <%
    if (lat != null && lnt != null) {
    SearchWifi searchWifi = new SearchWifi();
    HistoryDao historyDao = new HistoryDao();
    historyDao.saveHistory(lat, lnt);

    List<WifiDto> list = searchWifi.getNearbyWifi(lat, lnt);

        if (list != null) {
            for (WifiDto wifiDto : list) {
        %>
        <tr>
            <td><%=wifiDto.getDistance()%></td>
            <td><%=wifiDto.getX_SWIFI_MGR_NO()%></td>
            <td><%=wifiDto.getX_SWIFI_WRDOFC()%></td>
            <td>
                <a href="wifi/detail_wifi.jsp?mgrNo=<%= wifiDto.getX_SWIFI_MGR_NO() %>&distance=<%= wifiDto.getDistance() %>"><%= wifiDto.getX_SWIFI_MAIN_NM() %></a>
            </td>
            <td><%=wifiDto.getX_SWIFI_ADRES1()%></td>
            <td><%=wifiDto.getX_SWIFI_ADRES2()%></td>
            <td><%=wifiDto.getX_SWIFI_INSTL_FLOOR()%></td>
            <td><%=wifiDto.getX_SWIFI_INSTL_TY()%></td>
            <td><%=wifiDto.getX_SWIFI_INSTL_MBY()%></td>
            <td><%=wifiDto.getX_SWIFI_SVC_SE()%></td>
            <td><%=wifiDto.getX_SWIFI_CMCWR()%></td>
            <td><%=wifiDto.getX_SWIFI_CNSTC_YEAR()%></td>
            <td><%=wifiDto.getX_SWIFI_INOUT_DOOR()%></td>
            <td><%=wifiDto.getX_SWIFI_REMARS3()%></td>
            <td><%=wifiDto.getLAT()%></td>
            <td><%=wifiDto.getLNT()%></td>
            <td><%=wifiDto.getWORK_DTTM()%></td>
        </tr>
            <% } %>
        <% } %>
    <% } else { %>
        <td colspan='17'> 위치 정보를 입력한 후에 조회해 주세요. </td>
    <% } %>
    </tbody>

</table>
</div>
</body>
