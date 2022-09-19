package nl.novi.techiteasy1121.Dtos;

public class CIModulesDTO {

    private Long id;
    private String name;
    private String type;
    private Double price;

    public CIModulesDTO(Long id) {
        this.id = id;
    }

    //volledige constructor
    public CIModulesDTO(Long id, String name, String type, Double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    //lege constructor
    public CIModulesDTO() {
    }

    //Getters en Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
