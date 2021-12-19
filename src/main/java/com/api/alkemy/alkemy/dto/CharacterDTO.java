package com.api.alkemy.alkemy.dto;

import com.api.alkemy.alkemy.entity.MovieEntity;
import lombok.Data;

import java.util.List;

@Data
public class CharacterDTO {

    private Long id;
    private String imgUrl;
    private String name;
    private Integer age;
    private Double weight;
    private String history;
    private List<MovieEntity> list;

}
