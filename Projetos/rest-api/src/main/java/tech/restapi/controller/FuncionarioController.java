package tech.restapi.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.restapi.model.FuncionarioModel;
import tech.restapi.repository.FuncionarioRepository;

@RestController
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repository;


    @GetMapping(path = "/api/funcionario/{codigo}")
    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo) {
        return repository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/api/funcionario/salvar")
    public FuncionarioModel salvar(@RequestBody FuncionarioModel funcionario) {
        return repository.save(funcionario);
    }

    @DeleteMapping(path = "/api/funcionario/deletar")
    public void deletar(@RequestBody FuncionarioModel funcionario) {
        repository.delete(funcionario);
    }

    @PutMapping(path = "/api/funcionario/alterar")
    public FuncionarioModel alterar(@RequestBody FuncionarioModel funcionario) {
        return repository.save(funcionario);
    }
}