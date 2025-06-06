package WebProj.Togetherworks.controllers;

import WebProj.Togetherworks.DTOs.SponsorDTO;
import WebProj.Togetherworks.services.SponsorService;
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
@RequestMapping("/sponsors")
public class SponsorController {
    private final SponsorService sponsorService;

    @GetMapping("/all")
    public ResponseEntity<List<SponsorDTO>> getAllSponsors() {
        return ResponseEntity.ok(sponsorService.getAllSponsors());
    }

    @PostMapping("/create")
    public ResponseEntity<SponsorDTO> createSponsor(@RequestBody SponsorDTO sponsor) {
        SponsorDTO savedDTO = sponsorService.createSponsor(sponsor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDTO);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteSponsor(@PathVariable String name) {
        boolean deleted = sponsorService.deleteSponsor(name);
        return deleted ?
                ResponseEntity.ok("Deleted sponsor with name " + name) :
                ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{name}")
    public ResponseEntity<SponsorDTO> updateSponsor(@PathVariable String name, @RequestBody SponsorDTO sponsor) {
        return sponsorService.updateSponsor(name, sponsor)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
