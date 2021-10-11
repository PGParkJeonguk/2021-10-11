package co.micol.prj.board.command;

import java.util.Scanner;

import co.micol.prj.board.service.BoardVO;

public class BoardInsert implements Command {
	private Scanner scb = new Scanner(System.in);
	@Override
	public void execute() {
		//게시글등록
		BoardVO vo = new BoardVO();
		System.out.println("====================");
		System.out.println("작성자를 입력하세요.");
		vo.setBwriter(scb.nextLine());
		System.out.println("제목을 입력하세요.");
		vo.setBTitle(scb.nextLine());
		System.out.println("내용을 입력하세요.");
		vo.setBContents(scb.nextLine());
		int n = dao.boardInsert(vo);
		if(n != 0) {
			System.out.println("정상적으로 등록되었습니다.");
		}else {
			System.out.println("등록에 실패하였습니다.");
		}
	}

}
