package br.com.ordenservico.aberturaordenservico.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table (name = "equipamentos")
public class Equipamentos {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomeEquipamento;

    @NotBlank(message = "O equipamento não pode ser vazio")

    public int getId() {
        return id;
    }

    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }
}
    