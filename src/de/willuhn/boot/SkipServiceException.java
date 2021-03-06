/**********************************************************************
 * $Source: /cvsroot/jameica/util/src/de/willuhn/boot/SkipServiceException.java,v $
 * $Revision: 1.4 $
 * $Date: 2010/11/11 16:24:08 $
 * $Author: willuhn $
 * $Locker:  $
 * $State: Exp $
 *
 * Copyright (c) by willuhn.webdesign
 * All rights reserved
 *
 **********************************************************************/
package de.willuhn.boot;

/**
 * Eine Exception, die von einem Service bei der Initialisierung
 * geworfen werden kann, wenn diese zwar fehlschlug, sie jedoch
 * nicht dazu fuehren soll, dass der gesamte Boot-Prozess abgebrochen wird.
 */
public class SkipServiceException extends Exception {

	private Bootable bootable = null;

  /**
   * ct.
   * @param bootable Dienst, der die Exception ausgeloest hat.
   * @param message Text.
   */
  public SkipServiceException(Bootable bootable,String message) {
		super(message);
		this.bootable = bootable;
  }

	/**
	 * ct.
	 * @param bootable Dienst, der die Exception ausgeloest hat.
	 * @param message Text.
	 * @param cause
	 */
	public SkipServiceException(Bootable bootable,String message, Throwable cause) {
		super(message,cause);
		this.bootable = bootable;
	}

	/**
	 * Liefert den Dienst, der den Fehler augeloest hat.
   * @return Dienst.
   */
  public Bootable getBootable()
	{
		return bootable;
	}

}


/**********************************************************************
 * $Log: SkipServiceException.java,v $
 * Revision 1.4  2010/11/11 16:24:08  willuhn
 * @N Bootloader ist jetzt getypt
 *
 * Revision 1.3  2005/03/09 01:06:21  web0
 * @D javadoc fixes
 **********************************************************************/