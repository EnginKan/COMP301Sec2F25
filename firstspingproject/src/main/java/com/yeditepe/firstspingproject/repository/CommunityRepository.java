package com.yeditepe.firstspingproject.repository;

import com.yeditepe.firstspingproject.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository
extends JpaRepository<Community,Long> {
}
