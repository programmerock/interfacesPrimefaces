package ar.org.centro8.curso.java.web.interfaces.managed.beans;

import ar.org.centro8.curso.java.aplicaciones.connectors.Connector;
import ar.org.centro8.curso.java.aplicaciones.dao.interfaces.I_ArticuloRepository;
import ar.org.centro8.curso.java.aplicaciones.dao.jdbc.ArticuloRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Articulo;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("articuloMB")
@SessionScoped
public class ArticuloManagedBean implements Serializable{
    private Articulo articulo;
    private String mensaje;
    private I_ArticuloRepository ar=new ArticuloRepository(Connector.getConnection());
    private String bucarDescripcion="";

    public ArticuloManagedBean() {
        articulo=new Articulo();
        mensaje="";
    }
    
    public void save(){
        ar.save(articulo);
        mensaje="Se agregó el artículo de ID:"+articulo.getId();
        articulo=new Articulo();
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alta", mensaje));
    }
    
    public List<Articulo> getAll(){
        return ar.getAll();
    }
    
    public List<Articulo> getLikeDescripcion(){
        if(bucarDescripcion.equals("")) return ar.getAll();
        return ar.getLikeDescripcion(bucarDescripcion);
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getBucarDescripcion() {
        return bucarDescripcion;
    }

    public void setBucarDescripcion(String bucarDescripcion) {
        this.bucarDescripcion = bucarDescripcion;
    }
    
    
    
}
