package com.jbjares.owlmapper.newmodel.to;

import com.jbjares.owlmapper.newmodel.to.impl.*;

import java.util.Collection;

import org.protege.owl.codegeneration.CodeGenerationFactory;
import org.protege.owl.codegeneration.WrappedIndividual;
import org.protege.owl.codegeneration.impl.FactoryHelper;
import org.protege.owl.codegeneration.impl.ProtegeJavaMapping;
import org.protege.owl.codegeneration.inference.CodeGenerationInference;
import org.protege.owl.codegeneration.inference.SimpleInference;

import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

/**
 * A class that serves as the entry point to the generated code providing access
 * to existing individuals in the ontology and the ability to create new individuals in the ontology.<p>
 * 
 * Generated by Protege (http://protege.stanford.edu).<br>
 * Source Class: MyFactory<br>
 * @version generated on Sun Jan 11 02:43:59 GMT 2015 by jbjares
 */
public class MyFactory implements CodeGenerationFactory {
    private OWLOntology ontology;
    private ProtegeJavaMapping javaMapping = new ProtegeJavaMapping();
    private FactoryHelper delegate;
    private CodeGenerationInference inference;

    public MyFactory(OWLOntology ontology) {
	    this(ontology, new SimpleInference(ontology));
    }
    
    public MyFactory(OWLOntology ontology, CodeGenerationInference inference) {
        this.ontology = ontology;
        this.inference = inference;
        javaMapping.initialize(ontology, inference);
        delegate = new FactoryHelper(ontology, inference);
    }

    public OWLOntology getOwlOntology() {
        return ontology;
    }
    
    public void saveOwlOntology() throws OWLOntologyStorageException {
        ontology.getOWLOntologyManager().saveOntology(ontology);
    }
    
    public void flushOwlReasoner() {
        delegate.flushOwlReasoner();
    }
    
    public boolean canAs(WrappedIndividual resource, Class<? extends WrappedIndividual> javaInterface) {
    	return javaMapping.canAs(resource, javaInterface);
    }
    
    public  <X extends WrappedIndividual> X as(WrappedIndividual resource, Class<? extends X> javaInterface) {
    	return javaMapping.as(resource, javaInterface);
    }
    
    public Class<?> getJavaInterfaceFromOwlClass(OWLClass cls) {
        return javaMapping.getJavaInterfaceFromOwlClass(cls);
    }
    
    public OWLClass getOwlClassFromJavaInterface(Class<?> javaInterface) {
	    return javaMapping.getOwlClassFromJavaInterface(javaInterface);
    }
    
    public CodeGenerationInference getInference() {
        return inference;
    }

    /* ***************************************************
     * Class http://www.IRLontologies.ie/historicalEvents.owl#Address
     */

    {
        javaMapping.add("http://www.IRLontologies.ie/historicalEvents.owl#Address", Address.class, DefaultAddress.class);
    }

