package service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import model.Pais;

@Service
public class PaisesServiceImpl implements PaisesService {
	
	String url="https://restcountries.com/v2/all";
	RestClient restClient;
		
	public PaisesServiceImpl(RestClient restClient) {
		super();
		this.restClient = restClient;
	}

	@Override
	public List<String> listadoContinentes() {
		try {
			return Arrays.stream(restClient // con Arrays.Stream convertimos todo en stream
					.get()
					.uri(url)
					.retrieve()
					.body(Pais[].class)// array de objetos Formacion
				)
				.map(p->p.getContinente())
				.distinct()
				.toList();
		}catch(HttpClientErrorException ex) {
			throw new RuntimeException();
		}
	}

	@Override
	public List<Pais> BusarPorContinente(String continente) {
		return Arrays.stream(restClient // con Arrays.Stream convertimos todo en stream
				.get()
				.uri(url)
				.retrieve()
				.body(Pais[].class)// array de objetos Formacion
			)
			.filter(p->p.getContinente().equals(continente))
			.toList();
	}

}
