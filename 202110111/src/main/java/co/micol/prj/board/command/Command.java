package co.micol.prj.board.command;

import co.micol.prj.board.service.BoardService;
import co.micol.prj.board.serviceImpl.BoardServiceImpl;
import co.micol.prj.mybatis.BoardMybatisService;

public interface Command {
//	public BoardService dao = new BoardServiceImpl();
	public BoardService dao = new BoardMybatisService();		//매번 쓸거니까 interface로 상속시켜서 사용했다.
	public void execute();
}
