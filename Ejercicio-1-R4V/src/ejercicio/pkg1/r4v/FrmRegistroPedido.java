/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.pkg1.r4v;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author Alex
 */
public class FrmRegistroPedido extends JFrame {
    private JPanel pnlTitulo;
    private JLabel lblTitulo;
    private JLabel lblSubTitulo;
    private JPanel pnlContenido;
    
    // U2
    private JLabel lblFechaLabel;
    private JLabel lblFecha;

    
    //Mesas
    private JLabel lblMesas;
    private JList<String> lstMesas;
    private JPanel pnlMesas;
    private String [] mesas={"Mesa 1","Mesa 2","Mesa 3","Mesa 4","Mesa Terraza 1","Mesa terraza 2","Mesa VIP"};
   
    
    // platillos
    private JLabel lblPlatillos;
    private JLabel lblPlatillosSubTotal;
    private JList<String> lstPlatillos;
    private JPanel pnlPlatillos;
    private String [] platillos={"Pasta de Bits con ASCII","Pasta de Bytes ISO","Carne de Motherboard","Costillas de Ram","Asado de Sectores","Sanwich MSDOS","Pizza de estado solido","Pizza magnetica 7200rpm"};
    private double[] precioPlatillos={30.75,20.50,99.50,60.50,120.50,20.50,50.75,50.75};
     
    // Bebeidas
    private JLabel lblBebidas;
    private JLabel lblBebebidasSubTotal;
    private JList<String> lstBebidas;
    private JPanel pnlBebidas;
    private String [] Bebidas={"Bebidas Dos","Agua de CPU","Refresco F5","MyDoom Cola","WannaCry en las rocas","Troyano Up","Ninguna (Solo Platillo)"};
    private double[] precioBebidas={25.00,10.00,15.00,25.00,15.00,45.00,30.00};
     
    
    //Mesas
    private JLabel lblFormasPago;
    private JList<String> lstFormasPago;
    private JPanel pnlFormasPago;
    private String [] FormasPago={"Bitcoin","Lifecoin","Quark","Peercoin","Dogecoin","Pejecoins","Wilicoins"};
   
    
    // Label Grande
    private JLabel lblInstruccionesTitulo;
    private JLabel lblInstruccionesDetalle;
    private JPanel pnlInstrucciones;
    
    // ContenidoFooter
    
    private JLabel lblGranTotal;
    private JButton btnRegistrarPedido;
    private JPanel pnlTotalRegistro;
    
    // Sumas
    private double totalPlatillos , totalBebidas,GranTotal;
    

    public JLabel getLblInstruccionesTitulo() {
        if(lblInstruccionesTitulo == null){
            lblInstruccionesTitulo =new JLabel();
            lblInstruccionesTitulo.setText("Instrucciones para el mesero");            
    //        lblSubTitulo.setFont(new Font("Impact", Font.BOLD, 15));
            
        }
        
        return lblInstruccionesTitulo;
    }

    public JLabel getLblInstruccionesDetalle() {
        if(lblInstruccionesDetalle == null){
            lblInstruccionesDetalle = new JLabel();
            lblInstruccionesDetalle.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            lblInstruccionesDetalle.setText("<html><ol>"
                    +"<li>Salude con cortesia al comensal.</li>"
                    +"<li>Registre el numerfo de mesa</li>"
                    +"<li>Pregunte por el platillo de su preferencia(sugiera).</li>"
                    +"<li>Pregunte por su bebida de su preferencia(sugiera).</li>"
                    +"<li>Recuerda reshgistra ;la doema de pago</li>"
                    +"<li>Hagale saber que sera atendido en breve</li>"
                    +"</lo></html>");            
    //        lblSubTitulo.setFont(new Font("Impact", Font.BOLD, 15));
            
        }
        return lblInstruccionesDetalle;
    }

    public JPanel getPnlInstrucciones() {
        if (pnlInstrucciones==null) {
            pnlInstrucciones=new JPanel();
            pnlInstrucciones.setLayout(new BoxLayout(pnlInstrucciones, BoxLayout.Y_AXIS));            
            //Agregar widgets al panel 
            pnlInstrucciones.add(getLblInstruccionesTitulo());
            pnlInstrucciones.add(getLblInstruccionesDetalle());
            
        }
        return pnlInstrucciones;
    }
   
