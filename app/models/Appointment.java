package models;

import com.google.common.collect.Lists;
import play.data.validation.Constraints;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Appointment {

	private static final List<Appointment>  APPOINTMENTS = new CopyOnWriteArrayList<Appointment>();

	static {
		APPOINTMENTS.add(new Appointment("Stand up"));
		APPOINTMENTS.add(new Appointment("Grooming"));
		APPOINTMENTS.add(new Appointment("Demo"));
		APPOINTMENTS.add(new Appointment("Retro"));
	}

	@Constraints.Required
	public String name;

	public Appointment() {
	}

	public Appointment(String name) {
		this.name = name;
	}

	public static List<Appointment> findAll() {
		return Lists.newArrayList(APPOINTMENTS);
	}

	public static void save(Appointment appointment) {
		APPOINTMENTS.add(appointment);
	}
}