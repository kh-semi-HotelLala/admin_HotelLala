// 모달창

(function(){
    const reserveDetail = document.getElementsByClassName("reserve-detail");
    
    if(reserveDetail.length > 0){
        const modal = document.getElementsByClassName("modal")[0];
        const modalBtn = document.getElementById("modal-btn");
        const closeBtn = modal.querySelector(".modal-close");

        for(let rd of reserveDetail){
            rd.addEventListener("click", function(){
                modal.classList.toggle('show');
            });
        }

        closeBtn.addEventListener("click", function(){
            modal.classList.toggle('hide');
            setTimeout(function(){
                modal.classList.toggle('hide');
                modal.classList.toggle('show');
            },450);
        });

        modalBtn.addEventListener("click", function(){
            modal.classList.toggle("hide");
            setTimeout(function(){
                modal.classList.toggle('hide');
                modal.classList.toggle('show');
            })
        });

    }

})();

// modalBtn.addEventListener("click", function(){

//     modal.style.display = "flex";

// });

// closeBtn.addEventListener("click", function(){
//     modal.style.display = "none";
// });


// 비동기 통신 이용해서 층별 룸 데이터 불러오기
const secondFloor = document.getElementById("secondF");
const thirdFloor = document.getElementById("thirdF");
const forthFloor = document.getElementById("forthF");
const fifthFloor = document.getElementById("fifthF");
const sixthFloor = document.getElementById("sixthF");

// 전역 변수 -> 층 수를 받는 -> 타입으로 받고
var f = '';

secondF.addEventListener("click", function(){
    f = "SINGLE";
    floor();   
});
thirdF.addEventListener("click", function(){
    f = "STANDARD";
    floor();  
});
forthF.addEventListener("click", function(){
    f = "DELUX";
    floor();   
});
fifthF.addEventListener("click", function(){
    f = "SUITE";
    floor();   
});
sixthF.addEventListener("click", function(){
    f = "FAMILY";
    floor();
});



function floor(){
    
    //AJAX 코드 작성 (jQuery 방식)
    $.ajax({
        url : "/reservation/room", 
        data : {"floor" : f}, // 전송 파라미터
        type : "GET", // 전송 방식
        dataType : "JSON",
        success : function(){

            

        },
        error : function(request, status, error){
            
        }

    });
}

// 