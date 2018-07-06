package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.demo.entities.User;


public interface IUserRepository extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User>{

}
