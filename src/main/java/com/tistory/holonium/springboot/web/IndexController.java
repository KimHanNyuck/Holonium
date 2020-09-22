package com.tistory.holonium.springboot.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tistory.holonium.springboot.config.auth.LoginUser;
import com.tistory.holonium.springboot.config.auth.dto.SessionUser;
import com.tistory.holonium.springboot.service.posts.PostsService;
import com.tistory.holonium.springboot.web.dto.PostsResponseDto;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class IndexController {
	private final PostsService postsService;
	private final HttpSession httpSession;
	
	@GetMapping("/")
	public String index(Model model, @LoginUser SessionUser user) {
		model.addAttribute("posts", postsService.findAllDesc());
		
		if(user != null) {
			model.addAttribute("userName", user.getName());
		}
		return "index";
	}
	
	@GetMapping("/posts/save")
	public String postSave() {

		return "posts-save";
	}
	
	@GetMapping("/posts/update/{id}")
	public String postsUpdate(@PathVariable Long id, Model model) {
		PostsResponseDto dto = postsService.findById(id);
		model.addAttribute("post", dto);
		return "posts-update";
	}
}
