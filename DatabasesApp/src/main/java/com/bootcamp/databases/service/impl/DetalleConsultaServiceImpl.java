package com.bootcamp.databases.service.impl;

import com.bootcamp.databases.model.DetalleConsulta;
import com.bootcamp.databases.repository.DetalleRepository;
import com.bootcamp.databases.service.DetalleConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleConsultaServiceImpl implements DetalleConsultaService {

    @Autowired
    private DetalleRepository detalleConsultaRepository;

//    @Transactional(transactionManager = "mongoTransactionManager")

    @Override
    public void guardarDetalleConsulta(DetalleConsulta detalle) throws Exception {
        try {
            detalleConsultaRepository.save(detalle);
        } catch (Exception e) {
            throw new Exception("Error al guardar el detalle de la consulta.", e);
        }
    }

    @Override
    public void eliminarDetalleConsulta(Integer idConsulta) throws Exception {
        detalleConsultaRepository.deleteByIdConsulta(idConsulta);
    }

    @Override
    public List<DetalleConsulta> obtenerDetalleConsulta(Integer idConsulta) throws Exception {
        return detalleConsultaRepository.findByIdConsulta(idConsulta);
    }
}
