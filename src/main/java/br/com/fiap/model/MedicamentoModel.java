package br.com.fiap.model;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
@Table(name = "T_FLC_MEDICAMENTO")
public class MedicamentoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long cd_medicamento;
    @Column(length = 130)
    private String nm_medicamento;
    @Column(length = 20)
    private String ds_dosagem;
    @Column(length = 30)
    private String ds_frequencia;

    // FK AQUI:
    // ...


    public MedicamentoModel (long cd_medicamento, String nm_medicamento,
                             String ds_dosagem, String ds_frequencia)
    {
        super();
        this.cd_medicamento = cd_medicamento;
        this.nm_medicamento = nm_medicamento;
        this.ds_dosagem = ds_dosagem;
        this.ds_frequencia = ds_frequencia;
    }





}
