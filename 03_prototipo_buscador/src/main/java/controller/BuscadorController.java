package controller;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.Resultado;
import service.ResultadoService;

@Path("/resultado")
public class BuscadorController {
	
	ResultadoService resultadoService=new ResultadoService();
	
	@GET
	@Path("/listado/{tematica}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Resultado> buscar(@PathParam("tematica") String tematica) {
		return resultadoService.resultado(tematica);
	}
	
	//Alta de nuevos resultados
	@POST
	@Path("/alta")
	@Consumes(MediaType.APPLICATION_JSON)
	public void alta(Resultado resultado) {
		resultadoService.alta(resultado);
	}
	
	@DELETE
	@Path("/baja")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Resultado> baja(@FormParam("url") String url) {
		return resultadoService.baja(url);
	}
}
