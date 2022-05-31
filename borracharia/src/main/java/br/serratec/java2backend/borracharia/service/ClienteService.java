package br.serratec.java2backend.borracharia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.serratec.java2backend.borracharia.DTO.ClienteDTO;
import br.serratec.java2backend.borracharia.exception.ClienteException;
import br.serratec.java2backend.borracharia.model.Cliente;
import br.serratec.java2backend.borracharia.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public void salvar (ClienteDTO clienteDTO) throws ClienteException {
		
		Cliente cliente = new Cliente();
		Cliente ClienteSalvar = new Cliente();
		ClienteSalvar = transformarClienteDTOEmClienteModel (clienteDTO, cliente);
		
		clienteRepository.save(ClienteSalvar);
		
	}
	
	
	public ClienteDTO transformarClienteModelEmClienteDTO(ClienteDTO clienteDTO, Cliente cliente) {
		clienteDTO.setIdCliente(cliente.getIdCliente());
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setNumero_Telefone(cliente.getNumero_Telefone());
		clienteDTO.setEmail(cliente.getEmail());
		
		
		return clienteDTO;
	}
	
	public Cliente transformarClienteDTOEmClienteModel(ClienteDTO clienteDTO, Cliente cliente) {
		cliente.setNome(clienteDTO.getNome());
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setNumero_Telefone(clienteDTO.getNumero_Telefone());
		cliente.setEmail(clienteDTO.getEmail());
		
		return cliente;
		
	}
	
	public ClienteDTO buscarPorId(Integer idCliente) throws ClienteException{
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		Cliente clienteNovo = new Cliente();
		ClienteDTO clienteDTO = new ClienteDTO();
		
		if(cliente.isPresent()) {
			clienteNovo = cliente.get();
			clienteDTO = transformarClienteModelEmClienteDTO(clienteDTO, clienteNovo);
		
		
		return clienteDTO;
	}
		throw new ClienteException("Cliente não encontrado");
		
	}
	

	//atualizar
	public void atualizar(Integer idCliente, ClienteDTO clienteDTO) {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		Cliente clienteNovo = new Cliente();
		
		if(cliente.isPresent()) {
			clienteNovo = cliente.get();
			if(clienteDTO.getNome() !=null) {
				clienteNovo.setNome(clienteNovo.getNome());
			}
		if(clienteDTO.getCpf() !=null) {
			clienteNovo.setCpf(clienteNovo.getCpf());
		}
		
		if(clienteDTO.getNumero_Telefone() !=null) {
			clienteNovo.setNumero_Telefone(clienteNovo.getNumero_Telefone());
		}
		if(clienteDTO.getEmail() !=null) {
			clienteNovo.setEmail(clienteNovo.getEmail());
		}
		clienteRepository.save(clienteNovo);
			
	}
				
}
	
	//delete
	
	public void delete (Integer idCliente) {
		clienteRepository.deleteById(idCliente);
	}
	
	//listar 
	
	public List<Cliente> listarTodos(){
		return clienteRepository.findAll();
	}

	
	

}
