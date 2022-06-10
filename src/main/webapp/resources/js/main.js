/* 이메일 비밀번호 입력 검증을 위한 함수 */
const inputEmail = document.getElementById("adminNo");
const inputPW = document.getElementById("adminPw");
function loginValidate(){
    if(adminNo.value.trim()==''){
        
        alert("이메일을 입력")
        return false;
    }

}