package br.com.davi.loja.modelo;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Categoria (){
    }

    public Categoria(String nome) {
        this.nome = nome;
    }
}
