package br.com.fiap.profi.domain.professional;

import br.com.fiap.profi.domain.category.Category;
import br.com.fiap.profi.domain.location.Location;
import br.com.fiap.profi.infra.BaseEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Professional extends BaseEntity {

    private String name;
    private String email;
    private String phone;

    @ManyToOne
    private Location location;

    @ManyToMany
    @JoinTable(
            name = "professional_category",
            joinColumns = @JoinColumn(name = "professional_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;

    public Professional() {
    }

    public Professional(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public void addCategory(Category category) {
        this.categories.add(category);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Set<Category> getCategories() {
        return Set.copyOf(categories);
    }
}
