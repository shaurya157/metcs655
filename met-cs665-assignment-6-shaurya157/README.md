# CS665 Assignment 6

This is assignment 6 for CS665.  The following readme can be used as user guide
to install and run the application using Java.  


# Program Assumptions

In this example I have chosen assignment-2 and assignment-3 for refactoring.   
Previously  
In assignment-2, I have implemented a observer design pattern to notify the drivers of a shop about the delivery request.   In assignment-3, I have implemented a email notification generating system for different type of customers with help of Template method design pattern. 

In assignment-2 problems with implementations are
1. Drivers and Shops are tightly coupled and dependent on each other.
2. Group of shops sending delivery request to same set of driver is not possible. 

In assignment-3 problems with implementations are
1. Email Generation and Customer Type are tightly coupled.
2. If multiple customers have same messaging type, code will be duplicated.

I have provided a new implementation of each assignments with new solutions.  Implementation description is give below.

The behaviour of  application is tested with JUnit test cases. 

# Implementation Description

For assignment-2,  I have used a new famous **Publish/Subscribe design pattern** where set of driver object will be subscribing to multiple shop channels. And also multiple shops can send messages to a single channel where a set of drivers are subscribed.   

``Shop`` objects will publish the delivery request into ``NotificationService`` and the by broadcasting that channel all the messages in the queue will be delivered in ``Driver`` objects. ``NotificationService`` acts as a Message broker here.

For problems in assignment-3, I have used **Strategy Design pattern**, along with **Dependency Injection Pattern** to dynamically select the proper messaging template. By this new implementation Multiple customers can use same type of message templates without changing the code. And messaging templates for a customer can be changed in the run time. 

Each ``Customer`` types will have their own messenger, and messenger can be injected dynamically at run time. There messengers are responsible to generate respective message bodies. By this way, we can reduce the duplicate code and we can reduce the coupling between Customer and message generator. In the future if customer objects are also added with some other functionalities, it will be easy to modify the class by using composition principle rather than inheritance.    

UML class diagram for implementation is assignment-6-uml.pdf

# Project Template

We use Apache Maven and JDK1.8 to compile and run this project. 

Please make sure that `java` and `mvn` commands are added to system path. 


# How to compile the project

```bash
mvn clean compile
```

# How to create a binary runnable package 


```bash
mvn clean compile assembly:single
```


# How to run


```bash
mvn clean compile assembly:single

java -jar target/assignment-6-1.0-SNAPSHOT-jar-with-dependencies.jar

OR

./run.sh
```


# Run all the unit test classes.


```bash
mvn clean compile test

```

# Using Findbugs 

To see bug detail using the Findbugs GUI, use the following command "mvn findbugs:gui"

Or you can create a XML report by using  


```bash
mvn findbugs:gui 
```

or 


```bash
mvn findbugs:findbugs
```


For more info about FindBugs see 

http://findbugs.sourceforge.net/

And about Maven Findbug plugin see 
https://gleclaire.github.io/findbugs-maven-plugin/index.html


You can install Findbugs Eclipse Plugin 

http://findbugs.sourceforge.net/manual/eclipse.html



SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


# Run Checkstyle 

CheckStyle code styling configuration files are in config/ directory. Maven checkstyle plugin is set to use google code style. 
You can change it to other styles like sun checkstyle. 

To analyze this example using CheckStyle run 

```bash
mvn checkstyle:check
```

This will generate a report in XML format


```bash
target/checkstyle-checker.xml
target/checkstyle-result.xml
```

and the following command will generate a report in HTML format that you can open it using a Web browser. 

```bash
mvn checkstyle:checkstyle
```

```bash
target/site/checkstyle.html
```


# Generate  coveralls:report 

You can find more info about coveralls 

https://coveralls.io/

```bash
mvn -DrepoToken=YOUR-REPO-TOCKEN-ON-COVERALLS  cobertura:cobertura coveralls:report
```


