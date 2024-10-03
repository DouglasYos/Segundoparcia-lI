package SegundoParcial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaCondiciones extends JFrame implements ActionListener {
    private JLabel ETitulo;
    private JTextArea TxtTerminos;
    private JCheckBox ChkAceptar;
    private JButton BtnContinuar, BtnNoAceptar;
    private String nombreUsuario;

    public PantallaCondiciones(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario; // Guarda el nombre del usuario
        setTitle("Términos y Condiciones");
        setLayout(null);
        setBounds(200, 10, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Título
        ETitulo = new JLabel("Términos y Condiciones");
        ETitulo.setBounds(250, 20, 400, 30);
        ETitulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(ETitulo);

        // Área de texto para los términos y condiciones
        TxtTerminos = new JTextArea("Esta aplicacion es propiedad de Douglas Yos y está operado por  los términos y condiciones bajo los cuales puedes usar nuestro  sitio web y los servicios que ofrecemos. Este sitio web ofrece a los visitantes  Al acceder o usar el sitio web  de nuestro servicio confirmas que has leído, entendido y aceptas estar  vinculado por estos Términos...Debe aceptarlos para continuar.");
        TxtTerminos.setBounds(50, 70, 700, 400);
        TxtTerminos.setLineWrap(true);
        TxtTerminos.setWrapStyleWord(true);
        TxtTerminos.setEditable(false);
        add(TxtTerminos);

        // Checkbox para aceptar términos
        ChkAceptar = new JCheckBox("Aceptar términos y condiciones");
        ChkAceptar.setBounds(50, 480, 250, 30);
        add(ChkAceptar);
        ChkAceptar.addActionListener(this);

        // Botón continuar
        BtnContinuar = new JButton("Continuar");
        BtnContinuar.setBounds(350, 520, 100, 30);
        BtnContinuar.setEnabled(false); // Deshabilitado por defecto
        BtnContinuar.addActionListener(this);
        add(BtnContinuar);

        // Botón no aceptar
        BtnNoAceptar = new JButton("No Aceptar");
        BtnNoAceptar.setBounds(470, 520, 100, 30);
        BtnNoAceptar.addActionListener(this);
        add(BtnNoAceptar);
;

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
            if (e.getSource() == ChkAceptar) {
                if (ChkAceptar.isSelected()){
                BtnNoAceptar.setEnabled(false);
                BtnContinuar.setEnabled(true);
                }else{
                    
                BtnNoAceptar.setEnabled(true);
                BtnContinuar.setEnabled(false);
                }
            
   
        }
        if (e.getSource() == BtnNoAceptar) {
            new segundo_parcial(); // Abre la pantalla principal
            dispose(); // Cierra la pantalla de condiciones
        }
        if (e.getSource() == BtnContinuar) {
            new PantallaPrincipal(nombreUsuario); // Abre la pantalla principal
            dispose(); // Cierra la pantalla de condiciones
        }
    }
}
