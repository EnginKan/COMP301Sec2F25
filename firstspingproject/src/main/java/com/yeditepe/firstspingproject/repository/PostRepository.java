package com.yeditepe.firstspingproject.repository;

import com.yeditepe.firstspingproject.entity.Post;
import org.springframework.data.repository.ListCrudRepository;

public interface PostRepository extends
        ListCrudRepository<Post, Long> {
}
