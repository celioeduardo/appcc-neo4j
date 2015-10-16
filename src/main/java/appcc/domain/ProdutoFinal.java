package appcc.domain;

import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@JsonIdentityInfo(generator=JSOGGenerator.class)
@NodeEntity
public class ProdutoFinal {
	@GraphId Long id;

	private String nome;
	
	private String produtoFinalId;

	public String getProdutoFinalId() {
		return produtoFinalId;
	}

	@Relationship(type = "SAI",  direction = Relationship.OUTGOING)
	List<Etapa> saiDe;
	
	@Relationship(type = "PRODUZ",  direction = Relationship.INCOMING)
	List<Etapa> produzidoPor;

	public List<Etapa> getProduzidoPor() {
		return produzidoPor;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Etapa> getSaiDe() {
		return saiDe;
	}

}
