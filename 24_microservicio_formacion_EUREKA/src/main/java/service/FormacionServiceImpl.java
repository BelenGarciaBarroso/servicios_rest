package service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import model.Formacion;

@Service
public class FormacionServiceImpl implements FormacionService {
	
	String url="http://servicio-cursos/cursos/";
	RestClient restClient;
	public FormacionServiceImpl(RestClient restClient) { // inyección al 
		super();
		this.restClient = restClient;
	}

	@Override
	public List<Formacion> buscarPorArea(String area) {
		return Arrays.stream(restClient // con Arrays.Stream convertimos todo en stream
				.get()
				.uri(url+"recuperartodos")
				.retrieve()
				.body(Formacion[].class)// array de objetos Formacion
			)
			.filter(f->f.getArea().equals(area))
			.toList();
		
		
	}

	@Override
	public void altaFormacion(Formacion formacion) {
		restClient
		.post()
		.uri(url+"alta") 
		.contentType(MediaType.APPLICATION_JSON) // tipo del cuerpo
		.body(formacion)
		.retrieve()//esto hace la llamada
		.toBodilessEntity(); // para que muestre el error si lo hay

	}

}
