
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;

public class FormDesign extends MIDlet implements CommandListener 

{

    public Form form =new Form("Sign In Here");
    public TextField t1 =new TextField("Username","",10,TextField.ANY);
    public TextField t2 =new TextField("Password","",10,TextField.PASSWORD);
	    //public TextField t3 =new TextField("lang","",10,TextField.CHAR);
	
	

    public Command SignIn=new Command("SignIn",Command.OK,1);
   public ChoiceGroup c1;
   public ChoiceGroup rbtn;
    private int defaultindex, rbtnindex;

    public FormDesign()
    {
	c1 =new ChoiceGroup("Languages Known",Choice.MULTIPLE);
          	c1.append("English", null);
        	c1.append("Hindi", null);
		c1.append("Gujarati", null);
        	c1.append("Other", null);

	rbtn = new ChoiceGroup("Select Your Gender",Choice.EXCLUSIVE);
	rbtn.append("Male",null);
	rbtn.append("Female",null);
	 rbtn.append("All", null);

	rbtn.setSelectedIndex(defaultindex, true);
	


        form.append(t1);
        form.append(t2);
        form.addCommand(SignIn);
        form.setCommandListener(this);
        form.append(c1);
	//form.append(t3);
        rbtnindex = form.append(rbtn);
    }
    
  public void commandAction(Command c, Displayable d) {
      if(c==SignIn)
      {
          Alert a1 = new Alert("LOGGED IN","You have successfully" + " logged in",null,AlertType.INFO);
          a1.setTimeout(30000);
          Display.getDisplay(this).setCurrent(a1,form);
      }
  }

    public void startApp() {
        Display.getDisplay(this).setCurrent(form);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}       