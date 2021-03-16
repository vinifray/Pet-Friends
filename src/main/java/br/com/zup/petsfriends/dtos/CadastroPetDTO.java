package br.com.zup.petsfriends.dtos;

import br.com.zup.petsfriends.models.Pet;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CadastroPetDTO {
    @NotNull
    @Size(min=2, max=30)
    private String nome;
    @NotNull
    @Size(min=2, max=30)
    private String raca;
    @NotNull
    @Size(min=2, max=30)
    private String especie;
    @NotNull
    @Size(min=2, max=30)
    private String nomeDono;
    @Email(message = "E-mail inválido")
    private String email;

    public CadastroPetDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getNomeDono() {
        return nomeDono;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pet converterDTOParaPet(){
        Pet pet = new Pet();
        pet.setNome(this.nome);
        pet.setEmail(this.email);
        pet.setRaca(this.raca);
        pet.setEspecie(this.especie);
        pet.setNomeDono(this.nomeDono);

        return pet;
    }
}