    /**
     * Creates an instance of type Address.  Modifies the underlying ontology.
     */
    public Address createAddress(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_ADDRESS, DefaultAddress.class);
    }

    /**
     * Gets an instance of type Address with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Address getAddress(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_ADDRESS, DefaultAddress.class);
    }

    /**
     * Gets all instances of Address from the ontology.
     */
    public Collection<? extends Address> getAllAddressInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_ADDRESS, DefaultAddress.class);
    }


    /* ***************************************************
     * Class http://www.IRLontologies.ie/historicalEvents.owl#BirthEvent
     */

    {
        javaMapping.add("http://www.IRLontologies.ie/historicalEvents.owl#BirthEvent", Birth_event.class, DefaultBirth_event.class);
    }

    /**
     * Creates an instance of type Birth_event.  Modifies the underlying ontology.
     */
    public Birth_event createBirth_event(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_BIRTH_EVENT, DefaultBirth_event.class);
    }

    /**
     * Gets an instance of type Birth_event with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Birth_event getBirth_event(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_BIRTH_EVENT, DefaultBirth_event.class);
    }

    /**
     * Gets all instances of Birth_event from the ontology.
     */
    public Collection<? extends Birth_event> getAllBirth_eventInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_BIRTH_EVENT, DefaultBirth_event.class);
    }


    /* ***************************************************
     * Class http://www.IRLontologies.ie/historicalEvents.owl#CauseOfDeath
     */

    {
        javaMapping.add("http://www.IRLontologies.ie/historicalEvents.owl#CauseOfDeath", Cause_of_death.class, DefaultCause_of_death.class);
    }

    /**
     * Creates an instance of type Cause_of_death.  Modifies the underlying ontology.
     */
    public Cause_of_death createCause_of_death(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_CAUSE_OF_DEATH, DefaultCause_of_death.class);
    }

    /**
     * Gets an instance of type Cause_of_death with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Cause_of_death getCause_of_death(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_CAUSE_OF_DEATH, DefaultCause_of_death.class);
    }

    /**
     * Gets all instances of Cause_of_death from the ontology.
     */
    public Collection<? extends Cause_of_death> getAllCause_of_deathInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_CAUSE_OF_DEATH, DefaultCause_of_death.class);
    }


    /* ***************************************************
     * Class http://www.IRLontologies.ie/historicalEvents.owl#County
     */

    {
        javaMapping.add("http://www.IRLontologies.ie/historicalEvents.owl#County", County.class, DefaultCounty.class);
    }

    /**
     * Creates an instance of type County.  Modifies the underlying ontology.
     */
    public County createCounty(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_COUNTY, DefaultCounty.class);
    }

    /**
     * Gets an instance of type County with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public County getCounty(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_COUNTY, DefaultCounty.class);
    }

    /**
     * Gets all instances of County from the ontology.
     */
    public Collection<? extends County> getAllCountyInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_COUNTY, DefaultCounty.class);
    }


    /* ***************************************************
     * Class http://www.IRLontologies.ie/historicalEvents.owl#DeathEvent
     */

    {
        javaMapping.add("http://www.IRLontologies.ie/historicalEvents.owl#DeathEvent", Death_event.class, DefaultDeath_event.class);
    }

    /**
     * Creates an instance of type Death_event.  Modifies the underlying ontology.
     */
    public Death_event createDeath_event(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_DEATH_EVENT, DefaultDeath_event.class);
    }

    /**
     * Gets an instance of type Death_event with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Death_event getDeath_event(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_DEATH_EVENT, DefaultDeath_event.class);
    }

    /**
     * Gets all instances of Death_event from the ontology.
     */
    public Collection<? extends Death_event> getAllDeath_eventInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_DEATH_EVENT, DefaultDeath_event.class);
    }


    /* ***************************************************
     * Class http://www.IRLontologies.ie/historicalEvents.owl#District
     */

    {
        javaMapping.add("http://www.IRLontologies.ie/historicalEvents.owl#District", District.class, DefaultDistrict.class);
    }

    /**
     * Creates an instance of type District.  Modifies the underlying ontology.
     */
    public District createDistrict(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_DISTRICT, DefaultDistrict.class);
    }

    /**
     * Gets an instance of type District with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public District getDistrict(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_DISTRICT, DefaultDistrict.class);
    }

    /**
     * Gets all instances of District from the ontology.
     */
    public Collection<? extends District> getAllDistrictInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_DISTRICT, DefaultDistrict.class);
    }


    /* ***************************************************
     * Class http://www.IRLontologies.ie/historicalEvents.owl#Event
     */

    {
        javaMapping.add("http://www.IRLontologies.ie/historicalEvents.owl#Event", Event.class, DefaultEvent.class);
    }

    /**
     * Creates an instance of type Event.  Modifies the underlying ontology.
     */
    public Event createEvent(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_EVENT, DefaultEvent.class);
    }

    /**
     * Gets an instance of type Event with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Event getEvent(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_EVENT, DefaultEvent.class);
    }

    /**
     * Gets all instances of Event from the ontology.
     */
    public Collection<? extends Event> getAllEventInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_EVENT, DefaultEvent.class);
    }


    /* ***************************************************
     * Class http://www.IRLontologies.ie/historicalEvents.owl#MarriageEvent
     */

    {
        javaMapping.add("http://www.IRLontologies.ie/historicalEvents.owl#MarriageEvent", Marriage_event.class, DefaultMarriage_event.class);
    }

    /**
     * Creates an instance of type Marriage_event.  Modifies the underlying ontology.
     */
    public Marriage_event createMarriage_event(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_MARRIAGE_EVENT, DefaultMarriage_event.class);
    }

    /**
     * Gets an instance of type Marriage_event with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Marriage_event getMarriage_event(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_MARRIAGE_EVENT, DefaultMarriage_event.class);
    }

    /**
     * Gets all instances of Marriage_event from the ontology.
     */
    public Collection<? extends Marriage_event> getAllMarriage_eventInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_MARRIAGE_EVENT, DefaultMarriage_event.class);
    }


    /* ***************************************************
     * Class http://www.IRLontologies.ie/historicalEvents.owl#Person
     */

    {
        javaMapping.add("http://www.IRLontologies.ie/historicalEvents.owl#Person", Person.class, DefaultPerson.class);
    }

    /**
     * Creates an instance of type Person.  Modifies the underlying ontology.
     */
    public Person createPerson(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_PERSON, DefaultPerson.class);
    }

    /**
     * Gets an instance of type Person with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Person getPerson(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_PERSON, DefaultPerson.class);
    }

    /**
     * Gets all instances of Person from the ontology.
     */
    public Collection<? extends Person> getAllPersonInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_PERSON, DefaultPerson.class);
    }


    /* ***************************************************
     * Class http://www.IRLontologies.ie/historicalEvents.owl#Place
     */

    {
        javaMapping.add("http://www.IRLontologies.ie/historicalEvents.owl#Place", Place.class, DefaultPlace.class);
    }

    /**
     * Creates an instance of type Place.  Modifies the underlying ontology.
     */
    public Place createPlace(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_PLACE, DefaultPlace.class);
    }

    /**
     * Gets an instance of type Place with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Place getPlace(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_PLACE, DefaultPlace.class);
    }

    /**
     * Gets all instances of Place from the ontology.
     */
    public Collection<? extends Place> getAllPlaceInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_PLACE, DefaultPlace.class);
    }


    /* ***************************************************
     * Class http://www.IRLontologies.ie/historicalEvents.owl#Rank
     */

    {
        javaMapping.add("http://www.IRLontologies.ie/historicalEvents.owl#Rank", Rank.class, DefaultRank.class);
    }

    /**
     * Creates an instance of type Rank.  Modifies the underlying ontology.
     */
    public Rank createRank(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_RANK, DefaultRank.class);
    }

    /**
     * Gets an instance of type Rank with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Rank getRank(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_RANK, DefaultRank.class);
    }

    /**
     * Gets all instances of Rank from the ontology.
     */
    public Collection<? extends Rank> getAllRankInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_RANK, DefaultRank.class);
    }


    /* ***************************************************
     * Class http://www.IRLontologies.ie/historicalEvents.owl#RegisterPage
     */

    {
        javaMapping.add("http://www.IRLontologies.ie/historicalEvents.owl#RegisterPage", Register_page.class, DefaultRegister_page.class);
    }

    /**
     * Creates an instance of type Register_page.  Modifies the underlying ontology.
     */
    public Register_page createRegister_page(String name) {
		return delegate.createWrappedIndividual(name, Vocabulary.CLASS_REGISTER_PAGE, DefaultRegister_page.class);
    }

    /**
     * Gets an instance of type Register_page with the given name.  Does not modify the underlying ontology.
     * @param name the name of the OWL named individual to be retrieved.
     */
    public Register_page getRegister_page(String name) {
		return delegate.getWrappedIndividual(name, Vocabulary.CLASS_REGISTER_PAGE, DefaultRegister_page.class);
    }

    /**
     * Gets all instances of Register_page from the ontology.
     */
    public Collection<? extends Register_page> getAllRegister_pageInstances() {
		return delegate.getWrappedIndividuals(Vocabulary.CLASS_REGISTER_PAGE, DefaultRegister_page.class);
    }


}
