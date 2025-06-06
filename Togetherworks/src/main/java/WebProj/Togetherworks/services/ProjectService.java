package WebProj.Togetherworks.services;

import WebProj.Togetherworks.DTOs.ProjectDTO;
import WebProj.Togetherworks.mappers.ProjectMapper;
import WebProj.Togetherworks.models.Project;
import WebProj.Togetherworks.models.Sponsor;
import WebProj.Togetherworks.repositories.ProjectRepository;

import WebProj.Togetherworks.repositories.SponsorRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;
    private final SponsorRepository sponsorRepository;

    public List<ProjectDTO> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(projectMapper::map2DTO)
                .toList();
    }

    public ProjectDTO createProject(ProjectDTO dto) {
        Sponsor sponsor = sponsorRepository.findByName(dto.getSponsor_name()).orElse(null);
        Project project = projectMapper.mapDTO(dto, sponsor);
        Project saved = projectRepository.save(project);
        return projectMapper.map2DTO(saved);
    }

    public boolean deleteProject(String name) {
        if (projectRepository.existsByName(name)) {
            projectRepository.deleteByName(name);
            return true;
        }
        return false;
    }

    public Optional<ProjectDTO> updateProject(String name, ProjectDTO dto) {
        return projectRepository.findByName(name).map(existing -> {
            Sponsor sponsor = sponsorRepository.findByName(dto.getSponsor_name()).orElse(null);
            existing.setName(dto.getName());
            existing.setOwner(dto.getOwner());
            existing.setMoney_needed(dto.getMoney_needed());
            existing.setStart_date(dto.getStart_date());
            existing.setEnd_date(dto.getEnd_date());
            existing.setSponsor(sponsor);
            return projectMapper.map2DTO(projectRepository.save(existing));
        });
    }

}
