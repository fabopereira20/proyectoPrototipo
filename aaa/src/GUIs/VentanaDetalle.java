package GUIs;

import modelo.Persona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VentanaDetalle extends JFrame {
    JButton guardarBtn;

    public VentanaDetalle(Persona persona) {
        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        add(mainPanel);

        JPanel detallesPanel = new JPanel(new GridLayout(3, 2));
        mainPanel.add(detallesPanel);

        JLabel nombreLabel = new JLabel(("nombre:"));
        JLabel nombrePersonaLabel = new JLabel(persona.getNombre());
        detallesPanel.add(nombrePersonaLabel);

        JLabel TipoRecursoLabel = new JLabel("Tipo Recurso:");
        JLabel TipoRecursoPersonaLabel = new JLabel(persona.getTipoRecurso().toString());
        detallesPanel.add(TipoRecursoLabel);
        detallesPanel.add(TipoRecursoPersonaLabel);

        JLabel claseLabel = new JLabel("Tipo Recurso:");
        JLabel clasePersonaLabel = new JLabel(persona.getClass().toString());
        detallesPanel.add(claseLabel);
        detallesPanel.add(clasePersonaLabel);

        JPanel guardarPanel = new JPanel();
        mainPanel.add(guardarPanel);

        JButton volverBtn = new JButton("volver");

        volverBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaPersona creacionPersonaWindow = new VentanaPersona();
                creacionPersonaWindow.setVisible(true);
                dispose();
            }//Procesa el Evento capturado



        });

        guardarBtn = new JButton("Guardar");
        guardarBtn.addActionListener(e -> {
            if (persona.save()) {
                JOptionPane.showMessageDialog(null, "Persona guardado en archivo \"persona.cvs\"");
            } else {
                JOptionPane.showMessageDialog(null, "Ocurrio un error al guaradar los datos al archivo\"persona.cvs\"");


            }
        });
        guardarPanel.add(volverBtn);
        guardarPanel.add(guardarBtn);

        setSize(700, 500);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);










}}
