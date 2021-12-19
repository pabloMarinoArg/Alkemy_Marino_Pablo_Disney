package com.api.alkemy.alkemy.controller;

import com.api.alkemy.alkemy.dto.MovieBasicDTO;
import com.api.alkemy.alkemy.dto.MovieDTO;
import com.api.alkemy.alkemy.service.implementation.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieServiceImpl movieService;

    @PostMapping
    public ResponseEntity<MovieDTO> save (@RequestBody MovieDTO movieDTO){
        MovieDTO movie = movieService.save(movieDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    @GetMapping
    public ResponseEntity<List<MovieBasicDTO>> findAll(){
        List<MovieBasicDTO> basicList = movieService.listOfMovies();
        return ResponseEntity.status(HttpStatus.OK).body(basicList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> findMovieById(@PathVariable Long id){
        MovieDTO movieDTO = movieService.findMovieById(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(movieDTO);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        movieService.delete(id);

        return new ResponseEntity<>("The movie with id "+ id + " has been erased", HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> modify (@RequestBody MovieDTO movieDTO, @PathVariable Long id){
        MovieDTO movie = movieService.modify(movieDTO, id);

        return ResponseEntity.status(HttpStatus.OK).body(movie);
    }

}
