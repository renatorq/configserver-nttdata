package com.bootcamp.databases.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.databases.model.Medico;
import com.bootcamp.databases.repository.MedicoRepository;
import com.bootcamp.databases.service.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoRepository repo;

    @Override
    public void registrar(Medico m) throws Exception {

        Medico medicoLocal = repo.findByDni(m.getDni());
        if (medicoLocal != null) {
            System.out.println("EL medico ya existe!; el dni se encuentra registrado");
            throw new Exception("El DNI del medico se encuentra registrado");
        }
        medicoLocal = repo.findByCmp(m.getCmp());
        if (medicoLocal != null) {
            System.out.println("EL medico ya existe!; el cmp se encuentra registrado ");
            throw new Exception("El cmp del medico se encuentra registrado");
        }
        repo.save(m);
    }

    @Override
    public void modificar(Medico m) throws Exception {

        Optional<Medico> medicoLocal = repo.findById(m.getIdMedico());

        if(medicoLocal.isEmpty()){
            System.out.println("EL medico no existe!");
            throw new Exception("EL medico no existe");
        }

        repo.save(m);

    }

    @Override
    public Medico buscar(int id) throws Exception {
        Optional<Medico> op = repo.findById(id);
        return op.isPresent() ? op.get() : new Medico();
    }

    @Override
    public List<Medico> listarTodos() throws Exception {
        return repo.findAll();
    }

    @Override
    public void eliminar(Integer idMedico) throws Exception {

        Optional<Medico> medicolocal = repo.findById(idMedico);

        if(medicolocal.isEmpty()){
            System.out.println("EL medico no existe!");
            throw new Exception("Error al eliminar, El medico no existe");
        }

        repo.deleteById(idMedico);

    }

}
