package br.com.fiap.controller;

import br.com.fiap.dto.ConsultaDto;
import br.com.fiap.dto.MedicamentoDto;
import br.com.fiap.model.ConsultaModel;
import br.com.fiap.model.MedicamentoModel;
import br.com.fiap.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    final ConsultaService consultaService;

    public ConsultaController (ConsultaService consultaService) {

        this.consultaService = consultaService;
    }

    // Puxar todos as CONSULTAS
    @GetMapping
    public ResponseEntity<List<ConsultaModel>> getAllMedicamentos() {
        return ResponseEntity.status(HttpStatus.OK).body(consultaService.findAll());
    }

    // SALVAR CONSULTA
    @PostMapping
    public ResponseEntity<Object> saveConsulta (@RequestBody @Valid ConsultaDto consultaDto) {

        var ConsultaModel = new ConsultaModel();
        BeanUtils.copyProperties(consultaDto, ConsultaModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.save(ConsultaModel));

    }

}
