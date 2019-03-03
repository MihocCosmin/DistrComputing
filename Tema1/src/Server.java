import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class Server {

	public static void main(String args[]) throws IOException{
		
        ServerSocket ss = new ServerSocket(2019); 
        Socket s = ss.accept();
        
        DataInputStream dis = new DataInputStream(s.getInputStream()); 
        DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
        
        while (true) {
        	String input = dis.readUTF();
        	
            if(input.equals("end")) 
                break; 
            
            System.out.println("Ecuatie primita:-> " + input); 
            int result; 
            
            StringTokenizer st = new StringTokenizer(input); 
            
            int oprnd1 = Integer.parseInt(st.nextToken()); 
            String operation = st.nextToken(); 
            int oprnd2 = Integer.parseInt(st.nextToken()); 
            
            if (operation.equals("+")) 
            { 
                result = oprnd1 + oprnd2; 
            } 
  
            else if (operation.equals("-")) 
            { 
                result = oprnd1 - oprnd2; 
            } 
            else if (operation.equals("*")) 
            { 
                result = oprnd1 * oprnd2; 
            } 
            else
            { 
                result = oprnd1 / oprnd2; 
            } 
            System.out.println("Se trimite raspunsul..."); 
            
            dos.writeUTF(Integer.toString(result));
        }
	}
}
