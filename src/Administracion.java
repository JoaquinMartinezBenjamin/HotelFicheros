import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Object.*;
import java.io.*;
import java.awt.image.*;



public  class  Administracion extends JFrame{
    
    
public JTextArea areaNuevaReservacion;
       private JLabel imagen;
    public JMenuItem OpcionCrear;
    public JMenuItem OpcionAltas;
    public JMenuItem OpcionBajas;
    public JMenuItem OpcionCambios;
    public JMenuItem OpcionBorrar;
    public JMenuItem OpcionIndividual;
    public JMenuItem OpcionGeneral;
    public JMenuItem OpcionSalir;

    public JMenuBar BarraDeMenus;

    public JMenu menuArchivo;
   // public JMenu menuRecuperacion;
    public JMenu menuActualizacion;
    public JMenu menuConsulta;
    public JMenu menuhacercaDe;

    public JToolBar BarraDeHerr;
    
     
    private int ancho=500;
    private int alto=500;

     Administracion () {
          setSize(ancho, alto);
          setTitle("MENU PRINCIPAL");
          ImageIcon icono = new ImageIcon(System.getProperty("user.dir") + "/img/" + "principal.jpg");
         Image imagen = icono.getImage();
         ImageIcon aescala = new ImageIcon(
         imagen.getScaledInstance(435,263,Image.SCALE_SMOOTH));
           
         JLabel label3 = new JLabel (aescala);
         add(label3);
          getContentPane().add(label3);
         label3.setBounds(0,0,435,263);
             
         inicializaComponentes();
         
                                       }
     
