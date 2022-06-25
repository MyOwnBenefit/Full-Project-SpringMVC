package com.myproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.domain.BoardAttachVO;
import com.myproject.domain.BoardVO;
import com.myproject.domain.Criteria;
import com.myproject.mapper.BoardAttachMapper;
import com.myproject.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;



@Log4j
@Service
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	@Setter(onMethod_=@Autowired)
	private BoardAttachMapper attachMapper;
	


	@Override
	public void register(BoardVO board) {
		log.info("register..."+board);
		mapper.insertSelectkey(board);
		
		if(board.getAttachList()==null || board.getAttachList().size() <=0) {
			return;
		}
		board.getAttachList().forEach(attach ->{
			
			attach.setBno(board.getBno());
			attachMapper.insert(attach);
		});
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get..."+bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		
		log.info("modify....."+board);
		return mapper.update(board) ==1;
	}

	@Transactional
	@Override
	public boolean remove(Long bno) {
		log.info("remove..."+bno);
		attachMapper.deleteAll(bno);
		
		return mapper.delete(bno)==1;
	}

	/*
	 * @Override public List<BoardVO> getList() { log.info("getList.............");
	 * return mapper.getList(); }
	 */
	
	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("getList with criteria:"+cri);
		return mapper.getListWithPaging(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}
	
	@Override
	public List<BoardAttachVO> getAttachList(Long bno) {
		
		log.info("get Attach list by bno"+bno);
		
		return attachMapper.findByBno(bno);
	}

}
