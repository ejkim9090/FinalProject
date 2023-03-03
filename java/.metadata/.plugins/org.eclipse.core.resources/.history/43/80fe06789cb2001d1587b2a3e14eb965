package kr.common.comment.service;

import java.sql.Connection;
import java.util.List;

import kr.common.comment.dao.CommentDao;
import kr.common.comment.vo.CommentVo;
import static kr.common.jdbc.JDBCTemplate.*;

public class CommentService {
	public CommentVo getBoardComment(int boardId, CommentVo vo) {
		CommentVo result = null;
		Connection con = getConnection();
		
		result = new CommentDao().getBoardComment(boardId, vo, con);
		
		return result;
	}

	public int getCountComment(int boardid) {
		System.out.println("1게시글 번호 : " + boardid);
		int result = 0;
		Connection con = getConnection();
		
		result = new CommentDao().getCountComment(boardid, con);
		close(con);
		
		return result;
	}
	
	public List<CommentVo> getCommentList(int srnum, int ernum, int boardid) {
		List<CommentVo> result = null;
		Connection con = getConnection();
		
		result = new CommentDao().getCommentList(con, srnum, ernum, boardid);
		
		return result;
	}
}
