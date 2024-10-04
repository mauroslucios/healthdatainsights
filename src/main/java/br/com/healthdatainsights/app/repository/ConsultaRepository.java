package br.com.healthdatainsights.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.healthdatainsights.app.entity.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long>{

}
