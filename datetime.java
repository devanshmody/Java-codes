import java.util.*;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
public class datetime extends MIDlet implements CommandListener
{
private Display display;
private Form form;
private Date today;
private Command exit;
private DateField datefield;
public datetime()
{
display = Display.getDisplay(this);
form = new Form("Today's Date");
today = new Date(System.currentTimeMillis());
datefield = new DateField("", DateField.DATE_TIME);
datefield.setDate(today);
exit = new Command("Exit", Command.EXIT, 1);
form.append(datefield);
form.addCommand(exit);
form.setCommandListener(this);
}
public void startApp ()
{
display.setCurrent(form);
}
public void pauseApp()
{
}
public void destroyApp(boolean unconditional)
{
}
public void commandAction(Command command, Displayable displayable)
{
if (command == exit)
{
destroyApp(false);
notifyDestroyed();
}
}
}