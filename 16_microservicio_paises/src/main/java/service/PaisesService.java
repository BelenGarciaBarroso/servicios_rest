package service;

import java.util.List;

import model.Pais;

public interface PaisesService {

	List<String> listadoContinentes();
	
	List<Pais> BusarPorContinente (String continente); 
}
