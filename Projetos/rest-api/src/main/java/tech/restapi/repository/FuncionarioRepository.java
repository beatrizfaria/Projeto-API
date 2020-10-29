package tech.restapi.repository;

import org.springframework.data.repository.CrudRepository;
import tech.restapi.model.FuncionarioModel;

public interface FuncionarioRepository extends CrudRepository<FuncionarioModel, Integer> {
}
