package com.odji.spring_back_end.repository;

import com.odji.spring_back_end.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

  User findByUserId(String userId);
}
