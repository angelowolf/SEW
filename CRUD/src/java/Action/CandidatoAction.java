package Action;

import DAO.DAOFactory;
import Modelo.Negocio.Candidato;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author angelo
 */
public class CandidatoAction extends ActionSupport implements ModelDriven<Candidato> {

    private Candidato candidato = new Candidato();
    private List<Candidato> candidatoLista = new ArrayList<>();
    private final DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    private final DAO.Candidato.CandidatoDAO daoCandidato = d.getCandidato();

    @Override
    public Candidato getModel() {
        return candidato;
    }

    public String guardarOModificarCandidato() {
        if (candidato.getIdCandidato() != 0) {
            daoCandidato.modificarCandidato(candidato);
        } else {
            daoCandidato.insertarCandidato(candidato);
        }
        return SUCCESS;
    }

    public String list() {
        candidatoLista = daoCandidato.getCandidatos();
        return SUCCESS;
    }

    public String eliminar() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        daoCandidato.eliminarCandidato(Integer.parseInt(request.getParameter("idCandidato")));
        return SUCCESS;
    }

    public String editar() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        candidato = daoCandidato.getCandidato(Integer.parseInt(request.getParameter("idCandidato")));
        return SUCCESS;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public List<Candidato> getCandidatoLista() {
        return candidatoLista;
    }

    public void setCandidatoLista(List<Candidato> candidatoLista) {
        this.candidatoLista = candidatoLista;
    }

}
