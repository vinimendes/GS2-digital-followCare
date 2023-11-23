package br.com.fiap.service;

import br.com.fiap.model.ConsultaModel;
import br.com.fiap.model.MedicamentoModel;
import br.com.fiap.repository.ConsultaRepository;
import br.com.fiap.repository.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service

public class ConsultaService {

    @Autowired
    final ConsultaRepository consultaRepository;

    public ConsultaService (ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @Transactional
    public ConsultaModel save(ConsultaModel consultaModel)
    {
        return consultaRepository.save(consultaModel);
    }

    public List<ConsultaModel> findAll() {
        return consultaRepository.findAll();
    }

    public Optional<ConsultaModel> findById(long id) {
        return consultaRepository.findById(id);
    }

    @Transactional
    public void delete (ConsultaModel consultaModel) {
        consultaRepository.delete(consultaModel);
    }

}
