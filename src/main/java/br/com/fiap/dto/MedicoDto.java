package br.com.fiap.dto;

import jakarta.validation.constraints.NotEmpty;

public class MedicoDto {

    @NotEmpty
    private String nm_medico;

    @NotEmpty
    private String nm_crm;

    @NotEmpty
    private String ds_especialidade;

    public String getNm_medico() {
        return nm_medico;
    }

    public void setNm_medico(String nm_medico) {
        this.nm_medico = nm_medico;
    }

    public String getNm_crm() {
        return nm_crm;
    }

    public void setNm_crm(String nm_crm) {
        this.nm_crm = nm_crm;
    }

    public String getDs_especialidade() {
        return ds_especialidade;
    }

    public void setDs_especialidade(String ds_especialidade) {
        this.ds_especialidade = ds_especialidade;
    }
}
