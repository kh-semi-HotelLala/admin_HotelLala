/* 이메일 비밀번호 입력 검증을 위한 함수 */
const inputNo = document.getElementById("adminNo");
const inputPW = document.getElementById("adminPw");


function loginValidate(){
    if(inputNo.value.trim()==''){
        alert("관리자 번호 입력하세요")
        inputNo.value="";
        inputNo.focus();
        return false;
    }   

    if(inputPW.value.trim()==''){
        alert("비밀번호를 입력하세요")
        return false;
    }   

    const regExpNo = /\d{6}$/; //길이
    console.log(!regExpNo.test(inputNo.value));

   /*  if(regExpNo.test(inputNo.value)){
        alert("올바른 관리자 번호를 입력하세요")
        inputNo.value="";
        inputNo.focus();
        return false;
    }
    
    const regExpPw = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,16}$/; 
    console.log(!regExpPw.test(inputPw.value));


    if(regExpPw.test(inputPW.value)){
        alert("비밀번호 형식이 올바르지 않습니다.(8~16자 영문 숫자 조합)")
        return false;
    }
 */
    return true;
}