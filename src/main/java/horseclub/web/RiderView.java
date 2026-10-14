package horseclub.web;

import horseclub.ejb.RiderBean;
import horseclub.entity.Rider;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("riderView")
@ViewScoped
public class RiderView implements Serializable {

    private Rider rider = new Rider();
    private List<Rider> riders;

    @EJB
    private RiderBean riderBean;

    @PostConstruct
    public void init() {
        loadRiders();
    }

    public void loadRiders() {
        riders = riderBean.findAll();
    }

    public void save() {
        riderBean.save(rider);
        rider = new Rider();
        loadRiders();
    }

    public void edit(Rider selectedRider) {
        this.rider = selectedRider;
    }

    public void delete(Long id) {
        riderBean.delete(id);
        loadRiders();
    }

    public Rider getRider() { return rider; }
    public void setRider(Rider rider) { this.rider = rider; }
    public List<Rider> getRiders() { return riders; }
}