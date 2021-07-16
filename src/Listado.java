import java.awt.*;
import  javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
public class Listado extends JFrame
{
    private JTextArea Area;
    private JButton aceptar,cerrar;
    private JLabel etiqueta;
    private int clave;
    private String nombre,fechas,fechas2;
    private RandomAccessFile maestro2;
    private JScrollPane desplazador;
    private long pos;
    private String[] lista;
    private long nreg;
    public Listado()
    {
        //-----propiedades de la vetana-----------
        setTitle("CONTENIDO DEL ARCHIVO DE RESERVACIONES");
        setSize(460,300);
        setLocation(240, 200);
        getContentPane().setLayout(null);

        //------propiedades de la etiqueta----------
        etiqueta=new JLabel("CONSULTAR RESERVACIONES");
        etiqueta.setBounds(80,20,350,25);
        etiqueta.setForeground(Color.BLUE);
        etiqueta.setFont(new Font("Arial",Font.PLAIN,20));
        getContentPane().add(etiqueta);

        //-------propiedades del bototn aceptar----------
        aceptar=new JButton();
        aceptar.setMnemonic('A');
        aceptar.setText("Ver reservaciones");
        getContentPane().add(aceptar);
        aceptar.setBounds(50, 50, 200, 20);

        //-------propiedades del bototn cerrar----------
        cerrar=new JButton();
        cerrar.setMnemonic('S');
        cerrar.setText("Salir");
        getContentPane().add(cerrar);
        cerrar.setBounds(270, 50, 90, 20);

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
                    String[] NombreColumnas = {"No.Hab","Nombre","Fecha entrada","Fecha salida"};
                    DefaultTableModel tabla = new DefaultTableModel(dato, NombreColumnas);
                    JTable table = new JTable(tabla);
                    table.setBackground(Color.BLUE);
                    table.setForeground(Color.WHITE);
                    table.setFont(new Font("Arial",Font.PLAIN,14));
                    table.setPreferredScrollableViewportSize(new Dimension(50, 70));
                    JScrollPane deslizador = new JScrollPane(table);

                    getContentPane().add(deslizador);
                    deslizador.setBounds(25,100,400,170);
                    lista=new String[4];
                    try
                    {
                           long LongitudReg=4+40+2; //4 byte para clave + 40 byte para nombre + 2 de interlineado de nombre
                           maestro2=new RandomAccessFile(fichero,"rw");
                           do{
                                  pos=maestro2.getFilePointer();
                                  nreg=pos/LongitudReg;
                                  clave=maestro2.readInt();
                                  nombre=maestro2.readUTF();
                                  fechas=maestro2.readUTF();
                                  fechas2=maestro2.readUTF();
                                 // lista[0]=pos+"";
                                 // lista[1]=nreg+"";
                                  lista[0]=clave+"";
                                  lista[1]=nombre+"";
                                  lista[2]=fechas+"";
                                  lista[3]=fechas2+"";
                                  tabla.addRow(lista);
                           }while (true);
                    }
            catch (IOException e)
            {}
            finally
            {
                try
                {
                   maestro2.close();
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
        new Listado().setVisible(true);
    }

}