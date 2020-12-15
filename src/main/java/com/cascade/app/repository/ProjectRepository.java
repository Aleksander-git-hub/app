package com.cascade.app.repository;

import com.cascade.app.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer>
{

}
