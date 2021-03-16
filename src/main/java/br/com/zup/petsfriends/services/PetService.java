package br.com.zup.petsfriends.services;

import br.com.zup.petsfriends.models.Pet;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {
    private static List<Pet> pets = new ArrayList<>();

    public Pet cadastrarPet(Pet pet) {
        pet.setDataEntrada(LocalDate.now());
        pets.add(pet);

        return pet;
    }

    public List<Pet> retornarListaDeTodosOsPets() {
        return pets;
    }

    public Pet pesquisarPeloEmailDoDono(String email) {
        for (Pet pet : pets) {
            if ( pet.getEmail().equalsIgnoreCase(email) ) {
                return pet;
            }
        }
        throw new RuntimeException("Pet não encontrado com esse email");
    }

    public void deletarPet(Pet nome){
        Pet pet = cadastrarPet(nome);
        pets.remove(pets);
    }

    public Pet procurarPeloNomeDoPet(String nome) {
        for (Pet pet : pets) {
            if ( pet.getNome().equalsIgnoreCase(nome) ) {
                return pet;
            }
        }
        throw new RuntimeException("Pet não encontrado com esse nome");
    }

}




