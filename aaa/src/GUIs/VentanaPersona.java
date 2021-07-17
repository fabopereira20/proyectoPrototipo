package GUIs;

import modelo.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPersona extends JFrame implements ActionListener {

    private final JTextField nombrePersonaInput;
    private final JButton crearPersonaButton;
    private final JComboBox<String> claseRecurosComboBox;
    private final ButtonGroup grupoRadioButtons;


    public VentanaPersona() {
        setTitle("Recourse Handler");
        JPanel mainContainer = new JPanel();
        GridLayout mainGrid = new GridLayout(3, 1);
        mainGrid.setHgap(3);
        mainContainer.setLayout(mainGrid);
        add(mainContainer);


        JPanel inputPanel = new JPanel();
        mainContainer.add(inputPanel);
        GridBagConstraints c = new GridBagConstraints();
        inputPanel.setLayout(new GridBagLayout());
        JLabel labelNombrePersona = new JLabel("Nombre persona:");
        nombrePersonaInput = new JTextField(5);
        nombrePersonaInput.getDocument().addDocumentListener(new DocumentListener(){
        @Override
        public void insertUpdate (DocumentEvent e){
            crearPersonaButton.setEnabled(nombrePersonaInput.getText().length() != 0);
        }
        @Override
        public void removeUpdate (DocumentEvent e){
            crearPersonaButton.setEnabled(nombrePersonaInput.getText().length() != 0);
        }
        @Override
        public void changedUpdate (DocumentEvent e){
            crearPersonaButton.setEnabled(nombrePersonaInput.getText().length() != 0);
        }
    });

        JLabel labelTipoRecurso = new JLabel("Tipo de recurso:");
        claseRecurosComboBox = new JComboBox<>();
        claseRecurosComboBox.addItem("Luz");
        claseRecurosComboBox.addItem("Agua");



        JLabel labelTipoRecurso2 = new JLabel("Tipo de Recurso:");
        var agua = new JRadioButton("Agua");
        agua.setActionCommand("1");
        var luz = new JRadioButton("Luz");
        luz.setActionCommand("2");
        luz.setSelected(true);
        grupoRadioButtons = new ButtonGroup();
        grupoRadioButtons.add(luz);
        grupoRadioButtons.add(agua);
        var panelTipoRecurso = new JPanel();
        panelTipoRecurso.add(luz);
        panelTipoRecurso.add(agua);


        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.1;
        c.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(labelNombrePersona, c);

        c.gridx = 1;
        c.gridy = 0;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(nombrePersonaInput, c);

        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.1;
        c.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(labelTipoRecurso, c);

        c.gridx = 1;
        c.gridy = 1;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(claseRecurosComboBox, c);

        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 0.1;
        c.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(labelTipoRecurso2, c);

        c.gridx = 1;
        c.gridy = 2;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.HORIZONTAL;
        inputPanel.add(panelTipoRecurso, c);

        JPanel buttonPanel = new JPanel();
        mainContainer.add(buttonPanel);
        crearPersonaButton = new JButton("Empezar encuesta");
        crearPersonaButton.setEnabled(false);
        crearPersonaButton.addActionListener(this);
        buttonPanel.add(crearPersonaButton);



        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Persona persona;
        String nombre = nombrePersonaInput.getText();
        String recurso = claseRecurosComboBox.getSelectedItem().toString();
        TipoRecurso tipoRecurso = TipoRecurso.valueOf(grupoRadioButtons.getSelection().getActionCommand());

        persona = switch (recurso) {
            case "Luz" -> new Luz(nombre, tipoRecurso);
            case "Agua" -> new Agua(nombre, tipoRecurso);

            default -> throw new IllegalStateException("Unexpected value: " + recurso);
        };//Procesa el Evento capturado con la clase Luz o agua elegida



        VentanaDetalle detalleWindow = new VentanaDetalle(persona);
        //this.setVisible(false); //Para poder ejecutar la ventana (true)
        dispose();    //borra la ventana
    }
}// Interfaces para gestión de eventos