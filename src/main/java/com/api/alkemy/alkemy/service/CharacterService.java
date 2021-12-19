package com.api.alkemy.alkemy.service;

import com.api.alkemy.alkemy.dto.CharacterBasicDTO;
import com.api.alkemy.alkemy.dto.CharacterDTO;
import com.api.alkemy.alkemy.dto.MovieDTO;

import java.util.List;

public interface CharacterService {

    CharacterDTO save(CharacterDTO characterDTO);
    List<CharacterBasicDTO> findAll();
    CharacterDTO findCharacterById(Long id);
    void delete (Long id);
    CharacterDTO modify (CharacterDTO characterDTO, Long id);
    CharacterDTO addMovie(MovieDTO movieDTO, Long id);



}
