package br.com.healthdatainsights.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tb_paciente")
public class Paciente {

	@Id
	private long id;
	
	private String nome;
	private String telefone;
	private String email;

}
