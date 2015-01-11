package com.jbjares.owlmapper.newmodel.to;

import java.util.Collection;

import org.protege.owl.codegeneration.WrappedIndividual;

import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLOntology;

/**
 * 
 * <p>
 * Generated by Protege (http://protege.stanford.edu). <br>
 * Source Class: Rank <br>
 * @version generated on Sun Jan 11 02:43:59 GMT 2015 by jbjares
 */

public interface Rank extends WrappedIndividual {

    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#rankPerAtDeath
     */
     
    /**
     * Gets all property values for the rank_of_person_at_death property.<p>
     * 
     * @returns a collection of values for the rank_of_person_at_death property.
     */
    Collection<? extends Person> getRank_of_person_at_death();

    /**
     * Checks if the class has a rank_of_person_at_death property value.<p>
     * 
     * @return true if there is a rank_of_person_at_death property value.
     */
    boolean hasRank_of_person_at_death();

    /**
     * Adds a rank_of_person_at_death property value.<p>
     * 
     * @param newRank_of_person_at_death the rank_of_person_at_death property value to be added
     */
    void addRank_of_person_at_death(Person newRank_of_person_at_death);

    /**
     * Removes a rank_of_person_at_death property value.<p>
     * 
     * @param oldRank_of_person_at_death the rank_of_person_at_death property value to be removed.
     */
    void removeRank_of_person_at_death(Person oldRank_of_person_at_death);


    /* ***************************************************
     * Property http://www.IRLontologies.ie/historicalEvents.owl#rankDesc
     */
     
    /**
     * Gets all property values for the rank property.<p>
     * 
     * @returns a collection of values for the rank property.
     */
    Collection<? extends Object> getRank();

    /**
     * Checks if the class has a rank property value.<p>
     * 
     * @return true if there is a rank property value.
     */
    boolean hasRank();

    /**
     * Adds a rank property value.<p>
     * 
     * @param newRank the rank property value to be added
     */
    void addRank(Object newRank);

    /**
     * Removes a rank property value.<p>
     * 
     * @param oldRank the rank property value to be removed.
     */
    void removeRank(Object oldRank);



    /* ***************************************************
     * Common interfaces
     */

    OWLNamedIndividual getOwlIndividual();

    OWLOntology getOwlOntology();

    void delete();

}
