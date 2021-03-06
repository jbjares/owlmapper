package com.jbjares.owlmapper.newmodel.to;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: Cause_of_death <br>
 * @version generated on Sun Jan 11 02:43:59 GMT 2015 by jbjares
 */

public interface Cause_of_death extends WrappedIndividual {

    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#DeathCauseOf
     */
     
    /**
     * Gets all property values for the death_cause_of property.<p>
     * 
     * @returns a collection of values for the death_cause_of property.
     */
    Collection<? extends Person> getDeath_cause_of();

    /**
     * Checks if the class has a death_cause_of property value.<p>
     * 
     * @return true if there is a death_cause_of property value.
     */
    boolean hasDeath_cause_of();

    /**
     * Adds a death_cause_of property value.<p>
     * 
     * @param newDeath_cause_of the death_cause_of property value to be added
     */
    void addDeath_cause_of(Person newDeath_cause_of);

    /**
     * Removes a death_cause_of property value.<p>
     * 
     * @param oldDeath_cause_of the death_cause_of property value to be removed.
     */
    void removeDeath_cause_of(Person oldDeath_cause_of);


    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#CauseIllnessDuration
     */
     
    /**
     * Gets all property values for the cause_of_death_and_duration_of_illness property.<p>
     * 
     * @returns a collection of values for the cause_of_death_and_duration_of_illness property.
     */
    Collection<? extends Object> getCause_of_death_and_duration_of_illness();

    /**
     * Checks if the class has a cause_of_death_and_duration_of_illness property value.<p>
     * 
     * @return true if there is a cause_of_death_and_duration_of_illness property value.
     */
    boolean hasCause_of_death_and_duration_of_illness();

    /**
     * Adds a cause_of_death_and_duration_of_illness property value.<p>
     * 
     * @param newCause_of_death_and_duration_of_illness the cause_of_death_and_duration_of_illness property value to be added
     */
    void addCause_of_death_and_duration_of_illness(Object newCause_of_death_and_duration_of_illness);

    /**
     * Removes a cause_of_death_and_duration_of_illness property value.<p>
     * 
     * @param oldCause_of_death_and_duration_of_illness the cause_of_death_and_duration_of_illness property value to be removed.
     */
    void removeCause_of_death_and_duration_of_illness(Object oldCause_of_death_and_duration_of_illness);



    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#cause
     */
     
    /**
     * Gets all property values for the cause_of_death property.<p>
     * 
     * @returns a collection of values for the cause_of_death property.
     */
    Collection<? extends Object> getCause_of_death();

    /**
     * Checks if the class has a cause_of_death property value.<p>
     * 
     * @return true if there is a cause_of_death property value.
     */
    boolean hasCause_of_death();

    /**
     * Adds a cause_of_death property value.<p>
     * 
     * @param newCause_of_death the cause_of_death property value to be added
     */
    void addCause_of_death(Object newCause_of_death);

    /**
     * Removes a cause_of_death property value.<p>
     * 
     * @param oldCause_of_death the cause_of_death property value to be removed.
     */
    void removeCause_of_death(Object oldCause_of_death);



    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#durIllness
     */
     
    /**
     * Gets all property values for the duration_of_illness property.<p>
     * 
     * @returns a collection of values for the duration_of_illness property.
     */
    Collection<? extends Object> getDuration_of_illness();

    /**
     * Checks if the class has a duration_of_illness property value.<p>
     * 
     * @return true if there is a duration_of_illness property value.
     */
    boolean hasDuration_of_illness();

    /**
     * Adds a duration_of_illness property value.<p>
     * 
     * @param newDuration_of_illness the duration_of_illness property value to be added
     */
    void addDuration_of_illness(Object newDuration_of_illness);

    /**
     * Removes a duration_of_illness property value.<p>
     * 
     * @param oldDuration_of_illness the duration_of_illness property value to be removed.
     */
    void removeDuration_of_illness(Object oldDuration_of_illness);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
