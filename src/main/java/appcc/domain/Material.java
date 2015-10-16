package appcc.domain;

import java.util.List;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@JsonIdentityInfo(generator=JSOGGenerator.class)
@NodeEntity
public class Material {
	
	@GraphId Long id;

	private String nome;
	private String materialId;
	private String tipo;

	@Relationship(type = "ENTRA")
	List<Etapa> entra;

	public Long getId() {
		return id;
	}

	public String getProdutoFinalId() {
		return materialId;
	}

	public String getMaterialId() {
		return materialId;
	}

	public String getTipo() {
		return tipo;
	}

	public List<Etapa> getEntra() {
		return entra;
	}

	public String getNome() {
		return nome;
	}

	

}
