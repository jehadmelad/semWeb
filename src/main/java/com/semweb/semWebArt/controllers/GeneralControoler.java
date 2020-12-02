package com.semweb.semWebArt.controllers;

import org.apache.jena.query.*;
import org.apache.jena.rdfconnection.RDFConnection;
import org.apache.jena.rdfconnection.RDFConnectionRemote;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.ClientInfoStatus;
import java.util.List;
import java.util.ListIterator;

@Controller
public class GeneralControoler {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String index() {



        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hi")
    public String try2(Model model){
        RDFConnection conn0 = RDFConnectionRemote.create()
                .destination("http://localhost:3030/animal")
                .queryEndpoint("sparql")
                .acceptHeaderSelectQuery("application/sparql-results+json, application/sparql-results+xml;q=0.9")
                .build();

        String prefixes = "prefix dbo: <http://dbpedia.org/ontology/> \n" +
                "prefix dbp: <http://dbpedia.org/property/> \n" +
                "prefix dbpedia: <http://dbpedia.org/resource/> \n" +
                "prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n" +
                "prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> \n" +
                "prefix tto: <http://example.org/tuto/ontology#> \n" +
                "prefix ttr: <http://example.org/tuto/resource#> \n" +
                "prefix xsd: <http://www.w3.org/2001/XMLSchema#> ";

        Query query = QueryFactory.create( prefixes +"SELECT ?o WHERE {\n" +
                "  ?s dbp:birthDate ?o\n" +
                "}");
        final QueryExecution queryExe = QueryExecutionFactory.sparqlService("http://localhost:3030/animal",query);
        final ResultSet results = queryExe.execSelect();
//        String t  = " ";
        while(results.hasNext()) {
            final QuerySolution qs = results.next();
            String test = qs.get("s").toString();
            String test2 = qs.getLiteral("n").toString();
//            t += test2;
//            System.out.println(test);
//            System.out.println(test2);

            model.addAttribute("data",qs);
            model.addAttribute("test2",test2);
        }
        return "hello";
    }

    @GetMapping("/mytry")
    public String try3(){
        return "try";
    }

    @Controller
    public class GreetingController {

        @GetMapping("/greeting")
        public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
            model.addAttribute("name", name);
            return "greeting";
        }

    }
}
