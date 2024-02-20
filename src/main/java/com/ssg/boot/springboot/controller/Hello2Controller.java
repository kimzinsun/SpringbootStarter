package com.ssg.boot.springboot.controller;

import com.ssg.boot.springboot.util.MediaTypeUtils;
import com.ssg.boot.springboot.dto.PdsDto;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Date;

@RestController
public class Hello2Controller {
    @PostMapping("fileupload")
    public String fileupload(PdsDto pds, @RequestParam("uploadfile") MultipartFile uploadfile, HttpServletRequest request) throws IOException {
        
        

        // 파일 업로드 경로
        String path = request.getServletContext().getRealPath("/upload");

        String filename = uploadfile.getOriginalFilename();

        // 파일명 변경
        filename = new Date().getTime() + "-" + filename;

        String filepath = path + "/" + filename;

        File file = new File(filepath);

        BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(file));
        os.write(uploadfile.getBytes()); // 실제 업로드 되는 부분
        os.close();


        return "fileupload success";
    }

    @Autowired
    ServletContext servletContext;

    @GetMapping("filedownload")
    public ResponseEntity<InputStreamResource> filedownload(String filename, HttpServletRequest request) throws FileNotFoundException {
        

        // 파일 업로드 경로
        String path = request.getServletContext().getRealPath("/upload");

        // 파일 타입 조사
        MediaType mediaType = MediaTypeUtils.getMediaTypeForFileName(servletContext, filename);

        File file = new File(path + "/" + filename);
        InputStreamResource is = new InputStreamResource(new FileInputStream(file));

        // download counter 증가
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName()).contentType(mediaType).contentLength(file.length()).body(is);
    }
}
