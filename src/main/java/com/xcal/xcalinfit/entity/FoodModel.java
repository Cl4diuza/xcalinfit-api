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
@Document(collection = "food")
public class FoodModel {
	@Id
	private String id;
	@NotNull(message = "name can not be null")
	private String name;
	@NotNull(message = "content can not be null")
	private String content;

}
