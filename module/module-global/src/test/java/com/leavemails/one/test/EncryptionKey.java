package com.leavemails.one.test;

import com.leavemails.one.module.global.GlobalApplication;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author lostsakura
 * @date 2022-06-10 01:05
 */
@SpringBootTest(classes = GlobalApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class EncryptionKey {

    @Resource
    StringEncryptor encryptor;

    @Test
    public void encrypt() {
        String oriStr = "qq282465134";
        System.out.println(oriStr + " 加密后 -> " + encryptor.encrypt(oriStr));
    }
}
