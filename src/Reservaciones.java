import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Object.*;
import java.io.*;

public class Reservaciones extends BarraHerramientasReservaciones{
   public JLabel imagen;
      private JLabel etiqueta;
    
     public Reservaciones () {
         setSize(500, 500);
            //------propiedades de la etiqueta----------
        etiqueta=new JLabel("CONSULTE LAS RESERVACIONES HECHAS");
        etiqueta.setBounds(20,0,350,25);
        etiqueta.setForeground(Color.yellow);
        etiqueta.setFont(new Font("Arial",Font.PLAIN,16));
        getContentPane().add(etiqueta);
        
      //   DatosRegistro L= new DatosRegistro();
        // (L.aceptar).setBounds(150,100,100,25);
       
         
     //     getContentPane().add (L.aceptar);
         
         
         setTitle ("Sistema hotelero: RESERVACIONES");
         
        ////////////////////////////////////////////////
        DefinirColores ColorNuevo = new DefinirColores();
        getContentPane().setBackground(ColorNuevo.color3);
        ////////////////////////////////////////////////
            ImageIcon icono = new ImageIcon(System.getProperty("user.dir") + "/img/" + "Notepad.png");
         Image imagen = icono.getImage();
         ImageIcon aescala = new ImageIcon(
         imagen.getScaledInstance(435,263,Image.SCALE_SMOOTH));
           
         JLabel label3 = new JLabel (aescala);
         add(label3);
         label3.setBounds(0,0,435,263);
      
        
        
        }
     
     
     
     
     
     
     public static void main(String[] args) {
        Reservaciones nuevaReservacion=new Reservaciones();
         nuevaReservacion.setVisible(true);
          nuevaReservacion.setBounds(200,100,450,350);
         
                           }
    }
    
