package com.blueyonder.UserService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blueyonder.UserService.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	@Query(value = "select * from user_info u where u.user_name=?", nativeQuery = true)
	public Optional<User> findUserByName(String uname);
	
	public boolean existsByUsername(String username);
}
