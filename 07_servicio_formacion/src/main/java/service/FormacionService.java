package service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import model.Respuesta;

public class FormacionService {
	
	String url="http://localhost:8080/04_servicio_crud_cursos/cursos";
	
	WebTarget wt=ClientBuilder
			.newClient()
			.target(url);
	
	public List<Respuesta> buscarCursoPorArea (String area) {
		
		
		//Generamos un array llamado datos con los datos del metodo del ejercicio 4 del controller llamado recuperartodos
		Respuesta [] datos= wt
				.path("/recuperartodos")
				.request(MediaType.APPLICATION_JSON)
				.get(Respuesta[].class);
		
		return
			Arrays.stream(datos)
			.filter(r->r.getArea().equals(area))
			.toList();		
	}
	
	
	public void altaFormacion(Respuesta formacion) {
		wt
		.path("/alta")
		.request(MediaType.TEXT_PLAIN)
		.post(Entity.entity(formacion, MediaType.APPLICATION_JSON));
	}

}
