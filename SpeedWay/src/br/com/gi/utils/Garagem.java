package br.com.gi.utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import br.com.gi.dao.AsasDao;
import br.com.gi.dao.CambioDao;
import br.com.gi.dao.ChassisDao;
import br.com.gi.dao.FreioDao;
import br.com.gi.dao.MotorDao;
import br.com.gi.dao.PistaDao;
import br.com.gi.dao.PneuDao;
import br.com.gi.dao.SuspensaoDao;
import br.com.gi.objetos.GrandePremio;

public class Garagem extends JFrame {
	private Dimension janela = Toolkit.getDefaultToolkit().getScreenSize();
	private JPanel panelGeral;
	private JTextField textField;
	private ChassisDao chassis;
	private MotorDao motor;
	private CambioDao cambio;
	private PneuDao pneu;
	private AsasDao asas;
	private SuspensaoDao suspensao;
	private FreioDao freio;
	private PistaDao pistas;
	private GrandePremio gp;
	private double dinheiro;
	private double valor;
	private double valorChassis;
	private double valorMotor;
	private double valorCambio;
	private double valorPneu;
	private double valorAsas;
	private double valorSuspensao;
	private double valorFreios;
	
	//Componentes
	private JLabel lblImgPista;
	private JLabel lblTamanhoVolta;
	private JComboBox cbPista;
	private JLabel lblTamanhoTotalPista;
	private JLabel lblVoltas;
	private JLabel lblGPTemperatura;
	private JLabel lblQtdImg;
	private JLabel dinCaixa;
	private JComboBox cbChassis;
	private JComboBox cbMotor;
	private JComboBox cbCambio;
	private JComboBox cbPneu;
	private JComboBox cbAsas;
	private JComboBox cbSuspensao;
	private JComboBox cbFreio;
	
