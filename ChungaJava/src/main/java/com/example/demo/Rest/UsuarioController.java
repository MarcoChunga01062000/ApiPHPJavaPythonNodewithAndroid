package com.example.demo.Rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Usuario;
import com.example.demo.crudImp.UsuarioImp;

@RestController()
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioImp usuarioService;
	
	@GetMapping("/test")
	public String prueba() {
		return "prueba 1";
	}
	
	@PutMapping("/update")
	public Usuario update(@RequestParam("id") String id,@RequestParam("name") String name, @RequestParam("pass") String pass, @RequestParam("correo") String correo) {
		Usuario usuario = new Usuario(Long.parseLong(id), name,correo,pass,"");
		return usuarioService.save(usuario);
	}
	
	@PostMapping("/insert")
	public Usuario crear(@RequestParam("name") String name, @RequestParam("pass") String pass, @RequestParam("correo") String correo) {
		Usuario usuario = new Usuario(name,correo,pass,"");
		return usuarioService.save(usuario);
	}
	
	@GetMapping("/list")
	public List<Usuario> listar() {
		return usuarioService.find();
	}
	
	@GetMapping("/listJava")
	public List<Usuario> listarJava() {
		System.out.println(usuarioService.findJava());
		return usuarioService.findJava();
	}
	
	@DeleteMapping("/delete")
	public void eliminar(@RequestParam("id") String id) {
		usuarioService.delete(Long.parseLong(id));
	}

}
