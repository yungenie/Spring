package app.web.spring.service;

import java.util.List;
import java.util.Map;

import app.web.spring.vo.BoardVO;

public interface BoardService {
	
	List<BoardVO> getBoardList(Map<String, Object> param) throws Exception;

}
