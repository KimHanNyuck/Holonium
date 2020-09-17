package com.tistory.holonium.springboot.web.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class HelloResponseDtoTest {
	
	@Test
	public void �Һ�_���_�׽�Ʈ() {
		String name = "test";
		int amount = 1000;
		
		HelloResponseDto dto = new HelloResponseDto(name, amount);
		
		assertThat(dto.getName()).isEqualTo(name);
		assertThat(dto.getAmount()).isEqualTo(amount);
	}
}