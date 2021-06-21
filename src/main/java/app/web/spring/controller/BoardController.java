package app.web.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import app.web.spring.service.BoardService;
import app.web.spring.vo.BoardVO;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired 
	BoardService boardService;
	
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public ModelAndView pagination(@RequestParam(value = "title", defaultValue = "") String title,
			@RequestParam(value = "cp", defaultValue = "1") int cp,
			@RequestParam(value = "pageUnit", defaultValue = "10") int pageUnit) {
		
		ModelAndView mav = new ModelAndView("board/boardList");
		
		// pagination START
		int totalCount = 301; // 총 갯수
		int pageLength = 10; // 페이지네이션 버튼 갯수
		int finalPage = (totalCount + (pageUnit - 1)) / pageUnit; // 마지막 페이지
		if (cp < 1) {
			cp = 1;
		}
		
		int startNum = 1;
		int endNum = 10;			
		startNum = (cp - 1) * pageUnit + 1;
		endNum = cp * pageUnit;
		
		int currentBlock = cp % pageLength == 0 ? cp / pageLength : (cp / pageLength) + 1;
		int startPage = (currentBlock - 1) * pageLength + 1;
		int endPage = startPage + pageLength - 1;
		if (endPage > finalPage) {
			endPage = finalPage;
		}
		mav.addObject("cp", cp);
		mav.addObject("startPage", startPage);
		mav.addObject("endPage", endPage);
		mav.addObject("finalPage", finalPage);
		mav.addObject("pageUnit", pageUnit);	
		// pagination END
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("title", title);
		param.put("startNum", startNum);
		param.put("endNum", endNum);
		
		try {
			List<BoardVO> boardList = (ArrayList<BoardVO>)boardService.getBoardList(param);
			mav.addObject("boardList", boardList);			
		} catch (Exception e) {
			logger.error("[BoardController] getBoardList() Exception : " + e.toString());
		}
		
		return mav;
	}
	
}
