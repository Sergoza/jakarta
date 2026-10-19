package horseclub.service;



import horseclub.entity.Horse;
import horseclub.repository.HorseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorseService {
    private final HorseRepository horseRepository;

    public HorseService(HorseRepository horseRepository) {
        this.horseRepository = horseRepository;
    }

    public List<Horse> getAllHorses() { return horseRepository.findAll(); }
    public Horse saveHorse(Horse horse) { return horseRepository.save(horse); }
    public Horse getHorseById(Long id) { return horseRepository.findById(id).orElse(null); }
    public void deleteHorse(Long id) { horseRepository.deleteById(id); }
}