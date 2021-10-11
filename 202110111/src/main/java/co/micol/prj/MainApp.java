package co.micol.prj;

import co.micol.prj.board.command.BoardList;
import co.micol.prj.board.command.BoardSelect;
import co.micol.prj.board.command.Command;
import co.micol.prj.common.BoardMenu;

public class MainApp {

	public static void main(String[] args) {
		//게시판 프로젝트
//		작업순서 1. VO객체 생성 dao 생성
//			   2. 인터페이스 생성
//				3. 인터페이스 구현체 생성
//		Command command = new BoardSelect();		//초기값에 따라서 달라지낟.
//		command.execute();
		
		BoardMenu boardMenu = new BoardMenu();
		boardMenu.run();
		
	}

}
