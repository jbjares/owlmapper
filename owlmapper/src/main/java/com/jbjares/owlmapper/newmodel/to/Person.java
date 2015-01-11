package com.jbjares.owlmapper.newmodel.to;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: Person <br>
 * @version generated on Sun Jan 11 02:43:59 GMT 2015 by jbjares
 */

public interface Person extends WrappedIndividual {

    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#deathIsInfBy
     */
     
    /**
     * Gets all property values for the death_is_informed_by property.<p>
     * 
     * @returns a collection of values for the death_is_informed_by property.
     */
    Collection<? extends Person> getDeath_is_informed_by();

    /**
     * Checks if the class has a death_is_informed_by property value.<p>
     * 
     * @return true if there is a death_is_informed_by property value.
     */
    boolean hasDeath_is_informed_by();

    /**
     * Adds a death_is_informed_by property value.<p>
     * 
     * @param newDeath_is_informed_by the death_is_informed_by property value to be added
     */
    void addDeath_is_informed_by(Person newDeath_is_informed_by);

    /**
     * Removes a death_is_informed_by property value.<p>
     * 
     * @param oldDeath_is_informed_by the death_is_informed_by property value to be removed.
     */
    void removeDeath_is_informed_by(Person oldDeath_is_informed_by);


    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#hasCauseOfDeath
     */
     
    /**
     * Gets all property values for the has_cause_of_death property.<p>
     * 
     * @returns a collection of values for the has_cause_of_death property.
     */
    Collection<? extends Cause_of_death> getHas_cause_of_death();

    /**
     * Checks if the class has a has_cause_of_death property value.<p>
     * 
     * @return true if there is a has_cause_of_death property value.
     */
    boolean hasHas_cause_of_death();

    /**
     * Adds a has_cause_of_death property value.<p>
     * 
     * @param newHas_cause_of_death the has_cause_of_death property value to be added
     */
    void addHas_cause_of_death(Cause_of_death newHas_cause_of_death);

    /**
     * Removes a has_cause_of_death property value.<p>
     * 
     * @param oldHas_cause_of_death the has_cause_of_death property value to be removed.
     */
    void removeHas_cause_of_death(Cause_of_death oldHas_cause_of_death);


    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#hasDeathRecord
     */
     
    /**
     * Gets all property values for the has_death_record property.<p>
     * 
     * @returns a collection of values for the has_death_record property.
     */
    Collection<? extends Death_event> getHas_death_record();

    /**
     * Checks if the class has a has_death_record property value.<p>
     * 
     * @return true if there is a has_death_record property value.
     */
    boolean hasHas_death_record();

    /**
     * Adds a has_death_record property value.<p>
     * 
     * @param newHas_death_record the has_death_record property value to be added
     */
    void addHas_death_record(Death_event newHas_death_record);

    /**
     * Removes a has_death_record property value.<p>
     * 
     * @param oldHas_death_record the has_death_record property value to be removed.
     */
    void removeHas_death_record(Death_event oldHas_death_record);


    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#hasInfDeathOf
     */
     
    /**
     * Gets all property values for the has_informed_the_death_of property.<p>
     * 
     * @returns a collection of values for the has_informed_the_death_of property.
     */
    Collection<? extends Person> getHas_informed_the_death_of();

    /**
     * Checks if the class has a has_informed_the_death_of property value.<p>
     * 
     * @return true if there is a has_informed_the_death_of property value.
     */
    boolean hasHas_informed_the_death_of();

    /**
     * Adds a has_informed_the_death_of property value.<p>
     * 
     * @param newHas_informed_the_death_of the has_informed_the_death_of property value to be added
     */
    void addHas_informed_the_death_of(Person newHas_informed_the_death_of);

    /**
     * Removes a has_informed_the_death_of property value.<p>
     * 
     * @param oldHas_informed_the_death_of the has_informed_the_death_of property value to be removed.
     */
    void removeHas_informed_the_death_of(Person oldHas_informed_the_death_of);


    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#hasRankAtDeath
     */
     
    /**
     * Gets all property values for the has_rank_at_death property.<p>
     * 
     * @returns a collection of values for the has_rank_at_death property.
     */
    Collection<? extends Rank> getHas_rank_at_death();

    /**
     * Checks if the class has a has_rank_at_death property value.<p>
     * 
     * @return true if there is a has_rank_at_death property value.
     */
    boolean hasHas_rank_at_death();

