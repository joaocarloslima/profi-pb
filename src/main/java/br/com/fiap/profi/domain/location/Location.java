package br.com.fiap.profi.domain.location;

import br.com.fiap.profi.infra.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Location extends BaseEntity {

    @Column(nullable = false)
    private String state;

    private String city;
    private String neighborhood;

    public Location() {

    }

    public Location(String state, String city, String neighborhood) {
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }
}
