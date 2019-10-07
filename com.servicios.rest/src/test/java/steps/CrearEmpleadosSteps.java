package steps;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.Matchers.is;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.containsString;

public class CrearEmpleadosSteps {
	private String strEndPoint = "https://reqres.in/api/users";
	private static Map<String, String> candidato = new HashMap<String, String>();
	private Response response;

	@Step
	public void laBusquedaEsEjecutadaExitosamente() {
		response.then().statusCode(201);
	}

	@Step
	public void yoDeberiaEncontrarLaCiudadIngresada(String country) {
		 response.then().body("RestResponse.result.name", is(country));
		response.then().body("respuesta", containsString("El consumo del servicio fue exitoso"));
	}

	@Step
	public void RecibirDatosDelNuevoCandidato(String strNombreCandidato, String strCargo) {
		try {
			candidato.put("name", strNombreCandidato);
			candidato.put("job", strCargo);
			response = SerenityRest.given().contentType("application/json").body(candidato).log().all().when()
					.post(strEndPoint);
		} catch (Exception e) {
			System.out.println("e: " + e.getMessage());
		}
	}

	@Step
	public void SeCreaEnLaBitacoraDeEmpleadosElNuevoCandidato() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		response.then().body("createdAt", containsString(dateFormat.format(date)));
		String strId = response.then().extract().path("id");
		Serenity.recordReportData().withTitle("ID").andContents("El ID del empleado " + response.then().extract().path("name") + " es: " + strId);
	}
}