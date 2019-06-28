/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utpl.wspft.ws;

import edu.utpl.wspft.enumeration.ConstanteEnumeration;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 *
 * @author Miguel Tenezaca
 */
public class Encripta {

    private static final Logger LOG = Logger.getLogger(ServiciosPft.class.getName());

    Cipher encryptC;

    public String encrypt(String password) {
        try {
            byte[] utf8 = password.getBytes("UTF8");
            byte[] enc = encryptC.doFinal(utf8);
            return new sun.misc.BASE64Encoder().encode(enc);

        } catch (UnsupportedEncodingException | BadPaddingException | IllegalBlockSizeException e) {
            LOG.log(Level.OFF, null, e);

        }
        return null;

    }

    public String encripta(String datos) {
        try {
            encryptC = (Cipher.getInstance("DES"));
            KeySpec ks = new DESKeySpec(ConstanteEnumeration.SECRETKEY.getTipo().getBytes(ConstanteEnumeration.UTF8.getTipo()));
            SecretKeyFactory kf = SecretKeyFactory.getInstance("DES");
            SecretKey ky = kf.generateSecret(ks);
            encryptC.init(Cipher.ENCRYPT_MODE, ky);

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | UnsupportedEncodingException | InvalidKeyException | InvalidKeySpecException e) {
            LOG.log(Level.OFF, null, e);
        }
        return encrypt(datos);
    }

    public Cipher getEncryptC() {
        return encryptC;
    }

    public void setEncryptC(Cipher encryptC) {
        this.encryptC = encryptC;
    }

}
