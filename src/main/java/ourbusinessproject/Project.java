package ourbusinessproject;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String title;

    private String description;

    public Project() {
    }

    public Project(String titre, String description, Enterprise entreprise) {
        this.title = titre;
        this.description = description;
        this.entreprise = entreprise;
    }

    @ManyToOne
    @NotNull
    private Enterprise entreprise;

    public Enterprise getEnterprise() {
        return entreprise;
    }

    public void setEnterprise(Enterprise entreprise) {
        this.entreprise = entreprise;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }
}
