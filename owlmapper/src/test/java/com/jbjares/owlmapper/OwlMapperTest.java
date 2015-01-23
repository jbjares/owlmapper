package com.jbjares.owlmapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.StringUtils;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.lang.PipedRDFIterator;
import org.apache.jena.riot.lang.PipedRDFStream;
import org.apache.jena.riot.lang.PipedTriplesStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.Assert;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.jbjares.owlmapper.jena.IJenaModelService;
import com.jbjares.owlmapper.newmodel.to.Address;
import com.jbjares.owlmapper.newmodel.to.Cause_of_death;
import com.jbjares.owlmapper.newmodel.to.County;
import com.jbjares.owlmapper.newmodel.to.Death_event;
import com.jbjares.owlmapper.newmodel.to.District;
import com.jbjares.owlmapper.newmodel.to.MyFactory;
import com.jbjares.owlmapper.newmodel.to.Person;
import com.jbjares.owlmapper.newmodel.to.Rank;
import com.jbjares.owlmapper.newmodel.to.Register_page;
import com.jbjares.owlmapper.to.DeathTO;
import com.jbjares.owlmapper.to.InputDataSampleTO;
import com.jbjares.owlmapper.to.SpreadDeathTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:owlmapper-applicationContext.xml" })
public class OwlMapperTest {

	private static final String NS = "http://www.IRLontologies.ie/historicalEvents.owl#";
	@Autowired
	private IJenaModelService jenaModelSource;


	@Test
	public void assertNotNullJenaModelService() {
		Assert.assertNotNull(jenaModelSource);
		
	}
	
	@Test
	public void mapperTest() throws Exception {
		InputDataSampleTO inputDataSampleTO = parseTTLSourceTOObject();
		Assert.assertNotNull(inputDataSampleTO);
		Assert.assertNotSame(Collections.EMPTY_LIST,inputDataSampleTO.getSpread_deaths());
		for(SpreadDeathTO spread: inputDataSampleTO.getSpread_deaths()){
			Assert.assertNotSame(Collections.EMPTY_LIST,spread.getDeaths());	
		}
		executeMapper(inputDataSampleTO);
	}

	private void executeMapper(InputDataSampleTO inputDataSampleTO) throws OWLOntologyCreationException, OWLOntologyStorageException, FileNotFoundException {
		OWLOntologyManager owlOntologyManager = OWLManager.createOWLOntologyManager();
		OWLOntology onto = owlOntologyManager.loadOntologyFromOntologyDocument(new File("src/test/resources/baseIRLontology-v0.3.owl"));
		System.out.println(onto.getLogicalAxiomCount());
		MyFactory factory = new MyFactory(onto);
		Assert.assertNotNull(factory);
		
		//owlOntologyManager.saveOntology(arg0, arg1);
		
		
		for(SpreadDeathTO spread:inputDataSampleTO.getSpread_deaths()){
			

			for(DeathTO death:spread.getDeaths()){
				UUID uuid = UUID.randomUUID();
				String uuidLong = uuid.toString();				/**
				 *  #4 different person individual, #
					##2 address individual, #
					##one rank individual, #
					##one cause of death individual; #
					##one death event individual,# 
					##one county individual,#
					##two district individual, #
					##one register page individual. #
				 */
				
				//one register page individual
				Register_page registerPage = createRegisterPage(spread,death,factory,uuidLong);
				//two district individual
				District districtEvent = createDistrictForEvent(spread,death,factory,uuidLong);
				District districtForDeathPerson = createDistrictForSubjectIndividualPerson(spread,death,factory,uuidLong);
				//one county individual
				County countyOfEvent = createCountyEvent(spread,death,factory,uuidLong);
				//one death event individual
				Death_event deathEvent = createDeathEvent(spread,death,factory,registerPage,districtEvent,countyOfEvent,uuidLong);
				//one cause of death individual
				Cause_of_death causeOfDeathForDeathPerson = createCauseOfDeathForDeathPerson(spread,death,factory,uuidLong);
				//one rank individual
				Rank rankForDeathPerson = createRankForDeathPerson(spread,death,factory,uuidLong);
				//2 address individual
				Address residenceOfDeathForDeathPerson = createResidenceOfDeathAddress(spread,death,factory,uuidLong);
				Address residenceOfDeathForInformantPerson = createResidenceOfDeathAddress(spread,death,factory,uuidLong);
				
				
				//4 different person individual
				
				//SuperIntendent
				Person superIntendentPerson = createSuperIntendentPersonPerson(spread,death,factory,districtEvent,uuidLong);
				registerPage.addSigned_by(superIntendentPerson);
				
				//Registrar Person
				Person registrarPerson = createRegistrarPerson(spread,death,factory,deathEvent,uuidLong);
				deathEvent.addRegistered_by(registrarPerson);
				
				//Subject To Death Event
				Person informedThedeathEventPerson = createInformedThedeathEventPerson(spread,death,factory,
						residenceOfDeathForInformantPerson,deathEvent,uuidLong);
				
				//Informed The Death Event
				Person subjectToDeathEventPerson = createSujectToDeathEventPerson(spread,death,factory,rankForDeathPerson,residenceOfDeathForDeathPerson,
						causeOfDeathForDeathPerson,deathEvent,informedThedeathEventPerson,districtForDeathPerson,uuidLong);
				informedThedeathEventPerson.addHas_informed_the_death_of(subjectToDeathEventPerson);
				
				
				//onto.accept(superIntendentPerson.getOwlOntology());
				owlOntologyManager.saveOntology(superIntendentPerson.getOwlOntology(), new FileOutputStream(new File("src/test/resources/subjectToDeathEventPerson.rdf")));
				owlOntologyManager.saveOntology(superIntendentPerson.getOwlOntology(), new FileOutputStream(new File("src/test/resources/informedThedeathEventPerson.rdf")));
				owlOntologyManager.saveOntology(superIntendentPerson.getOwlOntology(), new FileOutputStream(new File("src/test/resources/registrarPerson.rdf")));
				owlOntologyManager.saveOntology(superIntendentPerson.getOwlOntology(), new FileOutputStream(new File("src/test/resources/superIntendentPerson.rdf")));
				
				
				
				
			}
			
		}
		
		
		
	}



