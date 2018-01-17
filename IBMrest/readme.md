

The REST Service runs by default on http://localhost:8080/IBMrest/rest/.

http://localhost:8080/IBMrest/rest/filmsService/ - shows the list of all films (title, locations)

http://localhost:8080/IBMrest/rest/filmsService/{title} - filters the result by the title. 

Try for example:

	http://localhost:8080/IBMrest/rest/filmsService/Basic%20Instinct

To run it on Tomcat:

- Download Tomcat from http://www-us.apache.org/dist/tomcat/tomcat-9/v9.0.2/bin/apache-tomcat-9.0.2.zip
- Unzip
- Put the IBMrest.war into the apache-tomcat-9.0.2/webaps folder
- run apache-tomcat-9.0.2/bin/startup.bat
- see the result on http://localhost:8080/IBMrest/rest/