# Generating server code

You can find the presentation here: [Presentation](http://localhost:63342/rest-workshop/server-codegeneration/slides/presentation.html)

## Instructions
- Write an Api specification
  - Start at [editor.swagger.io](https://editor.swagger.io/)
  - Put your spec under `openapi.yaml`

- Generate server code
  - The pom.xml takes care of the generation, take a look at it
  - `mvn clean install` to generate the code
  - Take a look at the generated code

- Implement all controllers
  - Use the generated code to implement your controllers
  - Depend on the provided services

- Test code
  - There are request provided in de requests folder
  - See: [guests.http](requests/guests.http)
  - See: [reservations.http](requests/reservations.http)
  - See: [rooms.http](requests/rooms.http)
  - See: [search.http](requests/search.http)


