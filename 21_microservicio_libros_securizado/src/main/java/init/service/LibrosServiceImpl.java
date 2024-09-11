package init.service;

import java.util.List;

import org.springframework.stereotype.Service;

import init.dao.LibrosDao;
import init.model.LibroDto;
import init.utilidades.Mapeador;

@Service
public class LibrosServiceImpl implements LibrosService {
	// Inyectamos lo siguiente:
	LibrosDao librosDao;
	Mapeador mapeador;
	// Se genera el constructor
	public LibrosServiceImpl(LibrosDao librosDao, Mapeador mapeador) {
		this.librosDao = librosDao;
		this.mapeador = mapeador;
	}

	@Override
	public boolean alta(LibroDto libro) {
		if(librosDao.findById(libro.getIsbn()).isEmpty()) {
			librosDao.save(mapeador.libroDtoToEntity(libro));
			return true;
		}
		return false;
	}

	@Override
	public List<LibroDto> buscarLibroPorTema(String tema) {
		return librosDao.findByTema(tema)
				.stream()
				.map(l->mapeador.libroEntityToDto(l))
				.toList();
	}

	@Override
	public LibroDto buscarLibroPorIsbn(int isbn) {
		return librosDao.findById(isbn) // Optional<Libro> , esta clase tiene el método map tmb, no hace falta convertir a stream.
				.map(l->mapeador.libroEntityToDto(l)) //Optional<LibroDto>
				.orElse(null);
	}

}
