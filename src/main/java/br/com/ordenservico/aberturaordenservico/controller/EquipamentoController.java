package br.com.ordenservico.aberturaordenservico.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;   
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.ordenservico.aberturaordenservico.model.Equipamentos;
import br.com.ordenservico.aberturaordenservico.service.EquipamentosService;



@RestController
@RequestMapping("/equipamentos")
public class EquipamentoController {

    private final EquipamentosService equipamentosService;

    public EquipamentoController(EquipamentosService equipamentosService) {
        this.equipamentosService = equipamentosService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {

        boolean deletado = equipamentosService.deletarEquipamentos(id);

        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipamentos> atualizar(
            @PathVariable Integer id,
            @RequestBody Equipamentos novosDados) {

        final Optional<Equipamentos> equipamentoAtualizado =
                equipamentosService.atualizarEquipamentos(id, novosDados);

        if (equipamentoAtualizado.isPresent()) {
            return ResponseEntity.ok(equipamentoAtualizado.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipamentos> buscarEquipamentosPorId(
            @PathVariable Integer id) {

        Equipamentos equipamentos = equipamentosService.buscarEquipamentosPorId(id);

        if (equipamentos != null) {
            return ResponseEntity.ok(equipamentos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Equipamentos>> listarEquipamentos() {

        List<Equipamentos> equipamentos = equipamentosService.listarEquipamentos();

        return ResponseEntity.ok(equipamentos);
    }

    @PostMapping
    public ResponseEntity<Equipamentos> cadastrarEquipamentos(
             @RequestBody Equipamentos equipamentos) {

        Equipamentos equipamentoCadastrado =
                equipamentosService.cadastrarEquipamentos(equipamentos);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(equipamentoCadastrado);
    }
}
