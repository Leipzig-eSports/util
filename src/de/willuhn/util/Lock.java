/**********************************************************************
 * $Source: /cvsroot/jameica/util/src/de/willuhn/util/Attic/Lock.java,v $
 * $Revision: 1.5 $
 * $Date: 2004/04/25 17:35:34 $
 * $Author: willuhn $
 * $Locker:  $
 * $State: Exp $
 *
 * Copyright (c) by willuhn.webdesign
 * All rights reserved
 *
 **********************************************************************/
package de.willuhn.util;

import java.io.File;

/**
 * Kleine Hilfs-Klasse mit der eine Lock-Datei erzeugt werden kann.
 * Somit wird sichergestellt, dass eine Anwendung nicht mehrfach gestartet wird.<br>
 * Das Lockfile wird automatisch entfernt, wenn die JVM ordnungsgemaess beendet wird.<br>
 * Das Lock-File wird im aktuellen Verzeichnis erzeugt.
 */
public class Lock {

	private File file = null;

  /**
   * Erzeugt ein neues Lock-File.
   * @param name Alias-Name fuer das Lockfile.
   * Er muss fuer die zu lockende Anwendung eindeutig sein,
   * damit erkannt wird, ob genau diese Anwendung schon laeuft. 
   * @throws RuntimeException wird geworfen, wenn die Anwendung
   * schon laeuft. Im Text der Exception findet sich Pfad und
   * Dateiname das Lockfiles. Grund: Sollte eine vorherige Instanz
   * der Anwendung abgestuerzt sein und der erneute Start nur deswegen
   * fehlschlagen, weil das Lock-File noch existiert, dann kann
   * der Benutzer einfach das Lockfile loeschen
   */
  public Lock(String name) throws RuntimeException
  {
		file = new File(name + ".lock");
  	init();
  }

	/**
   * Loescht das ggf vorhandene Lock-File.
   */
  public synchronized void delete()
	{
		try {
			file.delete();
		}
		catch (Throwable t) {/* useless*/}
	}

	/**
	 * Initialisiert das Lock-File.
   * @throws RuntimeException wenn es schon existiert.
   */
  private synchronized void init() throws RuntimeException
	{
		try {
			if (!file.createNewFile()) throw new Exception();
			file.deleteOnExit();
		}
		catch (Exception e)
		{
			throw new RuntimeException("Die Anwendung l�uft bereits.\n" +
		}
	}
}


/**********************************************************************
 * $Log: Lock.java,v $
 * Revision 1.5  2004/04/25 17:35:34  willuhn
 * @D javadoc
 *
 * Revision 1.4  2004/04/21 22:29:07  willuhn
 * *** empty log message ***
 *
 * Revision 1.3  2004/03/29 23:08:49  willuhn
 * *** empty log message ***
 *
 * Revision 1.2  2004/03/29 19:56:56  willuhn
 * @D javadoc
 *
 * Revision 1.1  2004/03/03 22:27:33  willuhn
 * @N added Lock
 *
 **********************************************************************/