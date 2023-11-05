-- WERKZOEKDENDE
INSERT INTO jobseekers (id, first_name, sur_name, date_of_birth, email, phone_numbers, home_towns, zipcodes, home_addresses, house_numbers)
VALUES
    (1, 'John', 'Doe', '1986-05-04', 'johndoe@email.com', '0632654897', 'Amsterdam', '3423ET', 'destraat', '54b'),
    (2, 'Alex', 'Anders', '1996-02-01', 'alexanders@email.com', '0654789545', 'Rotterdam', '3443ET', 'kerkstraat', '321a'),
    (3, 'Lisa', 'Vermeer', '1990-10-10', 'lisavermeer@email.com', '0623564789', 'Utrecht', '3564GH', 'prinsengracht', '45d'),
    (4, 'Tom', 'Jansen', '1980-01-20', 'tomjansen@email.com', '0600547895', 'Den Haag', '2532ZX', 'koningslaan', '78f');

INSERT INTO resumes (id, about_me, jobseeker_id)
VALUES
    (1, 'Gepassioneerde developer met 5 jaar ervaring in Java en Spring Framework. Op zoek naar uitdagende rollen in een dynamisch team.', 1),
    (2, 'Digital marketeer met 3 jaar ervaring in SEO en content creatie. Zoekt naar mogelijkheden om te groeien in een data-gedreven organisatie.', 2),
    (3, 'Net afgestudeerd in software engineering. Sterke fundamenten in Python en Django. Zoekt naar een instaprol als junior developer.', 3),
    (4, 'Ervaring in projectmanagement en teamleiding gedurende 7 jaar. Op zoek naar operationele en strategische rollen in tech bedrijven.', 4);

INSERT INTO work_info (id, companys, jobtitles, period_of_employment, job_information, cv_id)
VALUES
    (1, 'Tech Solutions', 'Java Developer', '2017-2021', 'Ontwikkelde nieuwe features voor een e-commerce platform en werkte samen in een team van 5 developers.', 1),
    (2, 'Digital Wave', 'SEO Specialist', '2019-2022', 'Optimaliseerde de website voor zoekmachines en verhoogde het verkeer met 30% in één jaar.', 2),
    (3, 'Startup Hub', 'Intern Developer', '2020-2021', 'Werkte aan een nieuwe mobile app met een team en leerde veel over agile methodologieën.', 3),
    (4, 'Business Corp', 'Project Manager', '2014-2021', 'Leidde meerdere teams voor verschillende projecten en behaalde alle projectdoelstellingen binnen de tijd en het budget.', 4);


INSERT INTO personal_info (id, hobbys, period_of_hobby, hobby_info, cv_id)
VALUES
    (1, 'Schilderen', '2010-2023', 'Ik hou ervan om landschappen en portretten te schilderen in mijn vrije tijd. Ik heb meerdere kunstshows bijgewoond.', 1),
    (2, 'Gitaar spelen', '2015-2023', 'Ik speel gitaar in een lokale band en treed regelmatig op in cafés en muziekevenementen.', 2),
    (3, 'Hardlopen', '2018-2023', 'Ik heb deelgenomen aan verschillende marathons en werk voortdurend aan het verbeteren van mijn persoonlijke beste tijd.', 3),
    (4, 'Fotografie', '2012-2023', 'Fotografie is een passie van mij, vooral natuurfotografie. Ik heb een collectie van meer dan 1000 fotos.', 4);


INSERT INTO study_info (id, education_institue, education, period_of_study, study_info, cv_id)
VALUES
    (1, 'Universiteit van Amsterdam', 'Bachelor Informatica', '2010-2013', 'Gespecialiseerd in softwareontwikkeling en data-analyse.', 1),
    (2, 'Hogeschool Rotterdam', 'Master Software Engineering', '2014-2016', 'Diepgaande studie over geavanceerde softwarearchitecturen en ontwerppatronen.', 2),
    (3, 'Universiteit Utrecht', 'Bachelor Kunstmatige Intelligentie', '2011-2014', 'Studie over machine learning, neurale netwerken en cognitieve wetenschappen.', 3),
    (4, 'Technische Universiteit Eindhoven', 'PhD Informatica', '2016-2020', 'Onderzoek naar geoptimaliseerde algoritmen voor dataverwerking in cloudomgevingen.', 4);


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


-- SECURITY TEST

INSERT INTO users (id, firstname, lastname, email, password, role)
VALUES
    (100,'John', 'Doe', 'johndoe@mail.com', '1234', 'USER');
