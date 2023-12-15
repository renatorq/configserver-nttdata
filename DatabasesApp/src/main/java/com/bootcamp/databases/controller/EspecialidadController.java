package com.bootcamp.databases.controller;

import com.bootcamp.databases.model.Especialidad;
import com.bootcamp.databases.service.EspecialidadService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {

    private static final Logger logger = Logger.getLogger(EspecialidadController.class);

    @Autowired
    EspecialidadService service;

    @PostMapping("/nuevo")
    public ResponseEntity<Object> registrar(@RequestBody Especialidad es) {
        logger.info("Registrar nuevo especialidad");
        try {
            service.registrar(es);
            return ResponseEntity.ok(es);
        } catch (Exception e) {
            logger.error("No se pudo registrar la especialidad");
            logger.debug(e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Object> actualizar(@RequestBody Especialidad es) throws Exception {
        logger.info("Actualizando datos de la especialidad: "+es.getNombre());
        try {
            service.modificar(es);
            return ResponseEntity.ok(es);
        }catch (Exception e) {
            logger.error("No se pudo actualizar la especialidad");
            logger.debug(e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<Especialidad> buscar(@RequestParam("id") int id) throws Exception {
        return ResponseEntity.ok(service.buscar(id));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Especialidad>> listar() throws Exception {
        return ResponseEntity.ok(service.listarTodos());
    }

    @DeleteMapping("/eliminar/{idEspecialidad}")
    public ResponseEntity<Object> eliminar(@PathVariable("idEspecialidad") Integer idEspecialidad) throws Exception{

        try {
            service.eliminar(idEspecialidad);
            return ResponseEntity.ok().body("Se elimin\u00F3 la especialidad");
        }catch (Exception e){
            logger.error("No se pudo eliminar la especialidad");
            logger.debug(e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
