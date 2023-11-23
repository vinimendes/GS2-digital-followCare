package br.com.fiap.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "T_FLC_CONSULTA")
public class ConsultaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cd_consulta;

    @ManyToOne
    @JoinColumn(name = "cd_medico")
    private MedicoModel cd_medico;

    @ManyToOne
    @JoinColumn(name = "cd_paciente")
    private PacienteModel cd_paciente;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "UTC")
    @Temporal(TemporalType.DATE)
    @Column
    private Calendar dt_consulta;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "UTC")
    @Temporal(TemporalType.TIME)
    @Column
    private Calendar hr_consulta;

    public ConsultaModel() {}

    public ConsultaModel (long cd_consulta, MedicoModel cd_medico,
                          PacienteModel cd_paciente,
                          Calendar dt_consulta, Calendar hr_consulta) {

        super();
        this.cd_consulta = cd_consulta;
        this.cd_medico = cd_medico;
        this.cd_paciente = cd_paciente;
        this.dt_consulta = dt_consulta;
        this.hr_consulta = hr_consulta;

    }

    public ConsultaModel (MedicoModel cd_medico,
                          PacienteModel cd_paciente,
                          Calendar dt_consulta, Calendar hr_consulta) {

        super();
        this.cd_medico = cd_medico;
        this.cd_paciente = cd_paciente;
        this.dt_consulta = dt_consulta;
        this.hr_consulta = hr_consulta;

    }



    public long getCd_consulta() {
        return cd_consulta;
    }

    public void setCd_consulta(long cd_consulta) {
        this.cd_consulta = cd_consulta;
    }

    public MedicoModel getMedicoModel() {
        return cd_medico;
    }

    public void setMedicoModel(MedicoModel cd_medico) {
        this.cd_medico = cd_medico;
    }

    public PacienteModel getPacienteModel() {
        return cd_paciente;
    }

    public void setPacienteModel(PacienteModel cd_paciente) {
        this.cd_paciente = cd_paciente;
    }

    public Calendar getDt_consulta() {
        return dt_consulta;
    }

    public void setDt_consulta(Calendar dt_consulta) {
        this.dt_consulta = dt_consulta;
    }

    public Calendar getHr_consulta() {
        return hr_consulta;
    }

    public void setHr_consulta(Calendar hr_consulta) {
        this.hr_consulta = hr_consulta;
    }
}
