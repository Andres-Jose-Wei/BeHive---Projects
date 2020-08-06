package com.anjowe.behive.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anjowe.behive.domain.Project;
import com.anjowe.behive.services.ProjectService;

import reactor.core.publisher.Mono;

@RestController
public class ProjectController {

	private ProjectService projectService;

	@Autowired
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	@GetMapping("/project/{projectName}")
	public Project getProject(@RequestParam(name = "projectName") String projectName) {
		return projectService.getProject(projectName);
	}

	@PostMapping("/project/create")
	public Mono<Boolean> createProject(@RequestBody Project project, @RequestHeader("USER_NAME") String username) {
		project.setOwner(username);
		return projectService.createOrSaveProject(project);
	}
}
