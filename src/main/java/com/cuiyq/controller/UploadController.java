package com.cuiyq.controller;

import com.cuiyq.domain.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @version V1.0
 * @Title:
 * @Description: 文件上传
 * @Copyright 2024 Cuiyq
 * @author: Cuiyq
 * @date: 2025/3/16 15:30
 */
@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(String username, Integer age,@RequestParam("images") MultipartFile[] images) throws IOException {
        log.info("上传文件，用户名：{}, 年龄：{}, 文件名：{}",
                username, age, images);
        // 遍历处理每个文件
        for (MultipartFile image : images) {
            if (image.isEmpty()) {
                log.warn("文件为空，跳过处理");
                continue; // 跳过空文件
            }

            /*获取原始文件名*/
            String originalFilename = image.getOriginalFilename();

            String string = UUID.randomUUID().toString();
            originalFilename = string + originalFilename.substring(originalFilename.lastIndexOf("."));
//        将文件存储在服务器的目录中
            image.transferTo(new File("/Users/cuiyq/Documents/develop/resource/" + originalFilename));
        }
        return Result.success();
    }
}
