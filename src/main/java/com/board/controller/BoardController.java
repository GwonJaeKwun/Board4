package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.board.domain.BoardDTO;
import com.board.mapper.BoardMapper;
import com.board.menus.domain.MenuDTO;
import com.board.menus.mapper.MenuMapper;

@Controller
public class BoardController {
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Autowired
	private BoardMapper boardMapper;

	@RequestMapping("/Board/List")
	public ModelAndView list(MenuDTO menuDTO) {
		//메뉴 리스트
		List<MenuDTO> menuList = menuMapper.getMenuList();
		
		//게시물 목록처리
		List<BoardDTO> boardList = boardMapper.getBoardList(menuDTO);
		
	    ModelAndView mv = new ModelAndView();
	    mv.addObject("menuList", menuList);
	    mv.addObject("boardList", boardList);
		mv.setViewName("board/list" );
	    return mv;
	}
	
}
