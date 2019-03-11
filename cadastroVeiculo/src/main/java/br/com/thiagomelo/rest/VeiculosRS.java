package br.com.thiagomelo.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.thiagomelo.business.VeiculoBC;
import br.com.thiagomelo.model.Veiculo;
import br.com.thiagomelo.rest.security.JWTRequired;

@JWTRequired
@Path("veiculos")
@RequestScoped
public class VeiculosRS {
	
	@Inject
	private VeiculoBC veiculoBC;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Veiculo> selecionar() {
		return veiculoBC.selecionar();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Veiculo selecionar(@PathParam("id") Long id) {
		return veiculoBC.selecionar(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response inserir(Veiculo body) {
		Long id = veiculoBC.inserir(body);
		String url = "/api/usuarios/" + id;
		return Response
				.status(Status.CREATED)
				.header("Location", url)
				.entity(id)
				.build();
	}
	
	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") Long id, Veiculo veiculo)  {
		veiculo.setId(id);
		veiculoBC.atualizar(veiculo);
		return Response.ok(id).build();
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response excluir(@PathParam("id") Long id){
		Veiculo usuario = veiculoBC.excluir(id);
		return Response.ok(usuario).build();
	}

}
