package com.bootcamp.databases.controller;

import com.bootcamp.databases.model.Paciente;
import com.bootcamp.databases.service.PacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private static final Logger logger = Logger.getLogger(PacienteController.class);

    @Autowired
    private PacienteService service;

    @PostMapping("/nuevo")
    public ResponseEntity<Object> registrar(@RequestBody Paciente p) {
        logger.info("Registrar nuevo paciente");
        try {
            service.registrar(p);
            return ResponseEntity.ok(p);
        } catch (Exception e) {
            logger.error("No se pudo registrar al paciente");
            logger.debug(e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Object> actualizar(@RequestBody Paciente p) throws Exception {
        logger.info("Actualizando datos del Paciente: "+p.getNombres()+" "+p.getApellidos());
        try {
            service.modificar(p);
            return ResponseEntity.ok(p);
        }catch (Exception e) {
            logger.error("No se pudo actualizar al paciente");
            logger.debug(e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<Paciente> buscar(@RequestParam("id") int id) throws Exception {
        return ResponseEntity.ok(service.buscar(id));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Paciente>> listar() throws Exception {
        return ResponseEntity.ok(service.listarTodos());
    }

    @DeleteMapping("/eliminar/{idPaciente}")
    public ResponseEntity<Object> eliminar(@PathVariable("idPaciente") Integer idPaciente) throws Exception{

        try {
            service.eliminar(idPaciente);
            return ResponseEntity.ok().body("Se elimin\u00F3 al paciente");
        }catch (Exception e){
            logger.error("No se pudo eliminar al paciente");
            logger.debug(e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
