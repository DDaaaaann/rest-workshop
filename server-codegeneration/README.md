# Generating server code

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

[Slides](http://localhost:63342/rest-workshop/server-codegeneration/slides/presentation.html)
