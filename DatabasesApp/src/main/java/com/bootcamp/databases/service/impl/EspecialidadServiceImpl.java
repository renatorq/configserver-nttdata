package com.bootcamp.databases.service.impl;

import com.bootcamp.databases.model.Especialidad;
import com.bootcamp.databases.repository.EspecialidadRepository;
import com.bootcamp.databases.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    @Autowired
    private EspecialidadRepository repo;

    @Override
    public void registrar(Especialidad e) throws Exception {
        repo.save(e);
    }

    @Override
    public void modificar(Especialidad e) throws Exception {

        Optional<Especialidad> especialidadLocal = repo.findById(e.getIdEspecialidad());

        if (especialidadLocal.isEmpty()) {
            System.out.println("La especialidad no existe!");
            throw new Exception("La especialidad no existe");
        }

        repo.save(e);
    }

    @Override
    public Especialidad buscar(int id) throws Exception {
        Optional<Especialidad> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Especialidad();
    }

    @Override
    public List<Especialidad> listarTodos() throws Exception {
        return repo.findAll();
    }

    @Override
    public void eliminar(Integer idEspecialidad) throws Exception {
        Optional<Especialidad> especialidadLocal = repo.findById(idEspecialidad);

        if (especialidadLocal.isEmpty()) {
            System.out.println("La especialidad no existe!");
            throw new Exception("Error al eliminar, La especialidad no existe");
        }

        repo.deleteById(idEspecialidad);
    }
}
