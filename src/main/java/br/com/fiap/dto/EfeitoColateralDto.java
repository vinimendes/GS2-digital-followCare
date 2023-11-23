package br.com.fiap.dto;


import br.com.fiap.model.MedicamentoModel;
import jakarta.validation.constraints.NotEmpty;

public class EfeitoColateralDto {

    private MedicamentoModel cd_medicamento;

    @NotEmpty
    private String ds_efeito_colateral;

    public MedicamentoModel getCd_medicamento() {
        return cd_medicamento;
    }

    public void setCd_medicamento(MedicamentoModel cd_medicamento) {
        this.cd_medicamento = cd_medicamento;
    }

    public String getDs_efeito_colateral() {
        return ds_efeito_colateral;
    }

    public void setDs_efeito_colateral(String ds_efeito_colateral) {
        this.ds_efeito_colateral = ds_efeito_colateral;
    }
}
