package br.com.fiap.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "T_FLC_EFEITO_COLATERAL")
public class EfeitoColateralModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long cd_efeitos;

    @Column
    private String ds_efeito_colateral;

    @ManyToOne
    @JoinColumn(name = "cd_medicamento", nullable = true)
    private MedicamentoModel cd_medicamento;

    public EfeitoColateralModel () {}

    public EfeitoColateralModel (long cd_efeitos, MedicamentoModel cd_medicamento, String ds_efeito_colateral)
    {
        super();
        this.cd_efeitos = cd_efeitos;
        this.cd_medicamento = cd_medicamento;
        this.ds_efeito_colateral = ds_efeito_colateral;
    }

    public MedicamentoModel getCd_medicamento() {
        return cd_medicamento;
    }

    public void setCd_medicamento(MedicamentoModel cd_medicamento) {
        this.cd_medicamento = cd_medicamento;
    }

    public long getCd_efeitos() {
        return cd_efeitos;
    }

    public void setCd_efeitos(long cd_efeitos) {
        this.cd_efeitos = cd_efeitos;
    }

    public String getDs_efeito_colateral() {
        return ds_efeito_colateral;
    }

    public void setDs_efeito_colateral(String ds_efeito_colateral) {
        this.ds_efeito_colateral = ds_efeito_colateral;
    }
}
