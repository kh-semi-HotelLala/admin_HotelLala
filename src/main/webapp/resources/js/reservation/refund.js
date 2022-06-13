const updateBtn = document.getElementById("updateBtn");
const deleteBtn = document.getElementById("deleteBtn");
const modalUpdate = document.getElementById("modalUpdate");
const modalClose = document.getElementById("modalClose");

updateBtn.addEventListener("click", function(){

    modal.classList.toggle("show");

    modalUpdate.addEventListener("click", function(){

        modal.classList.toggle("hide");

    });

});