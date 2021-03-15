package br.com.zup.petsfriends.exceptions;

import br.com.zup.petsfriends.dtos.ResumoPetDTO;

import java.util.List;

public class MensagemDeErro {
    private String mensagem;
    private List<?> objects;

    public MensagemDeErro() {
    }

    public MensagemDeErro(String mensagem, List<?> objects) {
        this.mensagem = mensagem;
        this.objects = objects;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public List<?> getObjects() {
        return objects;
    }

    public void setObjects(List<?> objects) {
        this.objects = objects;
    }
}
