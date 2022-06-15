for(let i in ob){
    console.log(i);
}


//상세조회의 경우 수행 함수
const params = new URL(location.href).searchParams;

//상세조회일때만 
if(params.get('type')=='detail'){ 

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
        location.href="qna?type=delete&no="+qnaNo.value;
    }
})
}

//검색했을때만 수행.
if(params.get('type')=='search'){ 
/* 검색했을때 parameter로  */
(function(){
    const answer = params.get('answer')
    const category = params.get('category')
    const answerArr =document.getElementById("answer");
    const categoryArr =document.getElementById("category");

    for(let i of answerArr){
        if(i.value == answer){            i.selected = true        }
    }
    for(let c of categoryArr){
        if(c.value == category){            c.selected = true        }
    }
    
})()
}


