/**********************************************************************
 * $Source: /cvsroot/jameica/util/src/de/willuhn/util/I18N.java,v $
 * $Revision: 1.3 $
 * $Date: 2004/04/01 22:07:16 $
 * $Author: willuhn $
 * $Locker:  $
 * $State: Exp $
 *
 * Copyright (c) by willuhn.webdesign
 * All rights reserved
 *
 **********************************************************************/

package de.willuhn.util;

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

	private String path;
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

		path = resourcePath;
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
   * Beendet die aktuelle Sitzung und schreibt alle Strings in eine Datei
   * messages_xxx im Temp-Verzeichnis, die waehrend der aktuellen Sitzung
   * nicht uebersetzt werden konnten.
   */
  public void flush()
  {
  	return;
//    try
//    {
////      File file = new File(path + "_" + locale.toString() + ".properties");
//			File file = new File("/tmp/install/" + locale.toString() + ".properties");
//      properties.store(new FileOutputStream(file), "unresolved strings for locale " + locale.toString());
//    }
//    catch (Exception e)
//    {
//    }
  }
}

/*********************************************************************
 * $Log: I18N.java,v $
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
