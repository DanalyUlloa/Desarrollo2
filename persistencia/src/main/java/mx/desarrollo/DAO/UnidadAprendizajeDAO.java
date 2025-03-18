/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.DAO;

import java.util.List;
import mx.desarrollo.entidad.UnidadAprendizaje;
import mx.desarrollo.persistencia.AbstractDAO;
import mx.desarrollo.persistencia.HibernateUtil;
import org.hibernate.Query;

/**
 *
 * @author PC
 */
public class UnidadAprendizajeDAO extends AbstractDAO<Integer, UnidadAprendizaje>{
    private List<UnidadAprendizaje> unidades;
     public UnidadAprendizajeDAO(){
        super();
        setEntityClass(UnidadAprendizaje.class);
    }
    public List<Object[]> obtenerUnidadAprendizaje(){
        System.out.println("Unidad de aprendizaje: \t \t");
        List<Object[]> result = null;
        
        try{
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            String hql =  "SELECT ua.claveUnidadAprendizaje, ua.nombreUnidad, ua.horasclase, ua.horastaller, ua.horaslaboratorio"
                    +"LEFT JOIN Asignacion a ON ua.UnidadAprendizaje = a.claveUnidadAprendizaje"
                    + "LEFT JOIN UnidadAprendizaje u ON a.claveUnidadAprendizaje = u.claveUnidadAprendizaje "
                    + "ORDER BY ua.nombreUnidad ASC";
            
            Query query = HibernateUtil.getSession().createQuery(hql);
            result = query.list();
        }catch (Exception e){
            HibernateUtil.rollbackTransaction();
            System.out.println("Error en la consulta Profesor con Asignaciones: " + e);
            
        }finally{
            HibernateUtil.closeSession();
        }
        
        return result;
    }

    public UnidadAprendizaje buscarPorClave(int claveUnidadAprendizaje) {
        for (UnidadAprendizaje unidad : unidades) {
            if (unidad.getClaveUnidadAprendizaje().equals(claveUnidadAprendizaje)) {
                return unidad;
            }
        }
        return null;
    }

    public void eliminarUnidad(int claveUnidadAprendizaje) {
        unidades.removeIf(unidad -> unidad.getClaveUnidadAprendizaje().equals(claveUnidadAprendizaje));
    }
}
