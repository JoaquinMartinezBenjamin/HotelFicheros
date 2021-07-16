
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.border.*;

public abstract class RegistroDeDatos2 extends OperacionesArchivo2
{
  public DataOutputStream Directo2=null;
        
      public RegistroDeDatos2(){

       //----------propiedades del boton aceptar
        aceptar=new JButton("Aceptar");
        aceptar.setMnemonic('a');
        aceptar.setToolTipText("Aceptar datos tecleados");
        aceptar.setBounds(10,240,120, 25);

        //--------propiedades del boton otro registro------
        otroreg=new JButton("Otro registro");
        otroreg.setMnemonic('O');
        otroreg.setToolTipText("Borra los cajas de texto para insertar otro registro");
        otroreg.setBounds(136,240,120, 25);
          

        //---------propiedades del boton salir--------
        salir=new JButton("Salir");
        salir.setMnemonic('S');
        salir.setToolTipText("Terminar la aplicacion");
        salir.setBounds(265,240,120, 25);
        
          // getContentPane().add(aceptar);
           areaTrabajo.add(aceptar);
           // getContentPane().add(otroreg);
           areaTrabajo.add(otroreg);
            //getContentPane().add(salir);
           areaTrabajo.add(salir);
        
                    ActionListener accion = new java.awt.event.ActionListener()
       {
               public void actionPerformed(java.awt.event.ActionEvent evento)
               {
                   Object obj=evento.getSource();
                   int contador=0;
                  
                   if (obj==aceptar)
                   {
                     
                     String fecha;
                     String fecha2;
                       
                      dia=Integer.parseInt(Text3.getText());
                      dia2=Integer.parseInt(Text5.getText());
                      
                      mes=calendario.getSelectedIndex();
                      nombreMes=lista2[mes];
                      
                      mes2=calendario2.getSelectedIndex();
                      nombreMes2=lista2[mes];
                      
                       annio=Integer.parseInt(Text4.getText());
                       annio2=Integer.parseInt(Text6.getText());
                       
                       clav=Integer.parseInt(Text1.getText());//Numero de la habitación
                       nomb=Text2.getText();  //Nombre del cliente
                       fecha= ""+dia+" / "+nombreMes+" / " + annio;
                       fecha2=""+dia2+" / "+nombreMes2+" / "+ annio2;
                       
                      DatosRegistro VerDatos = new DatosRegistro();
                      inserta(clav,nomb,fecha,fecha2); 
                      VerDatos.VisualizarArchivo();
                       JOptionPane.showMessageDialog(null,"La habitacion ha sido reservada exitosamente","Confirmacion",JOptionPane.PLAIN_MESSAGE);
                     
                   }
                     
                   
                   if (obj==salir)
                   {
                        dispose();
                   }
                   
                   if (obj==otroreg)
                   {
                        Text1.setText("");
                        Text2.setText("");
                          Text3.setText("");
                            Text4.setText("");
                              Text5.setText("");
                                Text6.setText("");


                   }
               }
       };
       aceptar.addActionListener(accion);
       salir.addActionListener(accion);
       otroreg.addActionListener(accion);
            }
            
 public void inserta(int clave,String nombre,String fechas, String fechas2)
    {
        try
        {
               Directo2=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Directo2.dat",true)));
               Directo2.writeInt(clave);
               Directo2.writeUTF(nombre);
               Directo2.writeUTF(fechas);
               Directo2.writeUTF(fechas2);
        }
        catch (IOException e)
        { }
        finally
        {
             try
             {
                      Directo2.close();
             }
             catch (IOException e)
             {}
        }
    }
        }