package io.ghostIntel.projectManagementTool.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ghostIntel.projectManagementTool.Domain.Project;
import io.ghostIntel.projectManagementTool.Domain.Services.ProjectService;
import io.ghostIntel.projectManagementTool.Domain.Services.ValidationErrorService;

@RestController
@RequestMapping("/api/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ValidationErrorService validationErrorService;

	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project,BindingResult result){
		
        ResponseEntity<?> errorMap = validationErrorService.ValidationService(result);
        if(errorMap!=null) {
        	return errorMap;
        }
     	Project project1 = projectService.saveOrUpdate(project);
		return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
	}
	
	
}
