package com.yedam.board.service;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class CommentsVO {
	
	private String id; //int(9자리) long(13자리) BigDecimal 38자리
	private String[] ids; //@JsonIgnore
	private String name;
	private String content;
	private String board_id;
	@JsonIgnore private String out_msg;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date wdate;
	
}
