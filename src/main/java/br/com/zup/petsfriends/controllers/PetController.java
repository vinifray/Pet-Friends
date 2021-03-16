package br.com.zup.petsfriends.controllers;

import br.com.zup.petsfriends.dtos.CadastroPetDTO;
import br.com.zup.petsfriends.dtos.ResumoPetDTO;
import br.com.zup.petsfriends.models.Pet;
import br.com.zup.petsfriends.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("pets/")
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pet cadastrarPet(@RequestBody CadastroPetDTO cadastroPetDTO){
        Pet pet = cadastroPetDTO.converterDTOParaPet();
        return petService.cadastrarPet(pet);
    }

    @GetMapping("{email}/")
    public ResumoPetDTO pesquisarPetPorEmail(@PathVariable String email){
        Pet pet = petService.pesquisarPeloEmailDoDono(email);
        return ResumoPetDTO.converterPetParaDTO(pet);
    }

    @DeleteMapping("{nome}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPet(@PathVariable Pet nome){
        try {
            petService.deletarPet(nome);
        }catch (RuntimeException erro){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, erro.getMessage());
        }
    }
}
