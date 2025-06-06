package WebProj.Togetherworks.controllers;

import WebProj.Togetherworks.DTOs.ResourceDTO;
import WebProj.Togetherworks.enums.Type;
import WebProj.Togetherworks.services.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/resources")
public class ResourceController {
    private final ResourceService resourceService;

    @GetMapping("/all")
    public ResponseEntity<List<ResourceDTO>> getAllResources() {
        return ResponseEntity.ok(resourceService.getAllResources());
    }

    @PostMapping("/create")
    public ResponseEntity<ResourceDTO> createResource(@RequestBody ResourceDTO resource) {
        ResourceDTO savedDTO = resourceService.createResource(resource);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDTO);
    }

    @DeleteMapping("/delete/{type}")
    public ResponseEntity<String> deleteResource(@PathVariable Type type) {
        boolean deleted = resourceService.deleteResource(type);
        return deleted ?
                ResponseEntity.ok("Deleted resource with type " + type) :
                ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{type}")
    public ResponseEntity<ResourceDTO> updateResource(@PathVariable Type type, @RequestBody ResourceDTO resource) {
        return resourceService.updateResource(type, resource)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
