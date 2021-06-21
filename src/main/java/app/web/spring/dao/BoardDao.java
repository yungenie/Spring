package app.web.spring.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import app.web.spring.vo.BoardVO;

@Repository
public class BoardDao {

	private final String NAMESPACE = "mappers.boardMapper.";

	@Autowired 
	SqlSession sqlSession;	
	
	public List<BoardVO> selectBoardList(Map<String, Object> param) throws Exception {
		return sqlSession.selectList(NAMESPACE + "boardList", param);
	}

}