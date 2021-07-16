import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Object.*;
import java.io.*;



public abstract class  BarraHerramientasReservaciones extends JFrame{
    
    
public JTextArea areaNuevaReservacion;
     
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
  //  public JMenu menuRecuperacion;
    public JMenu menuActualizacion;
    public JMenu menuConsulta;
    public JMenu menuhacercaDe;

    public JToolBar BarraDeHerr;
    
     
    
     BarraHerramientasReservaciones () {
         inicializaComponentes();
                                       }
     
      private void inicializaComponentes()
    {
   
      
      
        
        getContentPane().setLayout(null);
        
     
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
      //  menuRecuperacion  = new JMenu();
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
        menuArchivo.setText("Nueva reservación");
        //-------------------Opcion Crear-------------------//
        OpcionCrear.setMnemonic('C');
        OpcionCrear.setText("Hace nueva reservacion");
        OpcionCrear.setToolTipText("Registra una nueva reservación");
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
        OpcionBorrar.setText("Consultar hechas");
        OpcionBorrar.setToolTipText("Consultar las reservaciones hechas...");
        menuArchivo.add(OpcionBorrar);

        OpcionSalir.setMnemonic('S');
        OpcionSalir.setToolTipText("Termina la aplicacion");
        OpcionSalir.setText("Salir");

        menuArchivo.add(OpcionSalir);

       // menuRecuperacion.setMnemonic('R');
      //  menuRecuperacion.setText("Recuperacion");
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

       // BarraDeMenus.add(menuRecuperacion);
      
      
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
                          
                        new  HacerReservacion2().setVisible(true);
                   }
                   if (obj==OpcionBorrar)
                   { //Listado Registros= new Listado();
                      //areaNuevaReservacion.add (Registros.area);
                    //areaNuevaReservacion.setText ("hola");
                    
                       new VerReservacionesRegistradas().setVisible(true);
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
         
  
         
    }
         
     
     