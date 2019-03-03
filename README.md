**Spring Boot Project to develop a REST Interface for retrieval of Real Estate Data**

spring-boot-real-estate directory - contains the spring boot backend project
app directory - contains the react frontend project

The project is developed using spring boot as the backend service, react native as the frontend application and mongodb as the database.

Since I didn't receive the JSON data file along with the project, I loaded the JSON data manually using the LoadDataRepository.java in the spring boot project.


In order to run the project, the user needs to have a mongodb installed locally. The instructions to install mongodb can be found below. After that the follow the sequence :

Run mongodb

	mongod

Run Spring boot

	mvn clean spring-boot:run

Run React app

	yarn start


**Frontend URL**

	http://localhost:3000/


**Backend URL**

	http://localhost:8080/

REST API endpoints


* **URL**

  /api/v1/realestates

* **Method:**

  `GET` 

* **Success Response:**
  
  * **Code:** 200 <br />
    **Content:** `[
    {
        "id": "5c7c37dd8947d043dd41afb9",
        "name": "Berlin",
        "resultListEntries": {
            "addressToDisplay": "10178, Berlin",
            "commercializationType": "RENT",
            "features": [
                "2 Bedroom, Kitchen, Bathroom"
            ],
            "floorSpace": "80 sq. m",
            "docId": "65573128",
            "priceForTotalArea": "1100 EUR",
            "realtorCompanyName": "EB Immo",
            "realtorName": "Michael",
            "title": "EBM",
            "pictureUrl": "www.google.com",
            "productType": "L"
        }
    },
    {
        "id": "5c7c37dd8947d043dd41afbb",
        "name": "Berlin",
        "resultListEntries": {
            "addressToDisplay": "10589, Berlin",
            "commercializationType": "BUY",
            "features": [
                "3 Bedroom, Kitchen, Bathroom, Balcony"
            ],
            "floorSpace": "90 sq. m",
            "docId": "65573130",
            "priceForTotalArea": "1300 EUR",
            "realtorCompanyName": "Immowelt",
            "realtorName": "Christian",
            "title": "IW",
            "pictureUrl": "www.google.com",
            "productType": "L"
        }
    },
    {
        "id": "5c7c37dd8947d043dd41afba",
        "name": "Berlin",
        "resultListEntries": {
            "addressToDisplay": "10179, Berlin",
            "commercializationType": "BUY",
            "features": [
                "1 Bedroom, Kitchen, Bathroom"
            ],
            "floorSpace": "50 sq. m",
            "docId": "65573129",
            "priceForTotalArea": "700 EUR",
            "realtorCompanyName": "Best Immo",
            "realtorName": "Eric",
            "title": "BI",
            "pictureUrl": "www.google.com",
            "productType": "S"
        }
    }
]`

* **Sample Call:**

  GET http://localhost:8080/api/v1/realestates




1. GET request to return all real estates sorted by Product Type 

	GET http://localhost:8080/api/v1/realestates

	Success Response : 200 OK

	Content-Type : JSON 



2. GET request to return all real estates grouped by Post Code

	GET http://localhost:8080/api/v1/realestates/count

	Success Response : 200 OK

	Content-Type : JSON

3. GET request to return all real estates

	GET http://localhost:8080/api/v1/realestates/list

	Success Response : 200 OK

	Content-Type : JSON


**To Configure MongoDB locally**

Follow the instructions:

https://docs.mongodb.com/manual/administration/install-community/

https://treehouse.github.io/installation-guides/mac/mongo-mac.html

To start mongodb from the command line:

	mongod

Mongodb starts on the Port number 27017

**To Run the Spring Boot application**

Using Maven plugin, from the command line:

	mvn clean spring-boot:run

Using Jar file as a packaged application, from the command line:

	mvn clean package

	java -jar ./target/spring-boot-real-estate-0.0.1-SNAPSHOT.jar


Spring boot project starts on the Port number 8080

**To Run the React application**

1. Go to the app directory

2. From the command line use:

	yarn start

React application starts on the Port number 3000