import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
public class Im extends MIDlet
implements CommandListener
{
private Display display;
private Form form;
private Command exit;
private Image image;
private ImageItem imageItem;
public Im()
{
display = Display.getDisplay(this);
exit = new Command("Exit", Command.EXIT, 1);
form = new Form("Immutable Image Example");
form.addCommand(exit);
form.setCommandListener(this);
try
{
image = Image.createImage("/myimage.png");
imageItem = new ImageItem(null, image,
ImageItem.LAYOUT_NEWLINE_BEFORE |
ImageItem.LAYOUT_LEFT |
ImageItem.LAYOUT_NEWLINE_AFTER, "My Image");
form.append(imageItem);
}
catch (java.io.IOException error)
{
Alert alert = new Alert("Error", "Cannot load myimage.png.",
null, null);
alert.setTimeout(Alert.FOREVER);
alert.setType(AlertType.ERROR);
display.setCurrent(alert);


}
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
public void commandAction(Command command, Displayable Displayable)
{
if (command == exit)
{
destroyApp(false);
notifyDestroyed();
}
}
}