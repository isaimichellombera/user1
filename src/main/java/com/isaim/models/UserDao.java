package com.isaim.models;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

@Transactional
public interface UserDao extends CrudRepository<User, Long> {

	public User findByNombre(String nombre);
	public User findById(long id);
}
