package com.blueyonder.UserService.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.blueyonder.UserService.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	@Query(value = "select * from user_info u where u.user_name=?", nativeQuery = true)
	public User findUserByName(String uname);
}
