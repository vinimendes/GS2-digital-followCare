package br.com.fiap.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "T_FLC_PACIENTE")
public class PacienteModel implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cd_paciente;
    @Column(length = 140)
    private String nm_paciente;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "UTC")
    @Temporal(TemporalType.DATE)
    @Column
    private Calendar dt_nascimento;
    @Column(name = "ds_cpf")
    private String cpf;
    @Column(name = "ds_senha")
    private String senha;

    @Column
    private UserRole role;

    public PacienteModel() {}

    public PacienteModel (String nm_paciente, Calendar dt_nascimento,
                          String cpf, String senha, UserRole role) {
        super();
        this.cpf = cpf;
        this.senha = senha;
        this.role = role;
        this.nm_paciente = nm_paciente;
        this.dt_nascimento = dt_nascimento;
    }

    public PacienteModel (long cd_paciente, String nm_paciente,
                          Calendar dt_nascimento, String senha,
                          String cpf, UserRole role) {

        super();
        this.cd_paciente = cd_paciente;
        this.nm_paciente = nm_paciente;
        this.dt_nascimento = dt_nascimento;
        this.senha = senha;
        this.cpf = cpf;
        this.role = role;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN ) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return cpf;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
