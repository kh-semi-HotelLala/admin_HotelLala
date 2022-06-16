// 검색창에 이전 검색 기록 반영
(function(){

    const select = document.getElementById("selectSearch");
    const input = document.getElementById("search-query");

    const option = document.querySelectorAll("selectSearch > option");

    if(select != null){

        const params = new URL(location.href).searchParams;

        const key = params.get("select");
        const query = params.get("query");

        input.value = query;
    }


})();



// 예약 상태 변경
(function(){

    const complete = document.getElementById("complete");
    const cancle = document.getElementById("cancle");
    
    const temp = document.getElementById("temp");

    if(temp.value() == 'Y'){
        cancle.style.backgroundColor = "#003458";
        cancle.style.color = "white";
    }
 
})();