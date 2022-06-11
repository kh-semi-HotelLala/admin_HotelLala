// 모달창
const modal = document.getElementById("modal");
const modalBtn = document.querySelectorAll(".reserve-detail");
const closeBtn = modal.querySelector(".modal-close");

modalBtn.addEventListener("click", function(){

    modal.style.display = "flex";

});

closeBtn.addEventListener("click", function(){
    modal.style.display = "none";
});

