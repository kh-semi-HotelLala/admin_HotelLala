const checkObj = {
    "Email":false,
    "pwCheck":false,
    "pwConfirm":false,
    "tell":false,
    "sendEmail" :false //인증번호 발송 체크를 위한 
};

const email = document.getElementById("email");
const sendBtn = document.getElementById("sendBtn");
/* 이메일 전송을 위한 이벤트 */
sendBtn.addEventListener("click",function(){
    
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
                checkObj.Email = true;
             }else{
                alert("이메일 발송에 실패하였습니다.")
            }
        },
        error:function(req,staus,error){
            console.log("이메일 발송 실패....");
        }
    })
}) 


// 이메일 인증번호 확인
const cNumber = document.getElementById("cNumber");
const  cBtn = document.getElementById("cBtn");
cBtn.addEventListener("click",function(){

    //1. 인증번호 받기 버튼이 클릭되어 이메일이 발송되었을 경우
    if(checkObj.Email){
        if(cNumber.value.length==6){ //6자리일 경우
            $.ajax({
                url:"checkNumber",
                data:{"cNumber":cNumber.value,"email":email.value},
                type:"GET",
                success:function(result){
                    console.log(result);
                    //1: 인증번호도 일치하고 O 시간도 만족 O
                    //2: 인증번호는 일치 O 시간은 만족 X
                    //3: 인증번호 일치 X
                    if(result==1){  
                         cBtn.disabled=true;
                         sendBtn.disabled=true;
                         cNumber.disabled=true;
                         
                         cBtn.classList.add("checkEmail")
                         sendBtn.classList.add("checkEmail");

                         cBtn.innerText="확인완료";
                         cNumber.style.backgroundColor="#003458";
                         checkObj.sendEmail = true;

                    }else if(result==2){
                        alert("만료된 인증번호입니다")
                    }else{
                        alert("인증번호가 일치하지 않습니다")
                    }
                },
                error:function(req,staus,error){
                    console.log("이메일 발송 실패....");
                }
            })

        } else{ //6자리가 아닐 경우
            alert("인증번호를 정확하게 입력해주세요..")
        }     
    }else{ //인증번호를 안받은 경우
        alert("[전송] 버튼을 먼저 클릭해주세요.")
    }

})


//비밀번호 정규식 체크 + 확인 체크
const pw = document.getElementById("password")
const pwConfirm = document.getElementById("passwordConfirm")
const pwMsg = document.getElementById("pwConfirmMessage");
pw.addEventListener("keyup",function(){
    //값이 지워지면 태그 내부 삭제.
    if(this.value.trim() == ''){
        pwMsg.innerHTML="";
        checkObj.pwCheck=false;
    }
    //입력한 이메일이 정규식에 통과하면 obj true
    const regExpPw=/^[a-z,A-Z,0-9]{4,30}$/;
    if(regExpPw.test(this.value)){
        checkObj.pwCheck=true;
    }
})
pwConfirm.addEventListener("keyup",function(){

    if(this.value.trim() == ''){
        pwMsg.innerHTML="";
        checkObj.pwConfirm=false;
    }
    if(checkObj.pwCheck){
        if(pw.value==pwConfirm.value){
            pwMsg.style.color="green"
            pwMsg.classList.remove("pwFail")
            pwMsg.classList.add("pwConfirm");
            pwMsg.innerText="일치";
            checkObj.pwConfirm=true;
        }else{
            pwMsg.style.color="red"
            pwMsg.classList.remove("pwConfirm")
            pwMsg.classList.add("pwFail");
            pwMsg.innerText="불일치";
            checkObj.pwConfirm=false;
        }
    }
})

const tell = document.getElementById("tell");
const telMsg = document.getElementById("tellConfirmMessage");
tell.addEventListener("keyup",function(){
    if(this.value.trim()==''){
        checkObj.tell = false;
    }
    const regExpTell=/^(010|011|016|017|018|019)\d{3,4}\d{4}$/;
    if(regExpTell.test(this.value)){
        checkObj.tell = true;
    }
})




function signUpValidate(){
    //checkObj에 있는 모든 속성을 반복 접근하여 
    //false 가 하나라도 있는 경우에는 false 반환
    let str;
    for(let k in checkObj){
        if(!checkObj[k]){ //현재 접근 중인 value가 false인 경우.
                switch(k){
                    case "Email":     str="이메일이"; break;
                    case "pwCheck":   str="비밀번호가"; break;    
                    case "pwConfirm": str="비밀번호 확인이"; break;
                    case "tell":       str="전화번호가"; break;
                    case "sendEmail":  str="이메일 인증이"; break;
                    }            
            alert(str+" 유효하지 않습니다.");    
            return false;
        }
    }
}