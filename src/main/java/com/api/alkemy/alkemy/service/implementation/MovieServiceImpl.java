package com.api.alkemy.alkemy.service.implementation;

import com.api.alkemy.alkemy.dto.MovieBasicDTO;
import com.api.alkemy.alkemy.dto.MovieDTO;
import com.api.alkemy.alkemy.entity.MovieEntity;
import com.api.alkemy.alkemy.mapper.MovieMapper;
import com.api.alkemy.alkemy.repository.MovieRepository;
import com.api.alkemy.alkemy.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public MovieDTO save(MovieDTO movieDTO) {
        MovieEntity movieEntity = movieMapper.movieDtoToEntity(movieDTO);
        MovieEntity movieSaved = movieRepository.save(movieEntity);

        return movieMapper.movieEntityToDto(movieSaved);
    }

    @Override
    public List<MovieBasicDTO> listOfMovies() {
        return movieMapper.movieListEntityToBasicDto(movieRepository.findAll());

    }

    @Override
    public MovieDTO findMovieById(Long id) {
        MovieEntity movieEntity = movieRepository.findById(id).orElse(null);
        MovieDTO movieDTO = movieMapper.movieEntityToDto(movieEntity);
        return movieDTO;


    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public MovieDTO modify(MovieDTO movieDTO, Long id) {
        return null;
    }
}
