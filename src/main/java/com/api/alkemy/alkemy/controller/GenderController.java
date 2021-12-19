package com.api.alkemy.alkemy.controller;

import com.api.alkemy.alkemy.dto.GenderDTO;
import com.api.alkemy.alkemy.service.implementation.GenderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genders")
public class GenderController {
    @Autowired
    private GenderServiceImpl genderService;

    @PostMapping
    public ResponseEntity<GenderDTO> save (@RequestBody GenderDTO genderDTO){
        GenderDTO dto= genderService.save(genderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
    @GetMapping
    public ResponseEntity<List<GenderDTO>> findAll(){
        List<GenderDTO> list = genderService.findAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<GenderDTO> findGenderById(@PathVariable Long id){
        GenderDTO genderDTO = genderService.findGenderById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(genderDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        genderService.delete(id);
        return new ResponseEntity<>("The gender with id "+id +" has been erased",HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<GenderDTO> modify(@RequestBody GenderDTO genderDTO, @PathVariable Long id){
       GenderDTO gender = genderService.modify(genderDTO,id);

        return ResponseEntity.status(HttpStatus.CREATED).body(gender);


    }

}
