package com.ssafy.happyhouse.service;

import java.util.List;

import org.json.simple.parser.ParseException;

import com.ssafy.happyhouse.dto.NewsDto;

public interface NewsService {
	List<NewsDto> NewsList(String keyword) throws ParseException;
}
