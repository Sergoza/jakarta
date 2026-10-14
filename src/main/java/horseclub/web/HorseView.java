package horseclub.web;

import horseclub.ejb.HorseBean;
import horseclub.entity.Horse;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("horseView")
@ViewScoped
public class HorseView implements Serializable {

    private Horse horse = new Horse();
    private List<Horse> horses;

    @EJB
    private HorseBean horseBean;

    @PostConstruct
    public void init() {
        loadHorses();
    }

    public void loadHorses() {
        horses = horseBean.findAll();
    }

    public void save() {
        horseBean.save(horse);
        horse = new Horse();
        loadHorses();
    }

    public void edit(Horse selectedHorse) {
        this.horse = selectedHorse;
    }

    public void delete(Long id) {
        horseBean.delete(id);
        loadHorses();
    }

    public Horse getHorse() { return horse; }
    public void setHorse(Horse horse) { this.horse = horse; }
    public List<Horse> getHorses() { return horses; }
}