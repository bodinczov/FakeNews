package org.fakenews.Controller;

import org.fakenews.model.News;
import java.util.List;
import org.fakenews.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        var result = newsRepository.save(news);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping("/news/{id}")
    ResponseEntity<News> update(@PathVariable String id, @RequestBody News updatedNews){
        News news = newsRepository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "News " + id + " not found!"));
        news.setTitle(updatedNews.getTitle());
        news.setDescription(updatedNews.getDescription());
        var result = newsRepository.save(news);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/news/{id}")
    ResponseEntity<News> delete(@PathVariable String id){
        News news = newsRepository.findById(Integer.parseInt(id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "News " + id + " not found!"));
        newsRepository.deleteById(Integer.parseInt(id));
        return ResponseEntity.noContent().build();
    }
}
