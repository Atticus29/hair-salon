# Hair Salon App

#### Hair Salon App, 03-31-2017

#### By Mark Fisher


## Description
This application would help a hair salon manage it's clients and stylists.

#### User stories
- [ ] As a salon employee, I need to be able to see a list of all our stylists.
- [ ] As an employee, I need to be able to select a stylist, see their details, and see a list of all clients that belong to that stylist.
- [ ] As an employee, I need to add new stylists to our system when they are hired.
- [ ] As an employee, I need to be able to add new clients to a specific stylist.
- [ ] As an employee, I need to be able to update a stylist's details.
- [ ] As an employee, I need to be able to update a client's details.
- [ ] As an employee, I need to be able to delete a stylist if they're no longer employed here. (What happens to the clients?)
- [ ] As an employee, I need to be able to delete a client if they no longer visit our salon.



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

### Bonus Specifications

| Behavior                   | Input Example     | Output Example    |
| -------------------------- | -----------------:| -----------------:|
|If a stylist is removed, clients should be randomly assigned to remaining stylists|Naomi Smalls removed|Jiggly Caliente assigned to Raja and Serena Cha Cha assigned to Kim Chi|

## Setup/Installation Requirements

* _Clone the repository_
* _Run the command 'gradle run'_
* _Open browser and go to localhost:4567_


### License

Copyright (c) 2017 Mark Fisher

This software is licensed under the MIT license.
