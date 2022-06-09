<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<section id="side-bar">
            <div>
                <a href="/Admin_HotelLala/src/main/webapp/index.html">
                    <img src="/Admin_HotelLala/resources/images/logo.png" id="logo">
                </a>
            </div>
            <div>
                <div class="admin-info">
                    <!-- 프로필 이미지 ... 다시 고르기  -->
                    <img src="/Admin_HotelLala/resources/images/user.png">
                </div>
                <div class="admin-info">
                    <div id="admin-name">김매니저</div>
                    <div id="admin-email">sample@lala.or.kr</div>
                </div>
            </div>
            <div id="menu-bar">
                <div>Menu</div>
                <ul>
                    <li class="menu">
                        <strong id="payment">예약</strong>
                        <ul>
                            <li class="board-list"><a href="/HotelLala/src/main/webapp/html/reserve-select.html" >예약리스트</a></li>
                            <li class="board-list"><a href="/HotelLala/src/main/webapp/html/room-manage.html" >객실관리</a> </li>
                            <li class="board-list"><a href="/HotelLala/src/main/webapp/html/refund-select.html" >환불내역</a></li>
                        </ul>
                    </li>
                    
                    <li class="menu">
                        <strong id="guest">고객</strong>
                        <ul>
                            <li class="board-list"><a href="/admin/고객전체조회 게시판.html" >고객 전체 조회</a></li>
                            <li class="board-list"><a href="#" >고객 검색</a> </li>
                        </ul>
                    </li>
                    <li class="menu">
                        <strong id="board">게시판</strong>
                        <ul>
                            <li class="board-list"><a href="/admin/게시판/공지사항 게시판.html" >공지사항</a></li>
                            <li class="board-list"><a href="/admin/게시판/QNA 게시판 .html 게시판.html" >QNA</a> </li>
                            <li class="board-list"><a href="#" >FAQ</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div>
                <a href="#" id="logout">로그아웃</a>
            </div>
        </section>