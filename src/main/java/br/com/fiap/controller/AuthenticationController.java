package br.com.fiap.controller;

import br.com.fiap.dto.AuthDTO;
import br.com.fiap.dto.RegisterDTO;
import br.com.fiap.model.PacienteModel;
import br.com.fiap.repository.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthDTO data) {

//        var login = data.cpf();
//        var password = data.senha();

        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {

        if(this.pacienteRepository.findByCpf(data.cpf()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.senha());
        PacienteModel newPaciente = new PacienteModel(data.nm_paciente(), data.dt_nascimento(),
                                                      data.cpf(), encryptedPassword, data.role());

        this.pacienteRepository.save(newPaciente);

        return ResponseEntity.ok().build();
    }

}
