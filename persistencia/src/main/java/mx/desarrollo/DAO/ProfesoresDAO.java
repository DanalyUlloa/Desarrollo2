/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.DAO;

import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.persistencia.AbstractDAO;
import java.util.List;
import mx.desarrollo.persistencia.HibernateUtil;
import org.hibernate.Query;
/**
 *
 * @author danal
 */
public class ProfesoresDAO extends AbstractDAO<Integer, Profesor> {
    
    public ProfesoresDAO(){
        super();
        setEntityClass(Profesor.class);
    }
    public List<Object[]> obtenerProfesorAsignaciones(){
        System.out.println("Profesor: \t \t Asignación");
        List<Object[]> result = null;
        
        try{
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            String hql = "SELECT p.nombre, p.apellidoPaterno, p.apellidoMaterno, ua.nombre From profesor p "
                    +"LEFT JOIN Asignacion a ON p.idProfesor = a.idProfesor "
                    + "LEFT JOIN UnidadAprendizaje u ON a.idUnidadAprendizaje = u.idUnidadAprendizaje "
                    + "ORDER BY p.nombre ASC";
            
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

    public List<Profesor> buscarProfesorUnidad(String nombreUnidad){
        System.out.println("*** Profesor Por Unidad de Aprendizaje ***");
        List<Profesor> profesor = null;
        
        try{
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            
            String hql = "SELECT p FROM Profesores p"
                    + "JOIN Asignacion a ON p.idProfesor"
                    + "JOIN UnidadAprendizaje u ON a.idUnidadAprendizaje = u.idUnidadAprendizaje"
                    + "WHERE u.nombre = :nombreUnidad";
            Query query = HibernateUtil.getSession().createQuery(hql);
            query.setParameter("nombreUnidad", nombreUnidad);
            profesor = query.list();
        }catch (Exception e){
            HibernateUtil.rollbackTransaction();
            System.out.println("Error en buscar al Profesor");
        }finally{
            HibernateUtil.closeSession();
        }
        return profesor;
    }
    
    public void modificarAsignacionProfesor(int idProfesor, int idUnidadNueva){
        System.out.println("*** Modificacion Asignación Profesor ***");
        
        try{
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            
            String hql = "UPDATE Asignacion a SET a.idUnidadAprendizaje = :idUnidadNueva "
                    + "WHERE a.idProfesor = :idProfesor";
            
            Query query = HibernateUtil.getSession().createQuery(hql);
            query.setParameter("idUnidadNueva", idUnidadNueva);
            query.setParameter("idProfesor", idProfesor);
            query.executeUpdate();
            
            HibernateUtil.commitTransaction();
        }catch (Exception e){
            HibernateUtil.rollbackTransaction();
            System.out.println("Error en Modificar Profesor" + e);
        }finally{
                HibernateUtil.closeSession();
                }
        }
    
    public void eliminarProfesorId(int idProfesor){
        System.out.println("*** Eliminar Profesor porID ***");
        
        try{
            HibernateUtil.getSession();
            HibernateUtil.beingTransaccion();
            
            Profesor profesor = find(idProfesor);
            if (profesor != null){
                delete(profesor);
                HibernateUtil.commitTransaction();
            }
        }catch(Exception e){
            HibernateUtil.rollbackTransaction();
            System.out.println("Error al eliminar al profesor\n"+e);
        }finally{
            HibernateUtil.closeSession();
        }
    }
}
