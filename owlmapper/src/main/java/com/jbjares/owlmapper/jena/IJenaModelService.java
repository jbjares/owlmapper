package com.jbjares.owlmapper.jena;


import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.StmtIterator;



/**
 * 
 * @author jbjares
 * 
 */
public interface IJenaModelService {

	OntModel getOntModel();

	PrintWriter getLogWriter();

	void importOntology(String ontologyFile, String base);

	void importData(String rdfFile);

	void queryModel(String queryString);

	Map<String, List<RDFNode>> queryModel(String queryString,
			List<String> queryVariables);

	Map<String, List<RDFNode>> queryModel(Map<String, String> prefixes,
			String queryString, List<String> queryVariables);

	String getPrefixString(Map<String, String> prefixUriMap);

	StmtIterator constructQuery(String queryString);

	List<String> getSubclassOf(String simNameSpace, String graphTypeClass);

	List<String> getPropertiesOf(String femNameSpace, String nummethodTypeClass);

	Object executeQuery(String query);

	void createIndividiual(String ontology, String query)
			throws FileNotFoundException;

	void importData(InputStream inputStream);


}
