package br.com.fiap.dto;

import br.com.fiap.model.PacienteModel;
import jakarta.validation.constraints.NotEmpty;


public class MedicamentoDto {

    /*

    Validacoes por ANOTACOES
    Jakarta Bean Validation

    */

    private PacienteModel cd_paciente;

    @NotEmpty(message = "Nome do medicamento nao pode ser NULL")
    private String nm_medicamento;

    @NotEmpty(message = "Nome do medicamento nao pode ser NULL")
    private String ds_dosagem;

    @NotEmpty
    private String ds_frequencia;


    public PacienteModel getCd_paciente() {
        return cd_paciente;
    }

    public void setCd_paciente(PacienteModel cd_paciente) {
        this.cd_paciente = cd_paciente;
    }

    public String getNm_medicamento() {
        return nm_medicamento;
    }

    public void setNm_medicamento(String nm_medicamento) {
        this.nm_medicamento = nm_medicamento;
    }

    public String getDs_dosagem() {
        return ds_dosagem;
    }

    public void setDs_dosagem(String ds_dosagem) {
        this.ds_dosagem = ds_dosagem;
    }

    public String getDs_frequencia() {
        return ds_frequencia;
    }

    public void setDs_frequencia(String ds_frequencia) {
        this.ds_frequencia = ds_frequencia;
    }
}
