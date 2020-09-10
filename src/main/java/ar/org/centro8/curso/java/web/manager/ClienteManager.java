package ar.org.centro8.curso.java.web.manager;

import ar.org.centro8.curso.java.aplicaciones.connectors.Connector;
import ar.org.centro8.curso.java.aplicaciones.dao.interfaces.I_ClienteRepository;
import ar.org.centro8.curso.java.aplicaciones.dao.jdbc.ClienteRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Cliente;
import java.util.List;

public class ClienteManager {
    private I_ClienteRepository cr=new ClienteRepository(Connector.getConnection());
    public List<Cliente> getAll(){
        return cr.getAll();
    }
}
