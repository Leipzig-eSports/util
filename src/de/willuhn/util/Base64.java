/**********************************************************************
 * $Source: /cvsroot/jameica/util/src/de/willuhn/util/Base64.java,v $
 * $Revision: 1.1 $
 * $Date: 2005/02/01 17:15:07 $
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

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Kleine Hilfe-Klasse zum Encoden und Decoden von Base64.
 * Die Klasse ist derzeit nichts weiter als ein Wrapper
 * um sun.misc.Base64*coder. Damit hab ich den proprietaeren
 * Code von Sun aber hier gebuendelt und kann die Implementierung
 * bei Gelegenheit noch gegen was freies tauschen.
 */
public class Base64
{

  private Base64()
  {
  }

	/**
	 * Dekodiert Base64 in Text.
   * @param base64 Base64.
   * @return Text.
   */
  public final static byte[] decode(String base64) throws IOException
	{
		BASE64Decoder decoder = new BASE64Decoder();
		return decoder.decodeBuffer(base64);
	}

	/**
	 * Kodiert Text nach Base64.
   * @param text
   * @return
   */
  public final static String encode(byte[] text)
	{
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(text);
	}
}


/**********************************************************************
 * $Log: Base64.java,v $
 * Revision 1.1  2005/02/01 17:15:07  willuhn
 * *** empty log message ***
 *
 **********************************************************************/