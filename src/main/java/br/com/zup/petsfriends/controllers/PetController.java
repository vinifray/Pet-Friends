package br.com.zup.petsfriends.controllers;

import br.com.zup.petsfriends.dtos.CadastroPetDTO;
import br.com.zup.petsfriends.models.Pet;
import br.com.zup.petsfriends.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pets/")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    public Pet cadastrarPet(@RequestBody CadastroPetDTO cadastroPetDTO){
        Pet pet = cadastroPetDTO.converterDTOParaPet();
        return petService.cadastrarPet(pet);
    }


}
