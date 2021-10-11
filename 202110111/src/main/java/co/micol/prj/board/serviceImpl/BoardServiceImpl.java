package co.micol.prj.board.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import co.micol.prj.board.service.BoardService;
import co.micol.prj.board.service.BoardVO;
import co.micol.prj.common.DataSource;

public class BoardServiceImpl implements BoardService {
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public List<BoardVO> boardSelectList() {
		List<BoardVO> list = new ArrayList<BoardVO>();
		BoardVO board;
		String sql = "select * from board";
		try{
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				board = new BoardVO();
				board.setBid(rs.getInt("bid"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBwriteDate(rs.getDate("bwritedate"));
				board.setBTitle(rs.getString("BTITELE"));
				board.setBHit(rs.getInt("bhit"));
				list.add(board);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

	@Override
	public BoardVO boardSelect(BoardVO board) {	//선택된 하나의 글 일기
		String sql = "select * from board where bid = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getBid());
			rs = psmt.executeQuery();
			if(rs.next()) {
				board.setBwriter(rs.getString("bwriter"));
				board.setBwriteDate(rs.getDate("bwritedate"));
				board.setBTitle(rs.getString("BTITELE"));
				board.setBContents(rs.getString("BCONTENTS"));
				board.setBHit(rs.getInt("BHIT"));
				hitUpdate(board.getBid()); //조회수증가
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	
		return board;
	}

	@Override
	public int boardInsert(BoardVO board) {		//글 추가
		int n = 0;
		String sql = "insert into board values (b_squ.nextval,?,sysdate,?,?,0)";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getBwriter());
			psmt.setString(2, board.getBTitle());
			psmt.setString(3, board.getBContents());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int boardUpdate(BoardVO board) {		//글 수정
		int n = 0;
		String sql = "update board set bcontents = ? Where bid = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getBContents());
			psmt.setInt(2, board.getBid());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int boardDelete(BoardVO board) {		//글 삭제
		int n = 0;
		String sql = "delete from board where bid = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, board.getBid());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	private void setInt(int i, int bid) {
		// TODO Auto-generated method stub
		
	}

	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null ) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void hitUpdate(int bId) {	// 조회수 증가
		String sql = "update board set bhit = bhit +1 where bid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bId);
			psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
