const checkObj = {
    "Email":false,
    "PwCheck":false,
    "PwConfirm":false,
    "memberTel":false,
    "sendEmail" :false //인증번호 발송 체크를 위한 
};



const email = document.getElementById("email")
/* 이메일 전송을 위한 이벤트 */
document.getElementById("sendBtn").addEventListener("click",function(){
    
    //이메일 정규식
    regExpEmail =/^[a-zA-Z0-9+-\_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;


    if(email.value.trim() == ''){
        alert("이메일을 입력하세요");
        email.focus();
        return false
    }

    if(!regExpEmail.test(email.value)){
        alert("정확한 이메일을 입력하세요 계정@도메인.최상위도메인 ");
        email.value="";
        email.focus();
        return false
    }

    $.ajax({
        url:"sendEmail", //필수 속성 (어디로 비동기 요청을 보낼건지)
        data:{"email":email.value},//서버로 전달할 parameter
        type:"GET",
        success:function(result){
            if(result==1){  
                alert("이메일 발송 성공.")
             }else{
                alert("이메일 발송에 실패하였습니다.")
            }
        },
        error:function(req,staus,error){
            console.log("이메일 발송 실패....");
        }
    })
    



}) 