// (function(){
//     const updateBtn = document.getElementsByClassName("updateBtn")
    
//     if(updateBtn.length > 0){
//         const modal = document.getElementsByClassName("modal");
//         const closeBtn = modal.querySelector(".modal-close");
        
//         for(let up of updateBtn){
//             up.addEventListener("click", function(){
//                 modal.classList.toggle('show');
//             });
//         };

//         closeBtn.addEventListener("click", function(){
//             modal.classList.toggle('hide');
//             setTimeout(function(){
//                 modal.classList.toggle('hide');
//                 modal.classList.toggle('show');
//             },0);
//         });

//         updateBtn.addEventListener("click", function(){
//             modal.classList.toggle("hide");
//             setTimeout(function(){
//                 modal.classList.toggle('hide');
//                 modal.classList.toggle('show');
//             })
//         });

//     };
    


// });





(function(){
    grantModalEvent();
    const modalUpdate = document.getElementById("modal-update");
    const modalClose = document.getElementById("modal-close");
    const closeBtn = modal.querySelector(".modal-close");
    
    closeBtn.addEventListener("click", function(){
        modal.classList.toggle('hide');
        setTimeout(function(){
            modal.classList.toggle('hide');
            modal.classList.toggle('show');
        },0);
    });

    modalUpdate.addEventListener("click", function(){
        modal.classList.toggle("hide");
        setTimeout(function(){
            modal.classList.toggle('hide');
            modal.classList.toggle('show');
        },0);
    });

    modalClose.addEventListener("click", function(){
        modal.classList.toggle("hide");
        setTimeout(function(){
            modal.classList.toggle('hide');
            modal.classList.toggle('show');
        },0);
    });

})();

function grantModalEvent(){
    const updateBtn = document.getElementsByClassName("updateBtn");
    
    if(updateBtn.length > 0){
        const modal = document.querySelector(".modal");

        for(let up of updateBtn){
            up.addEventListener("click", function(){
                modal.classList.toggle('show');
            });
        };

    };
};
