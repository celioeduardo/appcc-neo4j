package appcc.repositories;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import appcc.domain.Etapa;
import appcc.domain.ProdutoFinal;

@Repository
@Transactional
public interface EtapaRepository 
	extends GraphRepository<ProdutoFinal> {
		
		@Transactional(readOnly=true)
		Etapa findByNome(@Param("nome") String title);
	    
	    @Transactional(readOnly=true)
	    @Query("MATCH (m:Etapa) WHERE m.nome =~ ('(?i).*'+{nome}+'.*') RETURN m")
	    Collection<Etapa> findByNomeContaining(@Param("nome") String nome);
	    
	    @Transactional(readOnly=true)
	    @Query("MATCH (e:Etapa) RETURN e")
	    List<Map<String,Object>> todasEtapas();
	    
	    @Transactional(readOnly=true)
	    //@Query("MATCH p=(e:Etapa)-[:PRODUZ]->(s)-[:ENTRA|PROXIMA*]->(x) RETURN p")
	    @Query("MATCH (e:Etapa)-[p:PRODUZ]->(s) RETURN e,s")
	    List<Etapa> todasEtapasTipadas();
	    
	    @Transactional(readOnly=true)
	    @Query("MATCH (m:Movie)<-[:ACTED_IN]-(a:Person) RETURN m.title as movie, collect(a.name) as cast LIMIT {limit}")
	    List<Map<String,Object>> graph(@Param("limit") int limit);
}
