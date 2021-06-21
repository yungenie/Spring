package app.web.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.web.spring.dao.BoardDao;
import app.web.spring.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDao boardDao;
	
	@Override
	public List<BoardVO> getBoardList(Map<String, Object> param) throws Exception {
		return boardDao.selectBoardList(param);
	}

}