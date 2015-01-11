package com.jbjares.owlmapper.newmodel.to;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: County <br>
 * @version generated on Sun Jan 11 02:43:59 GMT 2015 by jbjares
 */

public interface County extends Place {

    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#countyOf
     */
     
    /**
     * Gets all property values for the county_of property.<p>
     * 
     * @returns a collection of values for the county_of property.
     */
    Collection<? extends Event> getCounty_of();

    /**
     * Checks if the class has a county_of property value.<p>
     * 
     * @return true if there is a county_of property value.
     */
    boolean hasCounty_of();

    /**
     * Adds a county_of property value.<p>
     * 
     * @param newCounty_of the county_of property value to be added
     */
    void addCounty_of(Event newCounty_of);

    /**
     * Removes a county_of property value.<p>
     * 
     * @param oldCounty_of the county_of property value to be removed.
     */
    void removeCounty_of(Event oldCounty_of);


    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#resdOfPerAtDeath
     */
     
    /**
     * Gets all property values for the residence_of_person_at_death property.<p>
     * 
     * @returns a collection of values for the residence_of_person_at_death property.
     */
    Collection<? extends Person> getResidence_of_person_at_death();

    /**
     * Checks if the class has a residence_of_person_at_death property value.<p>
     * 
     * @return true if there is a residence_of_person_at_death property value.
     */
    boolean hasResidence_of_person_at_death();

    /**
     * Adds a residence_of_person_at_death property value.<p>
     * 
     * @param newResidence_of_person_at_death the residence_of_person_at_death property value to be added
     */
    void addResidence_of_person_at_death(Person newResidence_of_person_at_death);

    /**
     * Removes a residence_of_person_at_death property value.<p>
     * 
     * @param oldResidence_of_person_at_death the residence_of_person_at_death property value to be removed.
     */
    void removeResidence_of_person_at_death(Person oldResidence_of_person_at_death);


    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#resdOfPerInfDeath
     */
     
    /**
     * Gets all property values for the _residence_of_Person_Informing_Death property.<p>
     * 
     * @returns a collection of values for the _residence_of_Person_Informing_Death property.
     */
    Collection<? extends Person> get_residence_of_Person_Informing_Death();

    /**
     * Checks if the class has a _residence_of_Person_Informing_Death property value.<p>
     * 
     * @return true if there is a _residence_of_Person_Informing_Death property value.
     */
    boolean has_residence_of_Person_Informing_Death();

    /**
     * Adds a _residence_of_Person_Informing_Death property value.<p>
     * 
     * @param new_residence_of_Person_Informing_Death the _residence_of_Person_Informing_Death property value to be added
     */
    void add_residence_of_Person_Informing_Death(Person new_residence_of_Person_Informing_Death);

    /**
     * Removes a _residence_of_Person_Informing_Death property value.<p>
     * 
     * @param old_residence_of_Person_Informing_Death the _residence_of_Person_Informing_Death property value to be removed.
     */
    void remove_residence_of_Person_Informing_Death(Person old_residence_of_Person_Informing_Death);


    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#CountryDesc
     */
     
    /**
     * Gets all property values for the country_desciption property.<p>
     * 
     * @returns a collection of values for the country_desciption property.
     */
    Collection<? extends Object> getCountry_desciption();

    /**
     * Checks if the class has a country_desciption property value.<p>
     * 
     * @return true if there is a country_desciption property value.
     */
    boolean hasCountry_desciption();

    /**
     * Adds a country_desciption property value.<p>
     * 
     * @param newCountry_desciption the country_desciption property value to be added
     */
    void addCountry_desciption(Object newCountry_desciption);

    /**
     * Removes a country_desciption property value.<p>
     * 
     * @param oldCountry_desciption the country_desciption property value to be removed.
     */
    void removeCountry_desciption(Object oldCountry_desciption);



    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#addressDesc
     */
     
    /**
     * Gets all property values for the address property.<p>
     * 
     * @returns a collection of values for the address property.
     */
    Collection<? extends Object> getAddress();

    /**
     * Checks if the class has a address property value.<p>
     * 
     * @return true if there is a address property value.
     */
    boolean hasAddress();

    /**
     * Adds a address property value.<p>
     * 
     * @param newAddress the address property value to be added
     */
    void addAddress(Object newAddress);

    /**
     * Removes a address property value.<p>
     * 
     * @param oldAddress the address property value to be removed.
     */
    void removeAddress(Object oldAddress);



    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#districtDesc
     */
     
    /**
     * Gets all property values for the district_desciption property.<p>
     * 
     * @returns a collection of values for the district_desciption property.
     */
    Collection<? extends Object> getDistrict_desciption();

    /**
     * Checks if the class has a district_desciption property value.<p>
     * 
     * @return true if there is a district_desciption property value.
     */
    boolean hasDistrict_desciption();

    /**
     * Adds a district_desciption property value.<p>
     * 
     * @param newDistrict_desciption the district_desciption property value to be added
     */
    void addDistrict_desciption(Object newDistrict_desciption);

    /**
     * Removes a district_desciption property value.<p>
     * 
     * @param oldDistrict_desciption the district_desciption property value to be removed.
     */
    void removeDistrict_desciption(Object oldDistrict_desciption);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
