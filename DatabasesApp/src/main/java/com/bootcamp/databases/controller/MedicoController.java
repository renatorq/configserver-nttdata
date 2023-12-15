package com.bootcamp.databases.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bootcamp.databases.model.Medico;
import com.bootcamp.databases.service.MedicoService;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
	private static final Logger logger = Logger.getLogger(MedicoController.class);
	
	@Autowired
	private MedicoService service;
	
	@PostMapping("/nuevo")
	public ResponseEntity<Object> registrar(@RequestBody Medico m) {
		logger.info("Registrar nuevo médico");
		try {
			service.registrar(m);
			return ResponseEntity.ok(m);
		} catch (Exception e) {
			logger.error("No se pudo registrar el médico");
			logger.debug(e);
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<Object> actualizar(@RequestBody Medico m) throws Exception {
		logger.info("Actualizando datos del Medico: "+m.getNombres()+" "+m.getApellidos());
		try {
			service.modificar(m);
			return ResponseEntity.ok(m);
		}catch (Exception e) {
			logger.error("No se pudo actualizar al médico");
			logger.debug(e);
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<Medico> buscar(@RequestParam("id") int id) throws Exception {
		return ResponseEntity.ok(service.buscar(id));
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Medico>> listar() throws Exception {
		return ResponseEntity.ok(service.listarTodos());
	}

	@DeleteMapping("/eliminar/{idMedico}")
	public ResponseEntity<Object> eliminar(@PathVariable("idMedico") Integer idMedico) throws Exception{

		try {
			service.eliminar(idMedico);
			return ResponseEntity.ok().body("Se elimin\u00F3 al medico");
		}catch (Exception e){
			logger.error("No se pudo eliminar al médico");
			logger.debug(e);
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

}
