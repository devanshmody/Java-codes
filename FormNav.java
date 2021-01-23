import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class FormNav extends MIDlet implements CommandListener 
{

    private Form form1 =new Form("Enter Details");
    //private Form form2;// =new Form("Your Details are");
	
    public static TextField t1 =new TextField("Your Name","",10,TextField.ANY);
    public static TextField t2 =new TextField("Roll No.","",10,TextField.DECIMAL);
	
    private Command Ok =new Command("Submit",Command.OK,1);
    //private Form2 f2;

	public String s1;
	public String s2;
	
    public FormNav()
    { 
        form1.append(t1);
        form1.append(t2);
        form1.addCommand(Ok);
        form1.setCommandListener(this);
Display.getDisplay(this).setCurrent(form1);
    }


    public void commandAction(Command c,Displayable d)
    {
        if(c==Ok)
        {
	 Form form2 =new Form("Your Details are");
Display.getDisplay(this).setCurrent(form2);
			s1=t1.getString();
			s2=t2.getString();
			
			form2.append("Your Name is "+s1);
			form2.append("\nYour Roll No. is "+s2);
          
        }
    }

    public void startApp()
   {
     //Display.getDisplay(this).setCurrent(form1);
    }
    
    public void pauseApp() 
   {
    }

    public void destroyApp(boolean unconditional) 
   {
    }
}
