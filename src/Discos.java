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

//La siguiente clase se encarga de crear y dibujar los discos en las torres de Hanoi
public class Discos 
{
    //Variables de las que se compone el disco
    int No_Discos = 0;
    int Columna = 0;
    int Pos_Pila = 0;
    static int NoDiscos_MAX = 0;
    int Pos_X = 0;
    int Pos_Y = 0;
    int Ancho = 0;
    int Alto = 20;
    Graphics Rectangulo;

    public Discos(int _NoDiscos, int _Columna, int _PosPila, Graphics _Torre) 
    {
        //Cantidad de discos, se usara mas tarde para definir el ancho del disco.
        No_Discos = _NoDiscos; 
        
        //Permite controlar la altura de los discos.
        if (No_Discos > NoDiscos_MAX) 
        {
            NoDiscos_MAX = No_Discos; 
        }
        
        //Segun la cantidad de discos el ancho debe cambiar para cada uno
        Ancho = (No_Discos + 1) * 20; 
        
        //La columna (torre) en donde se encuentra el disco
        Columna = _Columna; 
        
        //De abajo hacia arriba, la posicion del disco en la pila.
        Pos_Pila = _PosPila; 
        
        //Esto permite crear una relacion entre el disco y su respectiva torre
        Rectangulo = _Torre;

    }
    
    public void ActualizarPila(int NuevaPila) 
    {
        Pos_Pila = NuevaPila;
    }
    
    public void DibujarDisco() 
    {
        //Es necesario centrar las coordenadas grafico
        //Centro de la base + desface de la base - desface por anchura
        Pos_X = 140 + (180 * (Columna)) - (10 * No_Discos); 
        
        //la altura del disco se adapta segun el numero de discos
        Pos_Y = 200 + (20 * (Pos_Pila - 1) - (NoDiscos_MAX * 20));
        
        //Dibuja el rectangulo de color azul.
        //El alto del disco nunca cambia.
        Rectangulo.setColor(Color.BLUE);
        Rectangulo.fillRect(Pos_X, Pos_Y, Ancho, Alto);
    }

    //Es necesario redibujar cada vez que el disco se mueve en la pantalla
    //Esto ocurre por la forma en que funciona el canvas de Java
    public void BorrarDisco() 
    {
        //Fondo
        Rectangulo.setColor(Color.WHITE);
        Rectangulo.fillRect(Pos_X, Pos_Y, Ancho, Alto);
        
        //Columna
        Rectangulo.setColor(Color.BLACK);
        Rectangulo.fillRect(140 + 180 * (Columna), 200 + (20 * Pos_Pila - 140), 20, 20);

    }
    
    public void MoverDisco(LinkedList<Discos>[] Pila, int TorreActual, int TorreObjetivo) 
    {
        //Se borra el disco (grafico) que se pretende mover.
        this.BorrarDisco();
        
        //Se mueve a la torre objetivo el ultimo disco de la torre actual (el recien borrado)
        Pila[TorreObjetivo].add(Pila[TorreActual].getLast());
        
        //Se actualiza la posicion en la pila del disco
        Pos_Pila = NoDiscos_MAX - Pila[TorreObjetivo].indexOf(this);
        
        //Se actualiza la columna del disco
        Columna = TorreObjetivo;

        
        //Se remueve el disco (logico|valor en linked list) de la torre que se acaba de modificar.
        Pila[TorreActual].removeLast(); 
        
        //Cada iteracion de Hanoi altera a todos los discos
        //Por lo tanto es necesario recorrer y alterar toda la pila
        for (int indice = 0; indice < Pila[TorreActual].size(); indice++) 
        {
            //Se borra el dibujo del disco
            Pila[TorreActual].get(indice).BorrarDisco();
            //Se empuja el disco hacia abajo
            Pila[TorreActual].get(indice).ActualizarPila(NoDiscos_MAX - indice);
            //Se dibuja el disco de nuevo
            Pila[TorreActual].get(indice).DibujarDisco();
        }
        
        //Se dibuja el  disco en la nueva posicion de la nueva torre
        this.DibujarDisco();
    }    
}
