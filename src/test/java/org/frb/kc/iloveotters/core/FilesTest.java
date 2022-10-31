package org.frb.kc.iloveotters.core;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FilesTest {

    @Test
    public void testFilesOpenAndRead() throws IOException {
        //Example of File being read in windows notice the backslashes are escaped
        //Files.readAllLines(Path.of("C:\\\\Users\\linda\\work\\Somefile.txt"));
        List<String> strings = Files.readAllLines(Path.of("/Users/danno" +
            "/sample.txt"));
        System.out.println(strings);
    }

    @Test
    public void testFilesWrite() throws IOException {
        Path write = Files.write(Path.of("/Users/danno/sample.txt"),
            Arrays.asList("Seven", "Eight", "Nine"), StandardOpenOption.APPEND);
        System.out.format("%s has been written", write);
    }

    @Test
    public void testFiles() throws IOException {
        long size = Files.size(Path.of("/Users/danno", "sample.txt"));
        System.out.println(size);
    }

    @Test
    public void testIsItADirectory() {
        Path directory = Path.of("/Users/danno/tmp/secondproject");
        boolean isItADirectory = Files.isDirectory(directory);
        boolean exists = Files.exists(directory, LinkOption.NOFOLLOW_LINKS);

        System.out.printf("Is the path a directory? %b%n", isItADirectory);
        System.out.printf("Does the path exist? %b%n", exists);
        System.out.printf("The directory name is %s%n",
            directory.getFileName());
    }

    @Test
    public void testWalkingADirectory() throws IOException {
        Path directory = Path.of("/Users/danno/tmp/secondproject");
        try (Stream<Path> walkedPath = Files.walk(directory,
            FileVisitOption.FOLLOW_LINKS)) {
            walkedPath
                .filter(path -> path.toAbsolutePath().toString().endsWith("java"))
                .map(p -> p.toAbsolutePath().toString())
                .forEachOrdered(System.out::println);
        }
    }
}