    /**
     * Adds a has_rank_at_death property value.<p>
     * 
     * @param newHas_rank_at_death the has_rank_at_death property value to be added
     */
    void addHas_rank_at_death(Rank newHas_rank_at_death);

    /**
     * Removes a has_rank_at_death property value.<p>
     * 
     * @param oldHas_rank_at_death the has_rank_at_death property value to be removed.
     */
    void removeHas_rank_at_death(Rank oldHas_rank_at_death);


    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#hasRegister
     */
     
    /**
     * Gets all property values for the has_register property.<p>
     * 
     * @returns a collection of values for the has_register property.
     */
    Collection<? extends Event> getHas_register();

    /**
     * Checks if the class has a has_register property value.<p>
     * 
     * @return true if there is a has_register property value.
     */
    boolean hasHas_register();

    /**
     * Adds a has_register property value.<p>
     * 
     * @param newHas_register the has_register property value to be added
     */
    void addHas_register(Event newHas_register);

    /**
     * Removes a has_register property value.<p>
     * 
     * @param oldHas_register the has_register property value to be removed.
     */
    void removeHas_register(Event oldHas_register);


    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#hasResdAtDeath
     */
     
    /**
     * Gets all property values for the has_residence_at_death property.<p>
     * 
     * @returns a collection of values for the has_residence_at_death property.
     */
    Collection<? extends Place> getHas_residence_at_death();

    /**
     * Checks if the class has a has_residence_at_death property value.<p>
     * 
     * @return true if there is a has_residence_at_death property value.
     */
    boolean hasHas_residence_at_death();

    /**
     * Adds a has_residence_at_death property value.<p>
     * 
     * @param newHas_residence_at_death the has_residence_at_death property value to be added
     */
    void addHas_residence_at_death(Place newHas_residence_at_death);

    /**
     * Removes a has_residence_at_death property value.<p>
     * 
     * @param oldHas_residence_at_death the has_residence_at_death property value to be removed.
     */
    void removeHas_residence_at_death(Place oldHas_residence_at_death);


    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#hasResdInfDeath
     */
     
    /**
     * Gets all property values for the has_residence_during_Informing_death property.<p>
     * 
     * @returns a collection of values for the has_residence_during_Informing_death property.
     */
    Collection<? extends Place> getHas_residence_during_Informing_death();

    /**
     * Checks if the class has a has_residence_during_Informing_death property value.<p>
     * 
     * @return true if there is a has_residence_during_Informing_death property value.
     */
    boolean hasHas_residence_during_Informing_death();

    /**
     * Adds a has_residence_during_Informing_death property value.<p>
     * 
     * @param newHas_residence_during_Informing_death the has_residence_during_Informing_death property value to be added
     */
    void addHas_residence_during_Informing_death(Place newHas_residence_during_Informing_death);

    /**
     * Removes a has_residence_during_Informing_death property value.<p>
     * 
     * @param oldHas_residence_during_Informing_death the has_residence_during_Informing_death property value to be removed.
     */
    void removeHas_residence_during_Informing_death(Place oldHas_residence_during_Informing_death);


    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#hasSigned
     */
     
    /**
     * Gets all property values for the has_signed property.<p>
     * 
     * @returns a collection of values for the has_signed property.
     */
    Collection<? extends Register_page> getHas_signed();

    /**
     * Checks if the class has a has_signed property value.<p>
     * 
     * @return true if there is a has_signed property value.
     */
    boolean hasHas_signed();

    /**
     * Adds a has_signed property value.<p>
     * 
     * @param newHas_signed the has_signed property value to be added
     */
    void addHas_signed(Register_page newHas_signed);

    /**
     * Removes a has_signed property value.<p>
     * 
     * @param oldHas_signed the has_signed property value to be removed.
     */
    void removeHas_signed(Register_page oldHas_signed);


    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#informs
     */
     
    /**
     * Gets all property values for the informs property.<p>
     * 
     * @returns a collection of values for the informs property.
     */
    Collection<? extends Event> getInforms();

    /**
     * Checks if the class has a informs property value.<p>
     * 
     * @return true if there is a informs property value.
     */
    boolean hasInforms();

    /**
     * Adds a informs property value.<p>
     * 
     * @param newInforms the informs property value to be added
     */
    void addInforms(Event newInforms);

