package com.tejas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tejas.entities.Project;

public interface ProjectRepository  extends JpaRepository<Project, Long>{

}
