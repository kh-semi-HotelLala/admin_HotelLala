// clock
function clockFn(){
    
    const clock = document.getElementById("clock");
    
    clock.innerText = currentTime(); // 현재 시간 화면에 출력

    // 지연 시간 마다 반복(첫 반복도 지연 시간 후에 시작)
    // -> 페이지 로딩 후 1초 후 부터 반복(지연 -> 함수 -> 지연 -> 함수)
    interval = setInterval(function(){
        clock.innerText = currentTime();
    }, 1000);

};

function currentTime(){
    
    const now = new Date();

    let hour = now.getHours();
    let min = now.getMinutes();
    let sec = now.getSeconds();

    if(hour < 10) hour = "0" + hour;
    if(min < 10) min = "0" + min;
    if(sec < 10) sec = "0" + sec;

    return hour + " : " + min + " : " + sec;
}   


clockFn(); // 함수 호출


// 차트 영역
let barChart = document.getElementById('bar-chart').getContext('2d');

let chart = new Chart(barChart, {
    type : 'bar', // pie, line, doughnut, polarArea
    data : {
        labels : ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        datasets : [{
            label : '월별 매출액',
            data : [
                50,
                100,
                150,
                200,
                250,
                300
            ]
        }]
    }
})