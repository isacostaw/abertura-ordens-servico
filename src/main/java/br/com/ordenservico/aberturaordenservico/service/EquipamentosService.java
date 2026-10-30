package br.com.ordenservico.aberturaordenservico.service;

import br.com.ordenservico.aberturaordenservico.model.Equipamentos;
import br.com.ordenservico.aberturaordenservico.repository.EquipamentosRepository;

import java.util.List;
import java.util.Optional;
    public class EquipamentosService {

    private final EquipamentosRepository equipamentosRepository;

    public EquipamentosService(EquipamentosRepository equipamentosRepository) {
        this.equipamentosRepository = equipamentosRepository;
    }

    public Equipamentos cadastrarEquipamentos(Equipamentos equipamentos) {
        return equipamentosRepository.save(equipamentos);
    }

    public List<Equipamentos> listarEquipamentos() {
        return equipamentosRepository.findAll();
    }

    public Equipamentos buscarEquipamentosPorId(int id) {
        return equipamentosRepository.findById(id).orElse(null);
    }

    public Optional<Equipamentos> atualizarEquipamentos(Integer id, Equipamentos novosDados) {
        Optional<Equipamentos> equipamentoExistente =
                equipamentosRepository.findById(id);

        if (equipamentoExistente.isPresent()) {
            Equipamentos equipamentos = equipamentoExistente.get();
            equipamentos.setNomeEquipamento(novosDados.getNomeEquipamento());
            return Optional.of(equipamentosRepository.save(equipamentos));
        } else {
            return Optional.empty();
        }
    }

    public boolean deletarEquipamentos(Integer id) {
        Optional<Equipamentos> equipamentoExistente =
                equipamentosRepository.findById(id);

        if (equipamentoExistente.isPresent()) {
            equipamentosRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
    

