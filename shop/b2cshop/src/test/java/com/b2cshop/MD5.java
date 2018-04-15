package com.b2cshop;

import cn.hutool.crypto.digest.DigestUtil;

public class MD5 {

    public static void main(String[] args) {
        System.out.println("----------------");
        System.out.println(DigestUtil.md5Hex("admin"+"U5opg0ds01slik"));
        System.out.println(DigestUtil.md5Hex("U5opg0ds01slikadmin"));
        System.out.println("----------------");
    }
}
