package com.bootcamp.databases.service.impl;

import com.bootcamp.databases.model.Examen;
import com.bootcamp.databases.repository.ExamenRepository;
import com.bootcamp.databases.service.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamenServiceImpl implements ExamenService {

    @Autowired
    private ExamenRepository repo;

    @Override
    public void registrar(Examen examen) throws Exception {

        Examen examenlocal = repo.findByNombre(examen.getNombre());
        if (examenlocal != null) {
            System.out.println("EL examen ya existe!");
            throw new Exception("El examen se encuentra registrado");
        }
        repo.save(examen);
    }

    @Override
    public void modificar(Examen examen) throws Exception {
        Optional<Examen> examenLocal = repo.findById(examen.getIdExamen());

        if (examenLocal.isEmpty()) {
            System.out.println("EL examen no existe!");
            throw new Exception("EL examen no existe");
        }

        repo.save(examen);
    }

    @Override
    public Examen buscar(Integer id) throws Exception {
        Optional<Examen> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Examen();
    }

    @Override
    public List<Examen> listarTodos() throws Exception {
        return repo.findAll();
    }

    @Override
    public void eliminar(Integer id) throws Exception {
        Optional<Examen> examenLocal = repo.findById(id);

        if (examenLocal.isEmpty()) {
            System.out.println("EL examen no existe!");
            throw new Exception("Error al eliminar, El examen no existe");
        }

        repo.deleteById(id);
    }
}
