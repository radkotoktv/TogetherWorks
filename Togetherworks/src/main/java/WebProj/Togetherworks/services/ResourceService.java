package WebProj.Togetherworks.services;

import WebProj.Togetherworks.DTOs.ResourceDTO;
import WebProj.Togetherworks.enums.Type;
import WebProj.Togetherworks.mappers.ResourceMapper;
import WebProj.Togetherworks.models.Project;
import WebProj.Togetherworks.models.Resource;
import WebProj.Togetherworks.repositories.ProjectRepository;
import WebProj.Togetherworks.repositories.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResourceService {
    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;
    private final ProjectRepository projectRepository;

    public List<ResourceDTO> getAllResources() {
        return resourceRepository.findAll()
                .stream()
                .map(resourceMapper::map2DTO)
                .toList();
    }

    public ResourceDTO createResource(ResourceDTO dto) {
        Project project = projectRepository.findByName(dto.getProject_name()).orElse(null);
        Resource resource = resourceMapper.mapDTO(dto, project);
        Resource saved = resourceRepository.save(resource);
        return resourceMapper.map2DTO(saved);
    }

    public boolean deleteResource(Type type) {
        if (resourceRepository.existsByType(type)) {
            resourceRepository.deleteByType(type);
            return true;
        }
        return false;
    }

    public Optional<ResourceDTO> updateResource(Type type, ResourceDTO dto) {
        return resourceRepository.findByType(type)
                .map(existing -> {
                    Project project = projectRepository.findByName(dto.getProject_name()).orElse(null);
                    existing.setType(dto.getType());
                    existing.setProject(project);
                    existing.setQuantity(dto.getQuantity());
                    return resourceMapper.map2DTO(existing);
                });
    }
}
