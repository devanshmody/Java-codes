import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class Gin extends MIDlet
{
private Gauge gauge;
private Display display;
Form form;


public void startApp()
{
display=Display.getDisplay(this);
form=new Form("gauge");
gauge=new Gauge("rate this movie:",true,5,1);
form.append(gauge);

display.setCurrent(form);
}
public void pauseApp()
{}
public void destroyApp(boolean x)
{}
}