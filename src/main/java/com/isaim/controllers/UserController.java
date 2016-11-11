package com.isaim.controllers;

import com.isaim.models.User;
import com.isaim.models.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserDao userDao;

	// ALTA
	@RequestMapping("/alta")
	//@ResponseBody
	//public String alta(String nombre, String apellido_materno, String apellido_paterno) {
	public User alta(String nombre, String apellido_materno, String apellido_paterno) {
		String userId = "";
		User user = null;

		try {
			user = new User(nombre, apellido_materno, apellido_paterno);
			userDao.save(user);
			userId = String.valueOf(user.getId());
		}
		catch (Exception e) {
			//return "Eror en usuario ALTA: " + e.toString();
			return user;
		}

		//return "Exito en usuario ALTA con id: " + userId;
		return user;
	}

	// BAJA
	@RequestMapping("/baja")
	//@ResponseBody
	public String baja(long id) {
		try {
			User user = new User(id);
			userDao.delete(user);
		}
		catch (Exception e) {
			return "Eror en usuario BAJA: " + e.toString();
		}

		return "Exito en usuario BAJA con id: " + id;
	}

	// CONSULTA
	@RequestMapping("/por-nombre")
	//@ResponseBody
	//public String porNombre(String nombre) {
	public User porNombre(String nombre) {
		String userId = "";
		User user = null;
		try {
			user = userDao.findByNombre(nombre);
			userId = String.valueOf(user.getId());
		}
		catch (Exception e) {
			//return "Eror usuario no encontrado";
			return user;
		}

		//return "Exito, id de usuario es: " + userId;
		return user;
	}

	// CAMBIOS
	@RequestMapping("/cambios")
	//@ResponseBody
	//public String cambiosUsuario(long id, String nombre, String apellido_materno, String apellido_paterno) {
	public User cambiosUsuario(long id, String nombre, String apellido_materno, String apellido_paterno) {
		User user = null;
		try {
			user = userDao.findOne(id);
			user.setNombre(nombre);
			user.setApellidoMaterno(apellido_materno);
			user.setApellidoPaterno(apellido_paterno);
			userDao.save(user);
		}
		catch (Exception e) {
			//return "Eror en usuario CAMBIOS con: " + e.toString();
			return user;
		}

		//return "Exito en usuario CAMBIOS con id: " + id;
		return user;
	}
}
