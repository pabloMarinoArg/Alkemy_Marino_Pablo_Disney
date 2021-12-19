package com.api.alkemy.alkemy.service;

import com.api.alkemy.alkemy.dto.MovieBasicDTO;
import com.api.alkemy.alkemy.dto.MovieDTO;

import java.util.List;

public interface MovieService {
    MovieDTO save(MovieDTO movieDTO);
    List<MovieBasicDTO> listOfMovies();
    MovieDTO findMovieById(Long id);
    void delete (Long id);
    MovieDTO modify (MovieDTO movieDTO, Long id);
}
