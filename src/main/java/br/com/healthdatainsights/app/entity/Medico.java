package br.com.healthdatainsights.app.entity;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name="tb_medico")
public class Medico extends RepresentationModel<Medico> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@NotBlank
	@Column(unique=true)
	private String crm;
	
	@NotBlank
	@Size(min = 3, max = 50, message = "Nome deve ter entre 3 e 50 caracteres")
	@Column(name = "nome", length = 50)
	private String nome;

	
	@NotBlank
	@Column(unique = true)
	@Email
	private String email;
	
	@NotBlank
	@Column(unique=true)
	private String senha;
	
	
	
	@ManyToOne
    @JoinColumn(name = "especialidade_id", nullable = false)
    private Especialidade especialidade;
		
	public Medico() {
		
	}
}
