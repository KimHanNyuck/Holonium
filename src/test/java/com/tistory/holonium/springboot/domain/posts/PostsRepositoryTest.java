package com.tistory.holonium.springboot.domain.posts;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;
	
	@AfterEach 	
	public void cleanup() {
		postsRepository.deleteAll();
	}
	@Test
	public void �Խñ�����_�ҷ�����() {
		String title = "�׽�Ʈ �Խñ�";
		String content = "�׽�Ʈ ����";
		
		postsRepository.save(Posts.builder()
			.title(title)
			.content(content)
			.author("jojoldu@gmail.com")
			.build());
		
		List<Posts> postsList = postsRepository.findAll();
		
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle()).isEqualTo(title);
		assertThat(posts.getContent()).isEqualTo(content);
	}
}
