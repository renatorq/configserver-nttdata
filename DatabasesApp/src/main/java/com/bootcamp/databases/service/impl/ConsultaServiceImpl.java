package com.bootcamp.databases.service.impl;

import com.bootcamp.databases.model.*;
import com.bootcamp.databases.repository.*;
import com.bootcamp.databases.service.ConsultaService;
import com.bootcamp.databases.service.DetalleConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    @Autowired
    private MedicoRepository medicoRepo;
    @Autowired
    private PacienteRepository pacienteRepo;
    @Autowired
    private EspecialidadRepository especialidadRepo;
    @Autowired
    private ConsultaRepository consultaRepo;

    @Autowired
    private ExamenRepository examenRepository;

    @Autowired
    private DetalleConsultaService detalleService;

    @Transactional
    @Override
    public Consulta registrar(Consulta c) throws Exception {

        try {
            Optional<Medico> medico = medicoRepo.findById(c.getMedico().getIdMedico());

            if (medico.isEmpty()) {
                System.out.println("EL medico no existe!");
                throw new Exception("Error al Registrar la Consulta, El medico no existe");
            }

            Optional<Paciente> paciente = pacienteRepo.findById(c.getPaciente().getIdPaciente());

            if (paciente.isEmpty()) {
                System.out.println("EL paciente no existe!");
                throw new Exception("Error al Registrar la Consulta, El paciente no existe");
            }

            Optional<Especialidad> especialidad = especialidadRepo.findById(c.getEspecialidad().getIdEspecialidad());

            if (especialidad.isEmpty()) {
                System.out.println("La especialidad no existe!");
                throw new Exception("Error al Registrar la Consulta, La especialidad no existe");
            }

            Consulta consultaRegistrada = consultaRepo.save(c);

            consultaRegistrada.getExamenes().forEach(examen -> {
                examen.getConsultas().add(consultaRegistrada);
                examenRepository.save(examen);
            });

            for (DetalleConsulta detalle : c.getDetallesConsulta()) {
                detalle.setIdConsulta(consultaRegistrada.getIdConsulta());
                detalleService.guardarDetalleConsulta(detalle);
            }

            return consultaRegistrada;
        } catch (Exception e) {
            throw new Exception("Error al guardar la consulta con detalles.", e);
        }

    }

    @Override
    public void eliminar(Integer idConsulta) throws Exception {

        detalleService.eliminarDetalleConsulta(idConsulta);
        consultaRepo.deleteById(idConsulta);
    }

    @Override
    public Consulta obtenerConsulta(Integer idConsulta) throws Exception {

        Consulta consulta = consultaRepo.findById(idConsulta)
                .orElseThrow(() -> new Exception("Consulta no encontrada"));


        List<DetalleConsulta> detalles = detalleService.obtenerDetalleConsulta(idConsulta);
        consulta.setDetallesConsulta(detalles);

        return consulta;
    }
}
