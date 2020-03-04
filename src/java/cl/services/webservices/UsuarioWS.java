/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.services.webservices;

import cl.model.pojos.Usuario;
import cl.model.dao.UsuarioDAO;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


/**
 *
 * @author willi
 */
@WebService(serviceName = "UsuarioWS")
public class UsuarioWS {

    /**
     * Web service operation
     * @param idUsuario
     * @param nip
     * @param nombre
     * @param celular
     * @return 
     */
    @WebMethod(operationName = "IngresarUsuario")
    public String IngresarUsuario(@WebParam(name = "idUsuario") int idUsuario, @WebParam(name = "nip") String nip, @WebParam(name = "nombre") String nombre, @WebParam(name = "celular") String celular) {
        Usuario u = new Usuario(nip,nombre,celular);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.ingresarUsuario(u);
        return "Usuario ingresado";
    }

    /**
     * Web service operation
     * @param nip
     * @return 
     */
    @WebMethod(operationName = "BuscarUsuario")
    public String BuscarUsuario(@WebParam(name = "nip") String nip) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        return usuarioDAO.consultarUsuario(nip);
    }
}
