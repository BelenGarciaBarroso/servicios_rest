package service;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import model.Formacion;

@Service
public class FormacionServiceImpl implements FormacionService {
	
	@Value("${usuario}")
	String user;
	@Value("${pass}")
	String pass;
	@Value("${url.cursos}")
	String url;
	RestClient restClient;
	public FormacionServiceImpl(RestClient restClient) { // inyección al 
		super();
		this.restClient = restClient;
	}

	@Override
	public List<Formacion> buscarPorArea(String area) {
		System.out.println("usuario "+user);
		System.out.println("Contraseña "+pass);
		return Arrays.stream(restClient // con Arrays.Stream convertimos todo en stream
				.get()
				.uri(url+"recuperartodos")
				.header("Authorization", "Basic "+getBase64(user, pass)) //para pasar el usuario y pass
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
	
	private String getBase64(String us, String pwd) {
		String cad=us+":"+pwd;
		return Base64.getEncoder().encodeToString(cad.getBytes());
	} 

}
