package br.com.cpf.controleFinanceiro.spring.cassandra.lombok.repository;

import java.util.List;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import br.com.cpf.controleFinanceiro.spring.cassandra.lombok.model.User;

public interface UserRepository extends CassandraRepository<User, Integer>{

	@AllowFiltering
	List<User> findByAgeGreaterThan(int age);

}
