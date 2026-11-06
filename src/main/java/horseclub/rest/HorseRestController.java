package horseclub.rest;

import horseclub.dto.HorseDTO;
import horseclub.entity.Horse;
import horseclub.service.HorseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        value = "/api/horses",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
)
public class HorseRestController {

    private final HorseService horseService;

    public HorseRestController(HorseService horseService) {
        this.horseService = horseService;
    }

    @GetMapping
    public List<HorseDTO> getAllHorses() {
        return horseService.getAllHorses().stream()
                .map(this::convertToDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorseDTO> getHorseById(@PathVariable Long id) {
        Horse h = horseService.getHorseById(id);
        if (h == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(convertToDto(h));
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public HorseDTO createHorse(@RequestBody HorseDTO dto) {
        Horse h = new Horse(dto.getName(), dto.getBreed(), dto.getAge(), dto.getWeight());
        return convertToDto(horseService.saveHorse(h));
    }

    @PutMapping(value = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<HorseDTO> updateHorse(@PathVariable Long id, @RequestBody HorseDTO dto) {
        Horse h = horseService.getHorseById(id);
        if (h == null) return ResponseEntity.notFound().build();

        h.setName(dto.getName());
        h.setBreed(dto.getBreed());
        h.setAge(dto.getAge());
        h.setWeight(dto.getWeight());

        return ResponseEntity.ok(convertToDto(horseService.saveHorse(h)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHorse(@PathVariable Long id) {
        horseService.deleteHorse(id);
    }

    private HorseDTO convertToDto(Horse h) {
        return new HorseDTO(h.getId(), h.getName(), h.getBreed(), h.getAge(), h.getWeight());
    }
}
