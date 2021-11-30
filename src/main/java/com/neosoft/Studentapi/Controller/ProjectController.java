package com.neosoft.Studentapi.Controller;

import com.neosoft.Studentapi.Entity.Project;
import com.neosoft.Studentapi.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> createProject(@RequestBody Project project){
        return ResponseEntity.ok(projectService.createProject(project));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable int id){
        return ResponseEntity.ok(projectService.getProject(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable int id, @RequestBody Project project){
        return ResponseEntity.ok(projectService.updateProject(id,project));
    }
}