	public Garagem(){
		// Carregando dados
		pistas = new PistaDao();
		pistas.carregarDados();
		
		chassis = new ChassisDao();
		chassis.carregaDados();
		
		motor = new MotorDao();
		motor.carregarDados();
		
		cambio = new CambioDao();
		cambio.carregaDados();
		
		pneu = new PneuDao();
		pneu.carregarDados();
		
		asas = new AsasDao();
		asas.carregarDados();
		
		suspensao = new SuspensaoDao();
		suspensao.carregaDados();
		
		freio = new FreioDao();
		freio.carregaDados();
		
		gp = new GrandePremio();
		
		
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
		
		JButton btnSeguirParaCorrida = new JButton("Correr");
		btnSeguirParaCorrida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startCorrida();
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
		
		JPanel panelGrandePremio = new PanelGrandePremio();
		panelGrandePremio.setForeground(Color.WHITE);
		panelGrandePremio.setBackground(Color.WHITE);
		panelGrandePremio.setBounds(this.janela.getSize().width/2-(585/2), 11, 585, 395);
		getContentPane().add(panelGrandePremio);
		
		lblImgPista = new JLabel("");
		lblImgPista.setIcon(new ImageIcon());
		lblImgPista.setBounds(585-(lblImgPista.getWidth()+20), 395-(lblImgPista.getHeight()-20), lblImgPista.getWidth(), lblImgPista.getHeight());
		
		JLabel lblGrandePrmio = new JLabel("GRANDE PR\u00CAMIO");
		lblGrandePrmio.setForeground(new Color(51, 51, 153));
		lblGrandePrmio.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		lblTamanhoVolta = new JLabel();
		lblTamanhoVolta.setForeground(new Color(51, 51, 153));
		lblTamanhoVolta.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		lblTamanhoTotalPista = new JLabel();
		lblTamanhoTotalPista.setForeground(new Color(51, 51, 153));
		lblTamanhoTotalPista.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		lblVoltas = new JLabel();
		lblVoltas.setForeground(new Color(51, 51, 153));
		lblVoltas.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		lblGPTemperatura = new JLabel();
		lblGPTemperatura.setForeground(new Color(51, 51, 153));
		lblGPTemperatura.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		lblQtdImg = new JLabel();
		lblQtdImg.setForeground(new Color(51, 51, 153));
		lblQtdImg.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		dinCaixa = new JLabel();
		dinCaixa.setForeground(new Color(255, 255, 255));
		dinCaixa.setFont(new Font("Arial Black", Font.PLAIN, 20));
		
		cbPista = new JComboBox();
		cbPista.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				int item = cbPista.getSelectedIndex();
				lblImgPista.setIcon(new ImageIcon(Garagem.class.getResource(pistas.lPistas.get(item).getImgPista())));
				lblTamanhoVolta.setText("Tamanho da Volta: "+pistas.lPistas.get(item).getTamanhoPista()+" metros");
				lblTamanhoTotalPista.setText("Tamanho Total da Pista: "+pistas.lPistas.get(item).getTamanhoTotalPista()+" metros");
				lblVoltas.setText("Voltas: "+pistas.lPistas.get(item).getVoltas()+" Voltas");
				gp.selecionarTempo();
				lblGPTemperatura.setText("Temperatura: "+gp.getTempo().getTemperatura()+"°");
				lblQtdImg.setText("Quantidade de Água na Pista: "+gp.getTempo().getQtdAguaPista()+" mm");
				dinheiro = 20000.00;
				dinCaixa.setText("R$ "+dinheiro);
			}
		});
		
		
		DefaultComboBoxModel modeloPista = (DefaultComboBoxModel)cbPista.getModel();
		for (int i = 0; i < pistas.lPistas.size(); i++) {
			modeloPista.addElement(pistas.lPistas.get(i).getNome());
		}
		
		GroupLayout gl_panelGrandePremio = new GroupLayout(panelGrandePremio);
		gl_panelGrandePremio.setHorizontalGroup(
			gl_panelGrandePremio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelGrandePremio.createSequentialGroup()
					.addGroup(gl_panelGrandePremio.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panelGrandePremio.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelGrandePremio.createParallelGroup(Alignment.LEADING)
								.addComponent(cbPista, 0, 565, Short.MAX_VALUE)
								.addComponent(lblImgPista, Alignment.TRAILING)))
						.addGroup(Alignment.TRAILING, gl_panelGrandePremio.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panelGrandePremio.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelGrandePremio.createSequentialGroup()
									.addComponent(lblTamanhoTotalPista, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
									.addGap(30))
								.addGroup(gl_panelGrandePremio.createSequentialGroup()
									.addComponent(lblTamanhoVolta, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
									.addGap(61)))
							.addGroup(gl_panelGrandePremio.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblVoltas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblGPTemperatura, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)))
						.addGroup(gl_panelGrandePremio.createSequentialGroup()
							.addGap(226)
							.addComponent(lblGrandePrmio)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panelGrandePremio.createSequentialGroup()
					.addContainerGap(160, Short.MAX_VALUE)
					.addComponent(lblQtdImg, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
					.addGap(132))
		);
		gl_panelGrandePremio.setVerticalGroup(
			gl_panelGrandePremio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelGrandePremio.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGrandePrmio)
					.addGap(11)
					.addComponent(lblImgPista)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbPista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelGrandePremio.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTamanhoVolta, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblVoltas, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelGrandePremio.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTamanhoTotalPista, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblGPTemperatura, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblQtdImg, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(257, Short.MAX_VALUE))
		);
		panelGrandePremio.setLayout(gl_panelGrandePremio);
		
		JPanel panelGaragem = new JPanel();
		panelGaragem.setBounds(10, 72, 350, 254);
		panelGaragem.setOpaque(false);
		getContentPane().add(panelGaragem);
		
		JLabel lblPiloto = new JLabel("Piloto:");
		lblPiloto.setForeground(Color.WHITE);
		lblPiloto.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		JLabel lblGaragem = new JLabel("GARAGEM");
		lblGaragem.setForeground(Color.WHITE);
		lblGaragem.setFont(new Font("Arial Black", Font.PLAIN, 18));
		
		textField = new JTextField();
		textField.setForeground(new Color(255, 255, 255));
		textField.setBackground(new Color(153, 153, 153));
		textField.setFont(new Font("Arial Black", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBorder(null);
		
		JLabel lblSelecioneOChassis = new JLabel("Selecione o Chassis:");
		lblSelecioneOChassis.setForeground(Color.WHITE);
		lblSelecioneOChassis.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		// Carregando dados no Comobox de Chassis
		cbChassis = new JComboBox();
		cbChassis.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				valorChassis = chassis.lChassis.get(cbChassis.getSelectedIndex()).getValor();
				verificaValor();
			}
		});
		DefaultComboBoxModel modeloChassis = (DefaultComboBoxModel)cbChassis.getModel();
		for (int i = 0; i < chassis.lChassis.size(); i++) {
			modeloChassis.addElement(chassis.lChassis.get(i).getModelo()+" - "+chassis.lChassis.get(i).getValor());
		}
		
		JLabel lblSelecioneOMotor = new JLabel("Selecione o Motor:");
		lblSelecioneOMotor.setForeground(Color.WHITE);
		lblSelecioneOMotor.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		cbMotor = new JComboBox();
		cbMotor.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				valorMotor = motor.lmotor.get(cbMotor.getSelectedIndex()).getValor();
				verificaValor();
			}
		});
		DefaultComboBoxModel modeloMotor = (DefaultComboBoxModel)cbMotor.getModel();
		for (int i = 0; i < motor.lmotor.size(); i++) {
			modeloMotor.addElement(motor.lmotor.get(i).getModelo()+" - Consumo: "+motor.lmotor.get(i).getConsumo()+" - R$ "+motor.lmotor.get(i).getValor());
		}
		
		JLabel lblSelecioneOCambio = new JLabel("Selecione o Cambio:");
		lblSelecioneOCambio.setForeground(Color.WHITE);
		lblSelecioneOCambio.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		cbCambio = new JComboBox();
		cbCambio.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				valorCambio = cambio.lCambio.get(cbCambio.getSelectedIndex()).getValor();
				verificaValor();
			}
		});
		DefaultComboBoxModel modeloCambio = (DefaultComboBoxModel)cbCambio.getModel();
		for (int i = 0; i < cambio.lCambio.size(); i++) {
			modeloCambio.addElement(cambio.lCambio.get(i).getModelo()+" - "+cambio.lCambio.get(i).getValor());
		}
		
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
							.addComponent(cbChassis, 0, 330, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panelGaragem.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSelecioneOMotor))
						.addGroup(Alignment.LEADING, gl_panelGaragem.createSequentialGroup()
							.addContainerGap()
							.addComponent(cbMotor, 0, 330, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_panelGaragem.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSelecioneOCambio, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, gl_panelGaragem.createSequentialGroup()
							.addContainerGap()
							.addComponent(cbCambio, 0, 330, Short.MAX_VALUE))
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
					.addComponent(cbChassis, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSelecioneOMotor, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbMotor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSelecioneOCambio, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbCambio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelGaragem.setLayout(gl_panelGaragem);
		
		JPanel panelBox = new JPanel();
		panelBox.setBounds(1006, 11, 350, 358);
		panelBox.setOpaque(false);
		getContentPane().add(panelBox);
		
		JLabel lblBox = new JLabel("BOX");
		lblBox.setForeground(Color.WHITE);
		lblBox.setFont(new Font("Arial Black", Font.PLAIN, 18));
		
		JLabel lblTipoDePneus = new JLabel("Tipo de Pneus:");
		lblTipoDePneus.setForeground(Color.WHITE);
		lblTipoDePneus.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		cbPneu = new JComboBox();
		cbPneu.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				valorPneu = pneu.lPneu.get(cbPneu.getSelectedIndex()).getValor();
				verificaValor();
			}
		});
		DefaultComboBoxModel modeloPneu = (DefaultComboBoxModel)cbPneu.getModel();
		for (int i = 0; i < pneu.lPneu.size(); i++) {
			modeloPneu.addElement(pneu.lPneu.get(i).getModelo()+" - "+pneu.lPneu.get(i).getValor());
		}
		
		JLabel lblTipoDeAsas = new JLabel("Tipo de Asas:");
		lblTipoDeAsas.setForeground(Color.WHITE);
		lblTipoDeAsas.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		cbAsas = new JComboBox();
		cbAsas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				valorAsas = asas.lAsa.get(cbAsas.getSelectedIndex()).getValor();
				verificaValor();
			}
		});
		DefaultComboBoxModel modeloAsas = (DefaultComboBoxModel)cbAsas.getModel();
		for (int i = 0; i < asas.lAsa.size(); i++) {
			modeloAsas.addElement(asas.lAsa.get(i).getModelo()+" - "+asas.lAsa.get(i).getValor());
		}
		
		JLabel lblSuspenso = new JLabel("Suspens\u00E3o:");
		lblSuspenso.setForeground(Color.WHITE);
		lblSuspenso.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		cbSuspensao = new JComboBox();
		cbSuspensao.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				valorSuspensao = suspensao.lSuspensao.get(cbSuspensao.getSelectedIndex()).getValor();
				verificaValor();
			}
		});
		DefaultComboBoxModel modeloSuspensao = (DefaultComboBoxModel)cbSuspensao.getModel();
		for (int i = 0; i < suspensao.lSuspensao.size(); i++) {
			modeloSuspensao.addElement(suspensao.lSuspensao.get(i).getModelo()+" - "+suspensao.lSuspensao.get(i).getValor());
		}
		
		JLabel lblFreios = new JLabel("Freios:");
		lblFreios.setForeground(Color.WHITE);
		lblFreios.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		cbFreio = new JComboBox();
		cbFreio.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				valorFreios = freio.lFreio.get(cbFreio.getSelectedIndex()).getValor();
				verificaValor();
			}
		});
		DefaultComboBoxModel modeloFreio = (DefaultComboBoxModel)cbFreio.getModel();
		for (int i = 0; i < freio.lFreio.size(); i++) {
			modeloFreio.addElement(freio.lFreio.get(i).getModelo()+" - "+freio.lFreio.get(i).getValor());
		}
		
		JLabel lblTrocasDePenu = new JLabel("Trocas de Penu:");
		lblTrocasDePenu.setForeground(Color.WHITE);
		lblTrocasDePenu.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		JComboBox cbTrocaPneus = new JComboBox();
		DefaultComboBoxModel modeloTrocaPneus = (DefaultComboBoxModel)cbTrocaPneus.getModel();
		modeloTrocaPneus.addElement(1+" Parada");
		modeloTrocaPneus.addElement(2+" Paradas");
		modeloTrocaPneus.addElement(3+" Paradas");
		modeloTrocaPneus.addElement(4+" Paradas");
		
		JComboBox cbQtdComb = new JComboBox();
		DefaultComboBoxModel modeloQtdComb = (DefaultComboBoxModel)cbQtdComb.getModel();
		modeloQtdComb.addElement(80.00+" Litros");
		modeloQtdComb.addElement(100.00+" Litros");
		modeloQtdComb.addElement(120.00+" Litros");
		modeloQtdComb.addElement(140.00+" Litros");
		
		JLabel lblQuantidadeCombustvel = new JLabel("Quantidade Combust\u00EDvel:");
		lblQuantidadeCombustvel.setForeground(Color.WHITE);
		lblQuantidadeCombustvel.setFont(new Font("Arial Black", Font.PLAIN, 12));
		
		GroupLayout gl_panelBox = new GroupLayout(panelBox);
		gl_panelBox.setHorizontalGroup(
			gl_panelBox.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBox.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelBox.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTrocasDePenu, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panelBox.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblQuantidadeCombustvel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(Alignment.LEADING, gl_panelBox.createSequentialGroup()
								.addGap(141)
								.addComponent(lblBox)))
						.addComponent(cbQtdComb, 0, 330, Short.MAX_VALUE)
						.addComponent(cbTrocaPneus, 0, 330, Short.MAX_VALUE)
						.addComponent(lblTipoDePneus)
						.addComponent(cbPneu, 0, 330, Short.MAX_VALUE)
						.addComponent(lblTipoDeAsas, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbAsas, 0, 330, Short.MAX_VALUE)
						.addComponent(lblSuspenso, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbSuspensao, 0, 330, Short.MAX_VALUE)
						.addComponent(lblFreios, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbFreio, 0, 330, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panelBox.setVerticalGroup(
			gl_panelBox.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBox.createSequentialGroup()
					.addComponent(lblBox)
					.addGap(11)
					.addComponent(lblTrocasDePenu, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbTrocaPneus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblQuantidadeCombustvel, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbQtdComb, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTipoDePneus)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbPneu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTipoDeAsas, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbAsas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSuspenso, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbSuspensao, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblFreios, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cbFreio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		panelBox.setLayout(gl_panelBox);
		
		JPanel Caixa = new JPanel();
		Caixa.setBorder(new EmptyBorder(0, 0, 2, 2));
		Caixa.setBackground(new Color(51, 51, 153));
		Caixa.setBounds(10, 11, 350, 50);
		getContentPane().add(Caixa);
		
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
		
		panelGeral = new Panel();
		
		panelGeral.setLayout(null);
		panelGeral.setBounds(0, 0, this.janela.getSize().width, this.janela.getSize().width);
		this.getContentPane().add(panelGeral);
		
		this.setVisible(true); // Deixando o JFrame Visível
		
		
	}
	
	protected void verificaValor(){
		valor = valorAsas+valorCambio+valorChassis+valorFreios+valorMotor+valorPneu+valorSuspensao;
		if(valor > dinheiro){
			JOptionPane.showMessageDialog(null, "Você precisa corrigir seus valores, você não pode gastar mais do que possui.");
		}else{
			dinCaixa.setText("R$ "+(dinheiro-valor));
		}
	}
	
	protected void startCorrida() {
		if(valor > dinheiro){
			JOptionPane.showMessageDialog(null, "Você precisa corrigir seus valores, você não pode gastar mais do que possui.");
		}else{
			StartCorrida startCorrida = new StartCorrida();
			startCorrida.tStartCorrida = new Thread(startCorrida);
			startCorrida.tStartCorrida.start();
			this.dispose();
		}
	}


	protected void retornar() throws Throwable {
		Game game = new Game();
		game.tGame = new Thread(game);
		game.tGame.start();
		this.dispose();
	}
}
