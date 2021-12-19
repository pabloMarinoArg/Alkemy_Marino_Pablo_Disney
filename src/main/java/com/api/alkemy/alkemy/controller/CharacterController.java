package com.api.alkemy.alkemy.controller;

import com.api.alkemy.alkemy.dto.CharacterBasicDTO;
import com.api.alkemy.alkemy.dto.CharacterDTO;
import com.api.alkemy.alkemy.service.implementation.CharacterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterServiceImpl characterService;

    @PostMapping
    public ResponseEntity<CharacterDTO> save (@RequestBody CharacterDTO characterDTO){
        CharacterDTO character = characterService.save(characterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(character);

    }

    @GetMapping
    public ResponseEntity<List<CharacterBasicDTO>> findAll(){
        List<CharacterBasicDTO> list = characterService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> findById(@PathVariable Long id){
        CharacterDTO character = characterService.findCharacterById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(character);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){
        characterService.delete(id);
        return new ResponseEntity<>("The character with id " + id + " has been deleted",HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterDTO> modify(@RequestBody CharacterDTO characterDTO, @PathVariable Long id){
      CharacterDTO charDto =  characterService.modify(characterDTO,id);
        return ResponseEntity.status(HttpStatus.CREATED).body(charDto);

    }









}
