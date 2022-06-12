<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>admin signUp</title>

<link rel="stylesheet" href="${contextPath}/resources/css/admin/signUp-style.css">

<!-- 아이콘 추가를 위한 링크 -->
<script src="https://kit.fontawesome.com/ea629e8085.js"
	crossorigin="anonymous"></script>

</head>
<body>
	<main class="container">

			
        <section class="signUp-content">
            
            
            <form action="signUp" method="post" name="signUp-form" id = "signUp-box" onsubmit="return signUpValidate()">
                <div id="logo-area">
                    <img src="${contextPath}/resources/images/Logo.png">
                </div>
                
                <div class="signUp-input-area">
                    <span class="required">이메일</span> 
                    <input type="text" id="email" name="email" placeholder="아이디(이메일)" maxlength="30" autocomplete="off" required> 
                    <button type="button" id="sendBtn">전송</button>
                </div>

                <!-- 인증번호 -->
                <div class="signUp-input-area">
                    <span class="required">인증번호</span> 
                    <input type="text" id="cNumber" placeholder="인증번호를 입력하세요" maxlength="6" autocomplete="off" CLASS="""> 
                    <button type="button" id="cBtn">확인</button>
                </div>


                <!-- 비밀번호 -->
                <div id="pw-input-area">
                    <label for="memberPw">
                        <span class="required">비밀번호</span> 
                    </label>
                    <div class="signUp-input-area pw-area">
                        <input type="password" id="password" name="password" placeholder="비밀번호" maxlength="30"> 
                        <input type="password" id="passwordConfirm" placeholder="비밀번호 확인" maxlength="30"> 
                    </div>
                </div>

                <!-- 전화번호 -->
                <label for="memberTell">
                </label>
                
                <div class="signUp-input-area tell-area">
                    <span class="required">전화번호</span>  
                    <input type="text" id="tell" name="tell" placeholder="( -없이 숫자만 입력)" maxlength="11"> 
                </div>
                 <button type="submit" id="signUp-btn">등록</button>
            </form>
        </section>
	</main>

    <!-- jQuery Library 추가 -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <!-- singup.js 연결 -->

</body>

</html>