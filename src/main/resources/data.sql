
-- WERKZOEKENDE
INSERT INTO jobseekers (id, first_name, sur_name, date_of_birth, email, phone_numbers, residences, zipcodes, home_addresses, house_numbers)
VALUES
    (100, 'John', 'Doe', '1986-05-04', 'johndoe@email.com', '0632654897', 'Amsterdam', '3423ET', 'destraat', '54b'),
    (200, 'Patrick', 'Doet het zelfwel', '1986-05-04', 'patrick_vanzelf@email.com', '0632652145', 'Utrecht', '3423TW', 'Anderestraat', '76b');

INSERT INTO resumes (id, about_me, jobseeker_id)
VALUES
    (100, 'Ervaren en enthousiaste ontwikkelaar...', 100),
    (200, 'Gepassioneerde softwareontwikkelaar...', 200);

INSERT INTO work_info (id, companys, jobtitles, period_of_employment, job_information, cv_id)
VALUES
    (100, 'Tech Solutions', 'Java Developer', '2017-2021', 'Ontwikkelde nieuwe features...', 100),
    (200, 'Innovative Tech Inc.', 'Senior Software Engineer', '2021-Present', 'Leidt een team van ontwikkelaars...', 100);

INSERT INTO personal_info (id, hobbys, period_of_hobby, hobby_info, cv_id)
VALUES
    (100, 'Schilderen', '2010-2023', 'Landschappen en portretten schilderen.', 100),
    (200, 'Fotografie', '2015-2023', 'Actief in landschaps- en portretfotografie.', 100);

INSERT INTO study_info (id, education_institue, education, period_of_study, study_info, cv_id)
VALUES
    (100, 'Universiteit van Amsterdam', 'Bachelor Informatica', '2010-2013', 'Softwareontwikkeling en data-analyse.', 100),
    (200, 'Technische Universiteit Delft', 'Masters in Computer Science', '2013-2015', 'Gespecialiseerd in software-architectuur en cybersecurity.', 100);

-- WERKGEVER
INSERT INTO employers (id, companys, industries, office_addresses, office_adress_numbers, office_zipcode, office_city_locations, kvk_number, missions, visions, number_of_employees)
VALUES
(100, 'Sunrise In', 'IT', 'Technostraat 5', '5A', '1001AB', 'Amsterdam', '12345678', 'Technologie toegankelijk maken...', 'Een wereld waarin technologie...', '500');

INSERT INTO employer_job_info (id, Employer_id, job_descriptions, job_requirements, skills, educations, years_of_experience, job_offers, salary_indications, extras)
VALUES
(100, 100, 'Java Developer gezocht...', 'Ervaring met Java en Spring...', 'Java, Spring', 'Bachelor Informatica', '3 jaar', 'Full-time', '€4000 - €5000 per maand', 'Flexibele werktijden, thuiswerkmogelijkheden');


-- SECURITY TEST
INSERT INTO users (id, email, password, role, jobseeker_id, employer_id)
VALUES
    (100, 'johndoe@email.com', '$2a$10$4swew8oOgCAOTg3837tfWOgUlT0ofErBdPqc8yrOiBtNkfj4KKdgy', 'USER', 100, null),
    (200, 'company@email.com', '$2a$10$4swew8oOgCAOTg3837tfWOgUlT0ofErBdPqc8yrOiBtNkfj4KKdgy', 'COMPANY', null, 100),
    (300, 'admin@email.com', '$2a$10$4swew8oOgCAOTg3837tfWOgUlT0ofErBdPqc8yrOiBtNkfj4KKdgy', 'ADMIN', null, null);