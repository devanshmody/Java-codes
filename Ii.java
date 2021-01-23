import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
public class Ii extends MIDlet implements CommandListener
{
private Display display;
private Form form;
private Command exit;
private Command vote;
private Gauge gauge;
public Ii ()
{
display = Display.getDisplay(this);
gauge = new Gauge("Rate the movie: ", true, 5, 1);
exit = new Command("Exit", Command.EXIT, 1);
vote = new Command ("Vote", Command.SCREEN, 1);
form = new Form("");
form.addCommand(exit);
form.addCommand(vote);
form.append(gauge);
form.setCommandListener(this);
}
public void startApp()
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
else if (command == vote)
{
String msg = String.valueOf(gauge.getValue());
Alert alert = new Alert("Ranking", msg, null, null);
alert.setTimeout(Alert.FOREVER);
alert.setType(AlertType.INFO);
display.setCurrent(alert);
}
}
}