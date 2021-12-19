package com.api.alkemy.alkemy.service.implementation;

import com.api.alkemy.alkemy.dto.GenderDTO;
import com.api.alkemy.alkemy.entity.GenderEntity;
import com.api.alkemy.alkemy.mapper.GenderMapper;
import com.api.alkemy.alkemy.repository.GenderRepository;
import com.api.alkemy.alkemy.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenderServiceImpl implements GenderService {
    @Autowired
    private GenderMapper genderMapper;

    @Autowired
    private GenderRepository genderRepository;


    @Override
    public GenderDTO save(GenderDTO genderDTO) {
        GenderEntity genderEntity = genderMapper.genderDtoToEntity(genderDTO);
        GenderEntity genderSaved = genderRepository.save(genderEntity);
        return genderMapper.genderEntityToDto(genderSaved);

    }

    @Override
    public GenderDTO findGenderById(Long id) {
        GenderEntity gender = genderRepository.findById(id).orElse(null);

        GenderDTO genderDTO = genderMapper.genderEntityToDto(gender);

        return genderDTO;
    }

    @Override
    public List<GenderDTO> findAll() {
        return genderMapper.genderListEntityToDto(genderRepository.findAll());
    }

    @Override
    public void delete(Long id) {
        genderRepository.deleteById(id);
    }

    @Override
    public GenderDTO modify(GenderDTO genderDTO, Long id) {
        GenderEntity genderEntity = genderRepository.findById(id).orElse(null);
        genderEntity.setImgUrl(genderDTO.getImgUrl());
        genderEntity.setName(genderDTO.getName());
        genderRepository.save(genderEntity);
        GenderDTO dto = genderMapper.genderEntityToDto(genderEntity);
        return dto;

    }
}
