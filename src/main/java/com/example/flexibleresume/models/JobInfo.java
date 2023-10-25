package com.example.flexibleresume.models;


import jakarta.persistence.*;

@Entity
@Table(name = "job_info")
public class JobInfo {

    @Id
    @GeneratedValue
    private Long id;

    //    bedrijf / company ←- koppelen met employer ? onetomany
    //    Branch / industry ... zelfde als hierovern.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Employer_id")
    private Employer employer;

    @Column(name = "job_descriptions", length=1000)
    private String jobDescription;

    @Column(name = "job_requirements", length = 1000)  // de functie omschrijven kan opgedeeld worden in meedere colommen. voor nu is het 1 bericht / alinea naar wens van de werkgever.
    private String jobRequirements;
    // TODO de functie omschrijving uitwerken in meedere colommen. Welke skills, opleiding, jaar ervaring is gewenst. etc
    @Column(name = "job_offers", length = 1000)
    private String jobOffer;
    // TODO de functie job_offer uitwerken in meedere colommen. Wat is het salaris, auto van de zaak? thuiswerken mogelijk?


}
