/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utpl.wspft.dao.implement;

import edu.utpl.wspft.dao.AbstractDao;
import edu.utpl.wspft.dao.PftModalidadDao;
import edu.utpl.wspft.entity.PftModalidad;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Miguel Tenezaca
 */
@Stateless
public class PftModalidadDaoImplement extends AbstractDao<PftModalidad> implements PftModalidadDao {

    public PftModalidadDaoImplement() {
        super(PftModalidad.class);
    }

    @Override
    public List<PftModalidad> buscarTodo() {
        @SuppressWarnings("UnusedAssignment")
        List<PftModalidad> modalidades = new ArrayList<>();
        StoredProcedureQuery storedProcedureQuery = em.createNamedStoredProcedureQuery("modalidadesTodo");
        storedProcedureQuery.execute();
        modalidades = (List<PftModalidad>) storedProcedureQuery.getResultList();
        return modalidades;
    }

}
