package br.com.ordenservico.aberturaordenservico.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;




import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "setores")
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "O nome do setor é obrigatório")
    private String nomeSetor;

    public Setor() {
    }

    public Integer getId() {
        return id;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }
}
