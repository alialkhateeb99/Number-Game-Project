# NUMBER GAME

## Pre-Requisites 

- Java 8
- Git
- Maven 3.x



## Cloning repository 

- Add a new folder called bitbucket under your userhome directory 
- Add a folder called STP_2020_B01 under the bitbucket directory 
- Go to the folder STP_2020_B01
- Run the below command 
    - git clone https://bitbucket.org/sidgs/number-game.git

## Adding a folder  

Sample Command : mkdir <DIR_NAME>

- DIR_NAME is the name of the directory to be created 
- DIR_NAME should not exist 

## Got to a Directory  

Sample Command : cd "FQDP"

- FQDP: Fully Qualified Directory Path
	- Ex on Windows : c:/Users/<username>/bitbucket
	- Ex on Unix: /home/<username>/bitbucket


## Build and Run 
- Compile and Test 
    - __mvn clean compile test__ 
- Package the application 
    - __mvn package__ 
    - This will create a  war file in the 'target' directory that can be deployed to TOMCAT_HOME/Webapps folder
    
### Using the integrated Tomcat Server 

This project comes with a maven plugin to run tomcat in a standalone manner and this simplifies the process of development

Note: Please ensure that port 8080 is free and not in use

#### Steps to start integrated Tomcat Server
On a Console / CMD prompt run the below command
- __mvn tomcat7:run-war__

This will start your server as shown http://localhost:8080/number-game
