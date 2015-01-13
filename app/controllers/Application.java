package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Appointment;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {
	private static final Form<Appointment> appForm = Form.form(Appointment.class);


	public static Result index() {
        return ok(index.render(Appointment.findAll(), appForm));
    }

	public static Result getAllAppointments() {
		JsonNode jsonNode = Json.toJson(Appointment.findAll());
		return ok(jsonNode);
	}

	public static Result createAppointment() {
		Form<Appointment> appointmentForm = appForm.bindFromRequest();
		Appointment.save(appointmentForm.get());
		return ok();
	}

}
