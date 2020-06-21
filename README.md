# Currency Converter App

Currency convertion application for converting currencies by the bnb rates. Admin functionality for adding and updating currencies.

### Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for 
notes on how to deploy the project on a live system.

### Prerequisites

JDK 11
IntelliJ IDEA 2020.1
Maven 3.6
MySQL 8

Check out pom.xml file of the project to get acquainted with all the dependencies, this is a list of some of them:
Lombok for generating auto getters, setters and constructors
Spring Security for admin administration
Thymeleaf for view templating
ModelMapper import org.modelmapper.ModelMapper;


```
<dependency>
    <groupId>org.modelmapper</groupId>
    <artifactId>modelmapper</artifactId>
    <version>2.3.5</version>
</dependency>
```


You have to set yours environment variables into your IDE for your database url, username, password, server port,
url from which to update all currencies "http://bnb.bg/Statistics/StExternalSector/StExchangeRates/StERForeignCurrencies/index.htm?download=xml&search=&lang=EN"
and to use it into application.properties file of the project
```
server.port=${SERVER_PORT}
spring.datasource.url=${MYSQL_URL}  //todo to add more explanation
spring.datasource.username=${MYSQL_USER}
spring.datasource.password=${MYSQL_PASSWORD}
```

```
@Service
public class CurrenciesReader {
    @Value("${DOWNLOAD_XML_FILE_CURRENCIES_FROM_BNB_URL}")
    private String DOWNLOAD_XML_FILE_CURRENCIES_FROM_BNB_URL;
```

What things you need to install the software and how to install them

```
Give examples
```

### Installing

A step by step series of examples that tell you how to get a development env running

Say what the step will be

```
Give the example
```

And repeat

```
until finished
```

End with an example of getting some data out of the system or using it for a little demo




## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

