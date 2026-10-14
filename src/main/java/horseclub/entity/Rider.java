package horseclub.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rider")
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fio", nullable = false, length = 150)
    private String fio;

    @Column(name = "experience", nullable = false)
    private Integer experience;

    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

    public Rider() {
    }

    public Rider(String fio, Integer experience, String phoneNumber) {
        this.fio = fio;
        this.experience = experience;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}