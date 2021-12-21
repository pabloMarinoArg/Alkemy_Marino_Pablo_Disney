package com.api.alkemy.alkemy.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data

public class GenderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gender_id")
    private Long id;
    private String name;
    private String imgUrl;
    @OneToMany(mappedBy = "gender")
    @Getter(AccessLevel.NONE)
    private Set<MovieEntity> movieList;


    @JsonBackReference
    public Set<MovieEntity> getMovieList() {
        return movieList;
    }
}
