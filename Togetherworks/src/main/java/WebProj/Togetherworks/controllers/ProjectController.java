package WebProj.Togetherworks.controllers;

import WebProj.Togetherworks.DTOs.ProjectDTO;
import WebProj.Togetherworks.services.ProjectService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/all")
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @PostMapping("/create")
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO project) {
        ProjectDTO savedDTO = projectService.createProject(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDTO);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteProject(@PathVariable String name) {
        boolean deleted = projectService.deleteProject(name);
        return deleted ?
                ResponseEntity.ok("Deleted project with name " + name) :
                ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{name}")
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable String name, @RequestBody ProjectDTO project) {
        return projectService.updateProject(name, project)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
