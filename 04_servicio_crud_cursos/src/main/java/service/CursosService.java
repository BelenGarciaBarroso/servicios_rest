package service;

import java.util.ArrayList;
import java.util.List;

import model.Curso;

public class CursosService {
	
	
	
	private static List<Curso> cursos=new ArrayList<>(List.of(new Curso("Java 21","Programación",100,200),
			new Curso("Inglés","Idiomas",200,340),
			new Curso("Francés","Idiomas",150,320),
			new Curso("Python","Programación",60,110)
			)); 
	
	public boolean alta (Curso curso) {
		if(buscarCurso(curso.getNombre())==null) {
			cursos.add(curso);
			return true;
		}
		return false;
	}
	
	public boolean baja (String nombre) {
		if(buscarCurso(nombre)!=null) {
			cursos.removeIf(c->c.getNombre().equals(nombre));
			return true;
		}
		return false;
	}
	
	public boolean modificarDatos (Curso curso) {
		for (Curso c:cursos) {
			if (c.getNombre().equals(curso.getNombre())) {
				c.setArea(curso.getArea());
				c.setDuracion(curso.getDuracion());
				c.setPrecio(curso.getPrecio());
				return true;
			}
		}
		return false;
	}
	
	public Curso buscarCurso(String nombre) {
		return 
				cursos.stream().
				filter(c->c.getNombre().equals(nombre))
				.findFirst()
				.orElse(null);
	}

	public List<Curso> devuelveCursos() {		
		return cursos;
	}  
}
