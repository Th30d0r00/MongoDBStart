## Includes Code for the following exercises:

### Assignment No. 2 (Software for managing Salesmen; Due Date Oct 22th, 2024; Upload on DIArchitect!)

As mentioned in one of the documents, the source code of the program for managing salesmen and their social performance 
records has been hidden by the admin. However, a portion of the source has been revealed. You can download the Java 
codes from LEA (folder: “Source Codes and Scripts”) or from the GitHub repository (link follows later!)

The code shows the interface of a control class, which can be used to manage information on salesmen and their 
social performance records (part B of a bonus computation sheet). The implementation of the interface will be used
to access to a MongoDB database for storing and retrieving performance records of single employees. 
The internals of the MongoDB could not be identified, so you are asked to provide your own implementation.

Take the opportunity to introduce yourself to the database management system (DBMS) MongoDB. 
MongoDB is part of the MEAN-stack (the ‘M’ of MEAN), which has become a standard solution to implement full stack Web 
applications. We will also learn the remaining “letters” during the next weeks and months. However, feel free to learn 
at least a bit more on MEAN in terms of self-study. See the links below this assignment as a recommended pool of 
appropriate resources to these topics.

a.) 
Please provide a Java program that uses the interface of a control class for managing salesmen and their 
performance records. In the backend, integrate a local MongoDB database that contains of two collections for 
storing general data for salesmen as well as their social performance records. Please make suitable assumptions on the 
schema of the two collections.

b.) 
Does the interface of the control class fulfill the CRUD pattern entirely? If not, please add the 
missing operations and refactor the given interface accordingly. No implementation of the “U” is required 
(exception: adding further social performance records to a salesman).

c.) Test your application sufficiently by developing a Junit-Test Case. If possible, provide roundtrip test to ensure, 
hat now data waste is given after the execution of a test.