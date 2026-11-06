package horseclub.dto;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Rider")
public class RiderDTO {
    private Long id;
    private String fio;
    private int experience;
    private String phoneNumber;

    public RiderDTO() {}

    public RiderDTO(Long id, String fio, int experience, String phoneNumber) {
        this.id = id;
        this.fio = fio;
        this.experience = experience;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFio() { return fio; }
    public void setFio(String fio) { this.fio = fio; }
    public int getExperience() { return experience; }
    public void setExperience(int experience) { this.experience = experience; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}