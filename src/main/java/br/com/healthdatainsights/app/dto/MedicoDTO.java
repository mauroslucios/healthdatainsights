package br.com.healthdatainsights.app.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.RepresentationModel;

import br.com.healthdatainsights.app.entity.Especialidade;
import br.com.healthdatainsights.app.entity.Medico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MedicoDTO extends RepresentationModel<MedicoDTO>  {
	
	private Long id;
	private String nome;
	private String email;
	private String crm;
	private Especialidade especialidade;
	
	public MedicoDTO(Medico medico) {
		this.id = medico.getId();
		this.nome = medico.getNome();
		this.email = medico.getEmail();
		this.crm = medico.getCrm();
		this.especialidade = medico.getEspecialidade();
		
	}
	
	
	
	public static List<MedicoDTO> converter(List<Medico> list) {
		return list.stream().map(MedicoDTO::new).collect(Collectors.toList());
	}


}

