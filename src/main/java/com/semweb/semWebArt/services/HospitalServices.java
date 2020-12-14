package com.semweb.semWebArt.services;

import com.semweb.semWebArt.model.Hospital;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdfconnection.RDFConnection;
import org.apache.jena.rdfconnection.RDFConnectionRemote;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class HospitalServices {

    private RDFConnection conn0 = RDFConnectionRemote.create()
            .destination("http://localhost:3030/animal")
            .queryEndpoint("sparql")
            .acceptHeaderSelectQuery("application/sparql-results+json, application/sparql-results+xml;q=0.9")
            .build();
    private String service = "http://localhost:3030/animal";

    private List<Hospital> hospitalsList = new ArrayList<>();

    public List<Hospital> getHospitalsList() {
        return hospitalsList;
    }

    @PostConstruct
    @Scheduled(cron = "1 * * * * *")
    public void queryHopitalData() throws IOException {
        List<Hospital> updateHospitalsList = new ArrayList<>();
        // Define the prefixes of the knowledge base
        String prefixes = "prefix dbp: <http://dbpedia.org/property/> \n" +
                "prefix dbpedia: <http://dbpedia.org/resource/>  \n" +
                "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>  \n" +
                "prefix dbo: <http://dbpedia.org/ontology/> \n" +
                "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n" +
                "prefix tto: <http://example.org/tuto/ontology#> \n" +
                "prefix ttr:   <http://example.org/tuto/resource#> \n" +
                "PREFIX dbr:    <http://dbpedia.org/resource/> \n" +
                "PREFIX dbo:    <http://dbpedia.org/ontology/> \n" +
                "prefix xsd: <http://www.w3.org/2001/XMLSchema#> \n" ;

        // The query used to retrive our information using SPARQL
        Query query = QueryFactory.create( prefixes + "\n" + "select ?people ?sex ?birth ?name1 where {?people rdf:type dbo:Person .?people dbp:name ?name .?people tto:sex ?sex . ?people dbp:birthDate ?birth . SERVICE <http://dbpedia.org/sparql> {\n" +
                "        ?name1 dbo:country dbr:Netherlands .\n" +
                "   }} ORDER BY ?sex desc(?birth) limit 2");
        QueryExecution queryExe = QueryExecutionFactory.sparqlService(service,query);


        try {
            ResultSet resultSet = queryExe.execSelect();
            while (resultSet.hasNext()) {
                Hospital hospital = new Hospital();
                QuerySolution soln = resultSet.nextSolution();
                Resource resource=soln.getResource("people");
                RDFNode name = soln.get("name1");
                Literal sex = soln.getLiteral("sex");
                Literal birth = soln.getLiteral("birth");
                System.out.print(name+"  the sex is  "+sex+" the birth day is "+ birth + "\n"  );
                System.out.println("here the resource "+resource);

                hospital.setName(name.toString());
                hospital.setSex(sex.getString());
                hospital.setBirth(birth.getString());

                updateHospitalsList.add(hospital);

            }}finally {
            queryExe.close();
        }
        this.hospitalsList=updateHospitalsList;




    }
}
