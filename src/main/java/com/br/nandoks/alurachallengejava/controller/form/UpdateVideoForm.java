package com.br.nandoks.alurachallengejava.controller.form;

import com.br.nandoks.alurachallengejava.models.Video;
import com.br.nandoks.alurachallengejava.repository.VideoRepository;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;

public class UpdateVideoForm {

    @NotEmpty
    @NotNull
    @Length(min=5)
    private String title;
    @NotEmpty
    @NotNull
    @Length(min=10)
    private String description;
    @NotEmpty
    @NotNull
    @URL
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Video converter() {
        return new Video(title, description, url);
    }

    public Video update(Long id, VideoRepository videoRepository) {
        Video video = videoRepository.findById(id).get();
        video.setTitle(this.title);
        video.setDescription(this.description);
        video.setUrl(this.url);
        return video;
    }


}
