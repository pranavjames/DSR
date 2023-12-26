package com.dsr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsr.model.Project;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {

}
