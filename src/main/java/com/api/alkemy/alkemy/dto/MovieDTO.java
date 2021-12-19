package com.api.alkemy.alkemy.dto;

import com.api.alkemy.alkemy.entity.CharacterEntity;
import com.api.alkemy.alkemy.entity.GenderEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MovieDTO {
    private Long id;
    private String imgUrl;
    private String title;
    private String doc;
    private Integer calification;
    private List<CharacterEntity> characterList;
    private GenderEntity gender;
}
