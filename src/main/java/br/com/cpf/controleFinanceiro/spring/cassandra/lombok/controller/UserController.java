package br.com.cpf.controleFinanceiro.spring.cassandra.lombok.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.cpf.controleFinanceiro.spring.cassandra.lombok.model.User;
import br.com.cpf.controleFinanceiro.spring.cassandra.lombok.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void saveUser(){
		List<User> users = new ArrayList<>();
		users.add(new User(321, "Tio Sam", "Rua das Flores", 30));
		users.add(new User(123, "Tia Man", "Rua das Neves", 29));
		userRepository.saveAll(users);	
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/getUserFilterByAge/{age}")
	public List<User> getUserFilterByAge(@PathVariable int age){
		return userRepository.findByAgeGreaterThan(age);
	}
	
}
