package br.com.fiap.model;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "T_FLC_PACIENTE")
public class PacienteModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long cd_paciente;
    @Column(length = 140)
    private String nm_paciente;
    @Column
    private Calendar dt_nascimento;
    @Column
    private String ds_senha;
    @Column
    private String ds_cpf;

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




}
