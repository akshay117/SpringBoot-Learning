package io.ghostIntel.projectManagementTool.Domain.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ghostIntel.projectManagementTool.Domain.Project;
import io.ghostIntel.projectManagementTool.Repository.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project saveOrUpdate(Project project) {
		//LOGIC
		return projectRepository.save(project);
	}

}
