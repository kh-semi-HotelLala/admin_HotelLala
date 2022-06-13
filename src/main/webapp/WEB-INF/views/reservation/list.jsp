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
                <form action="#" method="get" id="reserve-search">
                    <div class="reserve-search">
                        <div>
                            <select name="select">
                                <option value="reserve-date">예약일</option>
                                <option value="reserve-num">예약번호</option>
                                <option value="room-num">객실번호</option>
                                <option value="member-num">회원이름</option>
                            </select>
                        </div>
                            
                        <div class="search-area">
                            
                            <input type="search" id="search" name="search"
                                autocomplete="off" placeholder="search">
        
                            <button type="submit" id="search-btn" >검색</button>
                            
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
                            <th>객실번호</th>
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
                                    <td>${paymentDate}</td>
                                    <td>${memberName}</td>
                                    <td>${memberName}</td>
                                    <td>${roomNo}</td>
                                    <td>${checkIn}</td>
                                    <td>${checkOut}</td>
                                    <td>
                                        <button id="btn">상세보기</button>
                                    </td>
                                </tr>

                            </c:forEach>

                            </c:otherwise>

                        </c:choose>
                        
                        <!-- <tr>
                            <td>2022-05-18</td>
                            <td>유저일</td>
                            <td>101</td>
                            <td>2022-06-01</td>
                            <td>2022-06-02</td>
                            <td>
                                <a href="listDetail">
                                    <button id="btn">상세보기</button>
                                </a>
                            </td>
                        </tr>
                        <tr>
                            <td>2022-05-18</td>
                            <td>유저일</td>
                            <td>101</td>
                            <td>2022-06-01</td>
                            <td>2022-06-02</td>
                            <td>
                                <a href="listDetail">
                                    <button id="btn">상세보기</button>
                                </a>
                            </td>
                        </tr> -->
                    </tbody>
                </table>
            </div>

            <!-- <div class="pagination-area">
                <ul class="pagination">
                    <li><a href="#">&lt;&lt;</a></li>
                    <li><a href="#">&lt;</a></li>
                    
                    <li><a class="current">1</a></li>
                    <li><a href="${contexxtPath}/reservation/list?cp=2">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">6</a></li>
                    <li><a href="#">7</a></li>
                    <li><a href="#">8</a></li>
                    <li><a href="#">9</a></li>
                    <li><a href="#">10</a></li>

                    <li><a href="#">&gt;</a></li>
                    <li><a href="#">&gt;&gt;</a></li>
                </ul>
            </div> -->
        
        </section>
    </main>
    </body>
    </html>

    
    