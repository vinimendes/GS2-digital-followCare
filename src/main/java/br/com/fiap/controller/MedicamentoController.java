package br.com.fiap.controller;

import br.com.fiap.dto.MedicamentoDto;
import br.com.fiap.model.MedicamentoModel;
import br.com.fiap.service.MedicamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@Controller
@RequestMapping("/medicamento")
public class MedicamentoController {

    @Autowired
    final MedicamentoService medicamentoService;

    public MedicamentoController (MedicamentoService medicamentoService) {
        this.medicamentoService = medicamentoService;
    }

    // Puxar todos os Medicamentos
    @GetMapping
    public ResponseEntity<List<MedicamentoModel>> getAllMedicamentos() {
        return ResponseEntity.status(HttpStatus.OK).body(medicamentoService.findAll());
    }



    // SALVAR MEDICAMENTO
    @PostMapping
    public ResponseEntity<Object> saveMedicamento (@RequestBody @Valid MedicamentoDto medicamentoDto) {

        var MedicamentoModel = new MedicamentoModel();
        BeanUtils.copyProperties(medicamentoDto, MedicamentoModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(medicamentoService.save(MedicamentoModel));

    }

}
