# CS665 Assignment 5

This is assignment 5 for CS665.  The following readme describes my analysis on the assignment.  


# Program Assumptions

I have used the project [Twitter4j](https://github.com/Twitter4J/Twitter4J) for understanding the real world usage of design patterns.

I found that **Factory Design pattern**, **Abstract Factory Design pattern**, **Singleton Design pattern** from Creational design patterns. And **Bridge Design pattern** from Behavioral Design patterns . 

# Implementation Description

The implementation description of Design Patterns is as follows. 

####Factory Method Design Pattern
It is a creational design pattern, In which A single factory class provides API's to create specific type of objects based on the given configuration. 

Examples in Twitter4J projects are:  
**TwitterFactory** : This factory class is responsible for creating instances of ``Twitter`` class on demand.  Various types of ``getInstance`` methods are provided to create Twitter instances for given configuration, authorization or access tokens. 

**AuthorizationFactory** : This factory class is responsible for generating instances of ``Authorization`` class for given configuration.  
A ``getInstance`` method will be generating instance of Authorization like OAuth2Authorization,OAuthAuthorization and BasicAuthorization.

If Any new type of Twitter or Authorization introduced, Passing a proper Configuration object will be enough to create instances using these factory classes. 


####Abstract Factory Design Pattern
It is a creational design pattern which provides an abstract API's for creating instance of a ``Object`` without mentioning their concrete classes. For each variant of ``Object``, a separate factory class will be created which inherits the methods of Abstract factory class

For example :  
** ConfigurationFactory** is a abstract factory class which will have API's to create **Configuration** objects.

**PropertyConfiguration** is a type of **Configuration**. And a **PropertyConfigurationFactory** of type **ConfigurationFactory** is solely responsible for creating **PropertyConfiguration** objects. 

**ConfigurationContext** is a user of **ConfigurationFactory**. based on the properties, a concrete **ConfigurationFactory** will be initialized and will be responsible for generating respective **Configuration**. 

Whenever we create new class of type **Configuration**, we have to create a respective **ConfigurationFactory** and just have to mention that factory class name as a system variable. The new ConfigurationFactory we created will be responsible for creating a required Configuration instance. 


####Singleton Design Pattern
It is again a creational design pattern, in which we make sure that only single instance of a class is created and it can be accessible anywhere in the code. 

Twitter4j project only followed half of the singleton pattern. As it is not made sure that only a single instance of ``Twitter`` can be created. But a instance of ``Twitter`` object is created and kept as a static global variable. Which can be accessed from anywhere in the application and will not be altered throughout the application run time. 

``TwitterFactor.getSingleton()`` is a global API available to access a Default ``Twitter`` instance. 

####Bridge Design Pattern
It is a structural design pattern, It solves some of major problems by switching inheritance to composition. This is nothing but splitting large class or set of closely related classes into two separate hierarchies. 

For Example :  
**AsyncTwitter** and **Twitter** are two different hierarchies. And **AsyncTwitterImpl** have a reference field to **Twitter** instance. This reference field acts as a Bridge for accessing the **Twitter** API's asynchronously. 

Any new functionalities provided in **Twitter** API can be used by **AsyncTwitter** by writing a new API and redirecting it to **Twitter** Object.

----------------
UML Class Diagram : uml-class-diagram.pdf



