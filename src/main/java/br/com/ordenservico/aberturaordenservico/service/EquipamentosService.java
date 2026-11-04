package br.com.ordenservico.aberturaordenservico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import br.com.ordenservico.aberturaordenservico.dto.EquipamentosRequest;
import br.com.ordenservico.aberturaordenservico.model.Equipamentos;
import br.com.ordenservico.aberturaordenservico.model.Setor;
import br.com.ordenservico.aberturaordenservico.repository.EquipamentosRepository;
import br.com.ordenservico.aberturaordenservico.repository.SetorRepository;

@Service
public class EquipamentosService {

        private final EquipamentosRepository equipamentosRepository;
        private final SetorRepository setorRepository;

        public EquipamentosService(
                        EquipamentosRepository equipamentosRepository,
                        SetorRepository setorRepository) {

                this.equipamentosRepository = equipamentosRepository;
                this.setorRepository = setorRepository;

        }

        // Cadastrar equipamento
        public Equipamentos cadastrarEquipamentos(EquipamentosRequest equipamentos) {

                if (equipamentos.getSetorId() == null) {
                        throw new ResponseStatusException(
                                        HttpStatus.BAD_REQUEST,
                                        "Informe o setor do equipamento.");
                }

                Integer idSetor = equipamentos.getSetorId();

                Setor setor = setorRepository.findById(idSetor)
                                .orElseThrow(() -> new ResponseStatusException(
                                                HttpStatus.NOT_FOUND,
                                                "Setor não encontrado. Equipamento não cadastrado."));

                Equipamentos novoEquipamento = new Equipamentos();

                novoEquipamento.setNomeEquipamento(equipamentos.getNomeEquipamento());
                novoEquipamento.setNumeroPatrimonio(equipamentos.getNumeroPatrimonio());
                novoEquipamento.setSetor(setor);

                return equipamentosRepository.save(novoEquipamento);
        }

        // Listar equipamentos
        public List<Equipamentos> listarEquipamentos() {

                return equipamentosRepository.findAll();
        }

        // Buscar equipamento por ID
        public Equipamentos buscarEquipamentosPorId(Integer id) {

                return equipamentosRepository.findById(id).orElse(null);
        }

        // Atualizar equipamento
        public Optional<Equipamentos> atualizarEquipamentos(
                        Integer id, EquipamentosRequest novosDados) {

                Optional<Equipamentos> equipamentoExistente = equipamentosRepository.findById(id);

                if (!equipamentoExistente.isPresent()) {
                        return Optional.empty();
                }

                Integer idSetor = novosDados.getSetorId();

                Setor setor = setorRepository.findById(idSetor)
                                .orElseThrow(() -> new ResponseStatusException(
                                                HttpStatus.NOT_FOUND,
                                                "Setor não encontrado. Equipamento não atualizado."));

                Equipamentos equipamentos = equipamentoExistente.get();

                equipamentos.setNomeEquipamento(
                                novosDados.getNomeEquipamento());

                equipamentos.setNumeroPatrimonio(
                                novosDados.getNumeroPatrimonio());

                equipamentos.setSetor(setor);

                return Optional.of(
                                equipamentosRepository.save(equipamentos));

        }

        // Deletar equipamento
        public boolean deletarEquipamentos(Integer id) {

                Optional<Equipamentos> equipamentoExistente = equipamentosRepository.findById(id);

                if (equipamentoExistente.isPresent()) {

                        equipamentosRepository.deleteById(id);
                        return true;

                } else {
                        return false;
                }

        }
}
