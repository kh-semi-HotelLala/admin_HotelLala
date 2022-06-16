$(document).ready(function() {
	$('#summernote').summernote({
		  height: 400,                 // 에디터 높이
		  minHeight: '80%',             // 최소 높이
		  maxHeight: '80%',            // 최대 높이
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
          resize: false,
          toolbar: [
            // [groupName, [list of button]]
            ['fontname', ['fontname']],
            ['fontsize', ['fontsize']],
            ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
            ['color', ['forecolor','color']],
            ['table', ['table']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['height', ['height']],
            ['insert',['picture','link','video']],
            ['view', ['fullscreen', 'help']]
          ],
        fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
        fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
	});
});
function inputValidate(){
   const title = document.getElementById("title");
   const note = document.getElementById("summernote");
    if(title.value==''){
        alert("제목을 작성해주세요.");
        title.value="";
        title.value.focus();
        return false;   
    }
    if(note.value.replace(/<p><br><\/p>/gm,'') == ''){
        alert("게시글을 작성해주세요.");
        note.value="";
        note.value.focus();
        return false;
    }
    return true;
}






/* 

1. 섬머노트의 xss는 자동 지원인지 
    ( '<p>dsaasd&lt;h1&gt;&lt;/h1&gt;</p><p><br></p>' )

2. 섬머노트의 공백 trim()으로 안되는데 <br>은 어떻게 처리하는지.

3.  QNA목록에서 처음에 SQL로 100개만 조회하고 끝에 도달했을떼 
    AJAX로 앞서 조회한 마지막 PK 이후 100개만 리스트 조회
    이후 ArrayList로 append 추가해도 되는지 
    
    기존 페이지 네이션은 현재 위치에서 앞뒤로 이동하지만 
    제가 조회할 목록은 아래로 리스트만 계속 조회 +추가 되고 
    오른쪽 아래에 TOP:0으로 이동시키는 BUTTON을 만들 예정.
    (

        SELECT * FROM (
            SELECT 
            ROWNUM AS RNUM,
            QNA_NO,
            QNA_TITLE,
            CREATE_DT,
            ANSWER,
            MEMBER_NM
            FROM QNA_BOARD
        JOIN MEMBER USING(MEMBER_NO)
        ORDER BY QNA_NO DESC
        ) WHERE RNUM BETWEEN ? AND ?+99;


    )
*/