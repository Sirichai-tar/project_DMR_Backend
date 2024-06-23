package com.tar.DMR.connect.MySQL.utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Base64;

public class ImageUtils {
    public static String byteToString(byte[] bytesimg){
        if (bytesimg  != null) {
            String mineType ="";
            if (bytesimg.length > 2 ){
                byte[] signature = Arrays.copyOfRange(bytesimg,0,2);
                if (Arrays.equals(signature,new byte[]{(byte) 0x89, (byte) 0x50})){
                    mineType = "image/png";
                } else if (Arrays.equals(signature,new byte[]{(byte) 0xFF, (byte) 0xD8})) {
                    mineType = "image/jpeg";
                } else if (Arrays.equals(signature,new byte[]{(byte) 0x47, (byte) 0x49})) {
                    mineType = "image/jpg";
                }
            }
            String imagestring = Base64.getEncoder().encodeToString(bytesimg);
//            String bast64 = "data:image/jpeg;base64," + imagestring;
            String bast64 = "data:" + mineType + ";base64," + imagestring ;
            return bast64;
        }
        return null;
    }
    public static byte[] stringToByte(String imgbast64){
        if (imgbast64 != null){
            String[] parts = imgbast64.split(",");
            if (parts.length == 2 ){
                String imageData = parts[1];
                byte[] decode = Base64.getDecoder().decode(imageData);
                return decode;
            }
        }

//        if(imgbast64 != null){
//          String replaceimg = imgbast64.replace("data:image/jpeg;base64," , "");
//           byte[] decode = Base64.getDecoder().decode(replaceimg);
//           return decode;
//        }
        return null;
    }
}
