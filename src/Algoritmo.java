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

import java.util.*;

//La siguiente clase corresponde al algoritmo de solucion de Hanoi.
public class Algoritmo 
{
    public static void Hanoi(int No_Discos, int TorreActual, int TorreAuxiliar, int TorreObjetivo, LinkedList<Discos>[] PilasDiscos) 
    {   
        try
        {   
            if (No_Discos == 1)
            {
                //Crea un atraso de un segundo en la ejecucion del algoritmo.
                //Permite ver la animacion del metodo "MoverDisco".
                Thread.sleep(1000);     
                PilasDiscos[TorreActual].getLast().MoverDisco(PilasDiscos, TorreActual, TorreObjetivo);
            } 
            else
            {
                //El algoritmo hace una llamada del metodo hacia si mismo, aplicando efectivamente recursividad.
                Hanoi(No_Discos - 1, TorreActual, TorreObjetivo, TorreAuxiliar, PilasDiscos);
                Thread.sleep(1000);
                PilasDiscos[TorreActual].getLast().MoverDisco(PilasDiscos, TorreActual, TorreObjetivo);
                Hanoi(No_Discos - 1, TorreAuxiliar, TorreActual, TorreObjetivo, PilasDiscos);
            }
        }
        catch(Exception E)
        {
            System.out.print("ERROR: LOS PARAMETROS DEL ALGORITMO SON INVALIDOS.");
        } 
    }
}
