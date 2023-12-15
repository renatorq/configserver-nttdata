package com.bootcamp.databases.service;

import com.bootcamp.databases.model.DetalleConsulta;

import java.util.List;

public interface DetalleConsultaService {

    void guardarDetalleConsulta(DetalleConsulta detalle) throws Exception;

    void eliminarDetalleConsulta(Integer idConsulta) throws Exception;

    List<DetalleConsulta> obtenerDetalleConsulta(Integer idConsulta) throws Exception;
}
