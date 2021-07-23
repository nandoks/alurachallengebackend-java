package com.br.nandoks.alurachallengejava.repository;

import com.br.nandoks.alurachallengejava.models.Video;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
class VideoRepositoryTest {


    @Autowired
    private VideoRepository videoRepository;

    @Test
    public void getRequestRepository() {
        List<Video> result = videoRepository.findAll();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.size(), 5);
    }

}