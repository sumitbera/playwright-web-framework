# Playwright Web Framework

## Introduction

This is an E2E framework for web application built on top of Playwright using JAVA.
- We are using Page Factory pattern for UI separation.
- Cucumber BDD is used for maintaining feature files.
- For building application we are using Gradle as our build tool.
- For packaging the whole solution in the form of a container we are using Docker as our containerzation platform.
- Reports are always a key focus in any project and that's why for real time reporting we are using report portals built by EPAM Systems. More details can be found at https://reportportal.io/
Our report portal is running on an EC2 instance on AWS cloud and the results are being pushed real time during every execution.
- For CI pipelines we have added two different type of CI pipelines one is the Github Actions and the other one is the Bitbucket pipelines.

## How to run this project ?
Well there are two ways we can this project either using a Gradle command or using docker

### Execute by using Gradle
- It's a simple command which you run from the main project directoy, which will clean the project and run the test for you.
<br />`./gradlew clean test`

### Execute by using Docker
- Here you need to make sure that you have Docker installed and running on your machine.
- To start with you need to build the docker image of your project. Which can be done by using below command
<br />`docker build -t <image_name>`<br />
- You can give image name of your choice, for this project we are using `playwright-web`
- Once you build the docker image of your project successfully, You need to run a container of the image, which you can do it by below command <br />
`docker run <image_name>` for e.g: `docker run playwright-web`

### Reporting Configuration
- Report portal configuration is being managed under `reportportal.properties` file which is placed under `/resources` folder.
```
#####SERVER CONFIG########
rp.endpoint = <Server URL of your report portal>
rp.uuid = <This can be found from the report portal server>
rp.launch = <Any relevant name of your choice>
rp.project = <This can be found from your report portal server, mostly will look like "superadmin_personal">
#rp.tags = <Any relevant name of your choice>
rp.batch.size.logs = 5

