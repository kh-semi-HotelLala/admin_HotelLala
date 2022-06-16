// 모달창

(function(){
    grantModalEvent();
    const modal = document.getElementsByClassName("modal")[0];
    const modalBtn = document.getElementById("modal-btn");
    const closeBtn = modal.querySelector(".modal-close");
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

})();

function grantModalEvent(){
    const reserveDetail = document.getElementsByClassName("reserve-detail");
    
    if(reserveDetail.length > 0){
        const modal = document.getElementsByClassName("modal")[0];
        

        for(let rd of reserveDetail){
            rd.addEventListener("click", function(){
                modal.classList.toggle('show');
            });
        };

    };
};


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

                // 층 버튼의 모든 배경색 제거
                for(let temp of floorBtn){
                    temp.classList.remove("floor-select");
                }

                // 선택한 층 버튼에만 배경색 추가
                btn.classList.add("floor-select");


                // 목록 지우기
                const top = document.querySelector(".top");
                top.innerHTML = "";
                
                // 객실 목록 만들기 (201,202,203)
                const arr = [];
                const num = btn.innerText.substring(0,1);
                for(let i=1 ; i<=3; i++){
                    arr.push(num * 100 + i);
                }

                console.log(arr);


                // 객실 출력
                for(let i=0 ; i<3; i++){

                    // 객실 테두리
                    const roomInfo = document.createElement("div");
                    roomInfo.classList.add("room-info");

                    // 객실 번호
                    const roomNo = document.createElement("div");
                    roomNo.innerText = arr[i];
                    roomInfo.append(roomNo);

                    // 예약된 객실인 경우
                    if(room[i] != undefined && ( room[i].roomNo == arr[i] ) ){ 
                        roomInfo.classList.add("in");
                        
                        const name = document.createElement("div");
                        name.innerText = room[i].memberName + " 님";


                        const rDate = document.createElement("div");
                        rDate.innerText = room[i].checkIn + "~(" + room[i].dateRange + "박)";

                        const btnArea = document.createElement("div");
                        const b = document.createElement("button");
                        b.classList.add("reserve-detail");
                        b.innerText = "예약상세";

                        btnArea.append(b);
                        
                        roomInfo.append(name, rDate, btnArea);


                    }else{ // 예약되지 않은 객실인 경우
                        const div = document.createElement("div");
                        div.innerText = "예약가능";

                        roomInfo.append(div);
                    }

                    top.append(roomInfo);
                }

                // 예약 상세 버튼에 모달 이벤트 추가
                grantModalEvent();
    
            },
            error : function(request, status, error){
                console.log('error');
            }
    
        });
    });
}

