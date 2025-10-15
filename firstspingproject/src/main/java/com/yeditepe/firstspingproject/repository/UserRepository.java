package com.yeditepe.firstspingproject.repository;

import com.yeditepe.firstspingproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

  public List<User> findByUsernameStartingWith(String start);

//  @Query("Select * from users where username like ':s*'")


}
