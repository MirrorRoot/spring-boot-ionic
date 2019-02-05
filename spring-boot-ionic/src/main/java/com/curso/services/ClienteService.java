 package com.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.curso.domain.Cidade;
import com.curso.domain.Cliente;
import com.curso.domain.Endereco;
import com.curso.domain.enums.TipoCliente;
import com.curso.dto.ClienteDTO;
import com.curso.dto.ClienteNewDTO;
import com.curso.repositories.ClienteRepository;
import com.curso.repositories.EnderecoRepository;
import com.curso.services.exception.DataIntegrityException;
import com.curso.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
  @Autowired	 
  private ClienteRepository cliRep;

	
 @Autowired
 private EnderecoRepository enderecoRepository;
  
  public ClienteService(ClienteRepository repo, EnderecoRepository endRep) {
	this.cliRep=repo;
	this.enderecoRepository=endRep;
}
	
 public Cliente find(Long id) {
	 
	 Optional<Cliente> obj = cliRep.findById(id);
	 return obj.orElseThrow(() -> new ObjectNotFoundException(
	 "Objeto não encontrado! Id: " + id + ", recurso: "  + Cliente.class.getSimpleName()));
 } 

	@Transactional
	public Cliente insert(Cliente obj) {
		obj.setId(null);
		obj = cliRep.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
}
	public Cliente update(Cliente obj) {
		Cliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return cliRep.save(newObj);
	}

	public void delete(Long id) {
		find(id);
		try {
			cliRep.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}
	
	public List<Cliente> findAll() {
		return cliRep.findAll();
	}
	
	
	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return cliRep.findAll(pageRequest);
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null, null);
	}
	
	public Cliente fromDTO(ClienteNewDTO objDto) {
		Cliente cli = new Cliente(null, objDto.getNome(),objDto.getCpfOuCnpj() ,objDto.getEmail(),TipoCliente.toTipoCliente(objDto.getTipo()));
		Cidade cid = new Cidade(objDto.getCidadeId(), null, null);
		Endereco end = new Endereco(null,objDto.getLogradouro(),objDto.getNumero(),objDto.getComplemento(),objDto.getBairro(),objDto.getCep(),cid,cli);
		cli.getEnderecos().add(end);
		cli.getTelefones().add(objDto.getTelefone1());
		if (objDto.getTelefone2()!=null) {
			cli.getTelefones().add(objDto.getTelefone2());
		}
		if (objDto.getTelefone3()!=null) {
			cli.getTelefones().add(objDto.getTelefone3());
		}
		return cli;
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

 
 

 
 
	
}
