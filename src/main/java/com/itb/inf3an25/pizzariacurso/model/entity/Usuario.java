package com.itb.inf3an25.pizzariacurso.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = true, length = 50)
    private String senha;

    @Transient
    private String mensagemErro = "";
    @Transient
    private boolean isValid = true;

    public boolean validarUsuario() {
        if(nome == null || nome.isEmpty()) {
            mensagemErro += "O nome do usuário é obrigatório:";
            isValid = false;
        }
        if(email == null || email.isEmpty()) {
            mensagemErro += "O email do usuário é obrigatório:";
            isValid = false;
        }
        if(senha == null || senha.isEmpty()) {
            mensagemErro += "A senha do usuário é obrigatória:";
            isValid = false;
        }

        return isValid;
    }
}
