package Controlador;

import Vistas.Vista;
import Modelos.Modelo;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author alumno
 */
public class Controlador implements ActionListener {
    private Vista vista;
    private Modelo modelo;
    
   public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnNuevo.addActionListener(this);
        this.vista.btnMatar.addActionListener(this);
    }
   
   @Override
   public void actionPerformed(ActionEvent e) {
       if (e.getSource() == vista.btnActualizar){
           List<List<String>> matrizProcesos = modelo.ListarProcesos();
           
           DefaultTableModel model = new DefaultTableModel();
           
           for (int j=0; j<3; j++) {
               model.addColumn(matrizProcesos.get(0).get(j));
           }
           for(int i = 1; i < matrizProcesos.size(); i++) {
               model.addRow(new Object[]{matrizProcesos.get(i).get(0),matrizProcesos.get(i).get(1),matrizProcesos.get(i).get(2)});
           }
           vista.tblProcesos.setModel(model);
           vista.txtNumeroProcesos.setText(String.valueOf(model.getRowCount()) + "procesos");
                               
           
           /*
           try {
               modelo.ListaProcesos();
           } catch (InterruptedException ex) {
               Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Error");
           }
            */
       } else if (e.getSource() == vista.btnNuevo){
       
       } else if (e.getSource() == vista.btnMatar){
       
       }
   
   }
   
}
