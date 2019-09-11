package sockets;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoCliente mimarco=new MarcoCliente();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}


class MarcoCliente extends JFrame{
	
	public MarcoCliente(){
		
		setBounds(600,300,280,350);//tamaño
				
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		
		add(milamina);// se grega la lamina
		
		setVisible(true);// se hace visible
		}	
	
}

class LaminaMarcoCliente extends JPanel{
	
	public LaminaMarcoCliente(){
	
                nick = new JTextField(5);
                    add(nick);
                
                JLabel texto=new JLabel("-CHAT");//nombre de un area de texto
                    add(texto);//agrega el texto
               
                ip = new JTextField(8);
                    add(ip);
                
                campochat = new JTextArea(12,20);
                    add(campochat);
	
		campo1=new JTextField(20);//lo que se envia
	
                    add(campo1);		
	
		miboton=new JButton("Enviar");
                
                EnviaTexto mievento = new EnviaTexto();
                
                miboton.addActionListener(mievento);
                
		add(miboton);	
		
	}
	
	private class EnviaTexto implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {//accion de un evento
            
            
           // System.out.println( campo1.getText());
          
            try {
                Socket misocket;
                misocket = new Socket("192.168.56.1",9999);
                
                PaqueteEnvio datos = new PaqueteEnvio();
                
                datos.setNick(nick.getText());//obtiene el texto del jtextfild
                datos.setIp(ip.getText());
                datos.setMensaje(campo1.getText());
                
                ObjectOutputStream paquete_datos = new ObjectOutputStream(misocket.getOutputStream());
                
                paquete_datos.writeObject(datos);
                
                misocket.close();
                
                
                //DataOutput flujo_salida= new DataOutputStream(misocket.getOutputStream());
                //flujo_salida.writeUTF(campo1.getText());
                
                /*  flujo_salida.close();*/
                
            } catch (IOException ex) {
                System.out.println( ex.getMessage());
                
            }
           
        }
            
            
        }
		
	private JTextField campo1;
	private JTextField nick, ip;
        private JTextArea campochat;
	private JButton miboton;
        
	
}

class PaqueteEnvio implements Serializable{
    
    private String nick, ip, mensaje;

    public String getNick() {//obtener dato
        return nick;
    }

    public void setNick(String nick) {//modificar dato
        this.nick = nick;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
}