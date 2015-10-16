package appcc.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import appcc.domain.ProdutoFinal;

@Repository
@Transactional
public interface ProdutoFinalRepository 
	extends GraphRepository<ProdutoFinal> {

	    @Transactional(readOnly=true)
	    @Query("match p=(pf {produtoFinalId:{produtoFinalId}})<-[r:PRODUZ|PROXIMA|ENTRA*]-(e) RETURN p")
	    ProdutoFinal obterArvoreProduto(@Param("produtoFinalId") String produtoFinalId);
	  
}
