package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dto.NoticeBoardDto;
import com.ssafy.happyhouse.mapper.NoticeBoardMapper;

@Service
public class NoticeBoardServiceImpl implements NoticeBoardService{
	
	@Autowired
	private NoticeBoardMapper noticeBoardMapper;
	
	@Override
	public List<NoticeBoardDto> listNotice() {
		return noticeBoardMapper.listNotice();
	}

	@Override
	public NoticeBoardDto detailNotice(int no) {
		return noticeBoardMapper.detailNotice(no);
	}

	@Override
	public boolean writeNotice(NoticeBoardDto notice) {
		return noticeBoardMapper.writeNotice(notice)==1;
	}

	@Override
	public boolean updateNotice(NoticeBoardDto notice) {
		return noticeBoardMapper.updateNotice(notice)==1;
	}

	@Override
	public boolean deleteNotice(int no) {
		return noticeBoardMapper.deleteNotice(no)==1;
	}

	@Override
	public boolean countViews(int no) {
		return noticeBoardMapper.countViews(no)==1;
	}

}
