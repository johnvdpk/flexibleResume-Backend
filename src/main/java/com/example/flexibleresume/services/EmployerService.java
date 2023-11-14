package com.example.flexibleresume.services;

import com.example.flexibleresume.dtos.EmployerDto;
import com.example.flexibleresume.dtos.EmployerInputDto;
import com.example.flexibleresume.dtos.JobSeekerDto;
import com.example.flexibleresume.exceptions.RecordNotFoundException;
import com.example.flexibleresume.models.Employer;
import com.example.flexibleresume.models.JobSeeker;
import com.example.flexibleresume.repositorys.EmployerRepository;
import com.example.flexibleresume.repositorys.UserRepository;
import com.example.flexibleresume.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployerService {

    private final EmployerRepository employerRepos;
    private final UserRepository userRepos;

    // Omzetten van Employer naar EmployerDto
    private EmployerDto employerToDto(Employer employer) {
        return new EmployerDto(
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

    // Bijwerken van een bestaande Employer
    public EmployerDto updateEmployer(Long id, EmployerInputDto dto) {
        Employer employer = employerRepos.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Employer niet gevonden met id: " + id));

        // Update de velden van de bestaande employer
        // ... (set alle velden van employer op basis van dto)

        employer = employerRepos.save(employer);
        return employerToDto(employer);
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