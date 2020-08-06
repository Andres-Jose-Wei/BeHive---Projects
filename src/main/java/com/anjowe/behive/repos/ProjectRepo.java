package com.anjowe.behive.repos;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.anjowe.behive.domain.Project;

import reactor.core.publisher.Mono;

@Repository
public interface ProjectRepo extends ReactiveMongoRepository<Project, String> {
	Mono<Project> findbyOwner(String owner);
}
