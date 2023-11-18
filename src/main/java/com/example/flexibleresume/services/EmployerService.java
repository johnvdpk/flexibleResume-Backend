package com.example.flexibleresume.services;

import com.example.flexibleresume.dtos.EmployerDto;
import com.example.flexibleresume.dtos.EmployerInputDto;
import com.example.flexibleresume.exceptions.RecordNotFoundException;
import com.example.flexibleresume.models.Employer;
import com.example.flexibleresume.repositorys.EmployerRepository;
import com.example.flexibleresume.repositorys.UserRepository;
import com.example.flexibleresume.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployerService {

    private final EmployerRepository employerRepos;
    private final UserRepository userRepos;

    // Omzetten van Employer naar EmployerDto
    private EmployerDto employerToDto(Employer employer) {
        return new EmployerDto(
                employer.getCompany(),
                employer.getIndustry(),
                employer.getOfficeAdress(),
                employer.getOfficeAdressNumber(),
                employer.getOfficeZipcode(),
                employer.getOfficeCityLocation(),
                employer.getKvk(),
                employer.getMission(),
                employer.getVision(),
                employer.getNumberOfEmployees()
        );
    }

    // Omzetten van EmployerInputDto naar Employer
    private Employer inputDtoToEmployer(EmployerInputDto dto) {
        Employer employer = new Employer();
        // Set alle velden van Employer

        employer.setCompany(dto.getCompany());
        employer.setIndustry(dto.getIndustry());
        employer.setOfficeAdress(dto.getOfficeAdress());
        employer.setOfficeAdressNumber(dto.getOfficeAdressNumber());
        employer.setOfficeZipcode(dto.getOfficeZipcode());
        employer.setOfficeCityLocation(dto.getOfficeCityLocation());
        employer.setKvk(dto.getKvk());
        employer.setMission(dto.getMission());
        employer.setVision(dto.getVision());
        employer.setNumberOfEmployees(dto.getNumberOfEmployees());
        return employer;
    }


    // Toevoegen van een nieuwe Employer
    public EmployerDto addEmployer(EmployerInputDto dto) {
        Employer employer = inputDtoToEmployer(dto);
        employer = employerRepos.save(employer);
        return employerToDto(employer);
    }


    public EmployerDto updateEmployer(String email, EmployerInputDto employerInputDto) {
        User user = userRepos.findByEmail(email).orElseThrow(() -> new RecordNotFoundException("User niet gevonden"));
        Employer existingEmployer = user.getEmployer();

        if(existingEmployer == null) {
            throw new RecordNotFoundException("Geen Employer gekoppeld aan deze user gevonden");
        }
        existingEmployer.setCompany(employerInputDto.getCompany());
        existingEmployer.setIndustry(employerInputDto.getIndustry());
        existingEmployer.setOfficeAdress(employerInputDto.getOfficeAdress());
        existingEmployer.setOfficeAdressNumber(employerInputDto.getOfficeAdressNumber());
        existingEmployer.setOfficeZipcode(employerInputDto.getOfficeZipcode());
        existingEmployer.setOfficeCityLocation(employerInputDto.getOfficeCityLocation());
        existingEmployer.setKvk(employerInputDto.getKvk());
        existingEmployer.setMission(employerInputDto.getMission());
        existingEmployer.setVision(employerInputDto.getVision());
        existingEmployer.setNumberOfEmployees(employerInputDto.getNumberOfEmployees());


        Employer updatedEmployer = employerRepos.save(existingEmployer);


        return employerToDto(updatedEmployer);
    }


    // Ophalen van een Employer op basis van ID
    public EmployerDto getEmployerById(Long id) {
        Employer employer = employerRepos.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Employer niet gevonden met id: " + id));
        return employerToDto(employer);
    }

    public EmployerDto getEmployerByEmail(String email) {
        User user = userRepos.findByEmail(email)
                .orElseThrow(() -> new RecordNotFoundException("User niet gevonden"));

        Employer employer = user.getEmployer();
        if (employer == null) {
            throw new RecordNotFoundException("Geen Employer gekoppeld aan gebruiker");
        }

        return employerToDto(employer);
    }

    // Verwijderen van een Employer
    public void deleteEmployer(Long id) {
        employerRepos.deleteById(id);
    }
}