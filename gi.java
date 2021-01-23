import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class gi extends MIDlet
{
	
	private Display display;
	private Form form;
	private Guage guage;
	public gi()
	{
		display = Diplay.getDisplay(this);
		gauge = new Guage("Rate the movie:",true,5,1);
		form.append(gauage);

		public void startApp()
		{
		display.setCurrent(form);
		}
		public void puaseApp()		
		{
		}
		public void destroyApp(boolean unconditional)
		{}
}