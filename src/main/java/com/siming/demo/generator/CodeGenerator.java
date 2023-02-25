package com.siming.demo.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DateType;

public class CodeGenerator {

    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/rental_car?useSSL=false&autoReconnect=true&characterEncoding=utf8", "user", "test")
                .globalConfig(builder ->
                        builder.author("siming") // 设置作者
//                                .enableSwagger() // 开启 swagger 模式
                                .dateType(DateType.TIME_PACK)
                                .outputDir(System.getProperty("user.dir") + "/src/main/java")   //设置输出路径：项目的 java 目录下【System.getProperty("user.dir")意思是获取到项目所在的绝对路径】
                )
                .packageConfig(builder ->
                        builder.parent("com.siming") // 设置父包名
                                .moduleName("demo") // 设置父包模块名
                )
                .strategyConfig(builder ->
                        builder.addInclude("car")
                                .entityBuilder().enableLombok().build()
                                .controllerBuilder().enableRestStyle().build()
                )
                .execute();
    }
}
