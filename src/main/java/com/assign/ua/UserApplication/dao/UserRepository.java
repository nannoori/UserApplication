package com.assign.ua.UserApplication.dao;

import com.assign.ua.UserApplication.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
  User findByName(String name);



}
