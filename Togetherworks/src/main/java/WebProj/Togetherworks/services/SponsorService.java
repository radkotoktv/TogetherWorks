package WebProj.Togetherworks.services;

import WebProj.Togetherworks.DTOs.SponsorDTO;
import WebProj.Togetherworks.mappers.SponsorMapper;
import WebProj.Togetherworks.models.Sponsor;
import WebProj.Togetherworks.repositories.SponsorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SponsorService {
    private final SponsorRepository sponsorRepository;
    private final SponsorMapper sponsorMapper;

    public List<SponsorDTO> getAllSponsors() {
        return sponsorRepository.findAll()
                .stream()
                .map(sponsorMapper::map2DTO)
                .toList();
    }

    public SponsorDTO createSponsor(SponsorDTO dto) {
        Sponsor sponsor = sponsorMapper.mapDTO(dto);
        Sponsor saved = sponsorRepository.save(sponsor);
        return sponsorMapper.map2DTO(saved);
    }

    public boolean deleteSponsor(String name) {
        if (sponsorRepository.existsByName(name)) {
            sponsorRepository.deleteByName(name);
            return true;
        }
        return false;
    }

    public Optional<SponsorDTO> updateSponsor(String name, SponsorDTO dto) {
        return sponsorRepository.findByName(name)
                .map(existing -> {
                    existing.setName(dto.getName());
                    existing.setAmount(dto.getAmount());
                    return sponsorMapper.map2DTO(sponsorRepository.save(existing));
                });
    }
}
