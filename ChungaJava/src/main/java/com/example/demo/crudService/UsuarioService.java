package com.example.demo.crudService;

import java.util.List;

import com.example.demo.Model.Usuario;

public interface UsuarioService {
	public Usuario save(Usuario usuario);
	public Usuario update(Usuario usuario);
	public void delete(Long id);
	public List<Usuario> find();
	public List<Usuario> findJava();
}
