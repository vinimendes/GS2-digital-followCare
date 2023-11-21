package br.com.fiap.dto;

import br.com.fiap.model.UserRole;
import java.util.Calendar;

public record RegisterDTO(String nm_paciente, Calendar dt_nascimento, String cpf, String senha, UserRole role) {

}
