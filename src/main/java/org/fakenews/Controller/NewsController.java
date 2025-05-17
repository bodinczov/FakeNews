package org.fakenews.Controller;

import org.fakenews.model.News;
import java.util.Optional;
import java.util.List;
import org.fakenews.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NewsController {
    @Autowired
    private NewsRepository newsRepository;

    @GetMapping("/news")
    List<News> all(){
        List<News> listOfNews = newsRepository.findAll();
        return listOfNews;
    }
    @PostMapping("/news/create")
    ResponseEntity<News> create(@RequestBody News news){
        newsRepository.save(news);
        return new ResponseEntity<>(news, HttpStatus.CREATED);
    }
}
