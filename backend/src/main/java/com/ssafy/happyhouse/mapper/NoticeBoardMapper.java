package com.ssafy.happyhouse.mapper;

import java.util.List;

import com.ssafy.happyhouse.dto.NoticeBoardDto;

public interface NoticeBoardMapper {
	List<NoticeBoardDto> listNotice();
	NoticeBoardDto detailNotice(int no);
	int writeNotice(NoticeBoardDto notice);
	int updateNotice(NoticeBoardDto notice);
	int deleteNotice(int no);
	int countViews(int no);
}
