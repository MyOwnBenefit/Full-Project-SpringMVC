package com.myproject.service;

import java.util.List;

import com.myproject.domain.Criteria;
import com.myproject.domain.ReplyPageDTO;
import com.myproject.domain.ReplyVO;

public interface ReplyService {
	public int register(ReplyVO vo);
	public ReplyVO get(Long rno);
	public int modify(ReplyVO vo);
	public int remove(Long rno);
	public List<ReplyVO> getList(Criteria cri, Long bno);
	public ReplyPageDTO getListPage(Criteria cri, Long bno);
}
