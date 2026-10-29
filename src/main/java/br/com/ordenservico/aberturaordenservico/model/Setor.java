package br.com.ordenservico.aberturaordenservico.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity 
 @Table (name = "setor")
    
public class Setor {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;

    private String nomeSetor;
    @NotBlank (message = "O setor não pode ser vazio")

    public int getId(){
        return id;
    }
    public String getNomeSetor(){
        return nomeSetor;
    }
    public void setNomeSetor(String nomeSetor){
        this.nomeSetor = nomeSetor;
    }



    
}
