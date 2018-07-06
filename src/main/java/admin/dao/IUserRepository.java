package admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import admin.entities.User;

public interface IUserRepository extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User>{

}
