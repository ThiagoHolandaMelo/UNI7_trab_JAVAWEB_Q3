package br.com.thiagomelo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

public class Veiculo extends BaseModel implements Serializable {

	private static final long serialVersionUID = -7179589001387593460L;

	@NotNull
	private String placa;
	
	@NotNull
	private String nomeProprietario;
	
	@Past
	private Date dataEmplacamento;
	
	@NotNull
	private BigDecimal valorIpva;

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getNomeProprietario() {
		return nomeProprietario;
	}

	public void setNomeProprietario(String nomeProprietario) {
		this.nomeProprietario = nomeProprietario;
	}

	public Date getDataEmplacamento() {
		return dataEmplacamento;
	}

	public void setDataEmplacamento(Date dataEmplacamento) {
		this.dataEmplacamento = dataEmplacamento;
	}

	public BigDecimal getValorIpva() {
		return valorIpva;
	}

	public void setValorIpva(BigDecimal valorIpva) {
		this.valorIpva = valorIpva;
	}
}
