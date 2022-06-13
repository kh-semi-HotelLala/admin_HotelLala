const updateBtn = document.getElementsByClassName("updateBtn")[0];
const deleteBtn = document.getElementsByClassName("deleteBtn")[0];
const modalUpdate = document.getElementById("modalUpdate");
const modalClose = document.getElementById("modalClose");

updateBtn.addEventListener("click", function(){

    for(let up of updateBtn){
        modal.classList.toggle("show");
    }

    modalUpdate.addEventListener("click", function(){
        modal.classList.toggle("hide");
    });

});