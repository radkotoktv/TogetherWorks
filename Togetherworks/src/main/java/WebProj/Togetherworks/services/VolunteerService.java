package WebProj.Togetherworks.services;

import WebProj.Togetherworks.DTOs.VolunteerDTO;
import WebProj.Togetherworks.mappers.VolunteerMapper;
import WebProj.Togetherworks.models.Project;
import WebProj.Togetherworks.models.Volunteer;
import WebProj.Togetherworks.repositories.ProjectRepository;
import WebProj.Togetherworks.repositories.VolunteerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VolunteerService {
    private final VolunteerRepository volunteerRepository;
    private final VolunteerMapper volunteerMapper;
    private final ProjectRepository projectRepository;

    public List<VolunteerDTO> getAllVolunteers() {
        return volunteerRepository.findAll()
                .stream()
                .map(volunteerMapper::map2DTO)
                .toList();
    }

    public VolunteerDTO createVolunteer(VolunteerDTO dto) {
        Project project = projectRepository.findByName(dto.getProject_name()).orElse(null);
        Volunteer volunteer = volunteerMapper.mapDTO(dto, project);
        Volunteer saved = volunteerRepository.save(volunteer);
        return volunteerMapper.map2DTO(saved);
    }

    public boolean deleteVolunteer(String name) {
        if (volunteerRepository.existsByName(name)) {
            volunteerRepository.deleteByName(name);
            return true;
        }
        return false;
    }

    public Optional<VolunteerDTO> updateVolunteer(String name, VolunteerDTO dto) {
        return volunteerRepository.findByName(name)
                .map(existing -> {
                    Project project = projectRepository.findByName(dto.getProject_name()).orElse(null);
                    existing.setFirst_name(dto.getFirst_name());
                    existing.setLast_name(dto.getLast_name());
                    existing.setEmail(dto.getEmail());
                    existing.setUsername(dto.getUsername());
                    existing.setGender(dto.getGender());
                    existing.setPreference(dto.getPreference());
                    existing.setProject(project);
                    return volunteerMapper.map2DTO(volunteerRepository.save(existing));
                });
    }
}
