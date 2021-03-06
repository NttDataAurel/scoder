package com.nttdata.practicadevara.scoder.rest.services;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class ScoderRestApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        // register root resource
        classes.add(ServicesAppConfig.class);
        classes.add(ServicesPhase.class);
        classes.add(ServicesUserSkill.class);
        classes.add(ServicesUserPhaseResult.class);
        classes.add(ServicesUser.class);
        return classes;
    }
   
}
