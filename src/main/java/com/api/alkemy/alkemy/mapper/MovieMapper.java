package com.api.alkemy.alkemy.mapper;

import com.api.alkemy.alkemy.dto.MovieBasicDTO;
import com.api.alkemy.alkemy.dto.MovieDTO;
import com.api.alkemy.alkemy.entity.MovieEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class MovieMapper {



    public MovieDTO movieEntityToDto(MovieEntity movieEntity){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movieEntity.getId());
        movieDTO.setImgUrl(movieEntity.getImgUrl());
        movieDTO.setTitle(movieEntity.getTitle());
        movieDTO.setCalification(movieEntity.getCalification());
        movieDTO.setDoc(movieEntity.getDoc().toString());
        movieDTO.setGender(movieEntity.getGender());
        return movieDTO;
    }



    public MovieEntity movieDtoToEntity(MovieDTO movieDTO){
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setImgUrl(movieDTO.getImgUrl());
        movieEntity.setTitle(movieDTO.getTitle());
        movieEntity.setCalification(movieDTO.getCalification());
        movieEntity.setDoc(this.string2LocalDate(movieDTO.getDoc()));
        movieDTO.setCharacterList(movieDTO.getCharacterList());
        return movieEntity;

    }



    public List<MovieBasicDTO> movieListEntityToBasicDto(Collection<MovieEntity> listEntity){
        List<MovieBasicDTO> listBasicDto = new ArrayList<>();

        for (MovieEntity mentity: listEntity) {
            MovieBasicDTO basic = new MovieBasicDTO();
            basic.setImgUrl(mentity.getImgUrl());
            basic.setTitle(mentity.getTitle());
            basic.setDoc(mentity.getDoc().toString());
            listBasicDto.add(basic);
        }

        return listBasicDto;

    }

    private LocalDate string2LocalDate(String stringDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(stringDate,formatter);
    }
    //public List<MovieEntity> movieListDtoToEntity(){}




}
