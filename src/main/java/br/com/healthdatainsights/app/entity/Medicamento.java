package br.com.healthdatainsights.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="tb_medicamento")
public class Medicamento {

	@Id
	private long id;
	private String nome;
}
