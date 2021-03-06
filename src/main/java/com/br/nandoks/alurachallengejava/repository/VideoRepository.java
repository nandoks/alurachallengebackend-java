package com.br.nandoks.alurachallengejava.repository;

import com.br.nandoks.alurachallengejava.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface VideoRepository extends JpaRepository<Video, Long> {

    List<Video> findByTitle(String title);
}
