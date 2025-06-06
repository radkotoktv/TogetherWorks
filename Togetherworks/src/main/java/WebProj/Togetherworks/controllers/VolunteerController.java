package WebProj.Togetherworks.controllers;

import WebProj.Togetherworks.DTOs.VolunteerDTO;
import WebProj.Togetherworks.services.VolunteerService;

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
@RequestMapping("/volunteers")
public class VolunteerController {
    private final VolunteerService volunteerService;

    @GetMapping("/all")
    public ResponseEntity<List<VolunteerDTO>> getAllVolunteers() {
        return ResponseEntity.ok(volunteerService.getAllVolunteers());
    }

    @PostMapping("/create")
    public ResponseEntity<VolunteerDTO> createVolunteer(@RequestBody VolunteerDTO volunteer) {
        VolunteerDTO savedDTO = volunteerService.createVolunteer(volunteer);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDTO);
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<String> deleteVolunteer(@PathVariable String username) {
        boolean deleted = volunteerService.deleteVolunteer(username);
        return deleted ?
                ResponseEntity.ok("Deleted volunteer with username " + username) :
                ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{username}")
    public ResponseEntity<VolunteerDTO> updateVolunteer(@PathVariable String username, @RequestBody VolunteerDTO volunteer) {
        return volunteerService.updateVolunteer(username, volunteer)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

}
