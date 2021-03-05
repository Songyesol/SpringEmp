package com.yedam.board.service.impl;

import java.util.List;

import com.yedam.board.service.CommentsVO;

public interface CommentsMapper {
	//등록
	public int insertComments(CommentsVO vo);
	//삭제
	public int deleteComments(CommentsVO vo);
	//단건조회(id기준)
	public CommentsVO getComment(CommentsVO vo);
	//전체조회(board_id 기준)
	public List<CommentsVO> getSearchComments(CommentsVO vo);
}
