package com.yedam.emp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.emp.UserVO;
import com.yedam.emp.UserValidation;
import com.yedam.emp.service.UserService;

@Controller
public class LoginController {
	@Autowired UserService userService; //@Resource 와 같다.
	
	//패스워드 변경페이지로 이동
	@GetMapping("/changePassword")
	public String changePassword() {
		return "user/changePassword";
	}
	//패스워드 변경처리
	@PostMapping("/changePassword")
	public String changePasswordProc(HttpSession session,@ModelAttribute UserVO vo,BindingResult errors) {
		//validation 일치여부 확인
		UserValidation userValidation = new UserValidation();
		userValidation.validate(vo, errors);
		if(errors.hasErrors()) {
			return "user/changePassword";
		}else {
			//패스워드 변경서비스(db와 조회해서 db에 입력한 패스워드와 일치하는지 확인)
			String id = (String) session.getAttribute("loginid");
			vo.setId(id);
			userService.updatePassword(vo);
			return "redirect:/";
		}
	}
	
	//로그인 페이지로 이동 
	@GetMapping("/login")
	public String login() {
		return "user/login";
	}
	//로그인 처리
	@PostMapping("/login")
	public String loginproc(UserVO vo,HttpSession session) {
		if(userService.loginCheck(vo)) { //로그인 된 경우
			//세션에 저장 (필요하다면 단건조회해서 session에 담아두어도 된다.)
			session.setAttribute("loginid", vo.getId());
			return "redirect:/";
		} else { //로그인 안됀경우
			return "user/login";
		}
	}
	
	//로그아웃처리 
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); //세션무효화
		return "redirect:/";
	}
}
