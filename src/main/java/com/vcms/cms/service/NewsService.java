package com.vcms.cms.service;

import com.vcms.cms.dto.NewsRequestDto;
import com.vcms.cms.dto.NewsResponseDto;
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

    public NewsResponseDto createNews(NewsRequestDto newsRequestDto) {
        News news = new News();
        applyRequest(news, newsRequestDto);
        return toResponseDto(newsRepository.save(news));
    }

    public List<NewsResponseDto> getAllNews() {
        return newsRepository.findAll()
                .stream()
                .map(this::toResponseDto)
                .toList();
    }

    public Optional<NewsResponseDto> getNewsById(Long id) {
        return newsRepository.findById(id)
                .map(this::toResponseDto);
    }

    public NewsResponseDto updateNews(Long id, NewsRequestDto updatedNews) {
        return newsRepository.findById(id)
                .map(news -> {
                    applyRequest(news, updatedNews);
                    return toResponseDto(newsRepository.save(news));
                })
                .orElseThrow(() -> new RuntimeException("News not found with id: " + id));
    }

    public void deleteNews(Long id) {
        newsRepository.deleteById(id);
    }

    private void applyRequest(News news, NewsRequestDto newsRequestDto) {
        news.setTitle(newsRequestDto.getTitle());
        news.setDescription(newsRequestDto.getDescription());
        news.setFilename(newsRequestDto.getFilename());
        news.setStatus(newsRequestDto.getStatus());
    }

    private NewsResponseDto toResponseDto(News news) {
        return new NewsResponseDto(
                news.getId(),
                news.getTitle(),
                news.getDescription(),
                news.getFilename(),
                news.getStatus()
        );
    }
}