	private Address createResidenceOfDeathAddress(SpreadDeathTO spread,
			DeathTO death, MyFactory factory, String uuidLong) {
		Address address = factory.createAddress(NS+"ResidenceOfDeathAddress_"+uuidLong);
		address.addAddress(death.getAddress());
		return address;
	}

	private Rank createRankForDeathPerson(SpreadDeathTO spread, DeathTO death,MyFactory factory, String uuidLong) {
		Rank rankTosubjectToDeathEventPerson = factory.createRank(NS+"Rank_"+uuidLong);
		//death.getRankProfessionOrOccupation()
		if(death.getRankProfessionOrOccupation()==null){
			rankTosubjectToDeathEventPerson.addRank("_:b");
		}else{
			rankTosubjectToDeathEventPerson.addRank(death.getRankProfessionOrOccupation());
		}
		return rankTosubjectToDeathEventPerson;
	}

	private Cause_of_death createCauseOfDeathForDeathPerson(SpreadDeathTO spread, DeathTO death, MyFactory factory, String uuidLong) {
		//CauseOfDeath
		Cause_of_death causeTosubjectToDeathEventPerson = factory.createCause_of_death(NS+"CauseOfDeath_"+uuidLong);
		causeTosubjectToDeathEventPerson.addCause_of_death(death.getCauseOfDeath());
		
		Set causeTosubjectToDeathEventPersonSet = ((Set)causeTosubjectToDeathEventPerson.getCause_of_death_and_duration_of_illness());
		if(causeTosubjectToDeathEventPersonSet!=null && !causeTosubjectToDeathEventPersonSet.isEmpty()){
			causeTosubjectToDeathEventPerson.addCause_of_death_and_duration_of_illness(causeTosubjectToDeathEventPersonSet);
		}
		
		Set duration_of_illness = ((Set)causeTosubjectToDeathEventPerson.getDuration_of_illness());
		if(duration_of_illness!=null && !duration_of_illness.isEmpty()){
			causeTosubjectToDeathEventPerson.addCause_of_death_and_duration_of_illness(duration_of_illness);
		}
		
		return causeTosubjectToDeathEventPerson;
	}

	private Death_event createDeathEvent(SpreadDeathTO spread, DeathTO death,MyFactory factory, Register_page registerPage, District districtEvent, County countyOfEvent, String uuidLong) {
		//##Death_event
		Death_event deathEnventToSubjectToDeathEventPerson = factory.createDeath_event(NS+"DeathEvent_"+uuidLong);
		deathEnventToSubjectToDeathEventPerson.addPlace_of_death(death.getPlaceOfDeath());
		deathEnventToSubjectToDeathEventPerson.addWith_death_certification_status(death.getDeathCertification());
		deathEnventToSubjectToDeathEventPerson.addQualification_of_informant(death.getQualificationOfInformant());
		deathEnventToSubjectToDeathEventPerson.addPlace_of_death(death.getPlaceOfDeath());
		deathEnventToSubjectToDeathEventPerson.addDate_of_registration(death.getDateOfRegistration());
		//###CountryDesc
		deathEnventToSubjectToDeathEventPerson.addHas_county(countyOfEvent);
		//###districtDesc
		deathEnventToSubjectToDeathEventPerson.addHas_district(districtEvent);
		//###Register Page
		deathEnventToSubjectToDeathEventPerson.addHas_register_page(registerPage);
		return deathEnventToSubjectToDeathEventPerson;
	}

