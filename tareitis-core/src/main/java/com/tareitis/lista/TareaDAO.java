package com.tareitis.lista;

import com.google.common.base.Optional;
import io.dropwizard.hibernate.AbstractDAO;
import java.util.List;
import org.hibernate.SessionFactory;

public class TareaDAO extends AbstractDAO<Tarea> {
	public TareaDAO(SessionFactory factory) {
		super(factory);
	}

	public Tarea create(Tarea tarea) {
		return (Tarea) persist(tarea);
	}

	public Optional<Tarea> findById(int id) {
		return Optional.fromNullable((Tarea) get(Integer.valueOf(id)));
	}

	public List<Tarea> findAll() {
		return list(namedQuery("com.tareitis.lista.Tarea.findAll"));
	}

	public Lista obtenerLista(int codUsuario) {
		return null;
	}
}