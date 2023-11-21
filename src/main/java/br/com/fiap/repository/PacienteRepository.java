package br.com.fiap.repository;

import br.com.fiap.model.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteModel, Long> {

    //Optional<PacienteModel> findByCpf(String cpf);
    UserDetails findByCpf(String cpf);
}
