package br.com.gi.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

public class Garagem extends JFrame {
	private Dimension janela = Toolkit.getDefaultToolkit().getScreenSize();
	private JPanel panel;
	private JTextField textField;
	
	
	public Garagem(){
		this.janela = Toolkit.getDefaultToolkit().getScreenSize();
		this.setTitle("SpeedWay"); // Definindo o Título da Janela
		this.setSize(this.janela.getSize().width, this.janela.getSize().height); // Definindo Tamanho da Janela
		this.setLocationRelativeTo(null);// Centralizar janelas
		this.setResizable(false); // Não deixar redimencionar
		this.setUndecorated(true); // Retirar as Bordas da janela
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // para o botão fechar finalizar a app
		this.getContentPane().setLayout(null); // Setando o layout do JFrame para null
		
		URL url = this.getClass().getResource("/assets/img/logo1.png"); // Pegando a logo para icone
		Image icone = Toolkit.getDefaultToolkit().getImage(url); // setando a logo para uma imagem
		this.setIconImage(icone); // Seta a imagem do icone
		
		JButton btnSeguirParaCorrida = new JButton("Seguir para Corrida");
		btnSeguirParaCorrida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StartCorrida startCorrida = new StartCorrida();
				Thread tStartCorrida = new Thread(startCorrida);
				tStartCorrida.start();
				next();
			}
		});
		btnSeguirParaCorrida.setBackground(new Color(51, 51, 153));
		btnSeguirParaCorrida.setIcon(new ImageIcon(Garagem.class.getResource("/assets/img/flags.png")));
		btnSeguirParaCorrida.setForeground(new Color(255, 255, 255));
		btnSeguirParaCorrida.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnSeguirParaCorrida.setBounds(1157, 723, 199, 34);
		getContentPane().add(btnSeguirParaCorrida);
		
		JButton btRetornar = new JButton("Voltar");
		btRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					retornar();
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		});
		btRetornar.setIcon(new ImageIcon(Garagem.class.getResource("/assets/img/flags.png")));
		btRetornar.setForeground(Color.WHITE);
		btRetornar.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btRetornar.setBackground(new Color(51, 51, 153));
		btRetornar.setBounds(10, 723, 199, 34);
		getContentPane().add(btRetornar);
		
		JPanel panelGaragem = new JPanel();
		panelGaragem.setBounds(10, 72, 350, 254);
		panelGaragem.setOpaque(false);
		getContentPane().add(panelGaragem);
		
		JLabel lblPiloto = new JLabel("Piloto:");
		lblPiloto.setForeground(new Color(153, 153, 153));
		lblPiloto.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		JLabel lblGaragem = new JLabel("GARAGEM");
		lblGaragem.setForeground(new Color(153, 153, 153));
		lblGaragem.setFont(new Font("Arial Black", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(153, 153, 153));
		textField.setFont(new Font("Arial Black", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBorder(null);
		
		JLabel lblSelecioneOChassis = new JLabel("Selecione o Chassis:");
		lblSelecioneOChassis.setForeground(new Color(153, 153, 153));
		lblSelecioneOChassis.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		JComboBox comboBox = new JComboBox();
		
		JLabel lblSelecioneOMotor = new JLabel("Selecione o Motor:");
		lblSelecioneOMotor.setForeground(new Color(153, 153, 153));
		lblSelecioneOMotor.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		JComboBox comboBox_1 = new JComboBox();
		
		JLabel lblSelecioneOCambio = new JLabel("Selecione o Cambio:");
		lblSelecioneOCambio.setForeground(new Color(153, 153, 153));
		lblSelecioneOCambio.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		JComboBox comboBox_2 = new JComboBox();
		GroupLayout gl_panelGaragem = new GroupLayout(panelGaragem);
		gl_panelGaragem.setHorizontalGroup(
			gl_panelGaragem.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelGaragem.createSequentialGroup()
					.addGroup(gl_panelGaragem.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_panelGaragem.createSequentialGroup()
							.addContainerGap()
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panelGaragem.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblPiloto))
						.addGroup(Alignment.LEADING, gl_panelGaragem.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSelecioneOChassis, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_panelGaragem.createSequentialGroup()
							.addContainerGap()
							.addComponent(comboBox, 0, 330, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panelGaragem.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSelecioneOMotor))
						.addGroup(Alignment.LEADING, gl_panelGaragem.createSequentialGroup()
							.addContainerGap()
							.addComponent(comboBox_1, 0, 330, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panelGaragem.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSelecioneOCambio, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_panelGaragem.createSequentialGroup()
							.addContainerGap()
							.addComponent(comboBox_2, 0, 330, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panelGaragem.createSequentialGroup()
							.addGap(117)
							.addComponent(lblGaragem)))
					.addContainerGap())
		);
		gl_panelGaragem.setVerticalGroup(
			gl_panelGaragem.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelGaragem.createSequentialGroup()
					.addComponent(lblGaragem, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPiloto, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblSelecioneOChassis, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSelecioneOMotor, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSelecioneOCambio, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelGaragem.setLayout(gl_panelGaragem);
		
		JPanel panelBox = new JPanel();
		panelBox.setBounds(1006, 11, 350, 254);
		panelBox.setOpaque(false);
		getContentPane().add(panelBox);
		
		JLabel lblBox = new JLabel("BOX");
		lblBox.setForeground(new Color(153, 153, 153));
		lblBox.setFont(new Font("Arial Black", Font.PLAIN, 18));
		
		JLabel lblTipoDePneus = new JLabel("Tipo de Pneus:");
		lblTipoDePneus.setForeground(new Color(153, 153, 153));
		lblTipoDePneus.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		JComboBox comboBox_3 = new JComboBox();
		
		JLabel lblTipoDeAsas = new JLabel("Tipo de Asas:");
		lblTipoDeAsas.setForeground(new Color(153, 153, 153));
		lblTipoDeAsas.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		JComboBox comboBox_4 = new JComboBox();
		
		JLabel lblSuspenso = new JLabel("Suspens\u00E3o:");
		lblSuspenso.setForeground(new Color(153, 153, 153));
		lblSuspenso.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		JComboBox comboBox_5 = new JComboBox();
		
		JLabel lblFreios = new JLabel("Freios:");
		lblFreios.setForeground(new Color(153, 153, 153));
		lblFreios.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		JComboBox comboBox_6 = new JComboBox();
		GroupLayout gl_panelBox = new GroupLayout(panelBox);
		gl_panelBox.setHorizontalGroup(
			gl_panelBox.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBox.createSequentialGroup()
					.addGroup(gl_panelBox.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelBox.createSequentialGroup()
							.addGap(151)
							.addComponent(lblBox))
						.addGroup(gl_panelBox.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTipoDePneus))
						.addGroup(gl_panelBox.createSequentialGroup()
							.addContainerGap()
							.addComponent(comboBox_3, 0, 330, Short.MAX_VALUE))
						.addGroup(gl_panelBox.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTipoDeAsas, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelBox.createSequentialGroup()
							.addContainerGap()
							.addComponent(comboBox_4, 0, 330, Short.MAX_VALUE))
						.addGroup(gl_panelBox.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSuspenso, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelBox.createSequentialGroup()
							.addContainerGap()
							.addComponent(comboBox_5, 0, 330, Short.MAX_VALUE))
						.addGroup(gl_panelBox.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblFreios, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelBox.createSequentialGroup()
							.addContainerGap()
							.addComponent(comboBox_6, 0, 330, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panelBox.setVerticalGroup(
			gl_panelBox.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBox.createSequentialGroup()
					.addComponent(lblBox)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTipoDePneus)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTipoDeAsas, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSuspenso, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFreios, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelBox.setLayout(gl_panelBox);
		
		JPanel Caixa = new JPanel();
		Caixa.setBorder(new EmptyBorder(0, 0, 2, 2));
		Caixa.setBackground(new Color(51, 51, 153));
		Caixa.setBounds(10, 11, 350, 50);
		getContentPane().add(Caixa);
		
		JLabel dinCaixa = new JLabel("R$ 00,00");
		dinCaixa.setForeground(new Color(255, 255, 255));
		dinCaixa.setFont(new Font("Arial Black", Font.PLAIN, 20));
		
		JLabel lblCaixa = new JLabel("CAIXA:");
		lblCaixa.setForeground(Color.WHITE);
		lblCaixa.setFont(new Font("Arial Black", Font.PLAIN, 20));
		GroupLayout gl_Caixa = new GroupLayout(Caixa);
		gl_Caixa.setHorizontalGroup(
			gl_Caixa.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_Caixa.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCaixa, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
					.addComponent(dinCaixa)
					.addContainerGap())
		);
		gl_Caixa.setVerticalGroup(
			gl_Caixa.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_Caixa.createSequentialGroup()
					.addContainerGap(23, Short.MAX_VALUE)
					.addGroup(gl_Caixa.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCaixa, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(dinCaixa))
					.addContainerGap())
		);
		Caixa.setLayout(gl_Caixa);
		
		panel = new Panel();
		
		panel.setLayout(null);
		panel.setBounds(0, 0, this.janela.getSize().width, this.janela.getSize().width);
		this.getContentPane().add(panel);
		
		this.setVisible(true); // Deixando o JFrame Visível
		
		
	}


	protected void next() {
		this.dispose();
	}


	protected void retornar() throws Throwable {
		Game game = new Game();
		Thread tGame = new Thread(game);
		tGame.start();
		this.finalize();
		this.dispose();
	}
}
