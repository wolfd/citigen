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


Notes:

- Order road generation to be approximately:
  - Preselect seed areas
  - (Generate big roads)
  - Use A* to find best path between seeds -> bump those up to highways
  - Generate offramps/cloverleafs
  - Generate smaller roads

Highways are difficult, and require special methods of going over/under
Generally are built after basic roads have been developed
Generally run into/out of city or radially around them
Sometimes bulldoze roads, sometimes leave them be (depending on road traffic)

Road intersection
  - Roads rectangles are tested first
  - If the rectangles intersect, full parallelpiped test is done

Road generation happens in 3D
  - roads have heights and don't interact with things outside of their ranges
  - roads try to follow ground level unless the slope is too high
    - roads will follow maximum allowed slope
    - if below ground, needs to be at least road height to be a tunnel
    - if above ground, road will be on top of land unless high up or above road

Multithreading
- Need singleton that manages calls to random number generator
  - road generation can be parallelized
  - road filtering must happen one at a time

Road queue
  Batch roads by n, figure out grid squares used by each, 
  road gets popped
  road gets random seed from random seed singleton
  road can be generated in parallel, but filters that require outside data cannot be run
  roads must be added to the road map in the same order that they are popped
    when a road is done processing, put it in it's place in the queue to be added
    road filtering can happen in parallel if the roads are not within a certain radius of already processing roads
  roads are added in order as they are done
