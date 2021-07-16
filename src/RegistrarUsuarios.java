import java.awt.*;
import java.lang.String.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;
public abstract class RegistrarUsuarios extends JFrame
{
   public JMenu archivo;//,ayuda;
    public JMenuItem registrar,eliminar,modificar,listado,salir;
    public JMenuBar  BarraDeMenus;
    public JToolBar BarraDeHerr;
    public DataOutputStream usuarios=null;
    public DataInputStream maes=null;
    public JButton agregar,borrar,cambiar,cerraralta,cerrarbaja,cerrarcambio,cerrarlistado;
    public String tipos[]={"Administrador","Temporal","Auxiliar"};
    public JLabel encabezado, etiqueta1,etiqueta2,etiqueta3,etiqueta4,etiqueta5,etiqueta6,etiqueta7;
    public JPasswordField texto1,texto2;
    public JTextField texto3,texto4,texto5,texto6;
    public JComboBox tipousuario;
    public String password1,nombreusuario,nombreempleado;
    public JPanel panelalta,panelbaja,panelcambio;
    public String campos[];
    public JScrollPane deslizador;
    public RegistrarUsuarios()
    {
         //-------propiedades del frame-----
        setSize(700,600);
        setTitle("Administracion de usuarios");
        setLocation(410,200);
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.yellow);

        //------apariencia de barra de herram----
        BarraDeHerr = new JToolBar();
        //-----------Menu archivo-------------
       archivo=new JMenu("USUARIOS");
        registrar= new JMenuItem("Registrar nuevo usuarios");
        eliminar = new JMenuItem("Eliminar usuario ");
        modificar= new JMenuItem("Cambiar password ");
        listado  = new JMenuItem("Visualizar usuarios");
        salir    = new JMenuItem("Salir");
        archivo.add(registrar);
      archivo.add(eliminar);
      archivo.add(modificar);
       archivo.add(listado);
      archivo.add(salir);
        BarraDeMenus = new JMenuBar();
      BarraDeMenus.add(archivo);

