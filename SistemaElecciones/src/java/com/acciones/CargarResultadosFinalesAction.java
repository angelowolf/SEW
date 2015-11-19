/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acciones;

import DAO.DAOFactory;
import DAO.VotosXMesaXCandidato.VotosXMesaXCandidatoDAO;
import DAO.MyException;
import Modelo.Negocio.Candidato;
import com.opensymphony.xwork2.ActionSupport;
import Modelo.Negocio.VotosXMesaXCandidato;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ParameterAware;

/**
 *
 * @author angelo
 */
public class CargarResultadosFinalesAction extends ActionSupport implements ParameterAware {

    private final Map<String, Object> sesion = ActionContext.getContext().getSession();
    private final DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    private static final Logger logger = Logger.getLogger(CargarResultadosFinalesAction.class);
    private Map<String, String[]> parametros;
    private int num_mesa;
    private final Map<String, Object> application = ActionContext.getContext().getApplication();

    public String cargarFormulario() {
        try {
            List<Candidato> candidatos = (List<Candidato>) application.get("candidatos");
            String s[] = {""};
            parametros = new HashMap<>();
            for (Candidato cadaCandidato : candidatos) {
                parametros.put("" + cadaCandidato.getIdCandidato(), s);
            }
            return SUCCESS;
        } catch (MyException e) {
            logger.error("Error rediriguir al formulario de carga resultados.", e);
            return ERROR;
        }
    }

    public String cargarResultados() {
        try {

            VotosXMesaXCandidatoDAO dao = d.getVotosXMesaXCandidato();
            VotosXMesaXCandidato mr = new VotosXMesaXCandidato();
            for (Map.Entry<String, String[]> entrySet : parametros.entrySet()) {
                String key = entrySet.getKey();
                String[] value = entrySet.getValue();
                if (key.compareTo("num_mesa") != 0) {
                    int i = Integer.parseInt(value[0]);
                    mr.setCantidad(i);
                    mr.setNumeroMesa(num_mesa);
                    mr.setIdCandidato(Integer.parseInt(key));
                    System.out.println(mr.toString());
                    boolean b = dao.cargarResultados(mr);
                    System.out.println(b);
                }
            }
            sesion.put("mensaje", "Resultados Cargados.");
            return SUCCESS;
        } catch (MyException e) {
            logger.error("Error al cargar resultados.", e);
            return ERROR;
        }
    }

    @Override
    public void validate() {

        for (Map.Entry<String, String[]> entrySet : parametros.entrySet()) {
            String key = entrySet.getKey();
            String[] value = entrySet.getValue();
            try {
                int i = Integer.parseInt(value[0]);
                if (key.compareTo("num_mesa") == 0) {
                    if (i < 0) {
                        addFieldError("" + key, "Seleccione una mesa.");
                    }
                } else {
                    if (i < 0) {
                        addFieldError("" + key, "El valor ingresado debe ser mayor a 0.");
                    }
                }
            } catch (NumberFormatException e) {
                addFieldError("" + key, "Ingrese un número.");
            } catch (NullPointerException e) {
                System.out.println(e.toString());
                addFieldError("" + key, "Este campo no puede estar vacio.");
            }
        }
    }

    public int getNum_mesa() {
        return num_mesa;
    }

    public void setNum_mesa(int num_mesa) {
        this.num_mesa = num_mesa;
    }

    @Override
    public void setParameters(Map<String, String[]> maps) {
        this.parametros = maps;
    }

    public Map<String, String[]> getParametros() {
        return parametros;
    }

}
