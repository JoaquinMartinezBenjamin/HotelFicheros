 import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.border.*;  

public class BorrarRegistro extends JFrame{ 
 private String nombre,fechas,fechas2;
   public JTextArea areaTrabajo;
   public JTextField Text1,Text2,Text3,Text4,Text5,Text6;
   public JComboBox tipou,calendario,calendario2;
   public JButton aceptar,otroreg,salir;
   public JLabel etiqueta1,etiqueta2,etiqueta3,etiqueta4,etiqueta5,etiqueta6,etiqueta7;
   
   
       public RandomAccessFile maestro2,temporal;
    public JPanel panelalta;
    public int clave,clav,i,listaclave[],TReg,k;
    public String nomb,listanombre[],cad;
    public int ancho=400;
    public int alto=300;
    public String nombreMes,nombreMes2;
    public int dia, mes, annio;
    public int dia2, mes2, annio2;
    public int day, mon, year;
    public int day2, mon2, year2;
    public int listaDia1[],listaDia2[];
    public String listaMes1[],listaMes2[],listafechas[],listafechas2[];
    public int listaAnnio1[],listaAnnio2[];
    public String lista[]={"Delux","Standar","Suite"};
    public String lista2[]={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto",
        "Septiembre","Octubre", "Noviembre","Diciembre"};
   
public BorrarRegistro () { 
    
           areaTrabajo = new JTextArea   ();
            areaTrabajo.setBackground(Color.black);
            areaTrabajo.setFont(new java.awt.Font("Arial",1,15));
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
        
        
         Text1=new JTextField(10);
        Text1.setBounds(170, 10, 50, 20);
        areaTrabajo.add(Text1);
        
        
         // getContentPane().add(aceptar);
         areaTrabajo.add(aceptar);
           //getContentPane().add(otroreg);
           areaTrabajo.add(otroreg);
            //getContentPane().add(salir);
           areaTrabajo.add(salir);
        getContentPane().add(areaTrabajo);
                    ActionListener accion = new java.awt.event.ActionListener()
       {
               public void actionPerformed(java.awt.event.ActionEvent evento)
               {
                   Object obj=evento.getSource();
                   int contador=0;
                   int valor;
                  
                   if (obj==aceptar)
                   {
                        valor=Integer.parseInt(Text1.getText());
                     
                                 SuprimirRegistro(valor);
                    // String fecha;
                    // String fecha2;
                       
                      //dia=Integer.parseInt(Text3.getText());
                      //dia2=Integer.parseInt(Text5.getText());
                      
                      //mes=calendario.getSelectedIndex();
                      //nombreMes=lista2[mes];
                      
                      //mes2=calendario2.getSelectedIndex();
                      //nombreMes2=lista2[mes];
                      
                      // annio=Integer.parseInt(Text4.getText());
                       //annio2=Integer.parseInt(Text6.getText());
                       
                      // clav=Integer.parseInt(Text1.getText());//Numero de la habitación
                       //nomb=Text2.getText();  //Nombre del cliente
                       //fecha= ""+dia+" / "+nombreMes+" / " + annio;
                       //fecha2=""+dia2+" / "+nombreMes2+" / "+ annio2;
                       
                    
                      //inserta(clav,nomb,fecha,fecha2); 
                        DatosRegistro VerDatos = new DatosRegistro();
                         VerDatos.VisualizarArchivo();
                    
                       JOptionPane.showMessageDialog(null,"La reservacion de la habitación "+valor+"\n ha sido cancelada","Confirmacion",JOptionPane.PLAIN_MESSAGE);
                     
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


    public void SuprimirRegistro(int registroaborrar)
    {
        JTextArea area=new JTextArea();
        try
        {
                maestro2 = new RandomAccessFile("Directo2.dat","r");
                temporal= new RandomAccessFile("temporal.dat","rw");
                do{
                      clave=maestro2.readInt();
                      nombre=maestro2.readUTF();
                      fechas=maestro2.readUTF();
                      fechas2=maestro2.readUTF();
                      if (clave!=registroaborrar)
                      {
                          temporal.writeInt(clave);
                          temporal.writeUTF(nombre);
                          temporal.writeUTF(fechas);
                          temporal.writeUTF(fechas2);
                        //  area.append(clave+"\t"+nombre+"\n");
                      }
                }
                while (true);
        }
        catch (IOException ee)
        {
                System.out.println("fin del listado");
        }
        finally
        {
                 try
                 {
                     maestro2.close();
                     temporal.close();
                     File  f1,f2;
                     f2=new File("Directo2.dat");
                     f2.delete();
                     f1=new File("temporal.dat");
                     f2=new File("Directo2.dat");
                     f1.renameTo(f2);
                     JOptionPane.showMessageDialog(null,area,"Eliminando",JOptionPane.PLAIN_MESSAGE);
                     TomarDatos();
                     
                 }
                 catch (IOException ffff)
                 {
                     System.out.println("No se pudo cerrar el archivo" + ffff.getMessage());
                 }
           }
    }
  
    
    
      public void TomarDatos()
   {
        k=-1;
        try
         {
            maestro2=new RandomAccessFile("Directo2.dat","r");
            while (true)
            { 
               clave=maestro2.readInt();
                  nombre=maestro2.readUTF();
                   fechas=maestro2.readUTF();
                   fechas2=maestro2.readUTF();
               
                  k++;
                  listaclave[k]=clave;
                  listanombre[k]=nombre;
                  listafechas[k]=fechas;
                    listafechas2[k]=fechas2;
              
            }
         }
         catch(IOException e)
         {}
         finally
         {
             try
             {
                maestro2.close();
              //  OrdenarArchivo();
             }
             catch (IOException ff)
             {}
         }
      
       
         
   }
   
   

     public static void main(String[] args)
    {
        new BorrarRegistro().setVisible(true);
    }
   
   
}