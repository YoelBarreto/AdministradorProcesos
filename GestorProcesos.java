package gestorprocesos;

import Controlador.Controlador;
import Modelos.Modelo;
import Vistas.Vista;
import javax.swing.ListSelectionModel;

/**
 *
 * @author alumno
 */
public class GestorProcesos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vista vista = new Vista();
        Modelo modelo = new Modelo();
        Controlador controlador = new Controlador(vista, modelo);
        
        vista.setVisible(true);
        vista.tblProcesos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        vista.btnActualizar.doClick();
        
    }
    
}