        //--------menu ayuda-------------
       // ayuda=new JMenu("Ayuda");
       // ayuda.add("Indice");
      //  BarraDeMenus.add(ayuda);
        //-------------contenedor general------------
        setJMenuBar(BarraDeMenus);

        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosing(java.awt.event.WindowEvent evnt)
            {
                 System.exit(0);
            }
        });

        //panel para insertar  nuevos usuarios-----------------
        panelalta=new JPanel();
        Border grabado = BorderFactory.createEtchedBorder();
        Border  titulo= BorderFactory.createTitledBorder(grabado,"Insercion de nuevo usuario...");
        panelalta.setBorder(titulo);
        panelalta.setBounds(250,250,385,240);
        panelalta.setForeground(Color.black);
        getContentPane().add(panelalta);
        panelalta.setVisible(false);
        etiqueta1= new JLabel("Introduzca nuevo password");
        panelalta.add(etiqueta1);
        texto1=new JPasswordField(15);
        panelalta.add(texto1);
        etiqueta2= new JLabel("Confirme su password         ");
        panelalta.add(etiqueta2);
        texto2=new JPasswordField(15);
        panelalta.add(texto2);
        etiqueta3= new JLabel("Tipo de usuario                            ");
        panelalta.add(etiqueta3);
        tipousuario=new JComboBox(tipos);
        panelalta.add(tipousuario);
        etiqueta4= new JLabel("Nombre del empleado   ");
        panelalta.add(etiqueta4);
        texto3=new JTextField(20);
        panelalta.add(texto3);
        agregar=new JButton("Registrar datos");
        panelalta.add(agregar);
        cerraralta=new JButton("Cerrar registro");
        panelalta.add(cerraralta);
        panelalta.setBackground(Color.yellow);

        //panel para eliminar registros  de usuarios-------
        panelbaja=new JPanel();
        Border grabado2 = BorderFactory.createEtchedBorder();
        Border  titulo2= BorderFactory.createTitledBorder(grabado2,"Eliminarcion de usuarios...");
        panelbaja.setBorder(titulo2);
        panelbaja.setBounds(250,250,375,230);
        getContentPane().add(panelbaja);
        panelbaja.setVisible(false);
        etiqueta5=new JLabel("Teclee la clave del empleado a eliminar");
        panelbaja.add(etiqueta5);
        texto4=new JTextField(10);
        panelbaja.add(texto4);
        borrar=new JButton("Suprimir datos");
        panelbaja.add(borrar);
        cerrarbaja=new JButton("Cerrar eliminacion");
        panelbaja.add(cerrarbaja);

        //panel para cambiar rgistros  de usuarios-------
        panelcambio=new JPanel();
        Border grabado3 = BorderFactory.createEtchedBorder();
        Border  titulo3= BorderFactory.createTitledBorder(grabado3,"Modificacion  de clave de usuarios...");
        panelcambio.setBorder(titulo3);
        panelcambio.setBounds(250,250,375,230);
        getContentPane().add(panelcambio);
        panelcambio.setVisible(false);
        etiqueta6=new JLabel("Teclee la clave del empleado a cambiar");
        panelcambio.add(etiqueta6);
        texto5=new JTextField(10);
        panelcambio.add(texto5);
        etiqueta7=new JLabel("Nueva  clave de usuario                       ");
        panelcambio.add(etiqueta7);
        texto6=new JTextField(10);
        panelcambio.add(texto6);
        cambiar=new JButton("Cambiar datos");
        panelcambio.add(cambiar);
        cerrarcambio=new JButton("Cerrar cambios");
        panelcambio.add(cerrarcambio);

        //propiedades del boton cerrarlistado
        cerrarlistado=new JButton("Cerrar listado");
        cerrarlistado.setBounds(130,220,130,25);
        cerrarlistado.setVisible(false);
        getContentPane().add(cerrarlistado);


        ActionListener accion = new java.awt.event.ActionListener()
        {
             public void actionPerformed(java.awt.event.ActionEvent evento)
             {
                 Object obj = evento.getSource();
                 if (obj==registrar)
                 {
                     eliminar.setEnabled(false);
                     modificar.setEnabled(false);
                     listado.setEnabled(false);
                     panelalta.setVisible(true);
                 }
                 if (obj==eliminar)
                 {
                     registrar.setEnabled(false);
                     modificar.setEnabled(false);
                     listado.setEnabled(false);
                     panelbaja.setVisible(true);
                 }
                 if (obj==modificar)
                 {
                     listado.setEnabled(false);
                     eliminar.setEnabled(false);
                     registrar.setEnabled(false);
                     panelcambio.setVisible(true);
                 }
                 if (obj==listado)
                 {
                       registrar.setEnabled(false);
                       eliminar.setEnabled(false);
                       modificar.setEnabled(false);
                       listado.setEnabled(true);
                       VisualizarUsuarios();
                       registrar.setEnabled(true);
                       eliminar.setEnabled(true);
                       modificar.setEnabled(true);

                 }
                 if (obj==salir)
                 {
                       registrar.setEnabled(true);
                       eliminar.setEnabled(true);
                       modificar.setEnabled(true);
                       listado.setEnabled(true);
                       dispose();
                 }
                 if (obj==agregar)
                 {
                     String pw1,pw2,nombreu,nombre;
                     int indice = tipousuario.getSelectedIndex();
                     nombreu=tipos[indice];
                     pw1=texto1.getText();
                     pw2=texto2.getText();
                     nombre=texto3.getText();
                     if (pw1.length() != 0 && pw2.length()!=0)
                     {
                           if (pw1.equals(pw2))
                           {
                               inserta(pw1,nombreu,nombre);
                           }
                           else
                           {
                                 JOptionPane.showMessageDialog(null,"Confirme adecuadamante su password ","Error",JOptionPane.PLAIN_MESSAGE);
                           }
                     }
                     else
                     {
                         JOptionPane.showMessageDialog(null,"Clave no valida","Error",JOptionPane.PLAIN_MESSAGE);
                     }
                     texto1.setText("");
                     texto2.setText("");
                 }
                 if (obj==borrar)
                 {
                     String c=texto4.getText();
                     Borrarusuario(c);
                     registrar.setEnabled(true);
                     modificar.setEnabled(true);
                     panelbaja.setVisible(false);
                 }
                 if (obj==cambiar)
                 {
                       String cla=texto5.getText();
                       String tu=texto6.getText();
                       cambiarclaveusuario(cla,tu);
                       eliminar.setEnabled(true);
                       registrar.setEnabled(true);
                       panelcambio.setVisible(false);
                 }
                 if (obj==cerraralta)
                 {
                     eliminar.setEnabled(true);
                     modificar.setEnabled(true);
                     panelalta.setVisible(false);
                     listado.setEnabled(true);
                 }
                 if (obj==cerrarbaja)
                 {
                     registrar.setEnabled(true);
                     modificar.setEnabled(true);
                     panelbaja.setVisible(false);
                     listado.setEnabled(true);
                 }
                 if (obj==cerrarcambio)
                 {
                     registrar.setEnabled(true);
                     eliminar.setEnabled(true);
                     panelcambio.setVisible(false);
                     listado.setEnabled(true);
                 }
                 if (obj==cerrarlistado)
                 {
                     registrar.setEnabled(true);
                     eliminar.setEnabled(true);
                     modificar.setEnabled(true);
                     cerrarlistado.setVisible(true);
                     deslizador.setVisible(false);
                     cerrarlistado.setVisible(false);
                     //dispose();
                 }
             }
        };
        registrar.addActionListener(accion);
        eliminar.addActionListener(accion);
        modificar.addActionListener(accion);
        listado.addActionListener(accion);
        salir.addActionListener(accion);
        agregar.addActionListener(accion);
        borrar.addActionListener(accion);
        cambiar.addActionListener(accion);
        cerraralta.addActionListener(accion);
        cerrarbaja.addActionListener(accion);
        cerrarcambio.addActionListener(accion);
        cerrarlistado.addActionListener(accion);
    }
    public void inserta(String pw,String tipou,String nombre)
    {
        try
        {
               usuarios=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("usuarios.dat",true)));
               usuarios.writeUTF(pw);
               usuarios.writeUTF(tipou);
               usuarios.writeUTF(nombre);
        }
        catch (IOException e)
        { }
        finally
        {
             try
             {
                      usuarios.close();
             }
             catch (IOException e)
             {}
        }
    }
    public void Borrarusuario(String claveaborrar)
    {


    }
    public void cambiarclaveusuario(String viejaclave,String nuevaclave)
    {

    }
    public void VisualizarUsuarios()
    {
           File f;
           f=new File("usuarios.dat");
           cerrarlistado.setVisible(true);
           if (f.exists())
           {
                 Object[][] dato={};
                 String[] NombreColumnas={"PASSWORD","CLAVE","NOMBRE"};
                 DefaultTableModel tabla=new DefaultTableModel(dato,NombreColumnas);
                 JTable table=new JTable(tabla);

                 table.setPreferredScrollableViewportSize(new Dimension(50, 70));
                 deslizador = new JScrollPane(table);
                 deslizador.setVisible(true);

                 getContentPane().add(deslizador);
                 deslizador.setBounds(10,40,375,160);
                 campos=new  String[4];
                 try
                 {
                      maes = new DataInputStream(new BufferedInputStream(new FileInputStream("usuarios.dat")));
                      do{
                              password1=maes.readUTF();
                              nombreusuario=maes.readUTF();
                              nombreempleado=maes.readUTF();
                              campos[0]=password1+"";
                              campos[1]=nombreusuario+"";
                              campos[2]=nombreempleado+"";
                              tabla.addRow(campos);
                      }while (true);
                 }
                 catch (IOException e)
                 { }
                    finally
                   {
                            try
                            {
                                maes.close();
                            }
                            catch (IOException ff)
                            {}
                   }
            }
            else  JOptionPane.showMessageDialog(null,"El archivo no esta creado","Informacion",JOptionPane.PLAIN_MESSAGE);
    }
   /* public  static void main(String[] args)
    {
        new RegistrarUsuarios().setVisible(true);
    }*/
}