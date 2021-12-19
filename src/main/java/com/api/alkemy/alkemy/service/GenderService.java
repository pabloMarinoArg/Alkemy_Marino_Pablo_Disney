package com.api.alkemy.alkemy.service;

import com.api.alkemy.alkemy.dto.GenderDTO;

import java.util.List;

public interface GenderService {
    GenderDTO save(GenderDTO genderDTO);
    GenderDTO findGenderById(Long id);
    List<GenderDTO> findAll();
    void delete(Long id);
    GenderDTO modify (GenderDTO genderDTO, Long id);
}
