/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utpl.wspft.dao.implement;

import edu.utpl.wspft.dao.AbstractDao;
import edu.utpl.wspft.dao.PftPersonaDao;
import edu.utpl.wspft.entity.PftPersona;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Miguel Tenezaca
 */
@Stateless                                                                                                            
public class PftPersonaDaoImplement extends AbstractDao<PftPersona> implements PftPersonaDao {

    public PftPersonaDaoImplement() {
        super(PftPersona.class);
    }

    @Override
    public List<PftPersona> buscarTodo() {
        @SuppressWarnings("UnusedAssignment")
        List<PftPersona> personas = new ArrayList<>();
        StoredProcedureQuery storedProcedureQuery = em.createNamedStoredProcedureQuery("personasTodo");
        storedProcedureQuery.execute();
        personas = (List<PftPersona>) storedProcedureQuery.getResultList();
        return personas;
    }

    @Override
    public PftPersona buscarPorCedula(String cedula) {
        StoredProcedureQuery storedProcedureQuery = em.createNamedStoredProcedureQuery("personaPorCedula");
        storedProcedureQuery.setParameter("dni", cedula);
        storedProcedureQuery.execute();
        List<PftPersona> personas = (List<PftPersona>) storedProcedureQuery.getResultList();
        return !personas.isEmpty() ? personas.get(0) : null;
    }
}
