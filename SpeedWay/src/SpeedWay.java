import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import br.com.gi.utils.Game;
import br.com.gi.utils.Garagem;
import br.com.gi.utils.Menu;
import br.com.gi.utils.TextBox;


public class SpeedWay{
	
	public static void main(String[] args) {
		Game game = new Game();
		game.tGame = new Thread(game);
		game.tGame.start();
	}
}
