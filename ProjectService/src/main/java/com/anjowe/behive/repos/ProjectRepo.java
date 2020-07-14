package com.anjowe.behive.repos;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.anjowe.behive.domain.Project;

@Repository
public interface ProjectRepo extends ReactiveCrudRepository<Project, String> {

}
