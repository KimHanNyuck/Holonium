package com.tistory.holonium.springboot.service.posts;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tistory.holonium.springboot.domain.posts.PostsRepository;
import com.tistory.holonium.springboot.web.dto.PostsSaveRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostsService {
	private final PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto requestDto) {
		return postsRepository.save(requestDto.toEntity()).getId();
	}
}