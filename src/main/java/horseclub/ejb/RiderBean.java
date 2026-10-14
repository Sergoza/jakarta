package horseclub.ejb;

import horseclub.entity.Rider;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class RiderBean {

    @PersistenceContext(unitName = "HorseClubPU")
    private EntityManager em;

    public List<Rider> findAll() {
        return em.createQuery("SELECT r FROM Rider r", Rider.class).getResultList();
    }

    public Rider findById(Long id) {
        return em.find(Rider.class, id);
    }

    public void save(Rider rider) {
        if (rider.getId() == null) {
            em.persist(rider);
        } else {
            em.merge(rider);
        }
    }

    public void delete(Long id) {
        Rider rider = findById(id);
        if (rider != null) {
            em.remove(rider);
        }
    }
}