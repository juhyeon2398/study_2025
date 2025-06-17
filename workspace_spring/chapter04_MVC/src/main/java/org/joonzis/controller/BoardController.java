package org.joonzis.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import org.joonzis.domain.BoardVO;
import org.joonzis.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*")
public class BoardController {

    @Autowired
    private BoardService service;

    // 게시글 전체 조회
    @GetMapping(value = "/boardList", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BoardVO> getBoardList() {
        List<BoardVO> list = service.getAllList();
  
        return list;
    }

    // 게시글 상세 조회
    @GetMapping(value = "/board/{idx}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BoardVO getBoard(@PathVariable int idx) {
        BoardVO vo = service.getBoard(idx);
        return vo;
    }

    // 게시글 삽입
    @PostMapping("/board")
    public String register(@RequestBody BoardVO vo) {
        String result = service.register(vo) > 0 ? "success" : "fail";
        return result;
    }
    
    // 게시글 삭제
    @DeleteMapping(value = "/board/{idx}")
    public String delete(@PathVariable int idx){
        service.delete(idx);
        return "success";
    }

    // 게시글 수정
    @PutMapping("/board")
    public String putMethodName(@RequestBody BoardVO vo) {
        return service.update(vo) > 0 ? "success" : "fail";
    }
}