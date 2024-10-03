package SegundoParcial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class segundo_parcial extends JFrame implements ActionListener {
    private JLabel ETitulo, EIcono;
    private JTextField TxtNombreUsuario;
    private JButton BtnContinuar;

    public segundo_parcial() {
        setTitle("Pantalla de Bienvenida");
        setLayout(null);
        setBounds(200, 10, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Logo del negocio (puedes poner una imagen en el JLabel)
        JLabel logo = new JLabel(new ImageIcon("E:\\Programacion II\\IMAGENES\\1.jpg")); // Asegúrate de tener esta imagen
        logo.setBounds(50, 20, 700, 200); // Ajusta el tamaño según necesites
        add(logo);

        // Título
        ETitulo = new JLabel("Bienvenido a la Calculadora de Vacaciones");
        ETitulo.setBounds(200, 230, 500, 60);
        ETitulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(ETitulo);

        // Campo de texto para el nombre del usuario
        TxtNombreUsuario = new JTextField();
        TxtNombreUsuario.setBounds(250, 280, 300, 30);
        add(TxtNombreUsuario);

        // Botón para continuar
        BtnContinuar = new JButton("Continuar");
        BtnContinuar.setBounds(350, 320, 100, 30);
        BtnContinuar.addActionListener(this);
        add(BtnContinuar);

        // Información al pie de la interfaz
        JLabel lblInfo = new JLabel("Venta de plantas - Estudiante: Douglas Yos - Curso: Programación II - Sección: B");
        lblInfo.setBounds(50, 500, 600, 20);
        add(lblInfo);
        
        //LOGO PREDEFINIDO
        

        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Verifica que el campo no esté vacío antes de continuar
        if (e.getSource() == BtnContinuar) {
            String nombreUsuario = TxtNombreUsuario.getText().trim();
            if (nombreUsuario.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingresa tu nombre.");
            } else {
                // Abre la pantalla de condiciones
                new PantallaCondiciones(nombreUsuario); 
                dispose(); // Cierra la pantalla de bienvenida
            }
        }
    }

    public static void main(String[] args) {
        new segundo_parcial(); // Inicializa la pantalla de bienvenida
    }
}
