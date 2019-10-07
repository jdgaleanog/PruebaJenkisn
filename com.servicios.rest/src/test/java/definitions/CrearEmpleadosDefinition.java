package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import steps.CrearEmpleadosSteps;

public class CrearEmpleadosDefinition{

	@Steps
	CrearEmpleadosSteps crearEmpleadosSteps;

	@Given("^el nuevo candidato \"([^\"]*)\" al cargo \"([^\"]*)\"$")
	public void el_nuevo_candidato_al_cargo(String strNombreCandidato, String strCargo) {
		crearEmpleadosSteps.RecibirDatosDelNuevoCandidato(strNombreCandidato, strCargo);
	}

	@When("^firma contrato, se realiza la creacion en la bitacora$")
	public void firma_contrato_se_realiza_la_creacion_en_la_bitacora() {
		crearEmpleadosSteps.laBusquedaEsEjecutadaExitosamente();
	   
	}

	@Then("^yo deberia obtener un codigo de empleado nuevo$")
	public void yo_deberia_obtener_un_codigo_de_empleado_nuevo() {
	    
	    crearEmpleadosSteps.SeCreaEnLaBitacoraDeEmpleadosElNuevoCandidato(); 
	   
	}

}
