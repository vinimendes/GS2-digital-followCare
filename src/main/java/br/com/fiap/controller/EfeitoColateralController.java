package br.com.fiap.controller;

import br.com.fiap.dto.ConsultaDto;
import br.com.fiap.dto.EfeitoColateralDto;
import br.com.fiap.dto.PaginacaoDto;
import br.com.fiap.model.ConsultaModel;
import br.com.fiap.model.EfeitoColateralModel;
import br.com.fiap.service.ConsultaService;
import br.com.fiap.service.EfeitoColateralService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/efeitocolateral")
public class EfeitoColateralController {

    @Autowired
    final EfeitoColateralService efeitoColateralService;

    public EfeitoColateralController (EfeitoColateralService efeitoColateralService) {

        this.efeitoColateralService = efeitoColateralService;
    }

    // Puxar todos as CONSULTAS
    @GetMapping
    public ResponseEntity<List<EfeitoColateralModel>> getAllEfeitosColaterais() {
        return ResponseEntity.status(HttpStatus.OK).body(efeitoColateralService.findAll());
    }

    // PAGINACAO

    @PostMapping("/paginacao")
    public ResponseEntity<List<EfeitoColateralModel>> getAllEfeitos(
            @RequestBody @Valid PaginacaoDto paginacao) {

        Pageable pageable = PageRequest.of(paginacao.page(), paginacao.size());
        Page<EfeitoColateralModel> pageResult = efeitoColateralService.findAll(pageable);
        List<EfeitoColateralModel> efeitosColaterais = pageResult.getContent();

        return ResponseEntity.status(HttpStatus.OK).body(efeitosColaterais);
    }


    // SALVAR CONSULTA
    @PostMapping
    public ResponseEntity<Object> saveEfeitoColateral (@RequestBody @Valid EfeitoColateralDto efeitoColateralDto) {

        var EfeitoColateralModel = new EfeitoColateralModel();
        BeanUtils.copyProperties(efeitoColateralDto, EfeitoColateralModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(efeitoColateralService.save(EfeitoColateralModel));

    }

}
