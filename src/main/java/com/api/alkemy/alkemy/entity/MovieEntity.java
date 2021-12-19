package com.api.alkemy.alkemy.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long id;
    private String imgUrl;
    private String title;
    private LocalDate doc;
    private Integer calification;
    @ManyToMany(mappedBy = "list")
    private List<CharacterEntity> characterList;
    @ManyToOne
    @JoinColumn(name = "gender_id",nullable = false)
    private GenderEntity gender;





}
