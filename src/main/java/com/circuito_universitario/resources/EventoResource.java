package com.circuito_universitario.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.circuito_universitario.domain.Evento;
import com.circuito_universitario.services.EventoService;

@RestController
@RequestMapping(value="/eventos")
public class EventoResource {
	@Autowired
	private EventoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Evento> find(@PathVariable Integer id) {
		Evento obj = service.find(id);	
		return ResponseEntity.ok().body(obj);
	}
//POST
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Evento obj){
		Evento obj1 = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getIdEvento()).toUri();
		return ResponseEntity.created(uri).build();
	}
//DELETE
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Evento> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
//GET
	@RequestMapping( method=RequestMethod.GET)
	public ResponseEntity<List<Evento>> findAll() {	
		List<Evento> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
