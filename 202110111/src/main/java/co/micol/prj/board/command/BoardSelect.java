package co.micol.prj.board.command;

import java.util.Scanner;

import co.micol.prj.board.service.BoardService;
import co.micol.prj.board.service.BoardVO;
import co.micol.prj.board.serviceImpl.BoardServiceImpl;

public class BoardSelect implements Command {
	private Scanner scb = new Scanner(System.in);
	@Override
	public void execute() {
		
		BoardVO board = new BoardVO();
		System.out.println("=========================");
		System.out.println("조회할 글번호를 입력하세요.");
		board.setBid(scb.nextInt()); // 1번글 가져오기
		board = dao.boardSelect(board);

		System.out.println("번호 : " + board.getBid() + "      ");
		System.out.println("작성자 : " +board.getBwriter() + "      ");
		System.out.println("작성날짜 : " +board.getBwriteDate() + "      ");
		System.out.println("제목 : " +board.getBTitle() + "      ");
		System.out.println("내용 : " +board.getBContents() + "      " );
		System.out.println("조회수 : " +board.getBHit() + "      ");
		
	}
	
}
