package com.api.alkemy.alkemy.mapper;

import com.api.alkemy.alkemy.dto.CharacterBasicDTO;
import com.api.alkemy.alkemy.dto.CharacterDTO;
import com.api.alkemy.alkemy.entity.CharacterEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CharacterMapper {

    public CharacterDTO characterEntityToDto(CharacterEntity characterEntity){
        CharacterDTO characterDTO = new CharacterDTO();

        characterDTO.setId(characterEntity.getId());
        characterDTO.setImgUrl(characterEntity.getImgUrl());
        characterDTO.setName(characterEntity.getName());
        characterDTO.setAge(characterEntity.getAge());
        characterDTO.setWeight(characterEntity.getWeight());
        characterDTO.setHistory(characterEntity.getHistory());

        return  characterDTO;
    }

    public CharacterEntity characterDtoToEntity(CharacterDTO characterDTO){
        CharacterEntity characterEntity = new CharacterEntity();

        characterEntity.setImgUrl(characterDTO.getImgUrl());
        characterEntity.setName(characterDTO.getName());
        characterEntity.setAge(characterDTO.getAge());
        characterEntity.setWeight(characterDTO.getWeight());
        characterEntity.setHistory(characterDTO.getHistory());

        return characterEntity;
    }

    public List<CharacterBasicDTO> characterListBasicEntityToDto(Collection<CharacterEntity> listEntity){
        List<CharacterBasicDTO> basicDtoList = new ArrayList<>();

        for (CharacterEntity character : listEntity) {
            CharacterBasicDTO dtoBasic = new CharacterBasicDTO();
            dtoBasic.setImgUrl(character.getImgUrl());
            dtoBasic.setName(character.getName());
            basicDtoList.add(dtoBasic);
        }

        return basicDtoList;

    }

    public List<CharacterEntity> characterListEntityToDto (Collection<CharacterDTO> listDto){
        List<CharacterEntity> entityList = new ArrayList<>();

        for (CharacterDTO charDto: listDto) {
            entityList.add(this.characterDtoToEntity(charDto));
        }
        return entityList;
    }


}
