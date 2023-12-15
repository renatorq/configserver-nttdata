package com.bootcamp.databases.service;

import java.util.List;

import com.bootcamp.databases.model.Medico;
import com.bootcamp.databases.model.Paciente;

public interface PacienteService {
	
	public void registrar(Paciente p) throws Exception;
	
	public void modificar(Paciente p) throws Exception;
	
	public Paciente buscar(int id) throws Exception;
	
	public List<Paciente> listarTodos() throws Exception;

	void eliminar(Integer idPaciente) throws Exception;
}
