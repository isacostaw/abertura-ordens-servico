package br.com.ordenservico.aberturaordenservico.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ordenservico.aberturaordenservico.model.Equipamentos;

public interface  EquipamentosRepository extends JpaRepository<Equipamentos, Integer> {
    
}
