package org.zerock.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myproject.domain.BoardVO;
import com.myproject.domain.Criteria;
import com.myproject.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;

	/*
	 * @Test public void test() { mapper.getList().forEach(board->log.info(board));
	 * }
	 * 
	 * @Test public void testInsertSelectkey() {
	 * 
	 * BoardVO board=new BoardVO(); board.setTitle(null); board.setContent(null);
	 * board.setWriter(null);
	 * 
	 * mapper.insertSelectkey(board);
	 * 
	 * log.info(board); }
	 */
	@Test
	public void testPaging() {
		Criteria cri=new Criteria();
		cri.setPageNum(2);
		cri.setAmount(10);
		
		
		List<BoardVO> list=mapper.getListWithPaging(cri);
		list.forEach(board ->log.info(board.getBno()));
	}
	

}
