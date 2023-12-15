package com.bootcamp.databases.service;

import java.util.List;

import com.bootcamp.databases.model.Medico;

public interface MedicoService {
	
	public void registrar(Medico m) throws Exception;
	
	public void modificar(Medico m) throws Exception;
	
	public Medico buscar(int id) throws Exception;
	
	public List<Medico> listarTodos() throws Exception;

	void eliminar(Integer idMedico) throws Exception;

}
