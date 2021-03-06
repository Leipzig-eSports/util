/**********************************************************************
 * $Source: /cvsroot/jameica/util/src/de/willuhn/logging/targets/OutputStreamTarget.java,v $
 * $Revision: 1.2 $
 * $Date: 2007/03/26 23:52:08 $
 * $Author: willuhn $
 * $Locker:  $
 * $State: Exp $
 *
 * Copyright (c) by willuhn.webdesign
 * All rights reserved
 *
 **********************************************************************/
package de.willuhn.logging.targets;

import java.io.OutputStream;

import de.willuhn.logging.Message;

/**
 * Target, welches in einen OutputStream schreibt.
 */
public class OutputStreamTarget implements Target
{

	private OutputStream os = null;
  private final static String lineSep = System.getProperty("line.separator");

  /**
   * ct.
   * @param os OutputStream, in den geschrieben werden soll.
   */
  public OutputStreamTarget(OutputStream os)
  {
  	this.os = os;
  }

  /**
   * @see de.willuhn.logging.targets.Target#write(de.willuhn.logging.Message)
   */
  public void write(Message message) throws Exception
  {
  	if (message == null)
  		return;
  	
		os.write((message.toString() + lineSep).getBytes());
  }

  /**
   * @see de.willuhn.logging.targets.Target#close()
   */
  public void close() throws Exception
  {
  	os.close();
  }

}


/**********************************************************************
 * $Log: OutputStreamTarget.java,v $
 * Revision 1.2  2007/03/26 23:52:08  willuhn
 * @N plattform specific line separator in logfiles
 *
 * Revision 1.1  2004/12/31 19:34:22  willuhn
 * @C some logging refactoring
 * @N syslog support for logging
 *
 **********************************************************************/