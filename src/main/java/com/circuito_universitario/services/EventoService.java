package com.circuito_universitario.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.circuito_universitario.domain.Evento;
import com.circuito_universitario.exceptions.DataIntegrityException;
import com.circuito_universitario.exceptions.ObjectNotFoundException;
import com.circuito_universitario.repositories.EventoRepository;

@Service
public class EventoService {
	@Autowired
	private EventoRepository repo;
//	
	public Evento find(Integer id){
		Optional<Evento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " +id+", Tipo: "+ Evento.class.getName()));
	}
//	
	public Evento insert(Evento obj) {
		obj.setIdEvento(null);
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
	public List<Evento> findAll(){
		return repo.findAll();
	}
}
