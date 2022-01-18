package br.com.mentoria.mentoriajava.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private double preco;
    @ManyToOne
    @JoinColumn (name = "categoria", referencedColumnName = "id")
    private Categoria categoria;
}
