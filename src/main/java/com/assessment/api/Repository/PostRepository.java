package com.assessment.api.Repository;

import com.assessment.api.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitle(String title);
    List<Post> findByUserId(Long userId);
}
