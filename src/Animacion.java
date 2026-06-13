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

import java.awt.*;
import java.util.*;

public class Animacion extends javax.swing.JFrame {

    //Se crea una Lista Enlazada que almacena objetos para controlar la logica de los discos.
    //Se esta usando lista enlazada ya que tiene enlaces y punteros, y gracias a sus metodos facilitan el codigo de la tarea.
    //Ademas es muy rapida en inserccion y eliminacion de elementos, situacion que ocurre mucho en este ejercicio.
    public LinkedList<Discos>[] PilasDiscos = new LinkedList[3];

    public Animacion() {
        initComponents();
    }
    
    public void InicializarLista()
    {
        //Se inicializan las listas enlazadas
        for (int indice = 0; indice < 3; indice++) 
        { 
            PilasDiscos[indice] = new LinkedList<Discos>();
        }
    }
    
    //El siguiente metodo proviene del componente canvas de Java.
    //Para poder dibujar sobre el canvas es necesario hacer una sobreescritrura.
    @Override
    public void paint(Graphics Torre) 
    {         
        //Se indica que el color de las figuras geometricas debe ser negro
        Torre.setColor(Color.BLACK);
        
        //Ciclo For para crear 3 torres
        for (int indice = 0; indice < 3; indice++) 
        {
            //BASE
            //RellenarRectanguloPlano(PosicionX,PosicionY, AnchoRectangulo, AltoRectangulo)
            Torre.fillRect( ( 75 + ( indice * 180) ), 200, 150, 20); 
            
            //COLUMNA
            //RellenarRectanguloPlano(PosicionX,PosicionY, AnchoRectangulo, AltoRectangulo)
            Torre.fillRect( ( 140 + ( indice * 180 ) ), 60, 20, 140); 
        }
        
        InicializarLista();
        
        //Se crean y añaden los discos a la primera torre (pila 0).
        //De mayor al menor para obtener el orden de discos correcto
        for ( int No_Discos = 6, Iterador = 1; No_Discos > 0; No_Discos--, Iterador++ ) 
        {
            //Se crea y añade un nuevo objeto de tipo disco para la pila
            //Discos(Ancho, UbicacionTorreGrafica, UbicacionPilaLogica, RelacionRespectivaTorre)
            PilasDiscos[0].add(new Discos( No_Discos, 0, No_Discos, Torre ));
            
            //Segun el iterador se invoca el metodo de dibujar para crear el grafico del disco.
            PilasDiscos[0].get(Iterador - 1).DibujarDisco();
        }
        
       //Se llama al algoritmo para comenzar el traspaso de discos.
       Algoritmo.Hanoi( 6, 0, 1, 2, PilasDiscos );
       try{Thread.sleep(1000);}catch(Exception ex){} //retraso extra para mostrar al ultimo disco.
       
       //Al terminar la animacion el programa finaliza automaticamente
       Main.Exit();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Torres de Hanoi");
        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
