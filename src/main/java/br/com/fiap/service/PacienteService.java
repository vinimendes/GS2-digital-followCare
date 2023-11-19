package br.com.fiap.service;

import br.com.fiap.model.PacienteModel;
import br.com.fiap.repository.PacienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    final PacienteRepository pacienteRepository;

    public PacienteService (PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
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
