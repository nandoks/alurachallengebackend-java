package com.br.nandoks.alurachallengejava.controller.form;

import com.br.nandoks.alurachallengejava.models.Video;
import com.br.nandoks.alurachallengejava.repository.VideoRepository;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;


public class VideoForm {

    @NotEmpty
    @NotNull
    @Length(min=5)
    private String titulo;
    @NotEmpty
    @NotNull
    @Length(min=10)
    private String descricao;
    @NotEmpty
    @NotNull
    @URL
    private String url;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Video converter() {
        return new Video(titulo, descricao, url);
    }
}
