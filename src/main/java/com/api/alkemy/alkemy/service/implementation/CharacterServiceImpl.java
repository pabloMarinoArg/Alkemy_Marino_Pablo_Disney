package com.api.alkemy.alkemy.service.implementation;

import com.api.alkemy.alkemy.dto.CharacterBasicDTO;
import com.api.alkemy.alkemy.dto.CharacterDTO;
import com.api.alkemy.alkemy.dto.MovieDTO;
import com.api.alkemy.alkemy.entity.CharacterEntity;
import com.api.alkemy.alkemy.mapper.CharacterMapper;
import com.api.alkemy.alkemy.repository.CharacterRepository;
import com.api.alkemy.alkemy.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterMapper characterMapper;
    @Autowired
    private CharacterRepository characterRepository;

    @Override
    @Transactional
    public CharacterDTO save(CharacterDTO characterDTO) {

        CharacterEntity characterEntity = characterMapper.characterDtoToEntity(characterDTO);
        CharacterEntity characterSaved = characterRepository.save(characterEntity);

        return characterMapper.characterEntityToDto(characterSaved);


    }

    @Override
    @Transactional(readOnly = true)
    public List<CharacterBasicDTO> findAll() {
       return  characterMapper.characterListBasicEntityToDto(characterRepository.findAll());

    }

    @Override
    @Transactional(readOnly = true)
    public CharacterDTO findCharacterById(Long id) {

        CharacterEntity characterEntity = characterRepository.findById(id).orElse(null);

        CharacterDTO characterDTO = characterMapper.characterEntityToDto(characterEntity);

        return characterDTO;

    }

    @Override
    @Transactional
    public void delete(Long id) {
        characterRepository.deleteById(id);

       }

    @Override
    @Transactional
    public CharacterDTO modify(CharacterDTO characterDTO, Long id) {
        CharacterEntity characterEntity = characterRepository.findById(id).orElse(null);

        characterEntity.setImgUrl(characterDTO.getImgUrl());
        characterEntity.setName(characterDTO.getName());
        characterEntity.setAge(characterDTO.getAge());
        characterEntity.setWeight(characterDTO.getWeight());
        characterEntity.setHistory(characterDTO.getHistory());
        characterRepository.save(characterEntity);
        CharacterDTO charDto = characterMapper.characterEntityToDto(characterEntity);
        return charDto;
    }

    @Override
    @Transactional
    public CharacterDTO addMovie(MovieDTO movieDTO, Long id) {
        CharacterEntity characterEntity = characterRepository.findById(id).orElse(null);




        return null;
    }
}
