package com.api.alkemy.alkemy.dto;

import com.api.alkemy.alkemy.entity.MovieEntity;
import lombok.Data;

import java.util.Set;
@Data
public class GenderDTO {
    private Long id;
    private String name;
    private String imgUrl;
    private Set<MovieEntity> movieList;
}