    public JLabel getLblFechaLabel(){
        if(lblFechaLabel == null){
            lblFechaLabel =new JLabel();
            lblFechaLabel.setText("Fecha:");            
    //        lblSubTitulo.setFont(new Font("Impact", Font.BOLD, 15));
            
            
        }
        
        return lblFechaLabel;
        
    }
    // U2
    public JLabel getLblFecha() {
        if(lblFecha == null){
            lblFecha =new JLabel(); 
        }
        new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text =new SimpleDateFormat("Y.MM.dd HH.mm.ss").format(new Date());
                lblFecha.setText(text);
            }
        }).start();
        return lblFecha;
    }
    
    public JPanel getPnlTitulo() {
        if(pnlTitulo == null){
            pnlTitulo=new JPanel();
            //pnlTitulo.setBounds(0, 0, 200, 100);            
            pnlTitulo.setBackground(new java.awt.Color(111, 183, 169));
            pnlTitulo.setLayout(new BoxLayout(pnlTitulo, BoxLayout.Y_AXIS));
            pnlTitulo.add(getLblTitulo());            
            pnlTitulo.add(getLblSubTitulo());
        }
        return pnlTitulo;
    }

    public JLabel getLblTitulo() {
        if(lblTitulo == null){
            lblTitulo =new JLabel();
            lblTitulo.setText("R4V");            
            lblTitulo.setFont(new Font("Arial", Font.ITALIC, 30));
            lblTitulo.setBackground(Color.RED);
            lblTitulo.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            // agregar componentes hijo
           
            
        }
        return lblTitulo;
    }

    public JLabel getLblSubTitulo() {
        if(lblSubTitulo == null){
            lblSubTitulo =new JLabel();
            lblSubTitulo.setText("Restuarant For Virus");            
            lblSubTitulo.setFont(new Font("Arial", Font.ITALIC, 15));
            lblSubTitulo.setBackground(Color.RED);
            lblSubTitulo.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            // agregar componentes hijo
            
            
        }
        return lblSubTitulo;
    }

    public JList<String> getLstMesas() {
        if(lstMesas == null){
            lstMesas =new JList<>(mesas);
        }
        return lstMesas;
    }
    
    public JList<String> getLstPlatillos() {
        if(lstPlatillos == null){
            lstPlatillos =new JList<>(platillos);
            lstPlatillos.addListSelectionListener((ListSelectionEvent e) -> {
                if(!e.getValueIsAdjusting()){
                    totalPlatillos= precioPlatillos[lstPlatillos.getSelectedIndex()];
                    getLblPlatillosSubTotal().setText("Subtotal  "+ totalPlatillos);
                    getLblGranTotal().setText("Total $" + (totalPlatillos + totalBebidas));
                    
                }
            });
        }
        return lstPlatillos;
    }

    public JLabel getLblBebidas() {
        if (lblBebidas== null) {
            lblBebidas = new JLabel("Bebidas:");
        }
        return lblBebidas;
    }

    public JLabel getLblBebebidasSubTotal() {
        if (lblBebebidasSubTotal==null) {
            lblBebebidasSubTotal = new JLabel("Sub:");
        }
        return lblBebebidasSubTotal;
    }
    
    public JList<String> getLstBebidas() {
        if(lstBebidas == null){
            lstBebidas =new JList<>(Bebidas);
            lstBebidas.addListSelectionListener((ListSelectionEvent e) -> {
                if(!e.getValueIsAdjusting()){
                    totalBebidas= precioBebidas[lstBebidas.getSelectedIndex()];
                    getLblBebebidasSubTotal().setText("Subtotal  "+ totalBebidas);
                    getLblGranTotal().setText("Total $" + (totalPlatillos + totalBebidas));
                    
                }
            });
        }
        return lstBebidas;
    }
    
    public JPanel getPnlBebidas() {
        if (pnlBebidas==null) {
            pnlBebidas=new JPanel();
            pnlBebidas.setLayout(new BoxLayout(pnlBebidas, BoxLayout.Y_AXIS));
            pnlBebidas.add(getLblBebidas());
            pnlBebidas.add(getLstBebidas());
            pnlBebidas.add(getLblBebebidasSubTotal());
        }
        return pnlBebidas;
    }

    public String[] getBebidas() {
        return Bebidas;
    }

    public JLabel getlblPlatillos() {
        if(lblPlatillos == null){
            lblPlatillos =new JLabel("Platillos:"); 
        }
        
        return lblPlatillos;
    }

    public JLabel getLblPlatillosSubTotal() {
        if(lblPlatillosSubTotal == null){
            lblPlatillosSubTotal =new JLabel("Sub:"); 
        }
        return lblPlatillosSubTotal;
    }
    
    public JPanel getPnlPlatillos() {
        if (pnlPlatillos==null) {
            pnlPlatillos=new JPanel();
            pnlPlatillos.setLayout(new BoxLayout(pnlPlatillos, BoxLayout.Y_AXIS));            
            //Agregar widgets al panel 
            pnlPlatillos.add(getlblPlatillos());
            pnlPlatillos.add(getLstPlatillos());
            pnlPlatillos.add(getLblPlatillosSubTotal());
        }
        return pnlPlatillos;
    }
    
    public JLabel getlblMesas() {
        
        if(lblMesas == null){
            lblMesas =new JLabel("Mesas:"); 
        }
        return lblMesas;
    }
    
    public JPanel getPnlMesas(){
        if (pnlMesas==null) {
            pnlMesas=new JPanel();
            pnlMesas.setLayout(new BoxLayout(pnlMesas, BoxLayout.Y_AXIS));
            
            //Agregar widgets al panel 
            pnlMesas.add(getlblMesas());
            pnlMesas.add(getLstMesas());
        }
    return pnlMesas;
    }

    public JLabel getLblGranTotal() {
        if (lblGranTotal==null) {
            lblGranTotal = new JLabel("Total: $");
            lblGranTotal.setFont(new Font("impact",Font.BOLD,30) {
            });
        }
        return lblGranTotal;
    }

    public JButton getBtnRegistrarPedido() {
        if (btnRegistrarPedido == null) {
            btnRegistrarPedido = new JButton("Registrar pedido");
            btnRegistrarPedido.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    String mensaje = 
                            "------------------- DETALLES DE LA COMPRA ------------------- \n"+
                            getLstMesas().getSelectedValue() + "\n"+
                            getLstPlatillos().getSelectedValue() + "\n"+
                            getLstBebidas().getSelectedValue() + "\n"+
                            getLstFormasPago().getSelectedValue();
                    JOptionPane.showMessageDialog(null, mensaje);
                }
            
            });
        }
        return btnRegistrarPedido;
        
    }

    public JPanel getPnlTotalRegistro() {
        if (pnlTotalRegistro == null) {
            pnlTotalRegistro = new JPanel();
            pnlTotalRegistro.setLayout(new BoxLayout(pnlTotalRegistro, BoxLayout.Y_AXIS));
            pnlTotalRegistro.add(getLblGranTotal());
            pnlTotalRegistro.add(getBtnRegistrarPedido());
        }
        return pnlTotalRegistro;
    }
    
    public JPanel getPnlContenido() {
        if(pnlContenido == null){
            pnlContenido=new JPanel();         
            pnlContenido.setBackground(new java.awt.Color(186, 222, 215));
            pnlContenido.setLayout(new GridBagLayout());
            
            //Agregar widgets al panel contenedor
            GridBagConstraints constraints;
            constraints = new GridBagConstraints();
            pnlContenido.add(getLblFechaLabel(), constraints);
            constraints.gridx=0;
            constraints.gridy=0;
            pnlContenido.add(getLblFechaLabel(), constraints);
           
            constraints = new GridBagConstraints();
            constraints.gridx=1;
            constraints.gridy=0;
            pnlContenido.add(getLblFecha(), constraints);
            
            constraints = new GridBagConstraints();
            constraints.gridx=0;
            constraints.gridy=1;
            pnlContenido.add(getPnlMesas(), constraints);
            
            constraints = new GridBagConstraints();
            constraints.gridx=1;
            constraints.gridy=1;
            pnlContenido.add(getPnlPlatillos(), constraints);
            
            constraints = new GridBagConstraints();
            constraints.gridx=2;
            constraints.gridy=1;
            pnlContenido.add(getPnlBebidas(), constraints);
            
            constraints = new GridBagConstraints();
            constraints.gridx=4;
            constraints.gridy=1;
            pnlContenido.add(getPnlFormasPago(), constraints);
            
            constraints = new GridBagConstraints();
            constraints.gridx=0;
            constraints.gridy=2;
            constraints.gridwidth=2;
            pnlContenido.add(getPnlInstrucciones(), constraints);

            constraints = new GridBagConstraints();
            constraints.gridx=2;
            constraints.gridy=2;
            constraints.gridwidth=2;
            pnlContenido.add(getPnlTotalRegistro(), constraints);
           
        }
        return pnlContenido;
    }
    
    public JList<String> getLstFormasPago() {
        if(lstFormasPago == null){
            lstFormasPago =new JList<>(FormasPago);
        }
        return lstFormasPago;
    }
    
    public JLabel getlblFormasPago() {
        
        if(lblFormasPago == null){
            lblFormasPago =new JLabel("Formas de Pago:"); 
        }
        return lblFormasPago;
    }
    
    public JPanel getPnlFormasPago(){
        if (pnlFormasPago==null) {
            pnlFormasPago=new JPanel();
            pnlFormasPago.setLayout(new BoxLayout(pnlFormasPago, BoxLayout.Y_AXIS));
            
            //Agregar widgets al panel 
            pnlFormasPago.add(getlblFormasPago());
            pnlFormasPago.add(getLstFormasPago());
        }
    return pnlFormasPago;
    }
    
    public FrmRegistroPedido() {
        this.setBounds(0, 0, 800, 600);
        this.setTitle("Registro de pedido");
        //this.setIconImage(image);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        ImageIcon img = new ImageIcon(this.getClass().getClassLoader().getResource("images/Dino.png"));
        //  this.setIconImage(this.getClass().getClassLoader().getResource("images/calavera.png"));
        this.setIconImage(img.getImage());
        
        this.add(getPnlTitulo(), BorderLayout.NORTH);
        this.add(getPnlContenido(), BorderLayout.CENTER);
        // Reduce al minimo y reduce el espacio vacio al maximo, se comento el Bounds
        //this.pack();
        this.setVisible(true);
        
        
    }
    
    
    
}
