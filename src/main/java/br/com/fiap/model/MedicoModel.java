package br.com.fiap.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "T_FLC_MEDICO")
public class MedicoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long cd_medico;
    @Column(length = 130)
    private String nm_medico;
    @Column
    private Calendar dt_nascimento;
    @Column(length = 20)
    private String nm_crm;
    @Column
    private String ds_senha;
    @Column(length = 11)
    private String ds_cpf;

    public MedicoModel () {}

    public MedicoModel (long cd_medico, String nm_medico,
                        Calendar dt_nascimento, String nm_crm,
                        String ds_senha, String ds_cpf) {

        super();
        this.cd_medico = cd_medico;
        this.nm_medico = nm_medico;
        this.dt_nascimento = dt_nascimento;
        this.nm_crm = nm_crm;
        this.ds_senha = ds_senha;
        this.ds_cpf = ds_cpf;

    }


}
