import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.border.*;  
public abstract class OperacionesArchivo2 extends Visual
{ public String fechas;
       public RandomAccessFile maestro2,temporal;
    public JScrollPane barra;
       public JTextArea area2=new JTextArea(20,30);
    public OperacionesArchivo2()
    {      area2.setEditable (false);
area2.setFont(new java.awt.Font("Arial",2,13));
 
    area2.setForeground(Color.white); 
  area2.setBackground(Color.black);
             area2.append("\tRESERVACIONES HECHAS\n");
       area2.append("==========================================================\n");
       area2.append("No.Habitación|\tNombreCliente|\tTiempoDeEstancia\n");
       area2.append("==========================================================\n");
    }
    public long  Busca(int reg)
    {
             boolean encontrado=false;
             long ls=0;
             long li=0;
             long pos=-1;
             long media;
             File maes;
             maes=new File("Directo2.dat" );
             if (maes.exists())
             {
                  try
                  {
                        maestro2=new RandomAccessFile("Directo2.dat","rw");
                        li=(maestro2.length()/46)-1;
                        while (ls<=li && !encontrado)
                        {
                            media=(ls+li)/2;
                            maestro2.seek(media*46);
                            clave=maestro2.readInt();
                          // nombre=maestro2.readUTF();
                            if (clave==reg)
                            {
                                encontrado=true;
                                pos=media;
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
                          maestro2.close();
                       }
                       catch (IOException fff)
                       {
                            System.out.println("No se pudo cerrar el archivo" + fff.getMessage());
                       }
                  }
             }
             return pos;
    }
    public void  almacena(int clav,String nomb,String fechas1)
    {
          try
          {
                
              clave=clav;
                 fechas=redimensiona(fechas1,120);
                  nombre=redimensiona(nomb,120);
                  TReg = 4+ nombre.length()+2;
                 // area.append(TReg+"");

                  File fichero=new File("Directo2.dat");
                  maestro2=new RandomAccessFile(fichero,"rw");
                  maestro2.seek(maestro2.length());
                 maestro2.writeInt(clave);
                  maestro2.writeUTF(nombre);
                   maestro2.writeUTF(fechas);
          }
          catch (IOException f)
          {
                 System.out.println("eeor"+f.getMessage());
          }
          finally
          {
              try
             {
                  maestro2.close();
                  TomarDatos();
             }
             catch (IOException fy)
             {
                  System.out.println("eeor"+fy.getMessage());
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
               
                  k++;
                  listaclave[k]=clave;
                  listanombre[k]=nombre;
                  listafechas[k]=fechas;
              
            }
         }
         catch(IOException e)
         {}
         finally
         {
             try
             {
                maestro2.close();
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
    
       
        
       /*
     
       for(int i=0;i<=k;i++)
       {
           for(int j=0;j<k;j++)
           {
               if (listaclave[j]>listaclave[j+1])
               {
                  // auxclave=listaclave[j];
                 
                   auxnombre=listanombre[j];

                  // listaclave[j]=listaclave[j+1];
                 
                   listanombre[j]=listanombre[j+1];

                //   listaclave[j+1]=auxclave;
                  
             
               }
           }
       }*/
       for(int x=0;x<=k;x++)
       {
           area2.append(listaclave[x]+"\t"+listanombre[x]+"\t"+listafechas[x]+"\n");
             area2.append("---------------------------------------------------------------------------\n");
       }
         barra = new JScrollPane (area2) ;
       JOptionPane.showMessageDialog(null,barra,"Reservaciones registradas",JOptionPane.PLAIN_MESSAGE);
       CrearMaestroNuevo();
   }
   public void CrearMaestroNuevo()
    {
              File viejodirecto2=new File("Directo2.dat");
              viejodirecto2.delete();
              File nuevodirecto2=new File("Directo2.dat");
              try
              {
                 temporal=new RandomAccessFile("Directo2.dat","rw");

                 temporal.seek(0);
                 for(int m=0;m<=k;m++)
                 {
                      temporal.writeInt(listaclave[m]);
                      temporal.writeUTF(listanombre[m]);
                      temporal.writeUTF(listafechas[m]);
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
    public String redimensiona(String VariableCadena,int longitud)
    {
        if (VariableCadena.length()<longitud)
        {
             for(int i=VariableCadena.length();i<longitud;i++)
             {
                   VariableCadena=VariableCadena+" ";
             }
        }
        else VariableCadena=VariableCadena.substring(0,longitud);
        return VariableCadena;
    }
}
