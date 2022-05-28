package com.ssafy.happyhouse.controller;

import java.util.List;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dto.NewsDto;
import com.ssafy.happyhouse.service.NewsService;

@CrossOrigin("*")
@RestController
@RequestMapping("/news")
public class NewsController {
	
	@Autowired
	NewsService newsService;
	
	@GetMapping("/list/{keyword}")
	public List<NewsDto> NewsList(@PathVariable String keyword) throws ParseException{
		List<NewsDto> list = newsService.NewsList(keyword);
		return list;
	}
	
}
