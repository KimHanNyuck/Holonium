package com.tistory.holonium.springboot.service.posts;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tistory.holonium.springboot.domain.posts.Posts;
import com.tistory.holonium.springboot.domain.posts.PostsRepository;
import com.tistory.holonium.springboot.web.dto.PostsResponseDto;
import com.tistory.holonium.springboot.web.dto.PostsSaveRequestDto;
import com.tistory.holonium.springboot.web.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostsService {
	private final PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto requestDto) {
		return postsRepository.save(requestDto.toEntity()).getId();
	}
	
	@Transactional
	public Long update(Long id, PostsUpdateRequestDto requestDto) {
		Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("�ش� �Խñ��� �����ϴ�. id = "+id));
		posts.update(requestDto.getTitle(), requestDto.getContent());
		return id;
	}
	
	public PostsResponseDto findById (Long id) {
		Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("�ش� �Խñ��� ������ϴ�. id = "+id));
		return new PostsResponseDto(entity);
	}
}
