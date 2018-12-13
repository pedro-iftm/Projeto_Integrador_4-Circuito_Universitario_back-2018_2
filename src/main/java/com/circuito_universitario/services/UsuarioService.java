package com.circuito_universitario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.circuito_universitario.domain.Usuario;
import com.circuito_universitario.exceptions.DataIntegrityException;
import com.circuito_universitario.exceptions.ObjectNotFoundException;
import com.circuito_universitario.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository repo;
//	
	public Usuario find(Integer id){
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +id+", Tipo: "+ Usuario.class.getName()));
	}
//	
	public Usuario insert(Usuario obj) {
		obj.setIdUser(null);
		obj = repo.save(obj);
		return obj;
	}
//	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir por que há entidades relacionadas");
		}
	}
//
	public List<Usuario> findAll(){
		return repo.findAll();
	}
}
