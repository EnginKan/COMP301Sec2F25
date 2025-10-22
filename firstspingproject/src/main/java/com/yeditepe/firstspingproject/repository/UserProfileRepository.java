package com.yeditepe.firstspingproject.repository;

import com.yeditepe.firstspingproject.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository
        extends JpaRepository<UserProfile,Long> {


}
