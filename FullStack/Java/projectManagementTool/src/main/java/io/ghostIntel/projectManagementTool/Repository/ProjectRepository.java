package io.ghostIntel.projectManagementTool.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.ghostIntel.projectManagementTool.Domain.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {


}
