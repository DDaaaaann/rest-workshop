---
#author: Daan de Graaf
title: REST Principles 
subtitle: and the Art of Code Generation in an API-First Approach

---


# Agenda

- Introduction to REST Principles
- Understanding Resources in REST
- HTTP Methods and Responses
- API-First Approach
- Introduction to OpenAPI
- Workshop

# What is REST?

## What is REST?
**Representational State Transfer (REST)**

_An architectural style for designing networked applications._

## What is REST?

- **Key Principles:**
  - Resource based
  - HTTP Methods
  - Stateless
  - <span class="fragment fade-in">
      <span class="fragment highlight-red">
        Hypermedia as the Engine of Application State (HATEOAS)
      </span>
    </span>


# Understanding Resources in REST

## Understanding resources
- **Resources**: Core entities in an API.
  - Examples:
    - **Rooms**: `/guests`
    - **Room**: `/rooms/{roomNumber}`
    - **Reservation**: `/rooms/{roomNumber}/reservations`
- **Representation**: JSON, XML, etc.

## Representation
- Abstraction of data or functionality
- Resources are identified by URIs
  - Uniquely addressable on the web

## State
- Changing resource state using HTTP methods
- Resource vs Endpoint

## Relationships
- Linking to other resources
- `Reservation` links to `Guest` and `Room`
  - `/rooms/123/reservations`
  - `/guests/45/reservations`

# HTTP Methods in REST

- **Common Methods**:
  - **GET**, **POST**, **PUT/PATCH**, **DELETE**

##

![Standard HTTP methods](images/http-methods.png)
<sub><sup>[Source: Logius Standaard](https://gitdocumentatie.logius.nl/publicatie/api/adr/1.0/#http-methods)</sup></sub>

##

![Standard HTTP methods](images/http-examples.png)  
<sub><sup>[Source: Logius Standaard](https://gitdocumentatie.logius.nl/publicatie/api/adr/1.0/#http-methods)</sup></sub>

<small>HTTP also defines other methods, e.g. HEAD, OPTIONS and TRACE. For the purpose of this design rule, these operations are left out of scope.</small>

## Idempotence
![Standard HTTP methods](images/http-idempotence.png)  
<sub><sup>[Source: Logius Standaard](https://gitdocumentatie.logius.nl/publicatie/api/adr/1.0/#http-methods)</sup></sub>


## Exceptional cases

<small>Custom methods / action-oriented endpoints / complex operations</small>

Use verbs and _ to differentiate custom actions from standard operations

- _rooms/{id}/\_book_
- _guests/\_search_
- _reservations/{id}/\_upgrade_


# HTTP Responses

## Categories
![Standard HTTP methods](images/http-responses.png)
<sub><sup>[Source: restfulapi](https://restfulapi.net/http-status-codes/)</sup></sub>

## Status codes
  - **200 OK** 
  - **201 Created**
  - **204 No Content**
  - **400 Bad Request** 
  - **404 Not Found**
  - **500 Internal Server Error**

# Stateless communication

##

> Every request from client to server must contain all of the information necessary to understand the request.\
> 
> The server cannot take advantage of any stored session context on the server.



# API-First Approach

##

A development strategy in which the design and development of APIs take precedence over other software components.


## Pro's
- **Better collaboration and communication:** clear specification
- **Improved API design:** upfront focus on API design
- **Generation**: generating server and client code


## Con's
- **Upfront investment:** time-consuming and evolving requirements
- <p class="fragment strike">**Potential for divergence:** implemented code diverges from the API contract</p>


# Introduction to OpenAPI
- **Definition**: A standard format for defining APIs.
- **Features**: Language-agnostic, Supports code generation.

##

```yaml
openapi: 3.0.3
info:
  title: Hotel API
  version: 1.0.0
paths:
  /guests/{id}:
    get:
      summary: Get a guest by ID
      parameters:
        - name: id
          in: path
          required: true
          schema:
            type: string
      responses:
        '200':
          content:
          application/json:
            schema:
              type: array
              items:
                $ref: '#/components/schemas/Guest'
        '404':
          description: Guest not found

```

## Parameter types
- **Path parameters:** _/rooms/{id}_
- **Query parameters:** _/rooms?type=suite_
- **Header parameters:** _X-MyHeader: Value_
- **Cookie parameters:** _Cookie: csrftoken=BUSe35do..._

# Visualizing the API World

## Hotel
- **Rooms**
- **Guests**
- **Reservations**

## Room
- roomNumber
- type
- capacity
- status
- pricePerNight

## Guest
- name
- email
- phoneNumber

## Reservation
- Guest
- Room
- checkIn
- checkOut


# Workshop

## Overview
- **Objective**: Develop a RESTful API for managing rooms, guests, and reservations.
- **Focus Areas**: Code generation, Service layer implementation, Hands-on session.

## Details
Clone repo: [rest-workshops](https://github.com/DDaaaaann/rest-workshop)

Work in teams of two.

## Exercise

- Implement OpenAPI
  - /guests
  - /rooms
  - /reservations
  - /_search or /guests/_search
- Generate Api
- Generate Mappers
- Implement Controllers

## Tips
- Implement all TODO's
- Use [editor.swagger](https://editor.swagger.io)


# Future Workshops
- **Topics**: Client Code Generation, Error Handling, Unit Testing, HATEOAS.


# Feedback!

# Questions?

