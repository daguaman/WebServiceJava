/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utpl.wspft.dao;

import edu.utpl.wspft.entity.PftModalidad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Miguel Tenezaca
 */
@Local
public interface PftModalidadDao {

    List<PftModalidad> buscarTodo();
}
