/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.security.Key
 *  java.security.KeyFactory
 *  java.security.KeyPair
 *  java.security.KeyPairGenerator
 *  java.security.NoSuchAlgorithmException
 *  java.security.PrivateKey
 *  java.security.PublicKey
 *  java.security.spec.AlgorithmParameterSpec
 *  java.security.spec.KeySpec
 *  java.security.spec.PKCS8EncodedKeySpec
 *  java.security.spec.X509EncodedKeySpec
 *  javax.crypto.Cipher
 *  javax.crypto.KeyAgreement
 *  javax.crypto.SecretKey
 *  javax.crypto.interfaces.DHPublicKey
 *  javax.crypto.spec.DHParameterSpec
 *  midrop.service.c.d
 */
package com.xiaomi.midrop.util;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import midrop.service.c.d;

public final class r {
    public static KeyPair a() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance((String)"DH");
            keyPairGenerator.initialize(256);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            return keyPair;
        }
        catch (IllegalArgumentException | NoSuchAlgorithmException throwable) {
            d.a((String)"JDH", (String)"initPartyAKey", (Throwable)throwable, (Object[])new Object[0]);
            return null;
        }
    }

    public static KeyPair a(byte[] arrby) throws Exception {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(arrby);
        KeyFactory keyFactory = KeyFactory.getInstance((String)"DH");
        DHParameterSpec dHParameterSpec = ((DHPublicKey)keyFactory.generatePublic((KeySpec)x509EncodedKeySpec)).getParams();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance((String)keyFactory.getAlgorithm());
        keyPairGenerator.initialize((AlgorithmParameterSpec)dHParameterSpec);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return keyPair;
    }

    private static Cipher a(byte[] arrby, byte[] arrby2, String string2, int n2) throws Exception {
        SecretKey secretKey = r.a(arrby, arrby2, string2);
        Cipher cipher = Cipher.getInstance((String)secretKey.getAlgorithm());
        cipher.init(n2, (Key)secretKey);
        return cipher;
    }

    private static SecretKey a(byte[] arrby, byte[] arrby2, String string2) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance((String)"DH");
        PublicKey publicKey = keyFactory.generatePublic((KeySpec)new X509EncodedKeySpec(arrby2));
        PrivateKey privateKey = keyFactory.generatePrivate((KeySpec)new PKCS8EncodedKeySpec(arrby));
        KeyAgreement keyAgreement = KeyAgreement.getInstance((String)keyFactory.getAlgorithm());
        keyAgreement.init((Key)privateKey);
        keyAgreement.doPhase((Key)publicKey, true);
        SecretKey secretKey = keyAgreement.generateSecret(string2);
        return secretKey;
    }

    public static byte[] a(byte[] arrby, byte[] arrby2, byte[] arrby3, String string2) throws Exception {
        Cipher cipher = r.a(arrby2, arrby3, string2, 1);
        byte[] arrby4 = cipher.doFinal(arrby);
        return arrby4;
    }

    public static byte[] b(byte[] arrby, byte[] arrby2, byte[] arrby3, String string2) throws Exception {
        Cipher cipher = r.a(arrby2, arrby3, string2, 2);
        byte[] arrby4 = cipher.doFinal(arrby);
        return arrby4;
    }

    public static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a();
        public static final /* enum */ a b = new a();
        private static final /* synthetic */ a[] c;

        static {
            a[] arra = new a[]{a, b};
            c = arra;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])c.clone();
        }
    }

}

