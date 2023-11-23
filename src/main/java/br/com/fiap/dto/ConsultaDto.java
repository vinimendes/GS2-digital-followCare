package br.com.fiap.dto;

import br.com.fiap.model.MedicoModel;
import br.com.fiap.model.PacienteModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Calendar;

public class ConsultaDto {

    private MedicoModel cd_medico;

    private PacienteModel cd_paciente;

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "UTC")
    private Calendar dt_consulta;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone = "UTC")
    @Temporal(TemporalType.TIME)
    private Calendar hr_consulta;

    public MedicoModel getCd_medico() {
        return cd_medico;
    }

    public void setCd_medico(MedicoModel cd_medico) {
        this.cd_medico = cd_medico;
    }

    public PacienteModel getCd_paciente() {
        return cd_paciente;
    }

    public void setCd_paciente(PacienteModel cd_paciente) {
        this.cd_paciente = cd_paciente;
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
