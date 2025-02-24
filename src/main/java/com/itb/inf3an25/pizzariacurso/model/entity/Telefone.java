package com.itb.inf3an25.pizzariacurso.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name = "telefones")
@Data
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 15)
    private String numero;

    @Column(nullable = true, length = 50)
    private String tipo; // Ex: "Celular", "Fixo"

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    @Transient
    private String mensagemErro = "";
    @Transient
    private boolean isValid = true;

    public boolean validarTelefone() {
        if(numero == null || numero.isEmpty()) {
            mensagemErro += "O número de telefone é obrigatório:";
            isValid = false;
        }
        
        return isValid;
    }
}
