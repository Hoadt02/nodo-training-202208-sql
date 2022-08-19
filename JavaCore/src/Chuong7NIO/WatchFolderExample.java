package Chuong7NIO;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.io.IOException;
import java.nio.file.*;

public class WatchFolderExample {
    public static void watch(Path path) throws IOException, InterruptedException {
        FileSystem fs = path.getFileSystem();
        try (WatchService service = fs.newWatchService()){
            path.register(service, StandardWatchEventKinds.ENTRY_CREATE);
            while (true){
                WatchKey key = service.take();
                for (WatchEvent<?> watchEvent : key.pollEvents()) {
                    if (StandardWatchEventKinds.ENTRY_CREATE == watchEvent.kind()) {
                        Path newPath = ((WatchEvent<Path>) watchEvent).context();
                        System.out.println("New path created: " + newPath);
                    }
                }
                if (!key.reset()) break;
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Path path = Paths.get("D:\\Nodo - Work\\Java core\\Temp");
        watch(path);
    }
}
