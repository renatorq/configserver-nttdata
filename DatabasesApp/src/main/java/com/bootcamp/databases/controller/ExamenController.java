package com.bootcamp.databases.controller;

import com.bootcamp.databases.model.Examen;
import com.bootcamp.databases.service.ExamenService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examenes")
public class ExamenController {

    private static final Logger logger = Logger.getLogger(ExamenController.class);

    @Autowired
    ExamenService service;

    @PostMapping("/nuevo")
    public ResponseEntity<Object> registrar(@RequestBody Examen examen) {
        logger.info("Registrar nuevo examen");
        try {
            service.registrar(examen);
            return ResponseEntity.ok(examen);
        } catch (Exception e) {
            logger.error("No se pudo registrar el examen");
            logger.debug(e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Object> actualizar(@RequestBody Examen es) throws Exception {
        logger.info("Actualizando datos del examen: "+es.getNombre());
        try {
            service.modificar(es);
            return ResponseEntity.ok(es);
        }catch (Exception e) {
            logger.error("No se pudo actualizar el examen");
            logger.debug(e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<Examen> buscar(@RequestParam("id") int id) throws Exception {
        return ResponseEntity.ok(service.buscar(id));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Examen>> listar() throws Exception {
        return ResponseEntity.ok(service.listarTodos());
    }

    @DeleteMapping("/eliminar/{idExamen}")
    public ResponseEntity<Object> eliminar(@PathVariable("idExamen") Integer idExamen) throws Exception{

        try {
            service.eliminar(idExamen);
            return ResponseEntity.ok().body("Se elimin\u00F3 el examen");
        }catch (Exception e){
            logger.error("No se pudo eliminar el examen");
            logger.debug(e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

}
