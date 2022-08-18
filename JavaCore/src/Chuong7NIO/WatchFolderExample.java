package Chuong7NIO;

import java.nio.file.*;

public class WatchFolderExample {
    public static void watch(Path path){
        FileSystem fs = path.getFileSystem();
        try (WatchService service = fs.newWatchService()){
            path.register(service, WatchEvent.Kind<ENTR>)
        }
    }
}
