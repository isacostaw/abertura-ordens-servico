package br.com.ordenservico.aberturaordenservico.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ordenservico.aberturaordenservico.model.Setor;
public interface SetorRepository extends JpaRepository<Setor, Integer> {
    
}
