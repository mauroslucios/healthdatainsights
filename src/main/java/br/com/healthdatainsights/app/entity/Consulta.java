package br.com.healthdatainsights.app.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="tb_consulta")
public class Consulta {

	@Id
	private long id;
	private Date data;
	private Medico medico;
	private Paciente paciente;
	private Receita receituario;
}
