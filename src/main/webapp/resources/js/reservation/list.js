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