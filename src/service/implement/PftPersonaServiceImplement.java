/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utpl.wspft.service.implement;

import edu.utpl.wspft.dao.PftPersonaDao;
import edu.utpl.wspft.entity.PftPersona;
import edu.utpl.wspft.enumeration.ConstanteEnumeration;
import edu.utpl.wspft.service.PftPersonaService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Miguel Tenezaca
 */
@Stateless
public class PftPersonaServiceImplement implements PftPersonaService {

    @EJB
    private PftPersonaDao personaDao;
    private static final Logger LOG = Logger.getLogger(PftPersonaServiceImplement.class.getName());

    @Override
    public List<PftPersona> buscarTodo() {
        List<PftPersona> personas = personaDao.buscarTodo();
        List<PftPersona> result = new ArrayList<>();
        try {
            for (PftPersona persona : personas) {
                PftPersona pftPersona = new PftPersona();
                pftPersona.setEcvId(persona.getEcvId());
                pftPersona.setEntId(persona.getEntId());
                pftPersona.setPerPrimerNombre(new String(persona.getPerPrimerNombre().getBytes(), ConstanteEnumeration.UTF8.getTipo()));
                pftPersona.setPerSegundoNombre(new String(persona.getPerSegundoNombre().getBytes(), ConstanteEnumeration.UTF8.getTipo()));
                pftPersona.setPerPrimerApellido(new String(persona.getPerPrimerApellido().getBytes(), ConstanteEnumeration.UTF8.getTipo()));
                pftPersona.setPerSegundoApellido(new String(persona.getPerSegundoApellido().getBytes(), ConstanteEnumeration.UTF8.getTipo()));
                pftPersona.setEntIdentificacion(persona.getEntIdentificacion());
                pftPersona.setPerFechaNacimiento(persona.getPerFechaNacimiento());
                result.add(pftPersona);
            }
        } catch (Exception e) {
            LOG.log(Level.OFF, null, e);
        }

        return result;
    }

    @Override
    public PftPersona buscarPorCedula(String cedula) {
        PftPersona persona = personaDao.buscarPorCedula(cedula);
        PftPersona result = new PftPersona();
        try {
            if (persona == null) {
                return null;
            }
            result.setEcvId(persona.getEcvId());
            result.setEntId(persona.getEntId());
            result.setPerPrimerNombre(new String(persona.getPerPrimerNombre().getBytes(), ConstanteEnumeration.UTF8.getTipo()));
            result.setPerSegundoNombre(new String(persona.getPerSegundoNombre().getBytes(), ConstanteEnumeration.UTF8.getTipo()));
            result.setPerPrimerApellido(new String(persona.getPerPrimerApellido().getBytes(), ConstanteEnumeration.UTF8.getTipo()));
            result.setPerSegundoApellido(new String(persona.getPerSegundoApellido().getBytes(), ConstanteEnumeration.UTF8.getTipo()));
            result.setEntIdentificacion(persona.getEntIdentificacion());
            result.setPerFechaNacimiento(persona.getPerFechaNacimiento());
        } catch (Exception e) {
             LOG.log(Level.OFF, null, e);
        }

        return result;
    }
}
