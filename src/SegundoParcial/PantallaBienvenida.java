package SegundoParcial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PantallaBienvenida extends JFrame implements ActionListener {

    private JTextField txtNombre;
    private JButton btnContinuar;

    public PantallaBienvenida() {
        // Configuraciones de la ventana
        setTitle("Bienvenida - Calculadora de Vacaciones!!");
        setLayout(null);
        setBounds(200, 10, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Logotipo
        JLabel lblLogo = new JLabel(new ImageIcon("E:\\Programacion II\\IMAGENES\\logo.png")); // Ajusta la ruta según sea necesario
        lblLogo.setBounds(300, 20, 200, 100); // Ajusta el tamaño y la posición
        add(lblLogo);

        // Campo de texto para el nombre
        JLabel lblNombre = new JLabel("Ingrese su nombre:");
        lblNombre.setBounds(50, 150, 150, 20);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(200, 150, 150, 20);
        add(txtNombre);

        // Botón de continuar
        btnContinuar = new JButton("Continuar");
        btnContinuar.setBounds(50, 200, 100, 20);
        btnContinuar.setEnabled(false); // Deshabilitado inicialmente
        add(btnContinuar);
        btnContinuar.addActionListener(this);

        // Valida el campo de texto
        txtNombre.addCaretListener(e -> {
            if (txtNombre.getText().trim().isEmpty()) {
                btnContinuar.setEnabled(false);
            } else {
                btnContinuar.setEnabled(true);
            }
        });

        // Información al pie de la interfaz
        JLabel lblInfo = new JLabel("venta de plantas - Estudiante: Nombre - Curso: Programación II - Sección: B");
        lblInfo.setBounds(50, 500, 600, 20);
        add(lblInfo);
        
        // Configuración de favicon
        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\Programacion II\\IMAGENES\\favicon.png")); // Ajusta la ruta según sea necesario
        } catch (Exception e) {
            System.out.println("Error al establecer el favicon");
        }
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == btnContinuar) {
            String nombreUsuario = txtNombre.getText();
            new PantallaCondiciones(nombreUsuario); // Pasar el nombre a la siguiente pantalla
            dispose(); // Cierra la pantalla de bienvenida
        }
    }

    public static void main(String[] args) {
        new PantallaBienvenida();
    }
}