package com.yedam.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.board.service.CommentsService;
import com.yedam.board.service.CommentsVO;

@Service
public class CommentsServiceImpl implements CommentsService {

	@Autowired CommentsMapper commentDAO;
	
	public int insertComments(CommentsVO vo) {
		return commentDAO.insertComments(vo);
	}

	public int deleteComments(CommentsVO vo) {
		return commentDAO.deleteComments(vo);
	}

	public CommentsVO getComment(CommentsVO vo) {
		return commentDAO.getComment(vo);
	}

	public List<CommentsVO> getSearchComments(CommentsVO vo) {
		return commentDAO.getSearchComments(vo);
	}

}
