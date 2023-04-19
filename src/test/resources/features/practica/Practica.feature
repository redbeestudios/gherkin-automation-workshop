#language:es
@ignore
Característica: Practica

  Escenario: Inicio de sesión exitoso

    Dado un usuario registrado
    Y las credenciales correctas
    Cuando se intenta iniciar sesión
    Entonces el usuario inicia sesion correctamente

  Escenario: Agregar producto con monto inválido

    Dado el monto de un producto igual a 0
    Cuando se intenta crear el producto
    Entonces se debe visualizar el error de monto tiene que ser positivo

  Escenario: Creación de un usuario nuevo

    Dado un usuario no registrado
    Cuando se intenta crear un usuario
    Entonces el usuario de crea correctamente


  Esquema del escenario: Creación de un usuario sin datos obligatorios

    Dado un usuario no registrado
    Y un <nombre_de_dato> con valor vacío
    Cuando se intenta crear un usuario
    Entonces se debe visualizar el error de <nombre_de_dato> es obligatorio

    Ejemplos:
      | nombre_de_dato |
      | email          |
      | password       |

  Esquema del escenario: Formatos inválidos de email

    Dado un usuario no registrado
    Y un email <formato_de_email>
    Cuando se intenta crear un usuario
    Entonces se debe visualizar el error de <formato_de_email>

    Ejemplos:
      | formato_de_email |
      | sin @            |
      | sin punto        |


  Escenario: Visualizar Historial de Venta

    Dado un usuario que tiene ventas realizadas
    Cuando se intenta consultar su historial de venta
    Entonces se debe visualizar la lista de ventas realizadas


  Escenario: Password Incorrecto

    Dado que soy un usuario registrado
    Y un password incorrecto
    Cuando se intenta iniciar sesión
    Entonces se debe visualizar el error de credenciales incorrecta


  Escenario: Creación de un usuario que ya existe

    Dado un usuario registrado
    Cuando se intenta crear un usuario
    Entonces se debe visualizar el error de email ya existente


  Escenario: Email no existene

    Dado un usuario no registrado
    Y un email no existente
    Cuando se intenta iniciar sesión
    Entonces se debe visualizar el error de credenciales incorrecta

  Esquema del escenario: Formatos inválidos de email

    Dado que un usuario no registrado
    Y un email <formato_de_email>
    Cuando se intenta iniciar sesión
    Entonces se debe visualizar el error de <formato_de_email>

    Ejemplos:
      | formato_de_email |
      | sin @            |
      | sin punto        |

  Escenario: Agregar producto nuevo

    Dado los datos de un producto válidos
    Cuando se intenta crear el producto
    Entonces el producto se crea corectamente