	private County createCountyEvent(SpreadDeathTO spread, DeathTO death,MyFactory factory, String uuidLong) {
		//County
		County countySubjectToDeathEventPerson = factory.createCounty(NS+"County_"+uuidLong);
		countySubjectToDeathEventPerson.addCountry_desciption(spread.getCounty());
		return countySubjectToDeathEventPerson;
	}

	private District createDistrictForEvent(SpreadDeathTO spread,DeathTO death, MyFactory factory, String uuidLong) {
		District districtOfIndividualOfDeath = factory.createDistrict(NS+"District_"+uuidLong);
		districtOfIndividualOfDeath.addDistrict_desciption(spread.getDistrict());
		return districtOfIndividualOfDeath;
	}

	private District createDistrictForSubjectIndividualPerson(SpreadDeathTO spread,DeathTO death, MyFactory factory, String uuidLong) {
		District districtOfIndividualOfDeath = factory.createDistrict(NS+"District_"+uuidLong);
		districtOfIndividualOfDeath.addDistrict_desciption(spread.getDistrict());
		return districtOfIndividualOfDeath;
	}
	
	private Register_page createRegisterPage(SpreadDeathTO spread,DeathTO death, MyFactory factory, String uuidLong) {
		Register_page registerPageToSubjectToDeathEventPerson = factory.createRegister_page(NS+"RegisterPage_"+uuidLong);
		registerPageToSubjectToDeathEventPerson.addDate_of_page_certified(spread.getDatePageCertified());
		registerPageToSubjectToDeathEventPerson.addDate_of_page_certified_as_TrueCopy(spread.getDatePageCertifiedAsTrueCopy());
		registerPageToSubjectToDeathEventPerson.addQuarter(spread.getQuarter());
		registerPageToSubjectToDeathEventPerson.addStamp_number(spread.getStampNumber());
		registerPageToSubjectToDeathEventPerson.addVolume(spread.getVolume());
		registerPageToSubjectToDeathEventPerson.addYear_registered(spread.getYearRegistered());
		registerPageToSubjectToDeathEventPerson.addUnion(spread.getUnion());
		return registerPageToSubjectToDeathEventPerson;
	}

	private Person createSuperIntendentPersonPerson(SpreadDeathTO spread,DeathTO death, MyFactory factory, District districtEvent, String uuidLong) {

		//#superIntendent
		Person superIntendentPerson = factory.createPerson(NS+"SuperIntendentPerson_"+uuidLong);
		
		superIntendentPerson.addSurname(spread.getSurnameOfSuperintendantRegistrar());
		superIntendentPerson.addForename(spread.getForenameOfSuperintendantRegistrar());
		
		//hasDistrict
		superIntendentPerson.addHas_district(districtEvent);
		return superIntendentPerson;
	}

	private Person createInformedThedeathEventPerson(SpreadDeathTO spread,
DeathTO death, MyFactory factory, Address residenceOfDeathForInformantPerson, Death_event deathEvent, String uuidLong) {

		//#subjectToDeathEventPerson
		Person informedTheDeathEventPerson = factory.createPerson(NS+"InformedTheDeathEventPerson_"+uuidLong);
		informedTheDeathEventPerson.addSurname(death.getSurnameOfInformant());
		informedTheDeathEventPerson.addForename(death.getForenameOfInformant());
		
		
		//##Address
		informedTheDeathEventPerson.addHas_residence_during_Informing_death(residenceOfDeathForInformantPerson);
		
		//##Informs
		informedTheDeathEventPerson.addInforms(deathEvent);
		
		return informedTheDeathEventPerson;
	}

	private Person createRegistrarPerson(SpreadDeathTO spread, DeathTO death, MyFactory factory, Death_event deathEvent, String uuidLong) {
		//#subjectToDeathEventPerson
		Person registrarPerson = factory.createPerson(NS+"RegistrarPerson_"+uuidLong);
		registrarPerson.addSurname(death.getSurnameOfRegistrar());
		registrarPerson.addForename(death.getForenameOfRegistrar());
		registrarPerson.addTitleOfReg(death.getTitleOfRegistrar());

		return registrarPerson;
	}

