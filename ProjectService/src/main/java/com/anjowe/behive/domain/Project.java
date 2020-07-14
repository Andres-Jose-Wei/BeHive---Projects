package com.anjowe.behive.domain;

import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Document(collection = "Projects")
public class Project {

	@Id
	private String name;
	private String status;
	private boolean isPublic;
	private Map<Position, List<String>> team;
	private Map<Position, Integer> availableSpots;

}
