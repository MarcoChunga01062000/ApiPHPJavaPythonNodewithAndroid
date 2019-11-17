package com.example.demo.crudImp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Model.Usuario;
import com.example.demo.crud.UsuarioRepository;
import com.example.demo.crudService.UsuarioService;

@Service
public class UsuarioImp implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioR;

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		usuario.setOrigen("Insert Successful");
		System.out.println(usuario.toString());
		System.out.println("Insert Successful");
		return usuarioR.save(usuario);
	}

	@Override
	public Usuario update(Usuario usuario) {
		usuario.setOrigen("Update Successful");
		System.out.println(usuario.toString());
		System.out.println("Update Successful");
		return usuarioR.save(usuario);
	}

	@Override
	public List<Usuario> find() {
		System.out.println("Listado successful");
		return (List<Usuario>) usuarioR.findAll();
	}

	@Override
	public List<Usuario> findJava() {
		System.out.println("USUARIOS DE JAVA");
		return usuarioR.findByOrigen("API_JAVA");
	}

	@Override
	public void delete(Long id) {
		System.out.println("Deleted successful");
		usuarioR.deleteById(id);
	}
}
