package br.com.fiap.service;

import br.com.fiap.model.MedicamentoModel;
import br.com.fiap.model.MedicoModel;
import br.com.fiap.repository.MedicamentoRepository;
import br.com.fiap.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }


    @Transactional
    public MedicoModel save(MedicoModel medicoModelo)
    {
        return medicoRepository.save(medicoModelo);
    }

    public List<MedicoModel> findAll() {
        return medicoRepository.findAll();
    }

    public Optional<MedicoModel> findById(long id) {
        return medicoRepository.findById(id);
    }

    @Transactional
    public void delete (MedicoModel medicoModel) {
        medicoRepository.delete(medicoModel);
    }



}
