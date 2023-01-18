package com.socioFix.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.socioFix.model.User;

public interface UserRepository extends JpaRepository<User,String>{

}
