package com.xcal.xcalinfit.entity;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@Document(collection = "user")
public class UserModel {
	@Id
	private String id;
	@NotNull(message = "name can not be null")
	private String email;
	@NotNull(message = "content can not be null")
	private String password;
	private String name;

}
