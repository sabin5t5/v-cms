package com.vcms.cms.controller;

import com.vcms.cms.dto.NewsRequestDto;
import com.vcms.cms.dto.NewsResponseDto;
import com.vcms.cms.service.NewsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping
    public NewsResponseDto createNews(@RequestBody NewsRequestDto news) {
        return newsService.createNews(news);
    }

    @GetMapping
    public List<NewsResponseDto> getAllNews() {
        return newsService.getAllNews();
    }

    @GetMapping("/{id}")
    public NewsResponseDto getNewsById(@PathVariable Long id) {
        return newsService.getNewsById(id)
                .orElseThrow(() -> new RuntimeException("News not found with id: " + id));
    }

    @PutMapping("/{id}")
    public NewsResponseDto updateNews(@PathVariable Long id, @RequestBody NewsRequestDto news) {
        return newsService.updateNews(id, news);
    }

    @DeleteMapping("/{id}")
    public String deleteNews(@PathVariable Long id) {
        newsService.deleteNews(id);
        return "News deleted successfully";
    }
}
