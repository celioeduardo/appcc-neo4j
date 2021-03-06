package appcc.domain;

import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@JsonIdentityInfo(generator=JSOGGenerator.class)
@NodeEntity
public class Etapa {
	
	@GraphId Long id;

	private String nome;
	private String etapaId;
	private String fluxoId;
	private String fluxoNome;
	private Integer origens;
	
	@Relationship(type = "PROXIMA", direction = Relationship.OUTGOING)
	Etapa proxima;
	
	@Relationship(type = "PROXIMA", direction = Relationship.INCOMING)
	Etapa anterior;
	
	@Relationship(type = "RECEBE", direction = Relationship.OUTGOING)
	List<Subproduto> subprodutosEntrada;
	
	@Relationship(type = "RECEBE", direction = Relationship.OUTGOING)
	List<Material> materiais;
	
	@Relationship(type = "PRODUZ", direction = Relationship.OUTGOING)
	List<Subproduto> subprodutosSaida;
	
	@Relationship(type = "PRODUZ", direction = Relationship.OUTGOING)
	List<ProdutoFinal> produtosFinais;
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEtapaId() {
		return etapaId;
	}

	public String getFluxoId() {
		return fluxoId;
	}

	public String getFluxoNome() {
		return fluxoNome;
	}

	public Integer getOrigens() {
		return origens;
	}

	public Etapa getProxima() {
		return proxima;
	}

	public List<Subproduto> getSubprodutosEntrada() {
		return subprodutosEntrada;
	}

	public List<Material> getMateriais() {
		return materiais;
	}

	public List<Subproduto> getSubprodutosSaida() {
		return subprodutosSaida;
	}

	public List<ProdutoFinal> getProdutosFinais() {
		return produtosFinais;
	}

	public Etapa getAnterior() {
		return anterior;
	}
		
}
