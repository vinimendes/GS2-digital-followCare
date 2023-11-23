package br.com.fiap.service;

import br.com.fiap.model.MedicamentoModel;
import br.com.fiap.model.PacienteModel;
import br.com.fiap.repository.MedicamentoRepository;
import br.com.fiap.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService {

    @Autowired
    final MedicamentoRepository medicamentoRepository;

    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    @Transactional
    public MedicamentoModel save(MedicamentoModel medicamentoModel)
    {
        return medicamentoRepository.save(medicamentoModel);
    }

    public List<MedicamentoModel> findAll() {
        return medicamentoRepository.findAll();
    }

    public Optional<MedicamentoModel> findById(long id) {
        return medicamentoRepository.findById(id);
    }

    @Transactional
    public void delete (MedicamentoModel medicamentoModel) {
        medicamentoRepository.delete(medicamentoModel);
    }

}
