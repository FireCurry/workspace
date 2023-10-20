package com.kh.test.user.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
	
	private int userNo;
	private String userId;
	private String userName;
	private int userAge;
	
}
