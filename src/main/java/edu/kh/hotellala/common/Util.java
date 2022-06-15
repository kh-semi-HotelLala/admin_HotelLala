package edu.kh.hotellala.common;



public class Util {
	//개행문자-> <br>태그 변경 메서드 메서드
	public static String newLineHandling(String content) {
		//return content.replaceAll("(\n|\r|\r\n|\n\r)", "<br>");
		
		return content.replaceAll("(\r\n|\r|\n|\n\r)", "<br>");
	}
	
	/**개행문자 처리를 해제후 반환하는 메서드
	 * @param content
	 * @return
	 */
	public static String reverseLineHandling(String content) {
		return content.replaceAll( "<br>","\n");
	}
	
	
	
	
	
	
	
	
	//XSS : 관리자가 아닌 이용자가 악성 스크립트를 입력칸에 삽입해 공격하는. 웹 취약점 중하나
	//Cross site Script(ing) (크로스 사이트 스크립트(팅)) 공격 방지 처리 -> util에 작성
	public static String XssHandling(String content) {
		// < , > (태그) , &nbsp(띄어쓰기) , ""(속성값)
		//HTML 코드가 아닌 문자그대로 보이게 변경.
		if(content != null) {
			content = content.replaceAll("&","&amp;"); //& 기호 변환이 최상단에 위치해야 된다.
			content = content.replaceAll("<","&lt;");
			content = content.replaceAll(">","&gt;");
			content = content.replaceAll("\"","&quot;");
		}
		return content;
	}
	

}
