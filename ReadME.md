# Semantic Web Project



#### Group members
|Name|  Domain |  Master |  year|
|---|---|---|---|
|Mohamad Nour Badr |  CPS2 |  M2 | 2020/2021|
|Jehad Melad| CPS2  | M2  |2020/2021|

#### Introduction
This project is an extension of what we learn during the year of 
Master program M2 in the domain Cyber-Physical and social systems. 
This Project reflects the achievement of the course in many aspects 
that we had learned (  Basic of RDF, Turtle syntax, RDFa, JSON-LD, 
Schema.org Embedding structured data in Web pages, SPARQL, 
triplestores, Querying RDF databases and the Semantic Web, RDFS, 
OWL, RDF data management and programming with Java). Here within 
this repository, we were working to build a webpage using almost 
all concepts of the course and integrate them.

#### Objective
To Make a Web application that integrates geospatial data from multiple sources, including dynamic data.
To Define a knowledge model (that is, an ontology) that describes the types of entities that are stored in the database.
To Display information on Web pages together with structured data, for best search engine optimization.

### Files
Inside fuseki schema and data file :
<p>1- Put the (Bik-Hos and Bike-Hos-data) Database in the fuseki folder path:/apache-jena-fuseki-3.16.0\apache-jena-fuseki-3.16.0\run\databases </p>
<p> 2- The using file csv and java class to insert the data by rdf format inside the fuseki</p>
#### Tools
- The tools that we used to achieve our goals were:
- Java environment (__Spring boot__).
- HTML, Bootstrap. ( __combined by thymeleaf on SpringBoot__)
- Fuseki ( __local RDF DB__ )
- mohamad (__external RDF DB__ )
- External non-rdf data (__json__)
- internal non-rdf data (__csv__)
- online tool to build own Ontology (__http://www.visualdataweb.de/__).
- TextEditor ( __Intellij__ )

#### Data used:
* Bike stations 
    * (st-etienne, Lyon) non-rdf-data and realtime data.
* Hospitals 
    * (france) non-rdf-data and local (csv)
* Museum 
    * (France) rdf-data and external.
    
    
#### Ontology (_Bik-Hos_ )



For the ontology, we try to define our ontology based on topics that we are interested in. Therefore we have an ontology to serve bike stations and hospitals. In the next few lines, we will go through details:




<div id="classes"> 

<h4>Classes</h4>
<p>There are 8 Classes defined beside reuseing some existing ontologies. </p>

<a href="#SpatialThing">SpatialThing</a> |  &nbsp;
<a href="#Country">Country</a> | &nbsp;
<a href="#City">City</a> | &nbsp;
<a href="#Hospital">Hospital</a> | &nbsp;
<a href="#Transportaion">Transportaion</a> | &nbsp; 
<a href="#BikeStation">BikeStation</a> | &nbsp;
<a href="#Building">Building</a> | &nbsp;
<a href="#Thing">Thing</a> | &nbsp;
</div>

<div id="prop">
<h4>Properties</h4>
<p></p>
<a href="ref-France-Finess">ref-France-Finess</a> | &nbsp;
<a href="wikiData">wikiData</a> | &nbsp;
<a href="buildingNumber">buildingNumber</a> | &nbsp;
<a href="type-France-Finess">type-France-Finess</a> | &nbsp;
<a href="osm_TimeStamp">osm_TimeStamp</a> | &nbsp;
<a href="emergency">emergency</a> | &nbsp;
<a href="availableDock">availableDock</a> | &nbsp;
<a href="availableBike">availableBike</a> | &nbsp;
<a href="capacity">capacity</a> | &nbsp;
<a href="lat">lat</a> | &nbsp;
<a href="lon">lon</a> | &nbsp;
<a href="hasStatus">hasStatus</a> | &nbsp;
<a href="stationName">stationName</a> | &nbsp;
<a href="hasAddress">hasAddress</a> | &nbsp;
<a href="locatedInCommune">locatedInCommune</a> | &nbsp;
<a href="name">name</a> | &nbsp;
<a href="lat">lat</a> | &nbsp;
<a href="lon">lon</a> | &nbsp;
<a href="name">name</a> | &nbsp;
<a href="name">name</a> | &nbsp;
</div><br>

### Full Details
***
<div id="SpatialThing" >  
<p>Spatial Thing - A spatial coordination</p>
  <h5>Class: &nbsp;&nbsp;bikhos:SpatialThing</h5>
    <p><strong>Status:</strong> Stable</p>
    <p><strong>Subclass Of:</strong> &nbsp;<a href="#Thing">Thing</a></p>
  <p>[ SpatialThing ] It is an existing vocabulary model representing geolocation coordinations lat(itude), long(itude) and other information about spatially-located things, using WGS84 as a reference datum</p>
</div>
<br>

***
<br>

***
<div id="Country" >  
  <h5>Class: &nbsp;&nbsp;bikhos:Country</h5>
  <p>Country - Relevent to Country names</p>
    <p><strong>Status:</strong> Testing</p>
    <p><strong>Subclass Of:</strong> &nbsp;<a href="#SpatialThing">Spatial Thing</a></p>
<p>[Country] - it used when we are going to describe a country which could have geolocation or name properties.
</div><br>
<br>

***
<div id="City" >  
  <h5>Class: &nbsp;&nbsp;bikhos:City</h5>
  <p></p>
    <p><strong>Status:</strong> Testing</p>
    <p><strong>disjointWith:</strong> <a href="#BikeStation">BikeStation</a></p>
    <p><strong>Subclass Of:</strong> &nbsp;<a href="#Country">Country</a>
    </strong> </p>
    <p><strong>Properties include: </strong><a href="#name">name</a>
    <a href="#lat">lat</a>
    <a href="#lon">lon</a></p>
<p>[City] - Class useing to decribe the city entity </p>
</div>
<br>

***
<div id="Hospital" >  
  <h5>Class: &nbsp;&nbsp;bikhos:Hospital</h5>
  <p></p>//
    <p><strong>Status:</strong> Testing</p>
    <p><strong>Subclass Of:</strong> &nbsp;<a href="#Building">Building</a></p>
    <p><strong>Properties include: </strong><a href="#ref-France-Finess">ref-France-Finess</a>
        <a href="#wikiData">wikiData</a> </strong><a href="#buildingNumber">buildingNumber</a>
         <a href="#type-France-Finess">type-France-Finess</a> <a href="#osm_TimeStamp">osm_TimeStamp</a>
        <a href="#emergency">emergency</a></p>
        <p>[ Hospital ] - class useing to describe the hospital entity   </p>
</div>
<br>

***
<div id="Transportaion" >  
  <h5>Class: &nbsp;&nbsp;bikhos:Transportaion</h5>
  <p></p>
    <p><strong>Status:</strong> Testing</p>
    <p><strong>Subclass Of:</strong> &nbsp;<a href="#City">City</a></p>
    <p>[Transportaion] - Father class</p>
</div>
<br>

***
<div id="BikeStation" >  
  <h5>Class: &nbsp;&nbsp;bikhos:BikeStation</h5>
  <p></p>
    <p><strong>Status:</strong> Testing</p>
    <p><strong>Subclass Of:</strong> &nbsp;<a href="#Transportaion">Transportaion</a></p>
    <p><strong>Properties include: </strong><a href="#availableDock">availableDock</a>
            <a href="#availableBike">availableBike</a> </strong><a href="#capacity">capacity</a>
             <a href="#hasStatus">hasStatus</a> <a href="#stationName">stationName</a>
            <a href="#hasAddress">hasAddress</a> <a href="#locatedInCommune">locatedInCommune</a> <a href="#lat">lat</a>
              <a href="#lon">lon</a>
            </p>
    <p>[ BikeStation ] - class Useing to describr the BikeStation entity</p>
</div>
<br>

***
<div id="Building" >  
  <h5>Class: &nbsp;&nbsp;bikhos:Building</h5>
  <p></p>
    <p><strong>Status:</strong> Testing</p>
    <p><strong>Subclass Of:</strong> &nbsp;<a href="#City">City</a></p>
    <p>[Building] - useing to describe the building entity(Father class of 
    hospitla, subclass of City</p>
</div>
<br>

***
<div id="Thing" >  
  <h5>Class: &nbsp;&nbsp;bikhos:Thing</h5>
  <p></p>
    <p><strong>Status:</strong> Testing</p>
    <p><strong>Subclass Of:</strong> &nbsp;<a href="#City">City</a></p>
    <p>[Thing] - Thing of every thing (Main Class of all classes)</p>
</div>
<br>




