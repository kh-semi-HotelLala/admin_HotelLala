<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>- 예약상세조회</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/main-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/sideBar-style.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/reservation/list-detail-style.css">

</head>
<body>

    <main class="container">
        
        <jsp:include page="/WEB-INF/views/common/sideBar.jsp" />

        <section id="content">

                <!-- 페이지 이름 -->
                <div class="content-header">
                    <div class="content-name">Reserve</div> 
                    <div class="content-detailname">- 예약&결제 상세조회</div>
                </div>
            
                <!-- 페이지 내용 -->
                <div>예약 상세</div>
                <div class="reserve-info">
                    <div class="reserve">
                        <div>
                            <div class="reserve-no">
                                <div class="info-name">주문번호</div>
                                <div class="info-content">${detail.requestNo}</div>
                            </div>
                        
                            <div class="reserve-date">
                                <div class="info-name">예약접수일</div>
                                <div class="info-content">${detail.paymentDate}</div>
                            </div>
                        </div>
                            
                        <div>    
                            <div class="room-no">
                                <div class="info-name">객실번호</div>
                                <div class="info-content">${detail.roomNo}</div>
                            </div>
                            <div class="check-in">
                                <div class="info-name">입실일</div>
                                <div class="info-content">${detail.checkIn} / ${detail.dateRange}박</div>
                            </div>
                        </div>   
                            
                        <div>
                            <div class="room-type">
                                <div class="info-name">객실타입</div>
                                <div class="info-content">${detail.roomType}</div>
                            </div>
                            <div class="people">
                                <div class="info-name">인원</div>
                                <div class="info-content">${detail.adultCount+detail.childCount}명</div>
                            </div>
                        </div>
                        
                        <div>
                            <div class="member-nm">
                                <div class="info-name">예약자명</div>
                                <div class="info-content">${detail.memberName}</div>
                            </div>
                            <div class="member-phone">
                                <div class="info-name">휴대폰번호</div>
                                <div class="info-content">${detail.memberTel}</div>
                            </div>
                        </div>

                        <div>
                            <div class="birth-day">
                                <div class="info-name">생년월일</div>
                                <div class="info-content">${detail.memberBR}</div>
                            </div>
                            <div class="address">
                                <div class="info-name">주소</div>
                                <div class="info-content">${detail.memberAddress}</div>
                            </div>
                        </div>
                    </div>
                    <div class="req">
                        <div>
                            <div class="info-name">요청사항</div>
                            <div class="info-content">
                                <div>${detail.extraRequest}</div>
                            </div>                            
                        </div>
                    </div>
                </div>
                    <div class="reserve-status">
                        <div>
                            <div class="info-name">예약상태</div>
                            <div class="info-content">
                                <span id="complete">예약완료</span>
                            </div>                            
                        </div>
                    </div>
                    
                <div class="pay-info">
                    <div class="payment">
                        <div>
                            <div class="info-name">결제정보</div>
                            <div>
                                <div>
                                    <div class="info-name">기본가격</div>
                                    <div class="info-content">${payment.roomRates}</div>

                                    <!-- 비어있을 수 있음 -->
                                    <div class="info-name">옵션추가</div>
                                    <div class="info-content">${payment.extraRequest}</div>
                                </div>                            
                                <div>
                                    <!-- 비어있을 수 있음 -->
                                    <div class="info-name">결제수단</div>
                                    <div class="info-content">${payment.payType}</div>
                                    <div class="info-name">결제금액</div>
                                    <div class="info-content">${payment.paymentAmount}</div>
                                </div>                                                    
                            </div>
                        </div>
                    </div>
                </div>
                
                        
                <!-- 상세 페이지 저장/취소 버튼 -->
                <div class="btn">
                    <span>
                        <a href="${contextPath}/reservation/list">
                            <button id="save">확인</button>
                        </a>
                    </span>               
                </div>
        
        </section>
    </main>

    <script src="${contextPath}/resources/js/reservation/list.js"></script>
        
</body>
</html>