import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class Bajas extends JFrame
{
     private JButton borrar,salir;
    private JLabel etiqueta1,etiqueta2;
    private JTextField Text1,Text2;
    private int clave;
    public String nombre,cadena,listanombre[];
    private int encontrado;
    private RandomAccessFile maestro,temporal;
    private int pos,k,listaclave[];;
    public Bajas()
    {
         etiqueta1 = new JLabel("Numero de registro a eliminar: ");
         etiqueta2 = new JLabel("Nombre del empleado           : ");
         Text1     = new JTextField();
         Text2     = new JTextField();
         borrar = new JButton("Suprimir");
         salir     = new JButton("Salir");

         getContentPane().setLayout(null);

         setSize(350, 200);
         setLocation(240,200);
         setResizable(false);
         addWindowListener(new java.awt.event.WindowAdapter()
         {
               public void windowClosing(java.awt.event.WindowEvent evnt)
               {
                   System.exit(0);
               }
         });
         getContentPane().add(etiqueta1);
         etiqueta1.setBounds(7, 10, 250, 20);
         etiqueta1.setFont(new java.awt.Font("Arial",3,14));

         getContentPane().add(etiqueta2);
         etiqueta2.setBounds(7, 45, 250, 20);
         etiqueta2.setFont(new java.awt.Font("Arial",3,14));

         getContentPane().add(Text1);
         Text1.setBounds(225, 10, 80, 20);

         getContentPane().add(Text2);
         Text2.setBounds(195, 45, 145, 20);

         getContentPane().add(borrar);
         borrar.setBounds(45,130, 100, 20);

         borrar.setMnemonic('u');
         borrar.setToolTipText("Borra el  numero del archivo");

         salir.setText("Salir");
         salir.setMnemonic('S');
         salir.setToolTipText("Terminar la aplicacion");
         getContentPane().add(salir);
         salir.setBounds(210,130,100, 20);

         setTitle("ELIMINANDO REGISTROS DEL ARCHIVO");
         getContentPane().setLayout(null);

         setResizable(false);
         getContentPane().setLayout(null);

         setResizable(false);

         listanombre=new String[100];
         listaclave=new int[100];
         ActionListener accion = new java.awt.event.ActionListener()
         {
               public void actionPerformed(java.awt.event.ActionEvent evento)
               {
                   Object obj=evento.getSource();
                   if (obj==borrar)
                   {
                      int valor=Integer.parseInt(Text1.getText());
                      if (Busca(valor)>=0)
                      {
                           int opcion=JOptionPane.showConfirmDialog(null,"Ã‚Â¿EstÃƒÂ¡ seguro?","ConfirmaciÃƒÂ³n...",JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
                           if (opcion==0)
                           {
                                 SuprimirRegistro(valor);
                                 Text1.setText("");
                                 Text2.setText("");
                           }
                           else
                           {
                                Text1.setText("");
                                Text2.setText("");
                           }
                      }
                      else
                      {
                          JOptionPane.showMessageDialog(null,"Registro no encontrado","Informacion",JOptionPane.PLAIN_MESSAGE);
                          Text1.setText("");
                      }
                   }
                   if (obj==salir)
                   {
                        dispose();
                   }
                   if (obj==Text1)
                   {
                         int valor=Integer.parseInt(Text1.getText());
                         if (Busca(valor)<0)
                             JOptionPane.showMessageDialog(null,"Registro no encontrado","Informacion",JOptionPane.PLAIN_MESSAGE);
                   }
               }
         };
         borrar.addActionListener(accion);
         salir.addActionListener(accion);
         Text1.addActionListener(accion);
    }
    public long  Busca(int reg)
    {
             boolean encontrado=false;
             long ls=0;
             long li=0;
             long pos=-1;
             long media;
             File maes;
             maes=new File("usuarios.dat" );
             if (maes.exists())
             {
                  try
                  {
                        maestro=new RandomAccessFile("usuarios.dat","rw");
                        li=(maestro.length()/46)-1;
                        while (ls<=li && !encontrado)
                        {
                            media=(ls+li)/2;
                            maestro.seek(media*46);
                            clave=maestro.readInt();
                            nombre=maestro.readUTF();
                            if (clave==reg)
                            {
                                encontrado=true;
                                pos=media;
                                Text2.setText(nombre+"");
                            }
                            else if(clave>reg)
                                      li=media-1;
                                   else  ls=media+1;
                        }

                  }
                  catch (IOException e)
                  {
                        System.out.println("fin del listado");
                  }
                  finally
                  {
                      try
                      {
                          maestro.close();
                       }
                       catch (IOException fff)
                       {
                            System.out.println("No se pudo cerrar el archivo" + fff.getMessage());
                       }
                  }
             }
             return pos;
    }
    public void SuprimirRegistro(int registroaborrar)
    {
        JTextArea area=new JTextArea();
        try
        {
                maestro = new RandomAccessFile("usuarios.dat","r");
                temporal= new RandomAccessFile("temporal.dat","rw");
                do{
                      clave=maestro.readInt();
                      nombre=maestro.readUTF();
                      if (clave!=registroaborrar)
                      {
                          temporal.writeInt(clave);
                          temporal.writeUTF(nombre);
                          area.append(clave+"\t"+nombre+"\n");
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
                     maestro.close();
                     temporal.close();
                     File  f1,f2;
                     f2=new File("usuarios.dat");
                     f2.delete();
                     f1=new File("temporal.dat");
                     f2=new File("usuarios.dat");
                     f1.renameTo(f2);
                     JOptionPane.showMessageDialog(null,area,"Busqueda",JOptionPane.PLAIN_MESSAGE);
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
            maestro=new RandomAccessFile("usuarios.dat","r");
            while (true)
            {
                  clave=maestro.readInt();
                  nombre=maestro.readUTF();
                  k++;
                  listaclave[k]=clave;
                  listanombre[k]=nombre;
            }
         }
         catch(IOException e)
         {}
         finally
         {
             try
             {
                maestro.close();
                OrdenarArchivo();
             }
             catch (IOException ff)
             {}
         }
   }
   public void OrdenarArchivo()
   {
       int auxclave;
       String auxnombre;
       JTextArea area2=new JTextArea();
       area2.append("DATOS ORDENADOS\n");
       area2.append("=============================\n");
       area2.append("CLAVE\tNOMBRE\n");
       area2.append("=============================\n");
       for(int i=0;i<=k;i++)
       {
           for(int j=0;j<k;j++)
           {
               if (listaclave[j]>listaclave[j+1])
               {
                   auxclave=listaclave[j];
                   auxnombre=listanombre[j];

                   listaclave[j]=listaclave[j+1];
                   listanombre[j]=listanombre[j+1];

                   listaclave[j+1]=auxclave;
                   listanombre[j+1]=auxnombre;
               }
           }
       }
       for(int x=0;x<=k;x++)
       {
           area2.append(listaclave[x]+"\t"+listanombre[x]+"\n");
       }
       JOptionPane.showMessageDialog(null,area2,"DATOS ORDENADOS",JOptionPane.PLAIN_MESSAGE);
       CrearMaestroNuevo();
   }
   public void CrearMaestroNuevo()
    {
              File viejodirecto=new File("usuarios.dat");
              viejodirecto.delete();
              File nuevodirecto=new File("usuarios.dat");
              //if (viejodirecto.exists()) viejodirecto.delete();
              try
              {
                 temporal=new RandomAccessFile("usuarios.dat","rw");

                 temporal.seek(0);
                 for(int m=0;m<=k;m++)
                 {
                      temporal.writeInt(listaclave[m]);
                      temporal.writeUTF(listanombre[m]);
                 }
              }
              catch (IOException f)
              {
                   System.out.println("eeor"+f.getMessage());
              }
              finally
              {
                  try
                  {
                      temporal.close();
                  }
                  catch (IOException fy)
                  {
                      System.out.println("eeor"+fy.getMessage());
                  }
              }
    }
    public static void main(String[] args)
    {
         Bajas ec=new Bajas();
        ec.setVisible(true);
    }
}
