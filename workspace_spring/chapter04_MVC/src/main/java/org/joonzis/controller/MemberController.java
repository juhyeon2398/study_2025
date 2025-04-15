 package org.joonzis.controller;


import org.joonzis.domain.MemberVO;
import org.joonzis.service.MemberServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberServiceImple service;
	
	@Autowired
	private PasswordEncoder pwEncoder;
	
	@GetMapping("/join")
	public String join() {
		log.info("join page...");
		return "/member/join";
	}

	@PostMapping("/join")
	public String insertJoin(MemberVO vo) {
		log.info(vo.getUserPw());
		vo.setUserPw(pwEncoder.encode(vo.getUserPw()));
		
		log.info("encoding : " + vo.getUserPw());
		
		int result = service.insert(vo);
		if(result > 0) {
			log.info("success");
		}else {
			log.info("fail");
		}
		log.info("insertJoin...");
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login() {
		log.info("join page...");
		return "/member/login";
	}
	
	@PostMapping("/login")
	public String loginAction(MemberVO vo,Model model) {
		MemberVO user = service.findId(vo.getUserId());
		if(pwEncoder.matches(vo.getUserPw(), user.getUserPw())){
        	return "/";
        }else{
        	return "/member/login";
        }
	}
}
