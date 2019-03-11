package br.com.thiagomelo.business;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.thiagomelo.dao.Repositorio;
import br.com.thiagomelo.model.Veiculo;

@ApplicationScoped
public class VeiculoBC {
	
	@Inject
	private Repositorio repositorio;

	public VeiculoBC() {
		super();
	}
	
	@PostConstruct
	public void inicializar() {
		
		Calendar data = Calendar.getInstance();
		
		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca("POV-7401");
		veiculo.setNomeProprietario("Aristides");
		data.set(2019, 1, 1);
		veiculo.setDataEmplacamento(data.getTime());
		veiculo.setValorIpva(BigDecimal.ONE);		
		repositorio.inserir(veiculo);
		
		Veiculo veiculo2 = new Veiculo();
		veiculo2.setPlaca("AAA-9999");
		veiculo2.setNomeProprietario("João");
		data.set(2018, 1, 1);
		veiculo2.setDataEmplacamento(data.getTime());
		veiculo2.setValorIpva(BigDecimal.ONE);		
		repositorio.inserir(veiculo2);
		
	}
	
	public List<Veiculo> selecionar() {
		return repositorio.selecionar(Veiculo.class);
	}

	public Veiculo selecionar(Long id) {
		Veiculo veiculo = repositorio.selecionar(Veiculo.class, id);
		
		return veiculo;
	}

	public Long inserir(Veiculo veiculo){
		
		return repositorio.inserir(veiculo);
	}

	public void atualizar(Veiculo veiculo){
		
		repositorio.atualizar(veiculo);
	}
	
	public Veiculo excluir(Long id) {
		Veiculo veiculo = repositorio.excluir(Veiculo.class, id);
		
		return veiculo;
	}
	
}
