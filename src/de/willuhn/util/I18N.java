/**********************************************************************
 * $Source: /cvsroot/jameica/util/src/de/willuhn/util/I18N.java,v $
 * $Revision: 1.4 $
 * $Date: 2004/06/10 20:57:34 $
 * $Author: willuhn $
 * $Locker:  $
 * $State: Exp $
 *
 * Copyright (c) by willuhn.webdesign
 * All rights reserved
 *
 **********************************************************************/

package de.willuhn.util;

import java.io.IOException;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Diese Klasse behandelt die Internationalisierung.
 * Sie uebersetzt nicht nur alle Strings sondern speichert auch alle
 * nicht uebersetzbaren Strings waehrend der aktuellen Sitzung und
 * speichert diese beim Beenden der Anwendung im Temp-Verzeichnis ab.
 * @author willuhn
 */
public class I18N
{

  private ResourceBundle bundle;
  private Properties properties;

	private Locale locale;

  /**
   * Initialisiert diese Klasse mit dem angegebenen Locale.
   * @param resourcePath
   * @param l das zu verwendende Locale.
   */
  public I18N(String resourcePath, Locale l)
  {
		if (resourcePath == null || l == null)
			return;

		locale = l;
		properties = new Properties();

    try {
      bundle = ResourceBundle.getBundle(resourcePath,l);
    }
    catch (MissingResourceException mre)
    {
    }
  }
  
  /**
   * Uebersetzt den angegebenen String und liefert die uebersetzte
   * Version zurueck. Kann der String nicht uebersetzt werden, wird
   * der Original-String zurueckgegeben.
   * @param key zu uebersetzender String.
   * @return uebersetzter String.
   */
  public String tr(String key)
  {
    String translated = null;
    try {
      if (bundle != null)
        translated = bundle.getString(key);
    }
    catch(MissingResourceException e) {}

    if (translated != null)
      return translated;
    
    properties.put(key,key);
    return key;
  }

  /**
   * Uebersetzt den angegebenen String und liefert die uebersetzte
   * Version zurueck. Kann der String nicht uebersetzt werden, wird
   * der Original-String zurueckgegeben.
   * <br><b>Hinweis:</b>. Die Textmarken fuer die Ersetzungen sind mit <code>{n}</code> zu definieren
   * wobei n von 0 beginnend hochgezaehlt wird und genauso oft vorkommen darf wie das String-Array
   * Elemente besitzt.<br>
   * Bsp: i18n.tr("Das ist eine {0} nuetzliche {1}", new String[] {"besonders","Funktion"});
   * @param key zu uebersetzender String.
   * @param replacements String-Array mit den einzusetzenden Werten.
   * @return uebersetzter String.
   */
  public String tr(String key, String[] replacements)
  {
    return MessageFormat.format(tr(key),replacements);
  }
  
  /**
   * Uebersetzt den angegeben String und liefert die uebersetzte Version zurueck.
   * Diese Funktion existiert der Einfachheit halber fuer Strings, welche lediglich
   * ein Replacement besitzen. Die sonst notwendige Erzeugung eines String-Arrays
   * mit nur einem Element entfaellt damit.<br>
   * Bsp: i18n.tr("Das ist eine nuetzliche {0}", "Funktion");
   * @param key zu uebersetzender String.
   * @param replacement String mit dem einzusetzenden Wert.
   * @return uebersetzter String.
   */
  public String tr(String key, String replacement)
  {
    return MessageFormat.format(tr(key),new String[] {replacement});
  }

  /**
   * Schreibt alle bis dato nicht uebersetzbaren Strings in den angegebenen OutputStream.
   * @param os Stream, in den geschrieben werden soll.
   * @throws IOException
   */
  public void storeUntranslated(OutputStream os) throws IOException
  {
    properties.store(os, "unresolved strings for locale " + locale.toString());
  }
}

/*********************************************************************
 * $Log: I18N.java,v $
 * Revision 1.4  2004/06/10 20:57:34  willuhn
 * @D javadoc comments fixed
 *
 * Revision 1.3  2004/04/01 22:07:16  willuhn
 * *** empty log message ***
 *
 * Revision 1.2  2004/03/03 22:27:33  willuhn
 * @N added Lock
 *
 * Revision 1.1  2004/01/08 21:38:39  willuhn
 * *** empty log message ***
 *
 * Revision 1.6  2004/01/06 20:11:21  willuhn
 * *** empty log message ***
 *
 * Revision 1.5  2003/12/10 00:47:12  willuhn
 * @N SearchDialog done
 * @N ErrorView
 *
 * Revision 1.4  2003/11/30 16:23:09  willuhn
 * *** empty log message ***
 *
 * Revision 1.3  2003/11/21 02:10:21  willuhn
 * @N prepared Statements in AbstractDBObject
 * @N a lot of new SWT parts
 *
 * Revision 1.2  2003/11/13 00:37:35  willuhn
 * *** empty log message ***
 *
 * Revision 1.1  2003/10/23 21:49:46  willuhn
 * initial checkin
 *
 **********************************************************************/
