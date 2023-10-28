-- WERKZOEKDENDE

INSERT INTO jobseekers (id, first_name, sur_name, date_of_birth, email, phone_numbers, zipcodes, home_addresses, house_numbers)
VALUES
(1, 'John', 'Doe', '1986-05-04', 'johndoe@email.com','0632654897', '3423ET', 'destraat','54b'),
(2, 'Alex', 'Anders', '1996-02-01', 'alexanders@email.com', '+3165478954','3443ET', 'kerkstraat','321a');

INSERT INTO resumes (id,about_me, jobseeker_id)
VALUES
    (1,'Dit is een kort stukje over John.', 1),
    (2,'Een beschrijving over Alex.', 2);

INSERT INTO work_info (id, companys, jobtitles, period_of_employment, job_information, cv_id)
VALUES
    (1, 'TechCorp', 'Software Developer', '2015-2019', 'Ontwikkeling van diverse applicaties', 1),
    (2, 'WebSolutions', 'Web Developer', '2019-2022', 'Bouw en onderhoud van websites', 2),
    (3, 'DataFirm', 'Data Analyst', '2018-2021', 'Analyse van klantgegevens en trends', 2),
    (4, 'DesignCo', 'UX Designer', '2017-2020', 'Ontwerpen van gebruikersinterfaces', 1);

INSERT INTO personal_info (id, hobbys, period_of_hobby, hobby_info, cv_id)
VALUES
    (1, 'paardrijden', '2015-HEDEN', 'Ik vind het echt super leuk om te doen', 1),
    (2, 'schaken', '2021-HEDEN', 'zo leuk om te doen', 1),
    (3, 'zeilen', '2000-HEDEN', 'zal dit alijd blijven doen',2);

INSERT INTO study_info (id, education_institue, education, period_of_study, study_info, cv_id)
VALUES
    (1, 'Novi hogeschool', 'Full stack developer Bootcamp','2023-HEDEN', 'De leukste studie ooit', 1),
    (2, 'Hogeschool', 'Social Work','2008-2012', 'Een extra beschrijving wat voor studie dit is', 1),
    (3, 'Universiteit Utrecht', 'Antropologie','2012-2018', 'Wat kan je vertellen over antropologie', 2),
    (4, 'MBO Grafisch Lyceum', 'Multimedia vormgeven' ,'2006-2010','Een extra beschrijving wat voor studie dit is', 2);

-- WERKGEVER

INSERT INTO employers (id,companys, industries, office_addresses, office_adress_numbers, office_zipcode, office_city_locations, kvk_number, missions, visions, number_of_employees)

VALUES
    (1, 'TechCorp', 'IT', 'Technostraat 5', '5A', '1001AB', 'Amsterdam', '12345678', 'Onze missie is om technologie toegankelijk te maken voor iedereen.', 'Een wereld waarin technologie het dagelijks leven verbetert.', '500'),
    (2, 'GreenFields', 'Landbouw', 'Farmweg 12', '12B', '2002CD', 'Rotterdam', '23456789', 'We streven naar duurzame landbouw.', 'Een wereld waarin iedereen toegang heeft tot vers en duurzaam voedsel.', '150'),
    (3, 'FinanceGroup', 'Financiën', 'Bankplein 8', '8C', '3003DE', 'Utrecht', '34567890', 'Wij zetten ons in voor financiële transparantie.', 'Een wereld waarin financiële zekerheid voor iedereen toegankelijk is.', '250');


INSERT INTO job_info (id, Employer_id, job_descriptions, job_requirements, skills, educations, years_of_experience, job_offers, salary_indications, extras)
VALUES
    (1, 1, 'Ontwikkeling en onderhoud van webapplicaties.', 'Ervaring met Java en Spring Boot. Kennis van cloudtechnologieën.', 'Java, Spring Boot, AWS', 'HBO/WO Informatica of vergelijkbaar.', '3-5 jaar', 'Flexibele werktijden, mogelijkheid tot thuiswerken.', '€3000 - €5000', 'Bonusregeling, laptop van de zaak.'),
    (2, 2, 'Begeleiding van duurzame landbouwprojecten.', 'Kennis van duurzame landbouwtechnieken. Goede communicatieve vaardigheden.', 'Projectmanagement, Duurzaamheid', 'HBO/WO Landbouwkunde of vergelijkbaar.', '2-4 jaar', 'Mogelijkheid tot bijscholing. Reiskostenvergoeding.', '€2500 - €4000', 'Korting op biologische producten.'),
    (3, 3, 'Analyse en advisering op financieel gebied.', 'Ervaring met financiële analyse. Kennis van financiële software.', 'Excel, Financiële analyse', 'HBO/WO Bedrijfseconomie of vergelijkbaar.', '4-6 jaar', 'Mogelijkheid tot verdere specialisatie.', '€3500 - €6000', 'Pensioenregeling, jaarlijkse bonus.');
