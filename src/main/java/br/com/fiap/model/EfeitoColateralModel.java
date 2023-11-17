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
    private String ds_efeito_colateral;


    public EfeitoColateralModel (long cd_efeitos, String ds_efeito_colateral)
    {
        super();
        this.cd_efeitos = cd_efeitos;
        this.ds_efeito_colateral = ds_efeito_colateral;
    }

}
