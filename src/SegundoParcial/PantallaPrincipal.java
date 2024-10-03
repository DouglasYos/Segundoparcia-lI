package SegundoParcial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaPrincipal extends JFrame implements ActionListener {
    private JLabel ETitulo, EUsuario,EIcono;
    private JTextField TxtNombre, TxtApellido, TxtResultado;
    private JComboBox<String> comboDepartamento, comboAntiguedad;
    private JButton BtnCalcular, BtnLimpiar, BtnRegresar;

    public PantallaPrincipal(String nombreUsuario) {
        setTitle("Pantalla Principal");
        setLayout(null);
        setBounds(200, 10, 800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menú de personalización
        JMenuBar menuBar = new JMenuBar();
        JMenu menuPersonalizar = new JMenu("Personalizar");
        JMenuItem itemColorFondo = new JMenuItem("Cambiar Color de Fondo");
        JMenuItem itemFuente = new JMenuItem("Cambiar Tamaño de Fuente");

        itemColorFondo.addActionListener(e -> cambiarColorFondo());
        itemFuente.addActionListener(e -> cambiarTamanoFuente());

        menuPersonalizar.add(itemColorFondo);
        menuPersonalizar.add(itemFuente);
        menuBar.add(menuPersonalizar);
        setJMenuBar(menuBar);

        // Título
        ETitulo = new JLabel("Cálculo de Vacaciones");
        ETitulo.setBounds(300, 20, 400, 30);
        ETitulo.setFont(new Font("Arial", Font.BOLD, 24));
        add(ETitulo);

        // Mostrar el nombre del usuario
        EUsuario = new JLabel("Usuario: " + nombreUsuario);
        EUsuario.setBounds(50, 70, 400, 30);
        add(EUsuario);

        // Campos de texto para nombre y apellido
        TxtNombre = new JTextField();
        TxtNombre.setBounds(200, 120, 150, 30);
        add(TxtNombre);
        
        TxtApellido = new JTextField();
        TxtApellido.setBounds(200, 160, 150, 30);
        add(TxtApellido);

        // ComboBox para seleccionar departamento
        comboDepartamento = new JComboBox<>();
        comboDepartamento.setBounds(200, 200, 150, 30);
        comboDepartamento.addItem("Atención al Cliente");
        comboDepartamento.addItem("Logística");
        comboDepartamento.addItem("Gerente");
        add(comboDepartamento);

        // ComboBox para seleccionar antigüedad
        comboAntiguedad = new JComboBox<>();
        comboAntiguedad.setBounds(200, 240, 150, 30);
        comboAntiguedad.addItem("1 año");
        comboAntiguedad.addItem("2 años");
        comboAntiguedad.addItem("3 años");
        comboAntiguedad.addItem("4 años");
        comboAntiguedad.addItem("5 años");
        comboAntiguedad.addItem("6 años");
        comboAntiguedad.addItem("7 años o más");
        add(comboAntiguedad);

        // Botón para calcular
        BtnCalcular = new JButton("Calcular Vacaciones");
        BtnCalcular.setBounds(50, 300, 150, 30);
        BtnCalcular.addActionListener(this);
        add(BtnCalcular);

        // Campo para mostrar el resultado
        TxtResultado = new JTextField();
        TxtResultado.setBounds(200, 300, 150, 30);
        TxtResultado.setEditable(false);
        add(TxtResultado);

        // Botón para limpiar
        BtnLimpiar = new JButton("Limpiar");
        BtnLimpiar.setBounds(400, 300, 100, 30);
        BtnLimpiar.addActionListener(e -> limpiarCampos());
        add(BtnLimpiar);

        // Botón para regresar a la pantalla de bienvenida
        BtnRegresar = new JButton("Regresar");
        BtnRegresar.setBounds(510, 300, 100, 30);
        BtnRegresar.addActionListener(e -> {
            new segundo_parcial(); // Regresa a la pantalla de bienvenida
            dispose();
        });
        add(BtnRegresar);

        // Información del desarrollador
        JLabel lblDesarrollador = new JLabel("Desarrollador: Tu Nombre - Curso: Programación II - Sección: A");
        lblDesarrollador.setBounds(50, 500, 600, 20);
        add(lblDesarrollador);

        setVisible(true);
        
        Image icon = Toolkit.getDefaultToolkit().getImage("E:\\Programacion II\\IMAGENES\\Logo.jpg");
        setIconImage(icon);// Colocar icono en el JFrame
        //setIconImage(icon);
        
        ImageIcon logo = new ImageIcon("E:\\Programacion II\\IMAGENES\\3.jpg");
       
        Image image = logo.getImage();
        Image scaledImage = image.getScaledInstance(800, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        EIcono = new JLabel(scaledIcon);
        EIcono.setBounds(0, 40, 800, 400);
        
        add(EIcono);
    }

    private void limpiarCampos() {
        TxtNombre.setText("");
        TxtApellido.setText("");
        TxtResultado.setText("");
        comboDepartamento.setSelectedIndex(0);
        comboAntiguedad.setSelectedIndex(0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == BtnCalcular) {
            calcularVacaciones();
        }
    }

    private void calcularVacaciones() {
        String nombre = TxtNombre.getText().trim();
        String apellido = TxtApellido.getText().trim();
        String departamento = (String) comboDepartamento.getSelectedItem();
        String antiguedadStr = (String) comboAntiguedad.getSelectedItem();

        if (nombre.isEmpty() || apellido.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, completa todos los campos.");
            return;
        }

        // Obtener la antigüedad en años
        int antiguedad = obtenerAntiguedad(antiguedadStr);

        int diasVacaciones = 0;
        switch (departamento) {
            case "Atención al Cliente":
                if (antiguedad == 1) diasVacaciones = 6;
                else if (antiguedad >= 2 && antiguedad <= 6) diasVacaciones = 14;
                else if (antiguedad >= 7) diasVacaciones = 20;
                break;
            case "Logística":
                if (antiguedad == 1) diasVacaciones = 7;
                else if (antiguedad >= 2 && antiguedad <= 6) diasVacaciones = 15;
                else if (antiguedad >= 7) diasVacaciones = 22;
                break;
            case "Gerente":
                if (antiguedad == 1) diasVacaciones = 10;
                else if (antiguedad >= 2 && antiguedad <= 6) diasVacaciones = 20;
                else if (antiguedad >= 7) diasVacaciones = 30; // Asumí 30 para gerentes
                break;
        }

        TxtResultado.setText("Días de vacaciones: " + diasVacaciones);
    }
    
        
    private int obtenerAntiguedad(String antiguedadStr) {
        switch (antiguedadStr) {
            case "1 año": return 1;
            case "2 años": return 2;
            case "3 años": return 3;
            case "4 años": return 4;
            case "5 años": return 5;
            case "6 años": return 6;
            case "7 años o más": return 7;
            default: return 0; // No debería suceder
        }
    }

    private void cambiarColorFondo() {
        Color nuevoColor = JColorChooser.showDialog(this, "Seleccione un Color de Fondo", getBackground());
        if (nuevoColor != null) {
            getContentPane().setBackground(nuevoColor);
        }
    }

    private void cambiarTamanoFuente() {
        String input = JOptionPane.showInputDialog(this, "Ingrese el tamaño de la fuente:");
        if (input != null) {
            try {
                int tamano = Integer.parseInt(input);
                Font nuevaFuente = new Font("Arial", Font.PLAIN, tamano);
                ETitulo.setFont(nuevaFuente);
                EUsuario.setFont(nuevaFuente);
                TxtNombre.setFont(nuevaFuente);
                TxtApellido.setFont(nuevaFuente);
                TxtResultado.setFont(nuevaFuente);
                BtnCalcular.setFont(nuevaFuente);
                BtnLimpiar.setFont(nuevaFuente);
                BtnRegresar.setFont(nuevaFuente);
                comboDepartamento.setFont(nuevaFuente);
                comboAntiguedad.setFont(nuevaFuente);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.");
            }
        }
    }
}