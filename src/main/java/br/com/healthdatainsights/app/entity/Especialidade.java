package br.com.healthdatainsights.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tb_especialidade")
@Getter
@Setter
public class Especialidade {

	@Id
	private long id;
	private String nome;
	

}
