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


// 층별 룸 데이터 불러오기
const secondF = document.getElementById("secondF");
const thirdF = document.getElementById("thidF");
const forthF = document.getElementById("forthF");
const fifthF = document.getElementById("fifthF");
const sixthF = document.getElementById("sixthF");