    /**
     * Removes a informs property value.<p>
     * 
     * @param oldInforms the informs property value to be removed.
     */
    void removeInforms(Event oldInforms);


    /* ***************************************************
     * Property http://www.IRLontologies.ie/personOntology.owl#OWLObjectPropertyImpl_01420721646860402000
     */
     
    /**
     * Gets all property values for the has_district property.<p>
     * 
     * @returns a collection of values for the has_district property.
     */
    Collection<? extends District> getHas_district();

    /**
     * Checks if the class has a has_district property value.<p>
     * 
     * @return true if there is a has_district property value.
     */
    boolean hasHas_district();

    /**
     * Adds a has_district property value.<p>
     * 
     * @param newHas_district the has_district property value to be added
     */
    void addHas_district(District newHas_district);

    /**
     * Removes a has_district property value.<p>
     * 
     * @param oldHas_district the has_district property value to be removed.
     */
    void removeHas_district(District oldHas_district);


    /* ***************************************************
     * Property http://www.IRLontologies.ie/personOntology.owl#OWLObjectPropertyImpl_01420721646871238000
     */
     
    /**
     * Gets all property values for the has_child property.<p>
     * 
     * @returns a collection of values for the has_child property.
     */
    Collection<? extends Person> getHas_child();

    /**
     * Checks if the class has a has_child property value.<p>
     * 
     * @return true if there is a has_child property value.
     */
    boolean hasHas_child();

    /**
     * Adds a has_child property value.<p>
     * 
     * @param newHas_child the has_child property value to be added
     */
    void addHas_child(Person newHas_child);

    /**
     * Removes a has_child property value.<p>
     * 
     * @param oldHas_child the has_child property value to be removed.
     */
    void removeHas_child(Person oldHas_child);


    /* ***************************************************
     * Property http://www.IRLontologies.ie/personOntology.owl#OWLObjectPropertyImpl_01420721646877197000
     */
     
    /**
     * Gets all property values for the has_husband property.<p>
     * 
     * @returns a collection of values for the has_husband property.
     */
    Collection<? extends Person> getHas_husband();

    /**
     * Checks if the class has a has_husband property value.<p>
     * 
     * @return true if there is a has_husband property value.
     */
    boolean hasHas_husband();

    /**
     * Adds a has_husband property value.<p>
     * 
     * @param newHas_husband the has_husband property value to be added
     */
    void addHas_husband(Person newHas_husband);

    /**
     * Removes a has_husband property value.<p>
     * 
     * @param oldHas_husband the has_husband property value to be removed.
     */
    void removeHas_husband(Person oldHas_husband);


    /* ***************************************************
     * Property http://www.IRLontologies.ie/personOntology.owl#OWLObjectPropertyImpl_01420721646880075000
     */
     
    /**
     * Gets all property values for the has_wife property.<p>
     * 
     * @returns a collection of values for the has_wife property.
     */
    Collection<? extends Person> getHas_wife();

    /**
     * Checks if the class has a has_wife property value.<p>
     * 
     * @return true if there is a has_wife property value.
     */
    boolean hasHas_wife();

    /**
     * Adds a has_wife property value.<p>
     * 
     * @param newHas_wife the has_wife property value to be added
     */
    void addHas_wife(Person newHas_wife);

    /**
     * Removes a has_wife property value.<p>
     * 
     * @param oldHas_wife the has_wife property value to be removed.
     */
    void removeHas_wife(Person oldHas_wife);


    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#AgeAtLastBirthday
     */
     
    /**
     * Gets all property values for the age_at_last_birthday property.<p>
     * 
     * @returns a collection of values for the age_at_last_birthday property.
     */
    Collection<? extends Object> getAge_at_last_birthday();

    /**
     * Checks if the class has a age_at_last_birthday property value.<p>
     * 
     * @return true if there is a age_at_last_birthday property value.
     */
    boolean hasAge_at_last_birthday();

    /**
     * Adds a age_at_last_birthday property value.<p>
     * 
     * @param newAge_at_last_birthday the age_at_last_birthday property value to be added
     */
    void addAge_at_last_birthday(Object newAge_at_last_birthday);

    /**
     * Removes a age_at_last_birthday property value.<p>
     * 
     * @param oldAge_at_last_birthday the age_at_last_birthday property value to be removed.
     */
    void removeAge_at_last_birthday(Object oldAge_at_last_birthday);



    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#CondAtDeath
     */
     
