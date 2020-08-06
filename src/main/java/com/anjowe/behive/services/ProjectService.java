package com.anjowe.behive.services;

import java.util.List;

import com.anjowe.behive.domain.Position;
import com.anjowe.behive.domain.Project;

import reactor.core.publisher.Mono;

public interface ProjectService {

	public Project getProject(String projectName);

	public Mono<Boolean> createOrSaveProject(Project project);

	public boolean deleteProject(Project project);

	public boolean startProject(String projectName);

	public boolean endProject(String projectName);

	public boolean updateProject(Project project);

	public boolean addPositionToProject(Position position, int quantity);

	public boolean removePositionFromProject(Position position);

	public boolean fillSpotOnTeam(Position position, String username);

	public boolean fillSpotsOnTeam(Position position, List<String> usernames);

}
