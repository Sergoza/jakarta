package horseclub.service;


import horseclub.entity.Rider;
import horseclub.repository.RiderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderService {
    private final RiderRepository riderRepository;

    public RiderService(RiderRepository riderRepository) {
        this.riderRepository = riderRepository;
    }

    public List<Rider> getAllRiders() { return riderRepository.findAll(); }
    public Rider saveRider(Rider rider) { return riderRepository.save(rider); }
    public Rider getRiderById(Long id) { return riderRepository.findById(id).orElse(null); }
    public void deleteRider(Long id) { riderRepository.deleteById(id); }
}