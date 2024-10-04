package br.com.healthdatainsights.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="tb_receita")
public class Receita {

	@Id
	private long id;
	private Consulta consulta;
	
}
