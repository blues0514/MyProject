package Practice.Applet;

import java.awt.*;
import java.applet.*;

public class Prac_Parameter extends Applet
{
  String args;

  public void init()
  {
    args= getParameter("APPLET_PARAMETER");
    if(args==null){
      args="NO APPLET_PARAMETER";
    }
  }

  public void paint(Graphics g)
  {
    g.drawString(args, 50, 100);
  }
}