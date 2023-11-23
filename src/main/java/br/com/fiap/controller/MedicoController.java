package br.com.fiap.controller;

import br.com.fiap.dto.MedicamentoDto;
import br.com.fiap.dto.MedicoDto;
import br.com.fiap.model.MedicamentoModel;
import br.com.fiap.model.MedicoModel;
import br.com.fiap.service.MedicamentoService;
import br.com.fiap.service.MedicoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {

//    @GetMapping
//    public String medico() {
//        return "ACESSO AO MEDICO DISPONIVEL";
//    }

    @Autowired
    final MedicoService medicoService;

    public MedicoController (MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    // Puxar todos os MEDICOS
    @GetMapping
    public ResponseEntity<List<MedicoModel>> getAllMedicos() {
        return ResponseEntity.status(HttpStatus.OK).body(medicoService.findAll());
    }

    // SALVAR MEDICOS
    @PostMapping
    public ResponseEntity<Object> saveMedico (@RequestBody @Valid MedicoDto medicoDto) {

        var MedicoModel = new MedicoModel();
        BeanUtils.copyProperties(medicoDto, MedicoModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(medicoService.save(MedicoModel));

    }

}
