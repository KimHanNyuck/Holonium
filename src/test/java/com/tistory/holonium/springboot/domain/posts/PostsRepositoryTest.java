package com.tistory.holonium.springboot.domain.posts;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
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
	public void postRepository_저장() {
		String title = "title";
		String content = "content";
		
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
	
	@Test
	public void BaseTimeEntity_저장() {
		
		LocalDateTime now = LocalDateTime.of(2020,9,22,0,0,0);
		postsRepository.save(Posts.builder()
				.title("title")
				.author("author")
				.content("content")
				.build());
		
		List<Posts> postsList = postsRepository.findAll();
		
		Posts posts = postsList.get(0);
		
		System.out.println(">>>>>>>>>>> createDate="+posts.getCreatedDate()+", modifiedDate = "+posts.getModifiedDate());
		
		assertThat(posts.getCreatedDate().isAfter(now));
		assertThat(posts.getModifiedDate().isAfter(now));
	}
}
