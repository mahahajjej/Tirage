package tn.tirage.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import tn.tirage.service.ServiceAgent;
import tn.tirage.service.ServiceAuthentification;
import tn.tirage.service.ServiceEnseignant;
import tn.tirage.service.ServiceMatiere;
import tn.tirage.service.ServiceTache;

@ApplicationPath("")
public class TirageApplication extends Application {

	private Set<Class<?>> classes = new HashSet<>();

	public TirageApplication() {
		classes.add(ServiceAgent.class);
		classes.add(ServiceEnseignant.class);
		classes.add(ServiceMatiere.class);
		classes.add(ServiceTache.class);
		classes.add(ServiceAuthentification.class);
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}
}
