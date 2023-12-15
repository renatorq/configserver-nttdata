package com.bootcamp.databases.controller;

import com.bootcamp.databases.model.Consulta;
import com.bootcamp.databases.service.ConsultaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private static final Logger logger = Logger.getLogger(ConsultaController.class);
    @Autowired
    private ConsultaService service;

    @PostMapping("/nuevo")
    public ResponseEntity<Object> registrar(@RequestBody Consulta c) throws Exception {
        logger.info("Registrar nueva consulta");
        try {
            service.registrar(c);
            return ResponseEntity.ok(c);
        } catch (Exception e) {
            logger.error("No se pudo registrar la consulta");
            logger.debug(e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscar/{idConsulta}")
    public ResponseEntity<Object> obtenerConsultaConDetalles(@PathVariable int idConsulta) throws Exception {
        Consulta consulta = service.obtenerConsulta(idConsulta);
        return ResponseEntity.ok(consulta);
    }

    @DeleteMapping("eliminar/{idConsulta}")
    public ResponseEntity<String> eliminar(@PathVariable int idConsulta) throws Exception {
        service.eliminar(idConsulta);
        return ResponseEntity.ok().body("Consulta eliminada exitosamente");
    }

}
