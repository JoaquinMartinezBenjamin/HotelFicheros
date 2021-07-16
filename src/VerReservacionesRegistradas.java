  import java.awt.*;
import  javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
public class VerReservacionesRegistradas extends Listado
{   private JLabel imagen;
    private JTextArea Area;
    private JButton aceptar,cerrar;
    private JLabel etiqueta;
    private int clave;
    private String nombre;
    private RandomAccessFile maestro;
    private JScrollPane desplazador;
    private long pos;
    private String[] lista;
    private long nreg;
    public JButton agregar,borrar,cambiar,cerraralta,cerrarbaja,cerrarcambio,cerrarlistado;
    public VerReservacionesRegistradas()
    {
         getContentPane().setBackground(Color.black);
         
      //  cerrarlistado.setBounds(10,200,130,25);
        //-----propiedades de la vetana-----------
        setTitle("Consultando reservaciones");
        setSize(500,400);
        setLocation(240, 200);
        getContentPane().setLayout(null);

        /*//------propiedades de la etiqueta----------
        etiqueta=new JLabel("Cuentas de usuario registradas");
        etiqueta.setBounds(80,15,250,25);
        etiqueta.setForeground(Color.BLUE);
        etiqueta.setFont(new Font("Arial",Font.PLAIN,15));
        getContentPane().add(etiqueta);

        //-------propiedades del bototn aceptar----------
      /*  aceptar=new JButton();
        aceptar.setMnemonic('A');
        aceptar.setText("Ver cuentas");
        getContentPane().add(aceptar);
        aceptar.setBounds(300, 15, 120, 20);

        //-------propiedades del bototn cerrar----------
        cerrar=new JButton();
        cerrar.setMnemonic('c');
        cerrar.setText("Salir de ventana");
        getContentPane().add(cerrar);
        cerrar.setBounds(250,200,135,25);*/
 // ImageIcon icono = new ImageIcon("2.png");
   //      Image imagen = icono.getImage();
     //    ImageIcon aescala = new ImageIcon(
       //  imagen.getScaledInstance(435,263,Image.SCALE_SMOOTH));
           
         //JLabel label3 = new JLabel (aescala);
         //add(label3);
      //   label3.setBounds(0,0,435,263);
     /*   addWindowListener(new java.awt.event.WindowAdapter()
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
        };  */
     //   cerrar.addActionListener(accion);
       // aceptar.addActionListener(accion);
    }//Fin del Constructor
    
    
     public static void main(String[] args)
    {
        new VerReservacionesRegistradas().setVisible(true);
    }

}
