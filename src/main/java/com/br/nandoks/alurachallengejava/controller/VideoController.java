package com.br.nandoks.alurachallengejava.controller;

import com.br.nandoks.alurachallengejava.controller.form.UpdateVideoForm;
import com.br.nandoks.alurachallengejava.controller.form.VideoForm;
import com.br.nandoks.alurachallengejava.models.Video;
import com.br.nandoks.alurachallengejava.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @GetMapping("/videos")
    public List<Video> listVideos(String title) {
        List<Video> videos = null;
        if (title == null) {
            videos = videoRepository.findAll();
        } else {
            videos = videoRepository.findByTitle(title);
        }

        return videos;
    }

    @PostMapping("/videos")
    @Transactional
    public ResponseEntity<Video> create(@RequestBody @Valid VideoForm form, UriComponentsBuilder uriBuilder) {
        Video video = form.converter();
        videoRepository.save(video);
        URI uri = uriBuilder.path("/videos/{id}").buildAndExpand(video.getId()).toUri();
        return ResponseEntity.created(uri).body(video);
    }

    @GetMapping("/videos/{id}")
    public ResponseEntity<Video> cadastrar(@PathVariable Long id) {
        Optional<Video> optional = videoRepository.findById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/videos/{id}")
    @Transactional
    public ResponseEntity<Video> updateVideo(@PathVariable Long id, @RequestBody @Valid UpdateVideoForm form, UriComponentsBuilder uriBuilder) {
        Optional<Video> optional = videoRepository.findById(id);
        if(optional.isPresent()) {
            Video video = form.update(id, videoRepository);
            return ResponseEntity.ok(video);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/videos/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {

        Optional<Video> optional = videoRepository.findById(id);
        if(optional.isPresent()) {
            videoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
