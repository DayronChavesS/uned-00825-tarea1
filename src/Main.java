/*
UNIVERSIDAD ESTATAL A DISTANCIA
VICERRECTORIA ACADÉMICA
ESCUELA DE CIENCIAS EXACTAS Y NATURALES
CARRERA DE INGENIERÍA INFORMÁTICA

TAREA #1
TORRES DE HANOI

GRUPO 03
PROFESORA MIRIAM MORA MORALES

DAYRON ANTONY CHAVES SANDOVAL
305240018

CENTRO UNIVERSITARIO DE TURRIALBA

FECHA DE ENTREGA
28 DE FEBRERO DEL 2021

PRIMER CUATRIMESTRE, 2021.
*/

import javax.swing.*;

//Esta clase se encarga de ejecutar el programa y finalizarlo.
public class Main
{
    //Manejamos el JFrame como variable global por motivos practicos.
    public static Animacion NuevaVentana = new Animacion();
    
    public static void main(String args[]) 
    {
        Start();
    }
    
    public static void Start()
    {
        //Se ofrecen los botones para iniciar (o no) la animacion, solicitados en la tarea.
        int desicion = JOptionPane.showConfirmDialog(null, "¿Desea empezar una nueva animacion?", "Bienvenido", JOptionPane.YES_NO_OPTION);
        
        if(desicion == JOptionPane.YES_OPTION)
        {
            NuevaVentana.setLocationRelativeTo(null);
            NuevaVentana.setVisible(true);
        }        
        else
        {
            System.exit(0);
        }    
    }         
    
    //Este metodo crea la notificacion final y cierra el programa
    public static void Exit()
    {
        NuevaVentana.dispose();
        JOptionPane.showMessageDialog(null, "La animacion ha finalizado correctamente.", "Exito", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);    
    }        
}
