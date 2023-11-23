package br.com.fiap.repository;

import br.com.fiap.model.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<ConsultaModel, Long> {
}
