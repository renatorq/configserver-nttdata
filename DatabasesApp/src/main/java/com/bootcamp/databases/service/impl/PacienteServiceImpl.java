package com.bootcamp.databases.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.databases.model.Paciente;
import com.bootcamp.databases.repository.PacienteRepository;
import com.bootcamp.databases.service.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService {

	@Autowired
	private PacienteRepository repo;
	
	@Override
	public void registrar(Paciente p) throws Exception {
		Paciente pacienteLocal = repo.findByDni(p.getDni());
		if (pacienteLocal != null) {
			System.out.println("EL paciente ya existe!; el dni se encuentra registrado");
			throw new Exception("El DNI del paciente se encuentra registrado");
		}

		repo.save(p);
	}

	@Override
	public void modificar(Paciente p) throws Exception {
		Optional<Paciente> pacienteLocal = repo.findById(p.getIdPaciente());

		if(pacienteLocal.isEmpty()){
			System.out.println("EL paciente no existe!");
			throw new Exception("EL paciente no existe");
		}

		repo.save(p);
		
	}

	@Override
	public Paciente buscar(int id) throws Exception {
		Optional<Paciente> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Paciente();
	}

	@Override
	public List<Paciente> listarTodos() throws Exception {
		return repo.findAll();
	}

	@Override
	public void eliminar(Integer idPaciente) throws Exception {

		Optional<Paciente> pacientelocal = repo.findById(idPaciente);

		if(pacientelocal.isEmpty()){
			System.out.println("EL paciente no existe!");
			throw new Exception("Error al eliminar, El paciente no existe");
		}

		repo.deleteById(idPaciente);

	}

}
