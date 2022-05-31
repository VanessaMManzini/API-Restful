package br.serratec.java2backend.borracharia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.serratec.java2backend.borracharia.DTO.RelatorioDTO;
import br.serratec.java2backend.borracharia.model.TabelaDeServico;

@Repository
public interface TabelaDeServicoRepository extends JpaRepository<TabelaDeServico, Integer>{
	
	@Query(value="select\r\n"
			+ "c.CLIENTE_TX_NOME_CLIENTE as nome,\r\n"
			+ "ca.CARRO_MODELO_CARRO as modelo,\r\n"
			+ "se.TABELA_DE_SERVICO_TX_SERVICO_PRESTADO_TABELA as servico,\r\n"
			+ "se.TABELA_DE_SERVICO_NUM_VALOR_SERVICO_TABELA  as valor\r\n"
			+ "from TABELA_DE_SERVICO  se\r\n"
			+ "join CARRO ca on(se.CARRO_ID= ca.CARRO_ID_CARRO)\r\n"
			+ "join CLIENTE c on(ca.CLIENTE_ID= c.CLIENTE_CD_ID_CLIENTE)\r\n"
			+ "order by se.TABELA_DE_SERVICO_CD_ID_TABELA  desc \r\n"
			+ "limit 5", nativeQuery = true)
    List<RelatorioDTO> buscarUltimosServicos();

}
