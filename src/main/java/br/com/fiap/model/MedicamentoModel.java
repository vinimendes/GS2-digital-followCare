package br.com.fiap.model;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "T_FLC_MEDICAMENTO")
public class MedicamentoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cd_medicamento;
    @ManyToOne
    @JoinColumn(name = "cd_paciente", nullable = true)
    private PacienteModel cd_paciente;
    @Column(length = 130)
    private String nm_medicamento;
    @Column(length = 20)
    private String ds_dosagem;
    @Column(length = 30)
    private String ds_frequencia;


    public MedicamentoModel () {}

    public MedicamentoModel ( long cd_medicamento,PacienteModel cd_paciente, String nm_medicamento,
                             String ds_dosagem, String ds_frequencia)
    {
        super();
        this.cd_medicamento = cd_medicamento;
        this.cd_paciente = cd_paciente;
        this.nm_medicamento = nm_medicamento;
        this.ds_dosagem = ds_dosagem;
        this.ds_frequencia = ds_frequencia;
    }

    public PacienteModel getCd_paciente() {
        return cd_paciente;
    }

    public void setCd_paciente(PacienteModel cd_paciente) {
        this.cd_paciente = cd_paciente;
    }

    public long getCd_medicamento() {
        return cd_medicamento;
    }

    public void setCd_medicamento(long cd_medicamento) {
        this.cd_medicamento = cd_medicamento;
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
