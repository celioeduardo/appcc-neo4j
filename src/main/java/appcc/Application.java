package appcc;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import appcc.domain.Etapa;
import appcc.domain.ProdutoFinal;
import appcc.repositories.EtapaRepository;
import appcc.repositories.ProdutoFinalRepository;

@Configuration
@Import(Neo4jConfig.class)
@RestController("/")
public class Application {
	 	
	public static void main(String[] args) throws IOException {
	        SpringApplication.run(Application.class, args);
	    }

	    @Autowired
	    EtapaRepository etapaRepository;
	    
	    @Autowired
	    ProdutoFinalRepository produtoFinalRepository;

	    @RequestMapping("/etapas")
	    public Collection<Etapa> etapas(
	    		@RequestParam(value = "nome",required = false) String nome) {
	        return etapaRepository.findByNomeContaining(nome);
	    }
	    
	    @RequestMapping("/etapas3")
	    public Collection<Etapa> etapasTipadas(
	    		@RequestParam(value = "nome",required = false) String nome) {
	    	return etapaRepository.todasEtapasTipadas();
	    }
	    @RequestMapping("/etapas2")
	    public List<Map<String,Object>> etapas2(
	    		@RequestParam(value = "nome",required = false) String nome) {
	    	return etapaRepository.todasEtapas();
	    }
	    
	    @RequestMapping("/pf")
	    public ProdutoFinal pf(
	    		@RequestParam(value = "produtoFinalId",required = false) String produtoFinalId) {
	    	return produtoFinalRepository.obterArvoreProduto(produtoFinalId);
	    }

}
