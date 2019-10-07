@colaboradores
Feature: Verificar creacion colaborador

  Scenario Outline: Prueba empleado nuevo
    Given el nuevo candidato "<txtNombreEmpleado>" al cargo "<txtCargo>"
    When firma contrato, se realiza la creacion en la bitacora
    Then yo deberia obtener un codigo de empleado nuevo

    Examples: 
      | txtNombreEmpleado | txtCargo   |
      | Juan              | Secretario |
      | Pedro             | Carpintero |
      | Luisa             | Chofer     |
