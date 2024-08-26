package springsocket.k2.entity;

import jakarta.persistence.*;
import springsocket.k2.repository.NumberRepository;

@Entity
@Table(name = "main")
public class NumberEntity {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    @Column
    String identifier;
    @Column(name = "nr_value")
    Long value;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
