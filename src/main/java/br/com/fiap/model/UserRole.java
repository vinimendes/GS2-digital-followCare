package br.com.fiap.model;

public enum UserRole {

    ADMIN("admin"),

    PACIENTE("paciente");

    private String role;

    UserRole (String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }


}
