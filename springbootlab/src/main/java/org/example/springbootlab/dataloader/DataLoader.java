package org.example.springbootlab.dataloader;

import org.example.springbootlab.model.Employee;
import org.example.springbootlab.model.Patient;
import org.example.springbootlab.repository.EmployeeRepository;
import org.example.springbootlab.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final PatientRepository patientRepository;

    public DataLoader(EmployeeRepository employeeRepository, PatientRepository patientRepository) {
        this.employeeRepository = employeeRepository;
        this.patientRepository = patientRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Employee employee1 = new Employee(356712L, "cardiology", "Alonso Flores", "ON_CALL");
        Employee employee2 = new Employee(564134L, "immunology", "Sam Ortega", "ON");
        Employee employee3 = new Employee(761527L, "cardiology", "German Ruiz", "OFF");
        Employee employee4 = new Employee(166552L, "pulmonary", "Maria Lin", "ON");
        Employee employee5 = new Employee(156545L, "orthopaedic", "Paolo Rodriguez", "ON_CALL");
        Employee employee6 = new Employee(172456L, "psychiatric", "John Paul Armes", "OFF");

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        employeeRepository.save(employee3);
        employeeRepository.save(employee4);
        employeeRepository.save(employee5);
        employeeRepository.save(employee6);


        Patient patient1 = new Patient(1L, "Jaime Jordan", "1984-03-02", employee2);
        Patient patient2 = new Patient(2L, "Marian Garcia", "1972-01-12", employee2);
        Patient patient3 = new Patient(3L, "Julia Dusterdiek", "1954-06-11", employee1);
        Patient patient4 = new Patient(4L, "Steve McDuck", "1931-11-10", employee3);
        Patient patient5 = new Patient(5L, "Marian Garcia", "1999-02-15", employee6);

        patientRepository.save(patient1);
        patientRepository.save(patient2);
        patientRepository.save(patient3);
        patientRepository.save(patient4);
        patientRepository.save(patient5);
    }
}