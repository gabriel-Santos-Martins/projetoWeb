package Model;

import org.apache.commons.math3.analysis.function.Identity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import Model.DTO.CategoriaProduto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@builder
@Entity


public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private String nome;
    private String descricao;
    private double preco;
    private int quantidadeDisponivel;

    @Enumerated(EnumType.String)
    @Column(nullaple = false)
    private CategoriaProduto Categoria;

}