package co.micol.prj.board.command;

import java.util.Scanner;

import co.micol.prj.board.service.BoardVO;

public class BoardDelete implements Command {
	private Scanner scb = new Scanner(System.in);
	@Override
	public void execute() {
		// 게시글삭제
		BoardVO vo = new BoardVO();
		System.out.println("=========================");
		System.out.println("삭제할 글 번호를 입력하세요.");
		vo.setBid(scb.nextInt());
		int n = dao.boardDelete(vo);
		if( n != 0) {
			System.out.println("정상적으로 삭제되었습니다.");
		}else {
			System.out.println("게시글 삭제에 실패하였습니다.");
		}
	}

}
