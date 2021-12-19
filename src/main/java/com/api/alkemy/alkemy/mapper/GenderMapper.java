package com.api.alkemy.alkemy.mapper;

import com.api.alkemy.alkemy.dto.GenderDTO;
import com.api.alkemy.alkemy.entity.GenderEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class GenderMapper {

    public GenderDTO genderEntityToDto(GenderEntity genderEntity){
        GenderDTO dto = new GenderDTO();

        dto.setId(genderEntity.getId());
        dto.setImgUrl(genderEntity.getImgUrl());
        dto.setName(genderEntity.getName());
        //dto.setMovieList(genderEntity.getMovieList());

        return dto;
    }
    public GenderEntity genderDtoToEntity(GenderDTO genderDTO){
        GenderEntity entity = new GenderEntity();
        entity.setImgUrl(genderDTO.getImgUrl());
        entity.setName(genderDTO.getName());

        return entity;
    }
    public List<GenderDTO> genderListEntityToDto(Collection<GenderEntity> listEntity){
        List<GenderDTO> list = new ArrayList<>();
        for (GenderEntity gentity: listEntity) {
            list.add(this.genderEntityToDto(gentity));
        }

        return list;
    }




}
