package com.example.realestate.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Document(collection = "real_estate")
public class RealEstate {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private String id;
    private String name;

    @Embedded
    private RealEstateInfo resultListEntries;

    public RealEstate() {

    }

    public RealEstate(String name, RealEstateInfo resultListEntries) {
        this.name = name;
        this.resultListEntries = resultListEntries;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealEstateInfo getResultListEntries() {
        return resultListEntries;
    }

    public void setResultListEntries(RealEstateInfo resultListEntries) {
        this.resultListEntries = resultListEntries;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        final RealEstate that = (RealEstate) o;
        return Objects.equals(this.getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId());
    }
}
