package br.com.healthdatainsights.app.controller;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.healthdatainsights.app.dto.MedicoDTO;
import br.com.healthdatainsights.app.entity.Medico;
import br.com.healthdatainsights.app.service.MedicoService;
import lombok.AllArgsConstructor;



@RestController
@RequestMapping(value="app/v1")
@CrossOrigin(origins="*")
@AllArgsConstructor
public class MedicoController {
	
	@Autowired
	private MedicoService medicoService;
	
	private final PasswordEncoder encoder;
	
	@GetMapping(value="/medicos", produces="application/json")
	public ResponseEntity<List<MedicoDTO>> findAll(){
		List<MedicoDTO> list = medicoService.findAll();
		ArrayList<MedicoDTO> medicos = new ArrayList<MedicoDTO>();
		for(MedicoDTO medico: list) {
			Long id = medico.getId();
			medico.add(linkTo(methodOn(MedicoController.class).findById(id)).withRel("Lista médico pelo id"));
			medicos.add(medico);
		}
		return ResponseEntity.ok().body(medicos);
	}	

	@PostMapping("/medicos")
	@ResponseStatus(HttpStatus.CREATED)
	public MedicoDTO insertMedico(@RequestBody Medico medico) {
		// Aqui criptografa a senha antes de salvar.
	    medico.setSenha(encoder.encode(medico.getSenha())); 
	    Medico novoMedico = medicoService.insertMedico(medico);
	    return new MedicoDTO(novoMedico);
	}
	
	@GetMapping(value="/medicos/{id}", produces="application/json")
	public ResponseEntity<MedicoDTO> findById(@PathVariable Long id){
		MedicoDTO medico = medicoService.findById(id);
		medico.add(linkTo(methodOn(MedicoController.class).findAll()).withRel("Listar todos médicos"));
		return ResponseEntity.ok().body(medico);
	}
}
