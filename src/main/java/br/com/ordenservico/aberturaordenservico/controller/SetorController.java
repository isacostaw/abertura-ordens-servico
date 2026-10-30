package br.com.ordenservico.aberturaordenservico.controller;

import java.util.List;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ordenservico.aberturaordenservico.model.Setor;
import br.com.ordenservico.aberturaordenservico.service.SetorService;


@RestController 
@RequestMapping ("/setores")
public class SetorController {
    private final SetorService setorService;
    public SetorController(SetorService setorService) {
        this.setorService = setorService;
        
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar
    (@PathVariable Integer id) {
        
        boolean deletado = setorService.deletarSetor(id);
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    @PutMapping("/{id}")
public ResponseEntity<Setor> atualizar(
        @PathVariable Integer id,
        @RequestBody Setor novosDados) {

    if (novosDados.getNomeSetor() == null ||
            novosDados.getNomeSetor().isBlank()) {

        return ResponseEntity.badRequest().build();
    }

    return setorService.atualizarSetor(id, novosDados)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
}
        
        
    
    @GetMapping("/{id}")
    public ResponseEntity<Setor> buscarSetorPorId(@PathVariable Integer id) {
        Setor setor = setorService.buscarSetorPorId(id);
        if (setor != null) {
            return ResponseEntity.ok(setor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<Setor>> listarSetores() {
        List<Setor> setores = setorService.listarSetores();
        return ResponseEntity.ok(setores);
    }
    
    @PostMapping
public ResponseEntity<Setor> cadastrarSetor(
        @Valid @RequestBody Setor setor) {

    return ResponseEntity.ok(setorService.cadastrarSetor(setor));
}
    






}



