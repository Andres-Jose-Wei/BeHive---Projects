package com.anjowe.behive.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjowe.behive.domain.Position;
import com.anjowe.behive.domain.Project;
import com.anjowe.behive.repos.ProjectRepo;

import reactor.core.publisher.Mono;

@Service
public class ProjectServiceImpl implements ProjectService {

	Project project = new Project();

	private ProjectRepo projectRepo;

	@Autowired
	public void setProjectRepo(ProjectRepo projectRepo) {
		this.projectRepo = projectRepo;
	}

	@Override
	public boolean createOrSaveProject(Project project) {
		project.setStatus("Recruiting");
		this.projectRepo.save(project);
		return true;
	}

	@Override
	public boolean deleteProject(Project project) {
		this.projectRepo.delete(project);
		return true;
	}

	@Override
	public boolean startProject(String projectName) {
		Mono<Project> p = this.projectRepo.findById(projectName);
		p.subscribe(p1 -> project = p1);
		project.setStatus("In Progress");
		this.projectRepo.save(project);
		return true;
	}

	@Override
	public boolean endProject(String projectName) {
		Mono<Project> p = this.projectRepo.findById(projectName);
		p.subscribe(p1 -> project = p1);
		project.setStatus("Completed");
		this.projectRepo.save(project);
		return true;
	}

	@Override
	public boolean updateProject(Project project) {
		this.projectRepo.save(project);
		return true;
	}

	@Override
	public boolean addPositionToProject(Position position, int quantity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removePositionFromProject(Position position) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fillSpotOnTeam(Position position, String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fillSpotsOnTeam(Position position, List<String> usernames) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Project getProject(String projectName) {
		Mono<Project> p = this.projectRepo.findById(projectName);
		p.subscribe(p1 -> project = p1);
		return project;
	}

}
