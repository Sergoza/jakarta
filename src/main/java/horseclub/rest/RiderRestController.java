package horseclub.rest;

import horseclub.dto.RiderDTO;
import horseclub.entity.Rider;
import horseclub.service.RiderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/api/riders",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
)
public class RiderRestController {

    private final RiderService riderService;

    public RiderRestController(RiderService riderService) {
        this.riderService = riderService;
    }

    @GetMapping
    public List<RiderDTO> getAllRiders() {
        return riderService.getAllRiders().stream()
                .map(this::convertToDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiderDTO> getRiderById(@PathVariable Long id) {
        Rider r = riderService.getRiderById(id);
        if (r == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(convertToDto(r));
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public RiderDTO createRider(@RequestBody RiderDTO dto) {
        Rider r = new Rider(dto.getFio(), dto.getExperience(), dto.getPhoneNumber());
        return convertToDto(riderService.saveRider(r));
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<RiderDTO> updateRider(@PathVariable Long id, @RequestBody RiderDTO dto) {
        Rider r = riderService.getRiderById(id);
        if (r == null) return ResponseEntity.notFound().build();

        r.setFio(dto.getFio());
        r.setExperience(dto.getExperience());
        r.setPhoneNumber(dto.getPhoneNumber());

        return ResponseEntity.ok(convertToDto(riderService.saveRider(r)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRider(@PathVariable Long id) {
        riderService.deleteRider(id);
    }

    private RiderDTO convertToDto(Rider r) {
        return new RiderDTO(r.getId(), r.getFio(), r.getExperience(), r.getPhoneNumber());
    }
}