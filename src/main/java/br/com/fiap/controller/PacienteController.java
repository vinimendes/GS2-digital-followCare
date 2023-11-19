package br.com.fiap.controller;

import br.com.fiap.dto.PacienteDto;
import br.com.fiap.model.PacienteModel;
import br.com.fiap.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    final PacienteService pacienteService;

    public PacienteController (PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    // Puxar todos os Pacientes
    @GetMapping
    public ResponseEntity<List<PacienteModel>> getAllPacientes() {
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.findAll());
    }

    // Buscar de Paciente por (ID)
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePaciente(@PathVariable(value = "id") long id){
        Optional<PacienteModel> pacienteModelOptional = pacienteService.findById(id);

        // Validacao para verificar se o Paciente foi encontrado
        if (!pacienteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("PACIENTE COM ID %d NAO FOI ENCONTRADO", id));
        }

        return ResponseEntity.status(HttpStatus.OK).body(pacienteModelOptional.get());
    }

    // SALVAR PACIENTE
    @PostMapping
    public ResponseEntity<Object> savePaciente (@RequestBody @Valid PacienteDto pacienteDto) {

        var PacienteModel = new PacienteModel();
        BeanUtils.copyProperties(pacienteDto, PacienteModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.save(PacienteModel));

    }

    // ATUALIZAR PACIENTE

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePaciente(@PathVariable(value = "id") long id,
                                                 @RequestBody @Valid PacienteDto pacienteDto){

        Optional<PacienteModel> usuarioModelOptional = pacienteService.findById(id);

        if(!usuarioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("PACIENTE COM ID %d NAO FOI ENCONTRADO", id));
        }
        var pacienteModel = new PacienteModel();
        BeanUtils.copyProperties(pacienteDto, pacienteModel);
        pacienteModel.setCd_paciente(usuarioModelOptional.get().getCd_paciente());

        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.save(pacienteModel));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePaciente(@PathVariable(value="id") long id) {

        Optional<PacienteModel> usuarioModelOptional = pacienteService.findById(id);

        if(!usuarioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(String.format("PACIENTE COM ID %d NAO FOI ENCONTRADO", id));
        }
        pacienteService.delete(usuarioModelOptional.get());

        return ResponseEntity.status(HttpStatus.OK).body(String.format("PACIENTE COM ID %d DELETADO", id));
    }

}
