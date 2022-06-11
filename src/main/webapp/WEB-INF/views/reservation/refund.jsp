<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>환불관리</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/sideBar-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/reservation/refund-style.css">
</head>
<body>

    <main class="container">
        
        <jsp:include page="/WEB-INF/views/common/sideBar.jsp" />

        <section id="content">

            <div class="content-header">
                <div class="content-name">Sales</div> 
                <div class="content-detailname">- 환불내역</div>
            </div>

            <div>        
                <form action="#" method="get" id="refund-search">
                    <div class="refund-search">
                        <div>
                            <select name="select">
                                <option value="refund-date">환불요청일</option>
                                <option value="reserve-name">예약자명</option>
                                <option value="room-num">객실번호</option>
                                <option value="refund-status">환불상태</option>
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

            <div class="refund-list">
                
                <table class="list-table">
                    <thead>
                        <tr>
                            <th>환불번호</th>
                            <th>예약자명</th>
                            <th>객실번호</th>
                            <th>예약일</th>
                            <th>환불요청일</th>
                            <th>처리현황</th>
                            <th>관리</th>
                        </tr>
                    </thead>

                    <tbody>
                        
                        <tr>
                            <td>01</td>
                            <td>유저일</td>
                            <td>101</td>
                            <td>2022-06-01</td>
                            <td>2022-05-29</td>
                            <td><span id="wait">대기중</span></td>
                            <td>
                                <button id="updateBtn">환불처리</button>
                            </td>
                        </tr>
                        <tr>
                            <td>01</td>
                            <td>유저일</td>
                            <td>101</td>
                            <td>2022-06-01</td>
                            <td>2022-05-29</td>
                            <td><span id="complete">환불완료</span></td>
                            <td>
                                <button id="deleteBtn">삭제</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </section>
        </main>
                
                


    
    <div id="modal">
        <div class="modal-window">
            <div class="modal-close">&times;</div>
            <div class="title">
                <div>환불 수정</div>
            </div>
            <div class="modal-content">
                <div>
                    <div class="modal-name">
                        <div>결제 정보</div>
                    </div>
                    <div class="content-refund">
                        <div>
                            <div>예약자명</div>
                            <div>유저일</div>
                        </div>
                        <div>
                            <div>결제 금액</div>
                            <div>200,000 원</div>
                        </div>
                        <div>
                            <div>멤버십 사용 유무</div>
                            <div>
                                10,000 p
                            </div>
                        </div>
                    </div>
                    <div class="modal-name">
                        <div>환불 정보</div>
                    </div>
                    <div class="content-refund">
                        <div>
                            <div>환불 요청일</div>
                            <div>2022-05-29</div>
                        </div>
                        <div>
                            <div>환불 금액</div>
                            <div>200,000 원</div>
                        </div>
                        <div>
                            <div>환불 계좌</div>
                            <div>1110010101010</div>
                        </div>
                        <div>
                            <div>환불 사유</div>
                            <div>
                                환불 사유 
                                적는 입력란
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div>
                <button id="modal-update">수정</button>
                <button id="modal-close">취소</button>
            </div>
        </div>
    </div>
    
</body>
</html>