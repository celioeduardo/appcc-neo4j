package appcc.domain;

import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@JsonIdentityInfo(generator=JSOGGenerator.class)
@NodeEntity
public class Subproduto {
	@GraphId Long id;

	private String nome;
	
	private String subprodutoId;

	public String getSubprodutoId() {
		return subprodutoId;
	}

	@Relationship(type = "ENTRA")
	List<Etapa> entraEm;
	
	@Relationship(type = "SAI")
	List<Etapa> saiDe;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public List<Etapa> getEntraEm() {
		return entraEm;
	}

	public List<Etapa> getSaiDe() {
		return saiDe;
	}

}
