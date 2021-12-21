package com.api.alkemy.alkemy.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long id;
    private String imgUrl;
    private String title;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate doc;
    private Integer calification;
    @ManyToMany(mappedBy = "list")
    private List<CharacterEntity> characterList;
    @ManyToOne
    @JoinColumn(name = "gender_id",nullable = true)
    @Getter(AccessLevel.NONE)
    private GenderEntity gender;


    @JsonManagedReference
    public GenderEntity getGender() {
        return gender;
    }
}
