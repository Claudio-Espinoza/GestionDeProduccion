package ufro.dci.gestionapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ufro.dci.gestionapp.model.employees.Employee;
import ufro.dci.gestionapp.repository.EmployeeRepository;

@SpringBootApplication
public class GestionProduccionApplication {
	public static void main(String[] args) {
		SpringApplication.run(GestionProduccionApplication.class, args);
	}

	/*
	@Bean
	CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder){
		return args -> {
			employeeRepository.save(new Employee("207542628", "Operario", "ROLE_USER", "Marco", "Ruis", "Senn", "Part-Time", passwordEncoder.encode("1234")));
			employeeRepository.save(new Employee("107542628", "Operario", "ROLE_USER", "Juan", "Caceres", "Robin", "Part-Time", passwordEncoder.encode("5678")));
			employeeRepository.save(new Employee("307542628", "Operario", "ROLE_USER", "Diego", "Lefiqueo", "Tur", "Full-Time", passwordEncoder.encode("9101")));
		};
	}
	*/

}
