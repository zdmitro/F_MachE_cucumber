package utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class FileService {

    private final String path;

    public FileService(String path) {
        this.path = path;
    }

    public void write(String firstname, String lastname, String email, String password) {
        try {
            Charset utf8 = StandardCharsets.UTF_8;
            List<String> list = Arrays.asList(email, password, "");

            Files.write(Paths.get(path), list, utf8, StandardOpenOption.APPEND);

            // encoding
            // Files.write(Paths.get(path), content.getBytes(StandardCharsets.UTF_8));

            // extra options
            // Files.write(Paths.get(path), content.getBytes(),
            //		StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}