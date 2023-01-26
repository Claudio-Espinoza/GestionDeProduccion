package ufro.dci.gestionapp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionProduccionApplication {
	public static void main(String[] args) {
		SpringApplication.run(GestionProduccionApplication.class, args);
	}
/*
	@Bean
	CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder){
		return args -> {
			employeeRepository.save(new Employee("200000001", "Aquiles","Bailo","Petes","Part-Time", passwordEncoder.encode("1234"), Role.EMPLOYEE));
			employeeRepository.save(new Employee("200000002", "Casi","Miro","Hentai","Part-Time",passwordEncoder.encode("1234"),Role.EMPLOYEE));
			employeeRepository.save(new Employee("200000003", "Elva","Ginon","Marco","Full-Time",passwordEncoder.encode("1234"), Role.MANAGER));
		};
	}
 */


}
