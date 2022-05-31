package br.serratec.java2backend.borracharia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.serratec.java2backend.borracharia.DTO.CarroDTO;
import br.serratec.java2backend.borracharia.exception.CarroException;
import br.serratec.java2backend.borracharia.model.Carro;
import br.serratec.java2backend.borracharia.repository.CarroRepository;
import br.serratec.java2backend.borracharia.repository.ClienteRepository;

@Service
public class CarroService {
	
	@Autowired
	CarroRepository carroRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public void salvar (CarroDTO carroDTO) throws CarroException {
		Carro carro = new Carro();
		Carro carroSalvar = new Carro();
		carroSalvar = transformarDTOEmModel(carroDTO, carro); 
		
		carroRepository.save(carroSalvar);
	}
		public CarroDTO transformarModelEmDTO(CarroDTO carroDTO, Carro carro){
			
		carroDTO.setIdCarro(carro.getIdCarro());
		carroDTO.setMarca(carro.getMarca());
		carroDTO.setAnoFabricacao(carro.getAnoFabricacao());
		carroDTO.setModelo(carro.getModelo());
		carroDTO.setIdCliente(carro.getCliente().getIdCliente());
		
		return carroDTO;
		}
		
		public Carro transformarDTOEmModel(CarroDTO carroDTO, Carro carro) {
			//não seta id pq é automatico
		
		carro.setMarca(carroDTO.getMarca());
		carro.setAnoFabricacao(carroDTO.getAnoFabricacao());
		carro.setModelo(carroDTO.getModelo());
		
		return carro;
		}
		
		//buscar por id
		public CarroDTO buscarPorId(Integer idCarro) throws Exception {
			Optional<Carro> carro = carroRepository.findById(idCarro);
			Carro carroNovo = new Carro();
			CarroDTO carroDTO = new CarroDTO();
			
			if(carro.isPresent()) {
				carroNovo = carro.get();
				carroDTO = transformarModelEmDTO(carroDTO, carroNovo);
				
				return carroDTO;
						
			}
			throw new CarroException ("Carro não encontrado");
		}
		//atualizar
		public void atualizar (Integer idCarro, CarroDTO carroDTO) {
			Optional<Carro> carro = carroRepository.findById(idCarro);
			Carro carroNovo = new Carro();
		
			if(carro.isPresent()) {
				carroNovo = carro.get();
				if(carroDTO.getAnoFabricacao() !=null) {
					carroNovo.setAnoFabricacao(carroNovo.getAnoFabricacao());
				}
				if(carroDTO.getMarca() !=null) {
					carroNovo.setMarca(carroNovo.getMarca());
				}
				if(carroDTO.getModelo() !=null) {
					carroNovo.setModelo(carroNovo.getModelo());
				}
				carroRepository.save(carroNovo);
			
				}
		}
			//delete
			public void delete (Integer idCarro) {
				carroRepository.deleteById(idCarro);
			}
			//listar
			public List<Carro> listarTodos(){
				return carroRepository.findAll();
					
		}
}
