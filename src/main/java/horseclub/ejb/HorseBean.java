package horseclub.ejb;

import horseclub.entity.Horse;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class HorseBean {

    @PersistenceContext(unitName = "HorseClubPU")
    private EntityManager em;

    public List<Horse> findAll() {
        return em.createQuery("SELECT h FROM Horse h", Horse.class).getResultList();
    }

    public Horse findById(Long id) {
        return em.find(Horse.class, id);
    }

    public void save(Horse horse) {
        if (horse.getId() == null) {
            em.persist(horse);
        } else {
            em.merge(horse);
        }
    }

    public void delete(Long id) {
        Horse horse = findById(id);
        if (horse != null) {
            em.remove(horse);
        }
    }
}