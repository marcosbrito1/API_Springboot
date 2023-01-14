package br.com.tech.floresta.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.tech.floresta.model.Parque;
import br.com.tech.floresta.repository.IParque;

@Service
public class ParqueService {
	private IParque repository;
	public ParqueService(IParque repository) {
		this.repository = repository;
	}
	
	
	
	public List<Parque> listarParque(){
		List<Parque> lista = repository.findAll();
		return lista;
	}
	
	public Parque criarParque(Parque parque) {
		Parque parqueNovo = repository.save(parque);
		return parqueNovo;
	}
	
	public Parque editarParque(Parque parque) {
		Parque parqueAtualizado = repository.save(parque);
	
		return parqueAtualizado;
	}
	
	public Boolean excluirParque(Integer id) {
		repository.deleteById(id);
		return true;
	}

}
