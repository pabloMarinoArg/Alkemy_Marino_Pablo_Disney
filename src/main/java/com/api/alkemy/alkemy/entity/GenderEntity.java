package com.api.alkemy.alkemy.entity;

import lombok.Data;

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
    private Set<MovieEntity> movieList;


}
