package io.redbee.steps;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.Json;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.redbee.support.BeeRequest;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

public class EjemploSteps {

    private static final BeeRequest request = new BeeRequest("https://reqres.in");
    private static Object bookId;
    private static Response response;

    @Dado("el id de un usuario existente")
    public void elIdDeUnusuarioExistente() {
        bookId = 2;
    }

    @Cuando("se intenta obtener los datos del usuario")
    public void seIntentaObtenerLosDatosDelusuario() {
        HashMap<String, Object> queryParams = new HashMap<>();
        queryParams.put("id", bookId);

        request.setMethod("GET");
        request.setQueryParams(queryParams);
        request.setPath("/api/users/{id}");

        response = request.execute();
    }
    @Entonces("se debe visualizar los datos del usuario solicitado")
    public void seDebeVisualizarLosDatosDelusuarioSolicitado() {
        Assertions.assertEquals(200,response.statusCode(),"El Status Code debe ser 200");

        String jsonString = response.asString();
        Assertions.assertEquals("janet.weaver@reqres.in", JsonPath.from(jsonString).getString("data.email"),"El email debe ser esperado");
        Assertions.assertEquals("Janet", JsonPath.from(jsonString).getString("data.first_name"),"El nombre debe ser igual al esperado");
        Assertions.assertEquals("Weaver", JsonPath.from(jsonString).getString("data.last_name"),"El apellido debe ser igual al esperado");
    }

    @Dado("el id de un usuario existente igual a {int}")
    public void el_id_de_un_usuario_existente_igual_a(Integer id) {
        bookId = id;
    }


    @Entonces("se debe visualizar los datos del usuario {string} {string}")
    public void seDebeVisualizarLosDatosDelusuarioNombreApellido(String nombre, String apellido) {
        Assertions.assertEquals(200,response.statusCode(),"El Status Code debe ser 200");

        String jsonString = response.asString();

        Assertions.assertEquals(nombre, JsonPath.from(jsonString).getString("data.first_name"),"El nombre debe ser igual al esperado");
        Assertions.assertEquals(apellido, JsonPath.from(jsonString).getString("data.last_name"),"El apellido debe ser igual al esperado");
    }
}
