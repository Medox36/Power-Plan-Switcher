package ch.giuntini.powermodeswitch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PowerModesReader {

    public PowerModesReader() throws IOException {
        File file = new File("powercfg.txt");
        if (!file.exists()) {
            Path filePath = file.toPath();
            Files.createFile(filePath);
            Process p = Runtime.getRuntime().exec("powercfg -l");
            BufferedReader br = p.inputReader();
            BufferedWriter bw = Files.newBufferedWriter(filePath);
            List<String> lineList = new ArrayList<>(br.lines().toList());
            lineList.remove(0);
            lineList.remove(0);
            lineList.remove(0);
            Iterator<String> lines = lineList.iterator();
            while (lines.hasNext()) {
                String[] arr = lines.next().split(":")[1].trim().split("  ");
                if (arr[1].endsWith("*"))
                    arr[1] = new StringBuilder(arr[1]).deleteCharAt(arr[1].lastIndexOf("*")).toString().trim();
                bw.write(arr[0]);
                bw.write(",");
                bw.write(arr[1]);
                if (lines.hasNext())
                    bw.newLine();
            }
            bw.close();
            br.close();
        }
    }

    public String[][] readFile() throws IOException {
        List<String> lines = Files.readAllLines(Path.of("powercfg.txt"));
        String[][] arr = new String[lines.size()][2];
        for (String line : lines) {
            String[] tempArr = line.split(",");
            int lineNum = lines.indexOf(line);
            arr[lineNum][0] = tempArr[0].trim();
            arr[lineNum][1] = tempArr[1].trim();
        }
        return arr;
    }
}
