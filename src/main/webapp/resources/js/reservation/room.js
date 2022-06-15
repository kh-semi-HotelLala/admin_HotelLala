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





const floorBtn = document.getElementsByClassName("floorBtn");

for(let btn of floorBtn){
    btn.addEventListener("click", function(){
        let f = btn.innerText;
        switch(f){
        case '2F' : f="SINGLE"; break;
        case '3F' : f="STANDARD"; break;
        case '4F' : f="DELUX"; break;
        case '5F' : f="SUITE"; break;
        case '6F' : f="FAMILY"; break;
        }


        $.ajax({
            url : "room", 
            data : {"floor" : f}, // 전송 파라미터
            type : "POST", // 전송 방식
            dataType : "JSON",
            success : function(room){
    
                console.log(room);



    
            },
            error : function(request, status, error){
                console.log('error');
            }
    
        });
    });
}

