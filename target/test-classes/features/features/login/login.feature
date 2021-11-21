#language: es
  @LOGIN
  Característica: Login Proyecto

    @LOGIN_EXITOSO
    Escenario: Login con las credenciales del usuario correctas
      Dado que estoy en la pantalla de inicio
      Cuando ingreso las credenciales del usuario
        | user          | pass         |
        | admin@gmail.com | admin |
      Entonces se debería validar que estoy en el home de la plataforma

    @LOGIN_NO_EXITOSO
    Escenario: Login incorrecto con el password vacio
      Dado que estoy en la pantalla de inicio
      Cuando ingreso las credenciales del usuario
        | user          | pass |
        | admin@gmail.com |      |
      Entonces se debería validar que se muestra el mensaje de error "The password field is required."

    @LOGIN_NO_EXITOSO
    Escenario: Login incorrecto con el password incorrecto
      Dado que estoy en la pantalla de inicio
      Cuando ingreso las credenciales del usuario
        | user          | pass      |
        | admin@gmail.com | usuario |
      Entonces se debería validar que se muestra el mensaje de error "These credentials do not match our records."