	private Person createSujectToDeathEventPerson(SpreadDeathTO spread,DeathTO death, MyFactory factory, Rank rankForDeathPerson, 
			Address residenceOfDeathForDeathPerson, Cause_of_death causeOfDeathForDeathPerson, Death_event deathEvent, Person informedThedeathEventPerson, District districtForDeathPerson, String uuidLong) {
		//#subjectToDeathEventPerson
		Person subjectToDeathEventPerson = factory.createPerson(NS+"SubjectToDeathEventPerson_"+uuidLong);
		subjectToDeathEventPerson.addSurname(death.getSurname());
		subjectToDeathEventPerson.addForename(death.getForename());
		subjectToDeathEventPerson.addSex(death.getSex());
		subjectToDeathEventPerson.addAge_at_last_birthday(death.getAgeLastBirthday());
		subjectToDeathEventPerson.addCondition_at_death(death.getCondition());
		subjectToDeathEventPerson.addDate_of_death(death.getDateOfDeath());
		
		//##Rank
		subjectToDeathEventPerson.addHas_rank_at_death(rankForDeathPerson);
		
		//##Cause_of_death
		subjectToDeathEventPerson.addHas_cause_of_death(causeOfDeathForDeathPerson);
		
		//##Address
		subjectToDeathEventPerson.addHas_residence_at_death(residenceOfDeathForDeathPerson);
		
		//##Death_event
		subjectToDeathEventPerson.addHas_death_record(deathEvent);
		
		//##District
		subjectToDeathEventPerson.addHas_district(districtForDeathPerson);
		
		return subjectToDeathEventPerson;
	}


	private InputDataSampleTO parseTTLSourceTOObject() throws Exception {
		String datTurtle = "src/test/resources/2014.12.18.dummy-data.ttl";
		jenaModelSource.importData(datTurtle);
		Map<String, List<Triple>> triplesMap = getTriplesMap(datTurtle);
		InputDataSampleTO inputDataSampleTO = new InputDataSampleTO();

		for(SpreadDeathTO spread:getInputDataSampleTO(triplesMap).getSpread_deaths()){
			System.out.println("==> "+spread.getId());
			for(String recordStr:spread.getWithRecord()){
				System.out.println(recordStr);
				List<Triple> triples = triplesMap.get(recordStr);
				String lastDeathID = "";
				DeathTO death = null;
				for(Triple triple:triples){
					System.out.println(triple.getSubject()+" - "+triple.getPredicate()+" - "+triple.getObject());
					if (StringUtils.startsWithIgnoreCase(recordStr,"http://irl.dri.ie/deaths/")) {
						String attributeName = getAAttributeName(triple.getPredicate().toString());
						Field attribute = DeathTO.class.getDeclaredField(attributeName);
						String deathID = getURIID(recordStr);
						
						if (!StringUtils.equalsIgnoreCase(lastDeathID, deathID)) {
							death = new DeathTO();
							if ("".equals(lastDeathID)) {
								lastDeathID = deathID;
							}
						}
						death.setId(deathID);
						String methodName = fieldToSetter(attributeName);
						Method method = DeathTO.class.getDeclaredMethod(methodName, attribute.getType());
						if ("type".equals(attributeName)) {
							//TODO add types,if necessary.
							continue;
						}
						if (StringUtils.containsIgnoreCase(attribute.getType().toString(), String.class.getName())) {
							String value = triple.getObject().toString();
							if(value!=null && !"".equals(value)){
								if(value.contains("\"")){
									value = value.replace("\"", "");
								}
								if(value.contains("^^")){
									value = value.substring(0,value.indexOf("^^"));
								}
							}
							method.invoke(death, value);
						}
					}
				}	
				spread.getDeaths().add(death);
			}
			inputDataSampleTO.getSpread_deaths().add(spread);
		}

		return inputDataSampleTO;
	}
	
