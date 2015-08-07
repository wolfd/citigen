citigen
=======

A rewrite of a city generator I created over the past few years.

The concept is that cities have roads that act in the way that roots do in trees, 
growing only where there is water, and adaptive to their surroundings. In citigen,
roads are grown using a technique labelled "self-sensitive L-systems," by Parish
and Müller[1] in their CityEngine program and related publications.

In this version I intend to deviate more from the publication and explore ideas I
have had about how to model the mixing of patterns and mutation of patterns with
time.

My previous work can be viewed at https://bitbucket.org/2dawolf/citygen although
I would caution anyone looking to work off of that project. I learned how to
program by coding that project, and it shows an extreme negligence of
documentation as well as accepted object-oriented design techniques. One of the
foremost reasons I am undertaking this project is to have practice using
techniques I am currently learning in university.

[1]: http://people.ee.ethz.ch/~pascmu/documents/procedural_modeling_of_cities__siggraph2001.pdf


## Running
```
mvn clean package
java -jar target/citigen-1.0-SNAPSHOT.jar server city-server.yml
```
