import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.border.*;  
 public abstract class  Visual extends JFrame {
       
     /////////////////////////7
   public JTextArea areaTrabajo;
   public JTextField Text1,Text2,Text3,Text4,Text5,Text6;
   public JComboBox tipou,calendario,calendario2;
   public JButton aceptar,otroreg,salir;
   public JLabel etiqueta1,etiqueta2,etiqueta3,etiqueta4,etiqueta5,etiqueta6,etiqueta7;
     ////////////////////////////////
     
    public RandomAccessFile maestro,temporal;
    public JPanel panelalta;
    public int clave,clav,i,listaclave[],TReg,k;
    public String nombre,nomb,listanombre[],cad;
    public int ancho=400;
    public int alto=300;
    public String nombreMes,nombreMes2;
    public int dia, mes, annio;
    public int dia2, mes2, annio2;
    public int day, mon, year;
    public int day2, mon2, year2;
    public int listaDia1[],listaDia2[];
    public String listaMes1[],listaMes2[],listafechas[];
    public int listaAnnio1[],listaAnnio2[];
    public String lista[]={"Delux","Standar","Suite"};
    public String lista2[]={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto",
        "Septiembre","Octubre", "Noviembre","Diciembre"};
        ////////////////////////////
    public Visual()
    {
         listanombre=new String[100];
       listaclave=new int[100];
          
        listaDia1=new int[100];
         listaDia2=new int[100];
          listaMes1=new String[100];
           listaMes2=new String[100];
            listaAnnio1=new int[100];
             listaAnnio2=new int[100];
        /////////////////////////
         calendario= new JComboBox(lista2);
         tipou=      new JComboBox(lista);
         calendario2= new JComboBox (lista2);
         tipou.setBounds(170, 70, 200, 20);
         calendario.setBounds(180,140, 100, 20);
         calendario2.setBounds(180,200, 100, 20);
          setSize (ancho,alto);
           DefinirColores ColorNuevo = new DefinirColores();
            areaTrabajo = new JTextArea   ();
            areaTrabajo.setBackground(ColorNuevo.color3);
            areaTrabajo.setFont(new java.awt.Font("Arial",1,15));
         /* areaTrabajo.setBounds(0, 0, 300,200);*/
            areaTrabajo.setBounds(5,5,400,300);
            areaTrabajo.setEditable (false);
            
       //propiedades de la ventana
        Toolkit kit=Toolkit.getDefaultToolkit();
        Dimension tamaniopantalla=kit.getScreenSize();
        int anchopantalla=tamaniopantalla.width;
        int altopantalla=tamaniopantalla.height;
       

        getContentPane().setLayout(null);
        setTitle("Numero de reservación");
        getContentPane().setBackground(ColorNuevo.color1);
        setResizable(false);
//
         etiqueta1 = new JLabel();
          etiqueta1.setForeground(Color.yellow); 
           etiqueta1.setBounds(20,10, 200, 20);
         
         etiqueta2 = new JLabel();
           etiqueta2.setForeground(Color.white); 
         etiqueta2.setBounds(20, 40, 200, 20);
         etiqueta3 = new JLabel();
           etiqueta3.setForeground(Color.white); 
          etiqueta3.setBounds(20, 70, 200, 20);
         etiqueta4 = new JLabel();
           etiqueta4.setForeground(Color.white); 
        etiqueta4.setBounds(20, 100, 200, 20);
          etiqueta5 = new JLabel();
           etiqueta5.setForeground(Color.white); 
        etiqueta5.setBounds(100, 120, 300, 20);
         etiqueta6= new JLabel();
          etiqueta6.setForeground(Color.white); 
         etiqueta6.setBounds(20, 165, 300, 20);
           etiqueta7= new JLabel();
          etiqueta7.setForeground(Color.white); 
         etiqueta7.setBounds(100, 180, 300, 20);
        
        etiqueta1.setText("Número de habitación");
         etiqueta2.setText("Nombre del cliente: ");
         etiqueta3.setText("Tipo de habitación: ");
         etiqueta4.setText("Fecha de entrada: ");
        etiqueta4.setForeground(Color.yellow); 
  
     etiqueta5.setText("Día                       Mes                                       Año");
               etiqueta6.setText("Fecha de salida");
               etiqueta6.setForeground(Color.yellow); 
     etiqueta7.setText("Día                       Mes                                       Año");
        //panel para insertar  nuevos registros-----------------
      
        Border grabado = BorderFactory.createEtchedBorder();
        Border  titulo= BorderFactory.createTitledBorder(grabado,"Nuevo registro");
 
   

        areaTrabajo.add(etiqueta1);
        areaTrabajo.add(etiqueta2);
        areaTrabajo.add(etiqueta3);
        areaTrabajo.add(etiqueta4);
          areaTrabajo.add(etiqueta5);
           areaTrabajo.add(etiqueta6);
           areaTrabajo.add(etiqueta7);
          getContentPane().add(areaTrabajo);
        Text1=new JTextField(10);
        Text1.setBounds(170, 10, 50, 20);
        areaTrabajo.add(Text1);
 
      
        Text2=new JTextField(15);
        Text2.setBounds(170, 40, 200, 20);
        areaTrabajo.add(Text2);

        Text3=new JTextField(10);
        Text3.setBounds(100, 140, 50, 20);
       areaTrabajo.add(Text3);
       
         Text4=new JTextField(10);
        Text4.setBounds(320, 140, 50, 20);
       areaTrabajo.add(Text4); 
              
         Text5=new JTextField(10);
        Text5.setBounds(100, 200, 50, 20);
       areaTrabajo.add(Text5); 
              
         Text6=new JTextField(10);
        Text6.setBounds(320, 200, 50, 20);
       areaTrabajo.add(Text6); 
       
 
                  areaTrabajo.add(tipou);
                  areaTrabajo.add(calendario);
                  areaTrabajo.add(calendario2);

      
    
    
       
    }
}