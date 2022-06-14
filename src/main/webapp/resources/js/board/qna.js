function answerValidate(){
    const textArea = document.getElementById("answer");
    if(textArea.value.trim().length==0){
        alert("답변을 입력해주세요.");
        textArea.focus();
        return false; 
    }
};

const deleteBtn = document.getElementById("deleteBtn");
const qnaNo = document.getElementById("qnaNo");
deleteBtn.addEventListener("click",function(){
    if(confirm("해당 문의글을 정말 삭제하시겟습니까?")){
        location.href="qna?type=delete&boardNo="+qnaNo.value;
    }
})