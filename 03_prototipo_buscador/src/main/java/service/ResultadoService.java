package service;

import java.util.ArrayList;
import java.util.List;

import model.Resultado;

public class ResultadoService {
	
	static List<Resultado> resultados=new ArrayList<>(List.of(
			new Resultado("http://www.fnac.es/","libros","Libros y más"),
			new Resultado("http://www.mybook.com/","libros","librería de temas varios"),
			new Resultado("http://www.game.es/","juegos","Juegos variados"),
			new Resultado("http://www.music.es/","música","Lamejor música"),
			new Resultado("http://www.tech.com/","libros","Libros técnicos"),
			new Resultado("http://www.eljuego.es/","juegos","Juegos on-line")
			)); 
	
	
	public boolean comprobar (String categoria) {
		return resultados.contains(categoria);
	}
	
	public List resultado (String categoria) {
		return resultados.stream()
				.filter(n->n.getCategoria().equals(categoria))
				.toList();
	}
	
	public void alta(Resultado resultado) {
		resultados.add(resultado);
	}
	
	public List<Resultado> baja(String url) {
		for (Resultado r:resultados) {
			if(r.getUrl().equals(url)) {
				resultados.remove(r);
			}
			
		}
		return resultados;
	}

}