    /**
     * Gets all property values for the condition_at_death property.<p>
     * 
     * @returns a collection of values for the condition_at_death property.
     */
    Collection<? extends Object> getCondition_at_death();

    /**
     * Checks if the class has a condition_at_death property value.<p>
     * 
     * @return true if there is a condition_at_death property value.
     */
    boolean hasCondition_at_death();

    /**
     * Adds a condition_at_death property value.<p>
     * 
     * @param newCondition_at_death the condition_at_death property value to be added
     */
    void addCondition_at_death(Object newCondition_at_death);

    /**
     * Removes a condition_at_death property value.<p>
     * 
     * @param oldCondition_at_death the condition_at_death property value to be removed.
     */
    void removeCondition_at_death(Object oldCondition_at_death);



    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#dateOfDeath
     */
     
    /**
     * Gets all property values for the date_of_death property.<p>
     * 
     * @returns a collection of values for the date_of_death property.
     */
    Collection<? extends Object> getDate_of_death();

    /**
     * Checks if the class has a date_of_death property value.<p>
     * 
     * @return true if there is a date_of_death property value.
     */
    boolean hasDate_of_death();

    /**
     * Adds a date_of_death property value.<p>
     * 
     * @param newDate_of_death the date_of_death property value to be added
     */
    void addDate_of_death(Object newDate_of_death);

    /**
     * Removes a date_of_death property value.<p>
     * 
     * @param oldDate_of_death the date_of_death property value to be removed.
     */
    void removeDate_of_death(Object oldDate_of_death);



    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#forename
     */
     
    /**
     * Gets all property values for the forename property.<p>
     * 
     * @returns a collection of values for the forename property.
     */
    Collection<? extends Object> getForename();

    /**
     * Checks if the class has a forename property value.<p>
     * 
     * @return true if there is a forename property value.
     */
    boolean hasForename();

    /**
     * Adds a forename property value.<p>
     * 
     * @param newForename the forename property value to be added
     */
    void addForename(Object newForename);

    /**
     * Removes a forename property value.<p>
     * 
     * @param oldForename the forename property value to be removed.
     */
    void removeForename(Object oldForename);



    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#sex
     */
     
    /**
     * Gets all property values for the sex property.<p>
     * 
     * @returns a collection of values for the sex property.
     */
    Collection<? extends Object> getSex();

    /**
     * Checks if the class has a sex property value.<p>
     * 
     * @return true if there is a sex property value.
     */
    boolean hasSex();

    /**
     * Adds a sex property value.<p>
     * 
     * @param newSex the sex property value to be added
     */
    void addSex(Object newSex);

    /**
     * Removes a sex property value.<p>
     * 
     * @param oldSex the sex property value to be removed.
     */
    void removeSex(Object oldSex);



    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#surname
     */
     
    /**
     * Gets all property values for the surname property.<p>
     * 
     * @returns a collection of values for the surname property.
     */
    Collection<? extends Object> getSurname();

    /**
     * Checks if the class has a surname property value.<p>
     * 
     * @return true if there is a surname property value.
     */
    boolean hasSurname();

    /**
     * Adds a surname property value.<p>
     * 
     * @param newSurname the surname property value to be added
     */
    void addSurname(Object newSurname);

    /**
     * Removes a surname property value.<p>
     * 
     * @param oldSurname the surname property value to be removed.
     */
    void removeSurname(Object oldSurname);



    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#titleOfReg
     */
     
    /**
     * Gets all property values for the titleOfReg property.<p>
     * 
     * @returns a collection of values for the titleOfReg property.
     */
    Collection<? extends Object> getTitleOfReg();

    /**
     * Checks if the class has a titleOfReg property value.<p>
     * 
     * @return true if there is a titleOfReg property value.
     */
    boolean hasTitleOfReg();

    /**
     * Adds a titleOfReg property value.<p>
     * 
     * @param newTitleOfReg the titleOfReg property value to be added
     */
    void addTitleOfReg(Object newTitleOfReg);

    /**
     * Removes a titleOfReg property value.<p>
     * 
     * @param oldTitleOfReg the titleOfReg property value to be removed.
     */
    void removeTitleOfReg(Object oldTitleOfReg);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
