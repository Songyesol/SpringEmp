package com.yedam.board.controller;


import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.board.service.CommentsService;
import com.yedam.board.service.CommentsVO;

@RestController //이것을 사용하면 controller안에 모든 메서드가  ajax 응답으로 바뀜.
public class CommentsController {
	
	@Autowired CommentsService commentsService;
	
	//등록처리
	//@RequestBody : json타입으로 입력된 값 파싱해서 자바객체에 담아줌
	@PostMapping("/comments")
	public Map insertComments(@RequestBody CommentsVO vo) {
		int r = commentsService.insertComments(vo);
		/*
		 * if(vo.getId().equals("0")) { return vo; }else {
		 * commentsService.insertComments(vo); }
		 */
		System.out.println("======="+vo.getOut_msg());
		return Collections.singletonMap("cnt", r);
	}
	
	//수정 
	@PutMapping("/comments")
	public CommentsVO updateComments(@RequestBody CommentsVO vo) {
		System.out.println("==============="+vo);
		return vo;
	}
	
	//삭제 //method=RequestMethod.DELETE
	@DeleteMapping(value = "/comments") 
	public Map deleteComments(@RequestBody CommentsVO vo) {
		int r = commentsService.deleteComments(vo);
		return Collections.singletonMap("cnt", r);
	}
	
	//조회(id기준)
	@GetMapping("/comments/{id}")
	public CommentsVO getComment(CommentsVO vo , @PathVariable String id) {
		vo.setId(id);
		return commentsService.getComment(vo);
	}
	
	
	//해당 게시글의 댓글 전체조회(board_id 기준)
	@GetMapping("/comments")
	public List<CommentsVO> getSearchComments(CommentsVO vo){
		return commentsService.getSearchComments(vo);
	}
}
