package ar.org.centro8.curso.java.web.interfaces.managed.beans;

import ar.org.centro8.curso.java.aplicaciones.connectors.Connector;
import ar.org.centro8.curso.java.aplicaciones.dao.interfaces.I_FacturaRepository;
import ar.org.centro8.curso.java.aplicaciones.dao.jdbc.FacturaRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Factura;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("facturaMB")
@SessionScoped
public class FacturaManagedBean implements Serializable{
    private Factura factura;
    private String mensaje;
    private I_FacturaRepository fr=new FacturaRepository(Connector.getConnection());
    private int buscarIdCliente=0;

    public FacturaManagedBean() {
        mensaje="";
        factura=new Factura();
    }
    
    public void save(){
        fr.save(factura);
        mensaje="Se agregó la factura:"+factura.getLetra()+factura.getNumero();
        factura=new Factura();
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Alta", mensaje));
    }
    
    public List<Factura> getAll(){
        return fr.getAll();
    }
    
    public List<Factura> getByIdCliente(){
        if(buscarIdCliente==0)return fr.getAll();
        return fr.getByIdCliente(buscarIdCliente);
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getBuscarIdCliente() {
        return buscarIdCliente;
    }

    public void setBuscarIdCliente(int buscarIdCliente) {
        this.buscarIdCliente = buscarIdCliente;
    }
    
    
    
}
