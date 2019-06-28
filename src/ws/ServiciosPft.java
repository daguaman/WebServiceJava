/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utpl.wspft.ws;

import com.google.gson.Gson;
import edu.utpl.wspft.service.PftModalidadService;
import edu.utpl.wspft.service.PftPersonaService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.WebServiceContext;

/**
 *
 * @author Miguel Tenezaca
 */
@WebService(serviceName = "ServiciosPft")
public class ServiciosPft {

    @EJB
    private PftPersonaService personaService;
    @EJB
    private PftModalidadService pftModalidadService;
    @Resource
    WebServiceContext wsctx;
    private Encripta encripta;
    private static final Logger LOG = Logger.getLogger(ServiciosPft.class.getName());

    /**
     * Web service operation
     *
     * @return
     */
    @WebMethod(operationName = "get_personas")
    public String getPersonas() {
        try {
            Gson gson = new Gson();
            String datos = gson.toJson(personaService.buscarTodo());
            encripta = new Encripta();
//            encripta.setEncryptC(Cipher.getInstance("DES"));
//            KeySpec ks = new DESKeySpec(ConstanteEnumeration.SECRETKEY.getTipo().getBytes(ConstanteEnumeration.UTF8.getTipo()));
//            SecretKeyFactory kf = SecretKeyFactory.getInstance("DES");
//            SecretKey ky = kf.generateSecret(ks);
//            encripta.getEncryptC().init(Cipher.ENCRYPT_MODE, ky);
            return encripta.encripta(datos);

        } catch (Exception e) {
            LOG.log(Level.OFF, null, e);
        }
        return "";

    }

    @WebMethod(operationName = "get_modalidades")
    public String getModalidades() {
        try {
            Gson gson = new Gson();
            String datos = gson.toJson(pftModalidadService.buscarTodo());
            encripta = new Encripta();

            return encripta.encripta(datos);
        } catch (Exception e) {
            LOG.log(Level.OFF, null, e);
        }
        return "";
    }

    /**
     * Web service operation
     *
     * @param cedula
     * @return
     */
    @WebMethod(operationName = "get_persona_cedula")
    public String personaPorCedula(@WebParam(name = "cedula") final String cedula) {

        try {
            Gson gson = new Gson();
            String datos = gson.toJson(personaService.buscarPorCedula(cedula));
            encripta = new Encripta();

            return encripta.encripta(datos);
        } catch (Exception e) {
            LOG.log(Level.OFF, null, e);
        }
        return "";

    }
}
