 package org.joonzis.controller;

import java.util.ArrayList;
import java.util.List;

import org.joonzis.domain.BoardAttachVO;
import org.joonzis.domain.BoardVO;
import org.joonzis.domain.Criteria;
import org.joonzis.domain.MemberVO;
import org.joonzis.domain.PageDTO;
import org.joonzis.mapper.BoardAttachMapper;
import org.joonzis.mapper.MemberMapper;
import org.joonzis.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService service;
	@Autowired
	private BoardAttachMapper attachMapper;
	// 게시글 전체 조회
	@GetMapping("/list")
	public String list(Model model, Criteria cri) {
		
		int parsePageNum = cri.getPageNum();
		int parseAmount = cri.getAmount();
		
		if(parsePageNum == 0) {
			cri.setPageNum(1);
		}
		if(parseAmount == 0) {
			cri.setAmount(15);
		}
		
		int total = service.listAll();
		PageDTO pdto = new PageDTO(cri, total);
		
		model.addAttribute("list",service.getList(cri));
		model.addAttribute("pageMaker",pdto);
		
		return "board/list";
	}
	
	// 게시글 등록
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/register")
	public String register(BoardVO vo) {
		service.register(vo);
		return "redirect:/board/list";
	}
	
	@PreAuthorize("isAuthenticated()") // 인증된 사용자면 true
	@GetMapping("/register")
	public void register2() {
		log.info("register2... ");
	}
	
	
	// 게시글 조회
	@GetMapping("/get")
	public String get(@RequestParam("bno") int bno, Model model) {
		log.info("get... " + bno);
		model.addAttribute("vo", service.get(bno));
		return "board/get";
	}
	

	
	// 게시글 수정
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/modify")
	public String modify(@RequestParam("bno") int bno, Model model) {
		MemberVO vo = new MemberVO();
		
		log.info("modifyGET... " + bno);
		model.addAttribute("vo", service.get(bno));
		return "board/modify";
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/modify")
	public String modify(BoardVO vo, RedirectAttributes rttr) {
		log.info(vo.getAttachList());
		List<BoardAttachVO> list = new ArrayList<BoardAttachVO>(); 
		List<BoardAttachVO> newList = new ArrayList<BoardAttachVO>(); 
		List<String> uuidList = new ArrayList<String>(); 

		log.info("size() : " + vo.getAttachList().size());
		if(vo.getAttachList() != null && vo.getAttachList().size() > 0) {
			vo.getAttachList().forEach(attach ->{
				log.info("fileSeach :" +service.fileSearch(attach.getUuid()));
				if(service.fileSearch(attach.getUuid()) < 1) {
					newList.add(attach);
				}else {
					uuidList.add(attach.getUuid());
				}
			});
			
			
			vo.setNewAttachList(newList);
			vo.setUuidList(uuidList);
		}
		
		if(service.modify(vo)) {
			rttr.addFlashAttribute("result" ," success");
		}
		return "redirect:/board/list";
	}
	
	// 게시글 삭제
	@PostMapping("/remove")
	public String remove(int bno) {
		log.info("remove... " + bno);
		service.remove(bno);
		return "redirect:/board/list";
	}
	
	// 첨부 파일 리스트
	@ResponseBody
	@GetMapping(
		value="/getAttachList/{bno}",
		produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<BoardAttachVO>> getAttachList(
		@PathVariable("bno") int bno){
		log.info("getAttachList..." + bno);
		return new ResponseEntity<List<BoardAttachVO>> (service.getAttachList(bno),HttpStatus.OK);
	}
}
