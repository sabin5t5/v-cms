package com.vcms.cms.service;

import com.vcms.cms.entity.News;
import com.vcms.cms.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public News createNews(News news) {
        return newsRepository.save(news);
    }

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public Optional<News> getNewsById(Long id) {
        return newsRepository.findById(id);
    }

    public News updateNews(Long id, News updatedNews) {
        return newsRepository.findById(id)
                .map(news -> {
                    news.setTitle(updatedNews.getTitle());
                    news.setDescription(updatedNews.getDescription());
                    return newsRepository.save(news);
                })
                .orElseThrow(() -> new RuntimeException("News not found with id: " + id));
    }

    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }
}
