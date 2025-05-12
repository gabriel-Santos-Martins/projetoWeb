package main.java.Model.Entidades;

import Model.Carrinho;
import Model.Produto;
import Model.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.commons.math3.analysis.function.Identity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class OS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private Cliente cliente;
    private Produto produto;
    private Usuario usuario;
    private Carrinho carrinho;
    private LocalDateTime Data;
    
}
