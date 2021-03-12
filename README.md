<p align="center">
    <img alt="Glassfish Payara Logo" src="src/main/webapp/resources/images/payara-logo.png" width="120" />
</p>

<h1 align="center">:fish: JSF Login Project <img alt="Project Sparta Badge" src="https://img.shields.io/badge/project-sparta-%23e43560?label=project&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACQAAAAkCAMAAADW3miqAAABZVBMVEVAIFHkNWBBH1FDHlHiNmBBH1LON2DlNWBcHVH+/v////3FNmFAHlRAG08/H1A+IFFhIU5BHlL9/fxBH05EHVL///xAHlH9//3//v3Y0dnjNl9LLFhCHVRDG08+IU79//v7//vMwtD4+Pi8scF6ZITjNmLfOF5BI1JDHU/28/ZuV3pGKFZEI1FnH08/HU339veDbI7kNV7iN11NHlE/HEv//////P/7/PrVOGPdN2JiIVE8IVFAHU8/H05UHk1AGU1HHUxNHEy8scCklamjk6iCa4p3YYDRNmbKNmLHNmHBNWHnNGCvMGBTH1NAHFHy7PLt6e/Vy9iwpLWwpLSoma6jkKaXf5t6ZoFvVnpgRG1hS2lYPWW1M11NMFqMLViLJ1iVLFd2KVd7JVR2IFOHKFJeIVFaH009GUjg2ePDuMfAucKzqLqxpbiQeZeMe5HaOGTQN2CqNGCmLF+dLFuEKllJJ1lGKFVpXQQhAAACNUlEQVR42qXQhXajWACAYZyQwmVxSrwtbNzdU7fU3X3c5fmHCHMgDcfmj4ePa9A4XBQ50GBxZzQqAMgW28BpWkYccVwwaDdCMNAreP5zVk+l+rg1CBREAu3HH1cbxKvuWQuJXPdhu2pgGAaT9raw2r1sTdUo3H3F8vkBckRqa3VujJDuXS2XN4xXKKdt9v0jIqI/q8NRdFjXHEjb2i4MEYLLL5ukhuVIUqutrc842rgRhmeA0umn2haskXr16inlcdYu0NCgKN3b1nUsp63dtqMcJ3P0IM7vH3ywAB+OJID2DGZmfO+x/mbw/1HJZBKxH7X8vG4avfoIgLD6YX7Y4uL8SsuOkDqBma0/s+nzt4p3FFVaTkO2xBSBGXltwyMzCxmFokIURalh5diO2EaKMIwcOeMBzMKceZ2vVCp8hT8u2geS6wQJY/oIlVV+cSU76BzYR/L3b75tEl/GKMSfvOl00szODm5HEN7tvaQebgt/UbFYZBgOmghncdBtQaPpIstLS0vLK78mFEv7ab/IscOFU6okSd5S7FNrAiFRVAAox6xmeIoKK4qi8uF3SWhq4HJWMg+yVPKGKG8kMd1ArfjRweHB4ftM2BUFg/5mOtpsFi/2XBBiJiAM0wkEOu4IRdHodXzQ2edddyQyq7uxQRmeHyB5OjrNhFRVCYVUhQ9HfkMuaC4kDfMq/JHggs72Z8ftf7wE0xcuJH1W18kdfPoRQLIcDZhFAyjOOc3kgIMQd/Fv6A8ksVwk6PNPnQAAAABJRU5ErkJggg==" /> :fish:</h1>

> JSF Login Project for Sparta Global

## Table of Contents

#### [About :question:](#about)
#### [Dependencies :computer:](#depdendencies)
#### [Package Architecture :tokyo_tower:](#packages)
#### [Security :tshirt:](#security)
#### [Login :performing_arts:](#login)
#### [Database :clipboard:](#database)
#### [Future Enhancements :customs:](#future)

<div id='about'/>

## About :question:

As part of my training with Sparta Global, I was assigned the task of building a login application in Java EE, using JSFs as the template engine with SQL for the database.

The application needed to allow 2 different types of users to log in: user and admin. Users should see a simple welcome screen while admins should be able to add new users to the database. The application should make use of Security features to make sure a user cannot see the options an admin does.

I was also required to make use of Bootstrap and Facelets to create the UI.



<div id='dependencies'/>

## Dependencies :computer:

- mySql connector
- hibernate
- glassfish
- bootstrap
- mojarra server faces

<div id='packages'/>

## Package Architecture :tokyo_tower:

- authentication
- entity
- service
- view
- resources

<div id='security'/>

## Security :tshirt:

- web.xml
- roles

<div id='login'/>

## Login :performing_arts:

- loginbean
- jsf actions
- identitystore
- credentials (more about this in database)

<div id='database'/>

## Database :clipboard:

- persistence
- JPA 
- schema
- data types
- credentials repo

<div id='future'/>

## Future Enhancements :customs:

- more roles
- find by id
- users can change details
- apache tomcat
