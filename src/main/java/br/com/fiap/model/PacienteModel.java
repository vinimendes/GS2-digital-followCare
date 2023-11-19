package br.com.fiap.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "T_FLC_PACIENTE")
public class PacienteModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long cd_paciente;
    @Column(length = 140)
    private String nm_paciente;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "UTC")
    @Temporal(TemporalType.DATE)
    @Column
    private Calendar dt_nascimento;
    @Column
    private String ds_cpf;
    @Column
    private String ds_senha;

    public PacienteModel() {}

    public PacienteModel (long cd_paciente, String nm_paciente,
                          Calendar dt_nascimento, String ds_senha,
                          String ds_cpf) {

        super();
        this.cd_paciente = cd_paciente;
        this.nm_paciente = nm_paciente;
        this.dt_nascimento = dt_nascimento;
        this.ds_senha = ds_senha;
        this.ds_cpf = ds_cpf;

    }

    public long getCd_paciente() {
        return cd_paciente;
    }

    public void setCd_paciente(long cd_paciente) {
        this.cd_paciente = cd_paciente;
    }

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
