


-- WERKZOEKENDE
INSERT INTO jobseekers (id, first_name, sur_name, date_of_birth, email, phone_numbers, residences, zipcodes, home_addresses, house_numbers)
VALUES
    (1, 'John', 'Doe', '1986-05-04', 'johndoe@email.com', '0632654897', 'Amsterdam', '3423ET', 'destraat', '54b'),
    (2, 'Patrick', 'Doet het zelfwel', '1986-05-04', 'patrick_vanzelf@email.com', '0632652145', 'Utrecht', '3423TW', 'Anderestraat', '76b');

INSERT INTO resumes (id, about_me, jobseeker_id)
VALUES
    (1, 'Ervaren en enthousiaste ontwikkelaar...', 1),
    (2, 'Gepassioneerde softwareontwikkelaar...', 2);

INSERT INTO work_info (id, companys, jobtitles, period_of_employment, job_information, cv_id)
VALUES
    (1, 'Tech Solutions', 'Java Developer', '2017-2021', 'Ontwikkelde nieuwe features...', 1),
    (2, 'Innovative Tech Inc.', 'Senior Software Engineer', '2021-Present', 'Leidt een team van ontwikkelaars...', 1);

INSERT INTO personal_info (id, hobbys, period_of_hobby, hobby_info, cv_id)
VALUES
    (1, 'Schilderen', '2010-2023', 'Landschappen en portretten schilderen.', 1),
    (2, 'Fotografie', '2015-2023', 'Actief in landschaps- en portretfotografie.', 1);

INSERT INTO study_info (id, education_institue, education, period_of_study, study_info, cv_id)
VALUES
    (1, 'Universiteit van Amsterdam', 'Bachelor Informatica', '2010-2013', 'Softwareontwikkeling en data-analyse.', 1),
    (2, 'Technische Universiteit Delft', 'Masters in Computer Science', '2013-2015', 'Gespecialiseerd in software-architectuur en cybersecurity.', 1);

-- WERKGEVER
INSERT INTO employers (id, companys, industries, office_addresses, office_adress_numbers, office_zipcode, office_city_locations, kvk_number, missions, visions, number_of_employees)
VALUES
(1, 'Sunrise In', 'IT', 'Technostraat 5', '5A', '1001AB', 'Amsterdam', '12345678', 'Technologie toegankelijk maken...', 'Een wereld waarin technologie...', '500');

INSERT INTO employer_job_info (id, Employer_id, job_descriptions, job_requirements, skills, educations, years_of_experience, job_offers, salary_indications, extras)
VALUES
(1, 1, 'Java Developer gezocht...', 'Ervaring met Java en Spring...', 'Java, Spring', 'Bachelor Informatica', '3 jaar', 'Full-time', '€4000 - €5000 per maand', 'Flexibele werktijden, thuiswerkmogelijkheden');


-- SECURITY TEST
INSERT INTO users (id, email, password, role, jobseeker_id)
VALUES
    (1, 'johndoe@email.com', '$2a$10$gx6n5iAnrzzc8EPwNKVje.1bYs/FJzrgfj.NrHPzGYMyiOIUG.pye', 'USER', 1),
    (2, 'company@email.com', '$2a$10$gx6n5iAnrzzc8EPwNKVje.1bYs/FJzrgfj.NrHPzGYMyiOIUG.pye', 'COMPANY', null),
    (3, 'admin@email.com', '$2a$10$gx6n5iAnrzzc8EPwNKVje.1bYs/FJzrgfj.NrHPzGYMyiOIUG.pye', 'ADMIN', null);