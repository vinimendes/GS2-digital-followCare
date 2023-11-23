package br.com.fiap.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "T_FLC_MEDICO")
public class MedicoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cd_medico;
    @Column(length = 130)
    private String nm_medico;
    @Column(length = 20)
    private String nm_crm;

    @Column(length = 30)
    private String ds_especialidade;

    public MedicoModel () {}

    public MedicoModel (long cd_medico, String nm_medico,
                        String nm_crm, String ds_especialidade) {

        super();
        this.cd_medico = cd_medico;
        this.nm_medico = nm_medico;
//        this.dt_nascimento = dt_nascimento;
        this.nm_crm = nm_crm;
//        this.ds_senha = ds_senha;
//        this.ds_cpf = ds_cpf;
        this.ds_especialidade = ds_especialidade;

    }


    public long getCd_medico() {
        return cd_medico;
    }

    public void setCd_medico(long cd_medico) {
        this.cd_medico = cd_medico;
    }

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
