package br.com.fiap.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.*;
import java.util.Calendar;

public class PacienteDto {

    /*

    Validacoes por ANOTACOES
    Jakarta Bean Validation

    */

    @NotEmpty(message = "Nome nao pode ser NULL")
    private String nm_paciente;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "UTC")
    @NotNull
    private Calendar dt_nascimento;

    @Size(min = 11, max = 11)
    private String ds_cpf;
    private String ds_senha;




    public String getNm_paciente() {
        return nm_paciente;
    }

    public void setNm_paciente(String nm_paciente) {
        this.nm_paciente = nm_paciente;
    }

    public Calendar getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(Calendar dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getDs_senha() {
        return ds_senha;
    }

    public void setDs_senha(String ds_senha) {
        this.ds_senha = ds_senha;
    }

    public String getDs_cpf() {
        return ds_cpf;
    }

    public void setDs_cpf(String ds_cpf) {
        this.ds_cpf = ds_cpf;
    }
}
