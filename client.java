import java.io.*;
import java.awt.*;
import java.net.*;
import java.rmi.*;
class client
{
	public static void main(String args[])throws Exception
	{
		Socket s=new Socket("localhost",10);
		DataInputStream dis=new DataInputStream(System.in);
		DataInputStream in=new DataInputStream(s.getInputStream());
		String response=in.readLine();
		System.out.println(response);
		PrintStream p=new PrintStream(s.getOutputStream());
		System.out.println("Enter the First number");
		String z=dis.readLine();
		p.println(z);
		System.out.println("Enter the Second number");
	        z=dis.readLine();
		p.println(z);
		System.out.println("Enter the Operation");
		z=dis.readLine();
		p.println(z);
		response=in.readLine();
		System.out.println(response);
	}
}
