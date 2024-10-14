package Modelos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/*
ps -eo pid,euser,comm
ProcessBuilder pb = new ProcessBuilder("df", "-h");
*/
/**
 *
 * @author alumno
 */
public class Modelo {
    public List<List<String>> ListarProcesos() {
        List<List<String>> salidaProcesos = new ArrayList<List<String>>();
        ProcessBuilder pb = new ProcessBuilder("ps", "-eo", "pid,euser,comm");
                
        try {
            Process proceso = pb.start();
            
            BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            
            
            while ((linea = lector.readLine()) != null) {
                List<String> filaProceso = new ArrayList<String>();
                filaProceso.add(linea.substring(0,7));
                filaProceso.add(linea.substring(8,15));
                filaProceso.add(linea.substring(16));
                salidaProcesos.add(filaProceso);
            }
            int codigoSalida = proceso.waitFor();
        } catch (IOException exc) {
            exc.printStackTrace();
        } catch (InterruptedException exc) {
            exc.printStackTrace();
        }
        return salidaProcesos;
    }
    /*
    public CrearProceso(){
        
    } */
    /*
    public MatarProceso(){
        
    } */
}
