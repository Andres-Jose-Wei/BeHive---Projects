package com.anjowe.behive.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anjowe.behive.domain.Project;
import com.anjowe.behive.services.ProjectService;

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
	public boolean createProject(@RequestBody Project project) {
		return projectService.createOrSaveProject(project);
	}
}
