(function(){

    const updateBtn = document.getElementsByClassName("updateBtn")[0];
    const deleteBtn = document.getElementsByClassName("deleteBtn")[0];
    const modalUpdate = document.getElementById("modalUpdate");
    const modalClose = document.getElementById("modalClose");
    const modal = document.getElementsByClassName("modal")[0];
    const closeBtn = modal.querySelector(".modal-close");
    
    closeBtn.addEventListener("click", function(){
        modal.classList.toggle('hide');
    });

    modalBtn.addEventListener("click", function(){
        modal.classList.toggle("show");
    });

    updateBtn.addEventListener("click", function(){
        modal.classList.toggle("hide");
    });

    deleteBtn.addEventListener("click", function(){
        modal.classList.toggle("hide");
    });
    

})();