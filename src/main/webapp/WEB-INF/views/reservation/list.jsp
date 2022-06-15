<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>예약관리_조회</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/sideBar-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/reservation/list-style.css">
   

</head>
<body>

    <main class="container">
        
        
        <jsp:include page="/WEB-INF/views/common/sideBar.jsp" />
        
        <section id="content">
            
            <div class="content-header">
                <div class="content-name">Reserve</div> 
                <div class="content-detailname">- 예약조회</div>
            </div>
        
            <div>        
                <form action="list" method="get" id="reserveSearch" onsubmit="return searchValidate()">
                    <div class="reserve-search">
                        <div>
                            <select name="select" id="selectSearch">
                                <option value="reserve-date">예약일</option>
                                <option value="room-num">객실번호</option>
                                <option value="member-name">회원이름</option>
                            </select>
                        </div>
                            
                        <div class="search-area">
                            
                            <input type="search" id="search-query" name="query"
                                autocomplete="off" placeholder="search">
        
                            <button type="submit" id="search-btn" name="query">검색</button>
                            
                        </div>
                            
                    </div>
                </form>    
            </div>
    
            <div class="reserve-list">
                
                <table class="list-table">
                    <thead>
                        <tr>
                            <th>예약일</th>
                            <th>이름</th>
                            <th>객실호수</th>
                            <th>입실일</th>
                            <th>퇴실일</th>
                            <th>상세보기</th>
                        </tr>
                    </thead>
        
                    <tbody>

                        <c:choose>
                            <c:when test="empty reserveList">
                                <tr>
                                    <td>예약 정보가 없습니다.</td>
                                </tr>
                            </c:when>

                            <c:otherwise>

                            <c:forEach var="reserve" items="${reserveList}">

                                <tr>
                                    <!-- 나중에 작성해야 함! -->
                                    <td>${reserve.paymentDate}</td> 
                                    <td>${reserve.memberName}</td>
                                    <td>${reserve.roomNo}</td>
                                    <td>${reserve.checkIn}</td>
                                    <td>${reserve.checkOut}</td>
                                    <td>
                                        <a href="listDetail?no=${reserve.requestNo}">
                                            <button id="btn">상세보기</button>
                                        </a>
                                    </td>
                                </tr>

                            </c:forEach>

                            </c:otherwise>

                        </c:choose>
                        
                    </tbody>
                </table>
            </div>
        
        </section>
    </main>

    <script src="${contextPath}/resources/js/reservation/list.js"></script>

    </body>
    </html>

    
    