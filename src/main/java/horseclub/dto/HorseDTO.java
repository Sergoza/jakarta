package horseclub.dto;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Horse")
public class HorseDTO {
    private Long id;
    private String name;
    private String breed;
    private int age;
    private double weight;

    public HorseDTO() {}

    public HorseDTO(Long id, String name, String breed, int age, double weight) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
}