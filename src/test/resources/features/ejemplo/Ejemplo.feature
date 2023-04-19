#language: es

Característica: Ejemplo

  #Escenario Simple
  Escenario: Obtener los datos de un usuario
    Dado el id de un usuario existente
    Cuando se intenta obtener los datos del usuario
    Entonces se debe visualizar los datos del usuario solicitado

  #Escenario con ejemplos
  Esquema del escenario: Obtener los datos de un usuario usando ejemplos
    Dado el id de un usuario existente igual a <id>
    Cuando se intenta obtener los datos del usuario
    Entonces se debe visualizar los datos del usuario <nombre> <apellido>

    Ejemplos:
      | id | nombre | apellido |
      | 1  | George | Bluth    |
      | 2  | Janet  | Weaver |