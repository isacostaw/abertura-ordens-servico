package br.com.ordenservico.aberturaordenservico.service;

import java.util.List;
import java.util.Optional;

import br.com.ordenservico.aberturaordenservico.model.Setor;
import br.com.ordenservico.aberturaordenservico.repository.SetorRepository;

public class SetorService {
    private final SetorRepository setorRepository;
     
    public SetorService(SetorRepository setorRepository){
        this.setorRepository = setorRepository;
    }
    public Setor cadastrarSetor(Setor setor ){
        return setorRepository.save(setor);
    }
    public List<Setor> listarSetores(){
        return setorRepository.findAll();
    }

    public Setor buscarSetorPorId(int id) {
        return setorRepository.findById(id).orElse(null);
    }
   public Optional<Setor> atualizarSetor(Integer id, Setor novosDados) {
        Optional<Setor> setorExistente = 
        setorRepository.findById(id);
        if (setorExistente.isPresent()) {
            Setor setor = setorExistente.get();
            setor.setNomeSetor(novosDados.getNomeSetor());
            return Optional.of(setorRepository.save(setor));
        } else {
            return Optional.empty();
        }
    }

    public boolean deletarSetor(Integer id) {
        Optional<Setor> setorExistente = setorRepository.findById(id);
        if (setorExistente.isPresent()) {
            setorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    
}
