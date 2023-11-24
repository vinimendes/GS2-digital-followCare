package br.com.fiap.service;

import br.com.fiap.model.ConsultaModel;
import br.com.fiap.model.EfeitoColateralModel;
import br.com.fiap.repository.ConsultaRepository;
import br.com.fiap.repository.EfeitoColateralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EfeitoColateralService {

    @Autowired
    final EfeitoColateralRepository efeitoColateralRepository;

    public EfeitoColateralService (EfeitoColateralRepository efeitoColateralRepository) {
        this.efeitoColateralRepository = efeitoColateralRepository;
    }

    @Transactional
    public EfeitoColateralModel save(EfeitoColateralModel efeitoColateralModel)
    {
        return efeitoColateralRepository.save(efeitoColateralModel);
    }

    public List<EfeitoColateralModel> findAll() {
        return efeitoColateralRepository.findAll();
    }

    public Page<EfeitoColateralModel> findAll(Pageable pageable) {
        return efeitoColateralRepository.findAll(pageable);
    }

    public Optional<EfeitoColateralModel> findById(long id) {
        return efeitoColateralRepository.findById(id);
    }

    @Transactional
    public void delete (EfeitoColateralModel efeitoColateralModel) {
        efeitoColateralRepository.delete(efeitoColateralModel);
    }

}
