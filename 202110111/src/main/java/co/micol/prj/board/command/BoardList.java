package co.micol.prj.board.command;

import java.util.ArrayList;
import java.util.List;

import co.micol.prj.board.service.BoardService;
import co.micol.prj.board.service.BoardVO;
import co.micol.prj.board.serviceImpl.BoardServiceImpl;

public class BoardList implements Command {		//게시글 목록보는 명령.
	private List<BoardVO> list = new ArrayList<BoardVO>();
	private BoardService dao = new BoardServiceImpl();
	
	@Override
	public void execute() {
		list = dao.boardSelectList();
		System.out.println("순번  :  작성자  :     작성일자  :        제목           :      조회수:  ");
		for(BoardVO vo : list) {
			System.out.print(vo.getBid() + "      ");
			System.out.print(vo.getBwriter() + "      ");
			System.out.print(vo.getBwriteDate() + "      ");
			System.out.print(vo.getBTitle() + "      ");
			System.out.println(vo.getBHit() + "      ");
		}
	}
}
