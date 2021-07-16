import java.awt.image.*;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import java.io.*;
public class Acceso extends JFrame
{
     private JLabel etiqueta1,etiqueta2;
    private JLabel imagen;
    private JPasswordField pw;
    private JComboBox usuarios;
    private JButton entrar,cerrar,utilidad;
    private String[] tipos;
    private int veces=0;
    private int ancho=350;
    private int alto=300;

    public Acceso()
    {
           //propiedades de la ventana
         Toolkit kit=Toolkit.getDefaultToolkit();
         
         Dimension tamaniopantalla=kit.getScreenSize();
         int anchopantalla=tamaniopantalla.width;
         int altopantalla=tamaniopantalla.height;
         setTitle("Entrada De Usuario");
         setLocation((anchopantalla - ancho)/2,(altopantalla - alto)/2 );
         setSize(ancho, alto);
         setResizable(false);
         getContentPane().setLayout(null);

         tipos=new String[3];
         tipos[0]="Administrador";
         tipos[1]="Temporal";
         tipos[2]="Auxiliar";


         etiqueta1=new JLabel("Introduzca su password");
         etiqueta1.setBounds(10,50,150,30);
         getContentPane().add(etiqueta1);

         pw=new JPasswordField();
         pw.setBounds(160,50,100,30);
         getContentPane().add(pw);
         
         etiqueta2=new JLabel("Seleccione tipo de usuario");
         etiqueta2.setBounds(10,90,150,30);
         getContentPane().add(etiqueta2);


         usuarios=new JComboBox(tipos);
         usuarios.setBounds(160,90,110,30);
         getContentPane().add(usuarios);

         entrar=new JButton("Entrar");
         entrar.setMnemonic('E');
         entrar.setBounds(30,200,90,30);
         getContentPane().add(entrar);

         utilidad=new JButton("Utilidad");
         utilidad.setMnemonic('U');
         utilidad.setBounds(140,200,90,30);
         getContentPane().add(utilidad);

         cerrar=new JButton("Cerrar");
         cerrar.setMnemonic('C');
         cerrar.setBounds(240,200,90,30);
         getContentPane().add(cerrar);
         
        

         ImageIcon icono = new ImageIcon(System.getProperty("user.dir") + "/img/" + "Notepad.png");
         Image imagen = icono.getImage();
         ImageIcon aescala = new ImageIcon(
         imagen.getScaledInstance(435,263,Image.SCALE_SMOOTH));
           
         JLabel label3 = new JLabel (aescala);
         add(label3);
         label3.setBounds(0,0,435,263);
             
         
          ActionListener accion = new java.awt.event.ActionListener()
       {
               public void actionPerformed(java.awt.event.ActionEvent evento)
               {
                   Object obj=evento.getSource();
                   if (obj==cerrar)
                   {
                       System.exit(0 );
                   }
                   if (obj==utilidad)
                   {
                       String pass=pw.getText();
                       int indice=usuarios.getSelectedIndex();
                       String ti=tipos[indice];
                       
                       if (pass.equals("123") && ti.equals("Administrador"))
                       {
                                 //new utilidad().setVisible(true);
                       }
                       else
                       {
                           JOptionPane.showMessageDialog(null,"Clave no valida");
                             pw.setText("");
                             veces++;
                             if (veces==3)
                             {
                                 JOptionPane.showMessageDialog(null,"Lo siento, no puedes acceder al catalogo");
                                 System.exit(0);
                             }
                       }

                   }
                   if (obj==entrar)
                   {
                       String pass=pw.getText();
                       int indice=usuarios.getSelectedIndex();
                       String ti=tipos[indice];
                       if (pass.equals("123") && ti.equals("Administrador"))
                       {
                          new Administracion().setVisible(true);
                       }
                       else
                       {
                             JOptionPane.showMessageDialog(null,"Clave no valida");
                             pw.setText("");
                             veces++;
                              if (veces==3)
                             {
                                 JOptionPane.showMessageDialog(null,"Lo siento, no puedes acceder al catalogo");
                                 System.exit(0);
                             }

                       }
                    }
               }
       };
          cerrar.addActionListener(accion);
       entrar.addActionListener(accion);
       utilidad.addActionListener(accion);
    }
    
    public static void main(String args[])
    {
        new Acceso().setVisible(true);
    }
}