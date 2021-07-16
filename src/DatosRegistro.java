import java.awt.*;
import  javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
public class DatosRegistro extends JFrame
{
    private JTextArea Area;
    public JButton aceptar,cerrar;
    private JLabel etiqueta;
    private int clave;
    private String nombre,fechas,fechas2;
    private RandomAccessFile maestro;
    private JScrollPane desplazador;
    private long pos;
    private String[] lista;
    private long nreg;
    public JTextArea area;
    public JScrollPane barra;
    public DatosRegistro()
    {       
          getContentPane().setBackground(Color.blue);
        area= new JTextArea (25,50);
        //-----propiedades de la vetana-----------
        setTitle("         ::::::RESSERVACIONES:::::::::::::");
        setSize(450,150);
        setLocation(200, 200);
        getContentPane().setLayout(null);

        //------propiedades de la etiqueta----------
        etiqueta=new JLabel("Pulse aceptar para visualizar las reservaciones");
        etiqueta.setBounds(20,20,400,25);
        etiqueta.setForeground(Color.black);
        etiqueta.setFont(new Font("Arial",Font.PLAIN,18));
        getContentPane().add(etiqueta);

        //-------propiedades del bototn aceptar----------
        aceptar=new JButton();
        aceptar.setMnemonic('A');
        aceptar.setText("Aceptar");
        getContentPane().add(aceptar);
        aceptar.setBounds(100, 50, 90, 20);

        //-------propiedades del bototn cerrar----------
        cerrar=new JButton();
        cerrar.setMnemonic('c');
        cerrar.setText("Cerrar");
        getContentPane().add(cerrar);
        cerrar.setBounds(200, 50, 90, 20);

        addWindowListener(new java.awt.event.WindowAdapter()
        {
           public void windowClosing(java.awt.event.WindowEvent evt)
           {
                  dispose();
           }
        });
        ActionListener accion = new java.awt.event.ActionListener()
        {
               public void actionPerformed(java.awt.event.ActionEvent evento)
               {
                   Object obj=evento.getSource();
                   if (obj==aceptar)
                   {
                        VisualizarArchivo();
                   }

                   if (obj==cerrar)
                   {
                      dispose();
                   }
               }
        };
        cerrar.addActionListener(accion);
        aceptar.addActionListener(accion);
    }//Fin del Constructor
     public void VisualizarArchivo()
     {
           /* JLabel etiqueta=new JLabel("Tabla de Informacion");
            etiqueta.setBounds(20,20,150,25);
            etiqueta.setForeground(Color.GRAY);
            etiqueta.setFont(new Font("Arial",Font.PLAIN,14));
            */
            File fichero;
            fichero=new File("Directo2.dat");
            if (fichero.exists())
            {
                    Object[][] dato = {};
                    String[] NombreColumnas = {/*"POSICION","NREGISTRO",*/"CLAVE","NOMBRE"};
                    DefaultTableModel tabla = new DefaultTableModel(dato, NombreColumnas);
                    JTable table = new JTable(tabla);
                    table.setBackground(Color.BLUE);
                    table.setForeground(Color.WHITE);
                    table.setFont(new Font("Arial",Font.PLAIN,14));
                    table.setPreferredScrollableViewportSize(new Dimension(100, 120));
                    JScrollPane deslizador = new JScrollPane(table);

                   // getContentPane().add(deslizador);
                //  deslizador.setBounds(25,50,800,170);
                    lista=new String[4];
                    try
                    {
                           long LongitudReg=4+40+2; //4 byte para clave + 40 byte para nombre + 2 de interlineado de nombre
                           maestro=new RandomAccessFile(fichero,"rw");
                           String datos="";
                             area.setEditable (false);
                           area.setFont(new java.awt.Font("Arial",4,14));
                          area.setBounds(0,0,100,100);
                            area.setForeground(Color.white); 
                           area.setBackground(Color.black);
                             area.append("");
                           area.append("\t\tRESERVACIONES HECHAS\n");
                             area.append("===================================================================\n");
                           area.append("No.Hab|\t|NombreCliente|\tFecha de entrada\tFecha de salida\n");
                           area.append("=====================================================================\n");
                           do{
                                area.append("_________________________________________________________________\n");
                                  pos=maestro.getFilePointer();
                                  nreg=pos/LongitudReg;
                                  clave=maestro.readInt();
                                  nombre=maestro.readUTF();
                                  fechas=maestro.readUTF();
                                  fechas2=maestro.readUTF();
                                  lista[0]=clave+"";
                                  lista[1]=nombre+"";
                                  lista[2]=fechas+"";
                                  lista[3]=fechas2+"";
                                  
                                  //lista[1]=nombre+"";
                                  area.append(lista[0]+"\t"+lista[1]+"\t"+lista [2]+"\t"+lista[3]+"\n");
                                  //tabla.addRow(lista);
                           area.append("_________________________________________________________________\n");
                           }while (true);
                           
                        
                    }
            catch (IOException e)
            {}
            finally
            {
                try
                {     barra = new JScrollPane (area) ;
                    JOptionPane.showMessageDialog (null,barra);
                     //getContentPane().add(area);
                   maestro.close();
                }
                catch (IOException ff)
                {
                     System.out.println("No se pudo cerrar el archivo" + ff.getMessage());
                }
            }
            getContentPane().add(deslizador);
        }
        else  JOptionPane.showMessageDialog(null,"El archivo no esta creado","Informacion",JOptionPane.PLAIN_MESSAGE);
    }
    
    
    
     public static void main(String[] args)
    {
        new DatosRegistro().setVisible(true);
    }

}
