package com.arizon.StatisticalRestService.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by arizon on 12/9/17.
 */
public class HMACHelper {

    private static Logger log = LoggerFactory.getLogger(HMACHelper.class);
    public static boolean verifyHmac(String payload, String hmacKey, String hmacHash) {
        String digest = hmacDigest(payload, hmacKey, "SHA-256" );
        return digest.equals(hmacHash) ? true : false;
    }

    public static String hmacDigest(String msg, String hmacKey, String algorithm) {
        String digest = null;
        SecretKeySpec key = null;

        try {
            key = new SecretKeySpec(hmacKey.getBytes("UTF-8"), algorithm);
            Mac mac = Mac.getInstance(algorithm);
            mac.init(key);

            byte[] bytes = mac.doFinal(msg.getBytes("UTF-8"));

            StringBuffer hash = new StringBuffer();
            for (int i=0; i < bytes.length; i++) {
                String hex = Integer.toHexString(0xFF & bytes[i]);
                if (hex.length() == 1) {
                    hash.append('0');
                }
                hash.append(hex);
            }

            digest = hash.toString();
        } catch (UnsupportedEncodingException e) {
            log.error("Unsupported encoding: " +e.getStackTrace());
        } catch (NoSuchAlgorithmException e) {
            log.error("No such algorithm: " + algorithm + "\n" + e.getStackTrace());
        } catch (InvalidKeyException e) {
            log.error("Invalid key: " + key + "+\n" + e.getStackTrace());
        }

        return digest;
    }
}
