package com.ssg.boot.springboot;

import jakarta.servlet.ServletContext;
import org.springframework.http.MediaType;

public class MediaTypeUtils {

    public static MediaType getMediaTypeForFileName(ServletContext sc, String filename) {
        String mimType = sc.getMimeType(filename);

        try {
            MediaType mediaType = MediaType.parseMediaType(mimType);
            return mediaType;

        } catch (Exception e) {
            return MediaType.APPLICATION_OCTET_STREAM;
        }

    }
}
