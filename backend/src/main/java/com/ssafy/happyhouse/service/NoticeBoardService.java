package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.NoticeBoardDto;

public interface NoticeBoardService {
	List<NoticeBoardDto> listNotice();
	NoticeBoardDto detailNotice(int no);
	boolean writeNotice(NoticeBoardDto notice);
	boolean updateNotice(NoticeBoardDto notice);
	boolean deleteNotice(int no);
	boolean countViews(int no);
}
