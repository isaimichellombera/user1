package com.isaim.controllers;

import com.isaim.models.User;
import com.isaim.models.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	// ALTA
	@RequestMapping("/alta")
	@ResponseBody
	public String alta(String nombre, String apellido_materno, String apellido_paterno) {
		String userId = "";

		try {
			User user = new User(nombre, apellido_materno, apellido_paterno);
			userDao.save(user);
			userId = String.valueOf(user.getId());
		}
		catch (Exception e) {
			return "Eror en usuario ALTA: " + e.toString();
		}

		return "Exito en usuario ALTA con id: " + userId;
	}

	// BAJA
	@RequestMapping("/baja")
	@ResponseBody
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

	//
	@RequestMapping("/por-nombre")
	@ResponseBody
	public String porNombre(String nombre) {
		String userId = "";
		try {
			User user = userDao.findByNombre(nombre);
			userId = String.valueOf(user.getId());
		}
		catch (Exception e) {
			return "Eror usuario no encontrado";
		}

		return "Exito, id de usuario es: " + userId;
	}

	// CAMBIOS
	@RequestMapping("/cambios")
	@ResponseBody
	public String cambiosUsuario(long id, String nombre, String apellido_materno, String apellido_paterno) {
		try {
			User user = userDao.findOne(id);
			user.setNombre(nombre);
			user.setApellidoMaterno(apellido_materno);
			user.setApellidoPaterno(apellido_paterno);
			userDao.save(user);
		}
		catch (Exception e) {
			return "Eror en usuario CAMBIOS con: " + e.toString();
		}

		return "Exito en usuario CAMBIOS con id: " + id;
	}
}
