package br.com.zup.petsfriends.dtos;

import br.com.zup.petsfriends.models.Pet;

import java.time.LocalDate;

public class ResumoPetDTO {
    private String nome;
    private String raca;
    private String especie;
    private LocalDate dataEntrada;

    public ResumoPetDTO(String nome, String raca, String especie, LocalDate dataEntrada) {
        this.nome = nome;
        this.raca = raca;
        this.especie = especie;
        this.dataEntrada = dataEntrada;
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

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public static ResumoPetDTO converterPetParaDTO(Pet pet){
        ResumoPetDTO resumoPetDTO = new ResumoPetDTO(pet.getNome(), pet.getRaca(),
                pet.getEspecie(), pet.getDataEntrada());

        return resumoPetDTO;
    }
}
