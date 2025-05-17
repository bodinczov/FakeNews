package org.fakenews.Controller;

import org.fakenews.model.News;
import org.fakenews.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.fakenews.repository.NewsRepository;

@Controller
public class WebController {
    @Autowired
    private NewsRepository newsRepository;

    @GetMapping("/")
    public String showNews(Model model) {
        List<News> newsList = newsRepository.findAll();
        model.addAttribute("news", newsList);
        return "news";
    }
}