package io.ghostIntel.projectManagementTool.Domain.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.ghostIntel.projectManagementTool.Domain.Project;
import io.ghostIntel.projectManagementTool.Exceptions.ProjectIdException;
import io.ghostIntel.projectManagementTool.Repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public Project saveOrUpdate(Project project) {
		try {
			project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
			return projectRepository.save(project);

		} catch (Exception e) {

			throw new ProjectIdException(
					"Project ID " + project.getProjectIdentifier().toUpperCase() + " already exist");
		}
	}

	public Project findProjectByIdentifier(String projectId) {

		Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
		if (project == null) {
			throw new ProjectIdException("Project  does not exist");
		}
		return project;
	}
	
	public Iterable<Project> findAllProjects(){
		return projectRepository.findAll();
	}
	
	public void deleteProjectByIdentifier(String projectId) {
		Project project = projectRepository.findByProjectIdentifier(projectId);
		
		if(project== null) {
			throw new  ProjectIdException("Project does not exist");
		}
		
		projectRepository.delete(project);
	}

}
