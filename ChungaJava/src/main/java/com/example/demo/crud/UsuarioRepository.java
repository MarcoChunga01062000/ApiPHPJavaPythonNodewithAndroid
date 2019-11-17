package com.example.demo.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	public List<Usuario> findByOrigen(String origen);
}