      private void inicializaComponentes()
    {
      
    
      
      
        
        
             
     
        DefinirColores ColorNuevo = new DefinirColores();
        getContentPane().setBackground(ColorNuevo.color3);
        
         areaNuevaReservacion = new JTextArea   ();
        areaNuevaReservacion.setEditable (false);
        areaNuevaReservacion.setText (" RESERVACIONES");
    areaNuevaReservacion.setFont(new java.awt.Font("Arial",3,20));
   areaNuevaReservacion.setBounds(0,0, 300,200);
    areaNuevaReservacion.setBackground(ColorNuevo.color3);

  // Listado L= new Listado();
   
//areaNuevaReservacion.add (traerRegistro.area2);
  //  getContentPane().add(L.area);
     
      //getContentPane().add(areaNuevaReservacion);
        
        BarraDeHerr       = new JToolBar();
        BarraDeMenus      = new JMenuBar();
        menuArchivo       = new JMenu();
     //   menuRecuperacion  = new JMenu();
        OpcionCrear       = new JMenuItem();
        //menuActualizacion = new JMenu();
        menuConsulta      = new JMenu();
        menuhacercaDe     = new JMenu();
        OpcionAltas       = new JMenuItem();
        OpcionBajas       = new JMenuItem();
        OpcionCambios     = new JMenuItem();
        OpcionBorrar      = new JMenuItem();
        OpcionIndividual  = new JMenuItem();
        OpcionGeneral     = new JMenuItem();
       
        OpcionSalir       = new JMenuItem();
        
        
        

        //-------------------Menu Archivo-------------------//
        menuArchivo.setMnemonic('A');
        menuArchivo.setText("Menu");
        //-------------------Opcion Crear-------------------//
        OpcionCrear.setMnemonic('C');
        OpcionCrear.setText("Reservaciones");
        OpcionCrear.setToolTipText("Abre la ventana de reservaciones");
        menuArchivo.add(OpcionCrear);
        //-------------------Opcion Actualizacion-----------//
       // menuActualizacion.setMnemonic('A');
     //   menuActualizacion.setText("Actualizacion");
        //------------------SubOpcion Altas de Actualizacion-----//
        OpcionAltas.setMnemonic('l');
        OpcionAltas.setText("Altas");
        OpcionAltas.setToolTipText("AÃƒÂ±ade registros al final del archivo");
       // menuActualizacion.add(OpcionAltas);
        //------------------SubOpcion Bajas de Actualizacion-----//
        OpcionBajas.setMnemonic('B');
        OpcionBajas.setText("Bajas");
        OpcionBajas.setToolTipText("Elimina un registro del archivo");
      //  menuActualizacion.add(OpcionBajas);
        //------------------SubOpcion Cambios de Actualizacion-----//
        OpcionCambios.setMnemonic('C');
        OpcionCambios.setText("Cambios");
        OpcionCambios.setToolTipText("Cambia el contenido de un registro");
      //  menuActualizacion.add(OpcionCambios);

     //   menuArchivo.add(menuActualizacion);

        //------------------Opcion Salir---------------------------//
        OpcionBorrar.setMnemonic('o');
        OpcionBorrar.setText("Menu usuarios");
        OpcionBorrar.setToolTipText("Abre el menu de ususuarios");
        menuArchivo.add(OpcionBorrar);

        OpcionSalir.setMnemonic('S');
        OpcionSalir.setToolTipText("Termina la aplicacion");
        OpcionSalir.setText("Salir");

        menuArchivo.add(OpcionSalir);

       // menuRecuperacion.setMnemonic('R');
      // menuRecuperacion.setText("Recuperacion");
       menuConsulta.setText("Consulta");
        menuConsulta.setMnemonic('t');

        OpcionIndividual.setText("Indidual");
        OpcionIndividual.setMnemonic('I');
        OpcionIndividual.setToolTipText("Consulta un registro del archivo");
        menuConsulta.add(OpcionIndividual);
        OpcionGeneral.setText("General");
        OpcionGeneral.setMnemonic('G');
        OpcionGeneral.setToolTipText("Muestra el contenido del archivo");
        menuConsulta.add(OpcionGeneral);

       // menuRecuperacion.add(menuConsulta);
        BarraDeMenus.add(menuArchivo);

      //  BarraDeMenus.add(menuRecuperacion);
      
      
        setJMenuBar(BarraDeMenus);
        
        ActionListener accion = new java.awt.event.ActionListener()
        {
               public void actionPerformed(java.awt.event.ActionEvent evento)
               {
                   Object obj=evento.getSource();
                   
                
                   if (obj==OpcionCrear)
                   {
                        /* NuevaReservacion Reserv= new NuevaReservacion();
                        areaNuevaReservacion.add(Reserv.areaTrabajo);
                        JOptionPane.showMessageDialog (null, "Hara una nueva reservacion");*/
                          
                        new  Reservaciones().setVisible(true);
                   }
                   if (obj==OpcionBorrar)
                   { 
                        new VerCuentasUsuarios().setVisible(true);//Listado Registros= new Listado();
                      //areaNuevaReservacion.add (Registros.area);
                    //areaNuevaReservacion.setText ("hola");
                    
                     
                        }
                   if (obj==OpcionAltas)
                   {
                     
                   }
                   if (obj==OpcionBajas)
                   {
                       
                   }
                   if (obj==OpcionCambios)
                   {
                      
                   }
                   if (obj==OpcionIndividual)
                   {
                    
                   }
                   if (obj==OpcionGeneral)
                   {
                      

                   }
                   if (obj== OpcionSalir){
                       
                         dispose();
                    }
              //     if (obj== menuRecuperacion) { }
                   
                   
               }
        };
                  
  
        
        
        OpcionCrear.addActionListener(accion);
        OpcionBorrar.addActionListener(accion);
        OpcionAltas.addActionListener(accion);
        OpcionCambios.addActionListener(accion);
        OpcionBajas.addActionListener(accion);
        OpcionSalir.addActionListener(accion);
        OpcionGeneral.addActionListener(accion);
        OpcionIndividual.addActionListener(accion);
        
      
       
      
    }
    public static void main (String []args) {
    
    
           Administracion Administrar=new Administracion();
         Administrar.setVisible(true);
        
  
        }
    }
         