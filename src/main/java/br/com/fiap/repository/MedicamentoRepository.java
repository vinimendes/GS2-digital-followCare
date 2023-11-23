package br.com.fiap.repository;

import br.com.fiap.model.MedicamentoModel;
import br.com.fiap.model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRepository extends JpaRepository<MedicamentoModel, Long> {

}
