/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.util.Base64;

/**
 *
 * @author cesardias
 */
public class base64 {

    public static void main(String[] args) {
        byte[] encodedBytes = Base64.getEncoder().encode("Cristian".getBytes());
        System.out.println("encodedBytes " + new String(encodedBytes));
        byte[] decodedBytes = Base64.getDecoder().decode(encodedBytes);
        System.out.println("decodedBytes " + new String(decodedBytes));
    }

}
