package April._25;

/**
 * @author Marcelo Cohen
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.*;

public class JanelaAplicacao extends JFrame {

    private enum Modo { ARRAY, SINGLE, DOUBLE };
    private ZoomAndPanCanvas painel;
    private JLabel labelTotal;
    private JComboBox<String> cbModo;
    private ListTADPontos lista, listaSimplificada;
    private Modo modo;

    public JanelaAplicacao() {
        super("Simplificação de Polígonos");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel principal = new JPanel();
        this.setContentPane(principal);
        modo = Modo.ARRAY;

        lista = carregaArquivo("pontos.txt");
        painel = new ZoomAndPanCanvas(this, lista);

        principal.setLayout(new BorderLayout());
        principal.add(painel, BorderLayout.CENTER);

        labelTotal = new JLabel(String.format("%-6d", lista.size()));
        
        String modos[] = { "Array", "Lista Simples", "Lista Dupla" };
        cbModo = new JComboBox<String>(modos);
        cbModo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(cbModo.getSelectedItem().equals("Array"))
					modo = Modo.ARRAY;
				else if(cbModo.getSelectedItem().equals("Lista Simples"))
					modo = Modo.SINGLE;
				else modo = Modo.DOUBLE;				
			}
		});

        JPanel bottomPane = new JPanel();
        bottomPane.add(labelTotal);
        JButton botao18 = new JButton("1/8");
        JButton botao14 = new JButton("1/4");
        JButton botao12 = new JButton("1/2");
        JButton botaoTodos = new JButton("TODOS");
        bottomPane.add(botao18);
        bottomPane.add(botao14);
        bottomPane.add(botao12);
        bottomPane.add(botaoTodos);
        bottomPane.add(cbModo);
        principal.add(bottomPane, BorderLayout.PAGE_END);

        botao18.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                listaSimplificada = simplifica(lista.size() / 8);
                labelTotal.setText(String.format("%-6d", listaSimplificada.size()));
                painel.repaint();
            }
        });

        botao14.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                listaSimplificada = simplifica(lista.size() / 4);
                labelTotal.setText(String.format("%-6d", listaSimplificada.size()));
                painel.repaint();
            }
        });

        botao12.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                listaSimplificada = simplifica(lista.size() / 2);
                labelTotal.setText(String.format("%-6d", listaSimplificada.size()));
                painel.repaint();
            }
        });

        botaoTodos.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                listaSimplificada = simplifica(lista.size());
                labelTotal.setText(String.format("%-6d", lista.size()));
                painel.repaint();
            }
        });

        this.setSize(500, 500);
        this.pack();

        listaSimplificada = simplifica(lista.size());
        //painel.createBufferStrategy(2);
    }

	private ListTADPontos carregaArquivo(String nome) {
        ListTADPontos lista = new ListSingleLinkedPontos();
        try {
            Scanner scanner = new Scanner(new File(nome));
            //scanner.useDelimiter("\n"); //System.getProperty("line.separator"));
            System.out.println(Locale.getDefault());
            scanner.useLocale(Locale.ENGLISH);
            while (scanner.hasNext()) {
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();
                //System.out.println("X="+x+", Y="+y);
                lista.add(new Ponto(x, y));
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //System.out.println(lista.size());
        return lista;
    }

    ListTADPontos getSimplified() {
        return listaSimplificada;
    }
    
    private ListTADPontos simplifica(int size) {
        switch(modo) {
            case ARRAY:
			    return simplifyArray(size);
            case SINGLE:
                return simplifySingleLinked(size);
            case DOUBLE:
                return simplifyDoubleLinked(size);
            default:
                return null;
        }
	}

    ListTADPontos simplifyArray(int totalPontos) {
        ListTADPontos nova = new ListDoubleLinkedPontos();

        // No momento, só copia de uma para a outra...
        for (int i = 0; i < lista.size(); i++) {
            nova.add(lista.get(i));
        }

        long tempoInicial = System.currentTimeMillis();
        // ... faz simplificação ...        
        //while (nova.size() > totalPontos) {
        //}
        long tempoFinal = System.currentTimeMillis();
        
        System.out.println("Tempo aprox.: "+(tempoFinal-tempoInicial));        
        return nova;
    }

    private ListTADPontos simplifyDoubleLinked(int size) {
        return null;
    }

    private ListTADPontos simplifySingleLinked(int size) {
        return null;
    }

}
