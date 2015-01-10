package com.jbjares.owlmapper.jena;


import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.springframework.stereotype.Service;

import com.hp.hpl.jena.graph.Triple;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntProperty;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.sparql.core.DatasetGraph;
import com.hp.hpl.jena.sparql.core.DatasetGraphFactory;
import com.hp.hpl.jena.sparql.core.Quad;
import com.hp.hpl.jena.update.GraphStore;
import com.hp.hpl.jena.update.GraphStoreFactory;
import com.hp.hpl.jena.update.UpdateAction;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

@Service(value="jenaModel")
public class JenaModel implements IJenaModelService{

	private OntModel ontModel;

	private PrintWriter log;


	public JenaModel(){
		ontModel = ModelFactory.createOntologyModel();
		openLog("log.txt");
	}

	@Override
	public OntModel getOntModel(){
		return ontModel;
	}

	private void openLog(String filePath) {
		try {
			log = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)), true);	
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
	}

	@Override
	public PrintWriter getLogWriter() {
		return log;
	}


	@Override
	public void importOntology(String ontologyFile, String base){		
		try {		
			if (ontologyFile.contains(".")==false){
				ontologyFile=ontologyFile+".owl";	
			}
			FileInputStream file = new FileInputStream(ontologyFile);	
			ontModel.read(file, base);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
	}

	@Override
	public void importData(String rdfFile) {
		System.out.println(rdfFile);
		DatasetGraph dataset = RDFDataMgr.loadDataset(rdfFile, Lang.TTL).asDatasetGraph();		
		Iterator<Quad> quads = dataset.find();
		while ( quads.hasNext() ) {
			Quad quad = quads.next();
			Triple triple = quad.asTriple();
			Statement statement = ontModel.asStatement(triple);
			ontModel.add(statement);
		}	
	}
	
	
	@Override
	public void importData(InputStream inputStream) {
		DatasetGraph datasetGraph = DatasetGraphFactory.createMem();
		RDFDataMgr.read(datasetGraph, inputStream, Lang.TTL);
		Iterator<Quad> quads = datasetGraph.find();
		while ( quads.hasNext() ) {
			Quad quad = quads.next();
			Triple triple = quad.asTriple();
			Statement statement = ontModel.asStatement(triple);
			ontModel.add(statement);
		}	
	}
	

	@Override
	public void queryModel(String queryString) {
		QueryExecution qexec = QueryExecutionFactory.create(queryString, ontModel);
		ResultSet results = qexec.execSelect();
		while(results.hasNext()) {
			QuerySolution solution = results.next();			
			System.out.println(solution);
			log.println(solution.toString() +"\n");				
		}
	}	

	@Override
	public Map<String, List<RDFNode>> queryModel(String queryString, List<String> queryVariables) {
		Map<String, List<RDFNode>> solution = new HashMap<String, List<RDFNode>>();
		QueryExecution qexec = QueryExecutionFactory.create(queryString, ontModel);	
		ResultSet results = qexec.execSelect();
		while(results.hasNext()) {		
			QuerySolution sol = results.next();		
			for(String variable : queryVariables) {	

				RDFNode nodeVar = sol.get(variable);
				if(nodeVar!=null){
					if(solution.get(variable)==null)
						solution.put(variable, new ArrayList<RDFNode>());					
					solution.get(variable).add(nodeVar);
				}
			}
			log.println(solution.toString() +"\n");				
		}
		if(solution.isEmpty())
			solution = null;
		return solution;
	}	


	@Override
	public Map<String, List<RDFNode>> queryModel(Map<String, String> prefixes, String queryString, List<String> queryVariables) {
		queryString = getPrefixString(prefixes) + queryString;
		Map<String, List<RDFNode>> solution = new HashMap<String, List<RDFNode>>();
		QueryExecution qexec = QueryExecutionFactory.create(queryString, ontModel);	
		ResultSet results = qexec.execSelect();
		while(results.hasNext()) {		
			QuerySolution sol = results.next();		
			for(String variable : queryVariables) {	

				RDFNode nodeVar = sol.get(variable);
				if(nodeVar!=null){
					if(solution.get(variable)==null)
						solution.put(variable, new ArrayList<RDFNode>());					
					solution.get(variable).add(nodeVar);
				}
			}
			log.println(solution.toString() +"\n");				
		}
		if(solution.isEmpty())
			solution = null;
		return solution;
	}	


	@Override
	public String getPrefixString(Map<String, String> prefixUriMap){
		StringBuffer buffer = new StringBuffer();
		for(String prefix : prefixUriMap.keySet()){
			String uri = prefixUriMap.get(prefix);
			buffer.append("Prefix " +  prefix + ":" +  "<" + uri + "#> "  + "\n");			
		}		
		return buffer.toString().trim() + "\n";
	}

	@Override
	public StmtIterator constructQuery(String queryString) {
		QueryExecution qexec = QueryExecutionFactory.create(queryString, ontModel);	
		Model construct = qexec.execConstruct();

		StmtIterator statements = construct.listStatements();
		return statements;
	}


	@Override
	public void createIndividiual(String ontology, String query)
			throws FileNotFoundException {
		DatasetGraph dataset = RDFDataMgr.loadDataset(ontology, Lang.RDFXML)
				.asDatasetGraph();
		GraphStore graphstore = GraphStoreFactory.create(dataset);
		graphstore.setDefaultGraph(ontModel.getGraph());
		FileOutputStream out = new FileOutputStream(ontology);
		UpdateAction.parseExecute(query.toString(), graphstore);
		ontModel.write(out);
	}

	/**
	 * It returns the name of the subclass of any Class from ontology
	 * @param className
	 * @return
	 */
	@Override
	public List<String> getSubclassOf(String ontologyPath,String className) {
		List<String> lstOfSubclasses=new ArrayList<String>();
		OntClass classObj=this.ontModel.getOntClass(ontologyPath+"#"+className);
		ExtendedIterator<OntClass> iteratorSubClass=classObj.listSubClasses();
		while(iteratorSubClass.hasNext()){
			lstOfSubclasses.add(iteratorSubClass.next().getLocalName().trim());
		}
		/*ExtendedIterator<OntProperty> lstOfPro= classObj.listDeclaredProperties() ;
		while(lstOfPro.hasNext()){
			System.out.println(lstOfPro.next());
		}*/
		return lstOfSubclasses;
	}
	
	/**
	 * It returns the data properties of a class from  ontology
	 * @param className
	 * @return
	 */
	@Override
	public List<String> getPropertiesOf(String ontologyPath, String className) {
		List<String> lstOfProperties = new ArrayList<String>();
		OntClass classObj = this.ontModel.getOntClass(ontologyPath + "#"
				+ className);
		ExtendedIterator<OntProperty> lstOfPro = classObj.listDeclaredProperties(true);
		while (lstOfPro.hasNext()) {
			lstOfProperties.add(lstOfPro.next().getLocalName().trim());
		}
		return lstOfProperties;
	}
	
	@Override
	public Object executeQuery(String query){
		String errorMsg;
		try{
			QueryExecution queryExec= QueryExecutionFactory.create(query,this.ontModel);
			ResultSet rs=queryExec.execSelect();
			List<QuerySolution> lstOfQuerySol=ResultSetFormatter.toList(rs);
			return lstOfQuerySol;
		}catch(Exception e){
			errorMsg=e.getMessage();
			return errorMsg;
		}
	}


}
