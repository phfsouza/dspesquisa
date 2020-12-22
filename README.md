
# Big Game Survey 
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/phfsouza/dspesquisa/blob/master/LICENSE) 

# About the project

https://sds-pedro.netlify.app/

Big Game Survey is a full stack web application built during the 1st edition of **DevSuperior Week** (#sds1), event organized by [DevSuperior](https://devsuperior.com "DevSuperior website").

The application consists of a game preference survey, where the data is collected in the mobile app, and then listed in the web app, which also features a dashboard with graphics based on this data.

## Web Layout

![Web 1](https://github.com/phfsouza/dspesquisa/blob/master/assets/images/tela1.png)

![Web 2](https://github.com/phfsouza/dspesquisa/blob/master/assets/images/tela2.png)

![Web 3](https://github.com/phfsouza/dspesquisa/blob/master/assets/images/tela3.png)

## Conceptual model
![Conceptual model](https://github.com/acenelio/assets/raw/main/sds1/modelo-conceitual.png)

# Technologies used
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven

## Front end
- HTML / CSS / JS / TypeScript
- ReactJS
- Apex Charts
- Expo

## Implementation in production
- Back end: Heroku
- Front end web: Netlify
- Database: Postgresql

# How to execute the project

## Back end
Prerequisites: Java 11

```bash
# clone repository
git clone https://github.com/phfsouza/dspesquisa.git

# enter the back end project folder
cd backend

# execute the project
./mvnw spring-boot:run
```

## Front end web
Prerequisites: npm / yarn

```bash
# clone repository
git clone https://github.com/phfsouza/dspesquisa.git

# enter the front end web project folder
cd front-web

# install dependencies
yarn install

# execute the project
yarn start
```
# Autor

Pedro Henrique Ferreira de Souza

https://www.linkedin.com/in/pedrohferreirasouza/
