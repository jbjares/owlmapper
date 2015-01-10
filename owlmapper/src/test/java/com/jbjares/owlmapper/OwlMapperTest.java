package com.jbjares.owlmapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.StringUtils;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.lang.PipedRDFIterator;
import org.apache.jena.riot.lang.PipedRDFStream;
import org.apache.jena.riot.lang.PipedTriplesStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.Assert;

import com.hp.hpl.jena.graph.Node;
import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.jbjares.owlmapper.jena.IJenaModelService;
import com.jbjares.owlmapper.to.InputDataSampleTO;
import com.jbjares.owlmapper.to.SpreadDeathTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:owlmapper-applicationContext.xml" })
public class OwlMapperTest {

	@Autowired
	private IJenaModelService jenaModelSource;

	@Test
	public void assertNotNullJenaModelService() {
		Assert.assertNotNull(jenaModelSource);
	}

	@Test
	public void ttlImportTest() throws NoSuchFieldException, SecurityException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String datTurtle = "src/test/resources/2014.12.18.dummy-data.ttl";
		Map<String,List<Triple>> triplesMap =  getTriplesMap(datTurtle);		
		InputDataSampleTO inputDataSampleTO = new InputDataSampleTO();
		populateInputDataSampleTO(inputDataSampleTO,triplesMap);
		
	}
	private void populateInputDataSampleTO(InputDataSampleTO inputDataSampleTO, Map<String, List<Triple>> triplesMap) throws NoSuchFieldException, SecurityException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		String datTurtle = "src/test/resources/2014.12.18.dummy-data.ttl";
		jenaModelSource.importData(datTurtle);
		String NS = "http://irl.dri.ie/spread_deaths/";
		//Resource r = jenaModelSource.getOntModel().getResource(NS + "Certificate");
		//printStmtIteratorImpl(r.listProperties());
		//r = jenaModelSource.getOntModel().getResource(NS + "DeathRecord");
		//printStmtIteratorImpl(r.listProperties());
		//r = jenaModelSource.getOntModel().getResource(NS + "Record");
		//printStmtIteratorImpl(r.listProperties());
		

		SpreadDeathTO spread  = null;
		String lastNSCount = "";
		for(Map.Entry<String,List<Triple>> entry: triplesMap.entrySet()){			
			String key = entry.getKey();
			if(!StringUtils.containsIgnoreCase(key,"http://irl.dri.ie/deaths/") && 
					!StringUtils.containsIgnoreCase(key,"http://irl.dri.ie/spread_deaths/")){
				continue;
			}
			
			String id = getURIID(key);
			System.out.println(id);
			String nscount = NS + id;
			if(!StringUtils.equalsIgnoreCase(lastNSCount, nscount)){
				spread = new SpreadDeathTO();
				if("".equals(lastNSCount)){
					lastNSCount = nscount;
				}
				
				inputDataSampleTO.getSpread_deaths().add(spread);
			}	

			for(Triple triple:entry.getValue()){
				if(StringUtils.startsWithIgnoreCase(key,"http://irl.dri.ie/spread_deaths/")){
					
				
					System.out.println(nscount);
					System.out.println(triple.getPredicate());
					System.out.println(triple.getObject());
					System.out.println("isURI: "+triple.getObject().isURI());
					System.out.println("===================");
					String attributeName = getAAttributeName(triple.getPredicate().toString());
					System.out.println(attributeName);
					
					Field attribute = SpreadDeathTO.class.getDeclaredField(attributeName);
					spread.setId(id);
					String methodName = fieldToSetter(attributeName);
					System.out.println("attribute: "+methodName);
					Method method = SpreadDeathTO.class.getDeclaredMethod(methodName,attribute.getType());
					System.out.println(method.getName());
					System.out.println(attribute.getType());
					if(StringUtils.containsIgnoreCase(attribute.getType().toString(), "java.lang.String") ){
						method.invoke(spread, triple.getObject().toString());
					}else{
						continue;
					}
				}
			}
			
			if(spread!=null && spread.getId()!=null){
				inputDataSampleTO.getSpread_deaths().add(spread);				
			}
		}
		System.out.println(inputDataSampleTO);
	}


	private String fieldToSetter(String name){
	    return "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
	}

	private String getAAttributeName(String str) {
		str = str.substring(str.lastIndexOf("#")+1,str.length());
		return str;
	}

	private String getURIID(String key) {
		String str = key;
		str = str.substring(str.lastIndexOf("/")+1,str.length());
		return str;
	}

	private void printStmtIteratorImpl(StmtIterator stmtIt) {
		while (stmtIt.hasNext()) {
			Statement stm = stmtIt.next();
			System.out.println(stm);
		}
	}

	public Map<String,List<Triple>> getTriplesMap(final String filename) {
		//final String filename = "src/test/resources/2014.12.18.dummy-data.ttl";
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
		Map<String,List<Triple>> allTriplesMappedBySubjectName = new TreeMap<String,List<Triple>>();
		
		Set<String> namesSet = new TreeSet<String>();
		while (iter.hasNext()) {
			Triple next = iter.next();
			if(next==null){continue;}
			Node subjNode = next.getMatchSubject();
			if(subjNode==null){continue;}
			String subjNodeStr = subjNode.toString();
			if(!namesSet.contains(subjNodeStr)){
				namesSet.add(subjNodeStr);
				List<Triple> triples = new ArrayList<Triple>();
				triples.add(next);
				allTriplesMappedBySubjectName.put(subjNodeStr, triples);
			}else{
				List<Triple> triples = allTriplesMappedBySubjectName.get(subjNodeStr);
				triples.add(next);
				allTriplesMappedBySubjectName.put(subjNodeStr, triples);				
			}
		}
		return allTriplesMappedBySubjectName;
	}

	
}
