package br.com.fiap.service;

import br.com.fiap.model.PacienteModel;
import br.com.fiap.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements UserDetailsService {

    @Autowired
    private PacienteRepository pacienteRepository;


    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {

        try {

            return pacienteRepository.findByCpf(cpf);

        } catch (UsernameNotFoundException e) {
            throw new UsernameNotFoundException(String.format("PACIENTE COM CPF: %s NAO ENCONTRADO.", cpf));
        }

    }

    @Transactional
    public PacienteModel save(PacienteModel pacienteModel)
    {
        return pacienteRepository.save(pacienteModel);
    }

    public List<PacienteModel> findAll() {
        return pacienteRepository.findAll();
    }

    public Optional<PacienteModel> findById(long id) {
        return pacienteRepository.findById(id);
    }

    @Transactional
    public void delete (PacienteModel pacienteModel) {
        pacienteRepository.delete(pacienteModel);
    }

}
