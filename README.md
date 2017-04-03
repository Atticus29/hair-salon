# Hair Salon App

#### Hair Salon App, 03-31-2017

#### By Mark Fisher


## Description
This application would help a hair salon manage it's clients and stylists.

#### User stories
- [x] As a salon employee, I need to be able to see a list of all our stylists.
- [x] As an employee, I need to be able to select a stylist, see their details, and see a list of all clients that belong to that stylist.
- [x] As an employee, I need to add new stylists to our system when they are hired.
- [x] As an employee, I need to be able to add new clients to a specific stylist.
- [x] As an employee, I need to be able to update a stylist's details.
- [x] As an employee, I need to be able to update a client's details.
- [x] As an employee, I need to be able to delete a stylist if they're no longer employed here. (What happens to the clients?)
- [x] As an employee, I need to be able to delete a client if they no longer visit our salon.

#### Bonus user stories
- [x] As an employee, I need to be able to search for all or part of a stylist's name and see their details.


## Specifications

| Behavior                   | Input Example     | Output Example    |
| -------------------------- | -----------------:| -----------------:|
|User should be able to add a stylist|Add Naomi Smalls|Naomi Smalls added as a stylist|
|User should be able to add a client to a stylist|Add Jiggly Caliente to Naomi Small's client list|Jiggly Caliente added to Naomi Small's client list|
|User should be able to add a second client to a stylist's client list|Add Serena Cha Cha to Naomi Small's client list|Serena Cha Cha added to Naomi Small's client list|
|User should be able to edit details about a client|Change Serena Cha Cha's address to Panama|Serena Cha Cha's address updated to reflect address change|
|User should be able to remove a client from the system|Remove Serena Cha Cha completely|Serena Cha Cha removed|
|User should be able to edit details about a stylist|Change Naomi Small's hours of operation to 9-5 on MWF|Naomi Small's hours of operation changed to 9-5 MWF|
|User should be able to remove a stylist from the app|Remove Naomi Smalls|Naomi Smalls removed completely|

## Known Bugs
Currently, clients are orphaned when their stylist is deleted. A future fix would involve capturing the clients of a stylist in the delete method, delete the stylist, and then re-assign the clients at random to existing stylists (or keep them in limbo if no more stylists exist).

## Setup/Installation Requirements

* _Clone the repository_
* _Install [postgres](https://www.learnhowtoprogram.com/java/database-basics/installing-postgres-300b6a5b-7e65-4c23-b024-3d9e22dc5fe9) and [gradle](https://www.learnhowtoprogram.com/java/behavior-driven-development-with-java-604c2c27-3431-444d-8047-2fb947d022c6/gradle-and-project-dependencies) _
* _Set up a terminal session and run `postgres`_
* _Set up a second terminal session and run `psql`_
* _Create a new database in your psql session by typing, `CREATE DATABASE hair_salon;`_
* _In another terminal session, navigate to the hair-salon repo directory from the command line, type, `psql hair_salon < hair_salon.sql`_
* _Run the command `gradle run`_
* _Open browser and go to localhost:4567_


### License

Copyright (c) 2017 Mark Fisher

This software is licensed under the MIT license.
