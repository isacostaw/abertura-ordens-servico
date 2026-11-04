package br.com.ordenservico.aberturaordenservico.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EquipamentosRequest {
    @NotBlank (message = "O nome do equipamento é obrigatório")
    String nomeEquipamento;
    @NotBlank (message = "O número de patrimônio é obrigatório")
    String numeroPatrimonio;
    @NotNull (message = "O setor do equipamento é obrigatório")
    Integer setorId;

    public EquipamentosRequest() {
    }

    public String getNomeEquipamento() {
        return nomeEquipamento;
    }
    public void setNomeEquipamento(String nomeEquipamento) {
        this.nomeEquipamento = nomeEquipamento;
    }

    public String getNumeroPatrimonio() {
        return numeroPatrimonio;
    }

    public void setNumeroPatrimonio(String numeroPatrimonio) {
        this.numeroPatrimonio = numeroPatrimonio;
    }

    public Integer getSetorId() {
        return setorId;
    }

    public void setSetorId(Integer setorId) {
        this.setorId = setorId;
    }

   
}