	private InputDataSampleTO getInputDataSampleTO(Map<String, List<Triple>> triplesMap) throws Exception {
		String datTurtle = "src/test/resources/2014.12.18.dummy-data.ttl";
		jenaModelSource.importData(datTurtle);
		InputDataSampleTO inputDataSampleTO = new InputDataSampleTO();
		String NS = "http://irl.dri.ie/spread_deaths/";

		SpreadDeathTO spread = null;
		String lastNSCount = "";
		for (Map.Entry<String, List<Triple>> entry : triplesMap.entrySet()) {
			String key = entry.getKey();
			if (!StringUtils.containsIgnoreCase(key,
					"http://irl.dri.ie/deaths/")
					&& !StringUtils.containsIgnoreCase(key,
							"http://irl.dri.ie/spread_deaths/")) {
				continue;
			}

			String id = getURIID(key);
			String nscount = NS + id;
			if (!StringUtils.equalsIgnoreCase(lastNSCount, nscount)) {
				spread = new SpreadDeathTO();
				if ("".equals(lastNSCount)) {
					lastNSCount = nscount;
				}
			}

			for (Triple triple : entry.getValue()) {
				if (StringUtils.startsWithIgnoreCase(key,"http://irl.dri.ie/spread_deaths/")) {
					String attributeName = getAAttributeName(triple
							.getPredicate().toString());
					Field attribute = SpreadDeathTO.class
							.getDeclaredField(attributeName);
					spread.setId(id);
					String methodName = fieldToSetter(attributeName);
					Method method = SpreadDeathTO.class.getDeclaredMethod(methodName, attribute.getType());
					if ("deaths".equals(attributeName)) {
						continue;
					}
					if ("withRecord".equals(attributeName)) {
						String methodGetName = fieldToGetter(attributeName);
						Method methodGet = SpreadDeathTO.class
								.getDeclaredMethod(methodGetName);
						List<String> recordList = (List<String>) methodGet.invoke(spread);
						recordList.add(triple.getObject().toString());
					}
					if (StringUtils.containsIgnoreCase(attribute.getType().toString(), String.class.getName())) {
						String value = triple.getObject().toString();
						if(value!=null && !"".equals(value)){
							if(value.contains("\"")){
								value = value.replace("\"", "");
							}
							if(value.contains("^^")){
								value = value.substring(0,value.indexOf("^^"));
							}
						}
						method.invoke(spread,value);
					}
				}

			}

			if (spread != null && spread.getId() != null) {
				inputDataSampleTO.getSpread_deaths().add(spread);
			}
		}

		return inputDataSampleTO;
	}

	private String fieldToGetter(String name) {
		return "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
	}

	private String fieldToSetter(String name) {
		return "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
	}

	private String getAAttributeName(String str) {
		str = str.substring(str.lastIndexOf("#") + 1, str.length());
		return str;
	}

	private String getURIID(String key) {
		String str = key;
		str = str.substring(str.lastIndexOf("/") + 1, str.length());
		return str;
	}

	private void printStmtIteratorImpl(StmtIterator stmtIt) {
		while (stmtIt.hasNext()) {
			Statement stm = stmtIt.next();
			System.out.println(stm);
		}
	}

	public Map<String, List<Triple>> getTriplesMap(final String filename) {
		// final String filename =
		// "src/test/resources/2014.12.18.dummy-data.ttl";
		// Create a PipedRDFStream to accept input and a PipedRDFIterator to
		// consume it
		// You can optionally supply a buffer size here for the
		// PipedRDFIterator, see the documentation for details about recommended
		// buffer sizes
		PipedRDFIterator<Triple> iter = new PipedRDFIterator<Triple>();
		final PipedRDFStream<Triple> inputStream = new PipedTriplesStream(iter);
		// PipedRDFStream and PipedRDFIterator need to be on different threads
		ExecutorService executor = Executors.newSingleThreadExecutor();
		// Create a runnable for our parser thread
		Runnable parser = new Runnable() {
			@Override
			public void run() {
				// Call the parsing process.
				RDFDataMgr.parse(inputStream, filename);
			}
		};
		// Start the parser on another thread
		executor.submit(parser);
		// We will consume the input on the main thread here
		// We can now iterate over data as it is parsed, parsing only runs as
		// far ahead of our consumption as the buffer size allows
		Map<String, List<Triple>> allTriplesMappedBySubjectName = new TreeMap<String, List<Triple>>();

		Set<String> namesSet = new TreeSet<String>();
		while (iter.hasNext()) {
			Triple next = iter.next();
			if (next == null) {
				continue;
			}
			Node subjNode = next.getMatchSubject();
			if (subjNode == null) {
				continue;
			}
			String subjNodeStr = subjNode.toString();
			if (!namesSet.contains(subjNodeStr)) {
				namesSet.add(subjNodeStr);
				List<Triple> triples = new ArrayList<Triple>();
				triples.add(next);
				allTriplesMappedBySubjectName.put(subjNodeStr, triples);
			} else {
				List<Triple> triples = allTriplesMappedBySubjectName
						.get(subjNodeStr);
				triples.add(next);
				allTriplesMappedBySubjectName.put(subjNodeStr, triples);
			}
		}
		return allTriplesMappedBySubjectName;
	}

}
