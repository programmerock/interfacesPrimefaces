package ar.org.centro8.curso.java.web.interfaces.managed.beans;

import ar.org.centro8.curso.java.aplicaciones.enumerados.Letra;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("letraMB")
@SessionScoped
public class LetraManagedBean implements Serializable{
    public List<Letra> getLetra(){
        return Arrays.asList(Letra.values());
    }
}
