package org.fakenews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.fakenews.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Integer> {
}
