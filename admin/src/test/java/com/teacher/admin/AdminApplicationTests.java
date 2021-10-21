package com.teacher.admin;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.teacher.admin.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AdminApplicationTests {

    @Test
    void excelTest() {
        List<User> list = this.init();
        String templateFileName = "D:\\projects\\learning\\admin\\src\\main\\resources\\templates\\test.xlsx";
        String fileName = "D:\\projects\\learning\\admin\\src\\main\\resources\\excel\\excelFillTest.xlsx";
        ExcelWriter excelWriter = EasyExcel.write(fileName).withTemplate(templateFileName).build();
        WriteSheet writeSheet = EasyExcel.writerSheet().build();
        File file = new File(fileName);
        Assertions.assertEquals(true,file.exists());
    }

    private List<User> init() {
        List<User> list = new ArrayList<>(10);
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 10; i++) {
            list.add(new User((long)i,"username" + i,
                    "password" + i,"昵称" + i,
                    "1"+random.nextLong()));
        }
        return list;
    }

}
