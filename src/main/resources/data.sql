INSERT INTO jobseekers (id, first_name, sur_name, date_of_birth, email, phone_numbers, zipcodes, home_addresses, house_numbers)
VALUES
(1, 'John', 'Doe', '1986-05-04', 'johndoe@email.com','0632654897', '3423ET', 'destraat','54b'),
(2, 'Alex', 'Anders', '1996-02-01', 'alexanders@email.com', '+3165478954','3443ET', 'kerkstraat','321a');

INSERT INTO resumes (id,about_me, jobseeker_id)
VALUES
    -- aan dit id wordt de inof work, study en personal gekoppelt
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


