import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class InitMain {


    public static void main(String[] args) throws Exception {

        String projectName = "cas";//todo 修改这里


        System.out.println(System.getProperty("user.dir"));

        File dir = new File(System.getProperty("user.dir"));

        try {
            Map<String, String> placeholder = getPlaceHolder(projectName);
            compress(dir, projectName, placeholder);
        } catch (IOException e) {
            //log.error("错误", e);
            throw e;
        }

    }

    private static void compress(File sourceFile, String name, Map<String, String> placeholder) throws IOException {
        if (sourceFile.getName().equalsIgnoreCase(".git")) {
            return;
        }
        if (sourceFile.getName().equalsIgnoreCase("..idea")) {
            return;
        }
        if (sourceFile.isDirectory()) {
            //文件夹
            File[] listFiles = sourceFile.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File listFile : listFiles) {
                    compress(listFile, name, placeholder);
                }
            }
            if (sourceFile.getName().contains("xxx") || sourceFile.getName().contains("XXX")) {
                File newFile = new File(sourceFile.getParentFile(), sourceFile.getName().replace("xxx", name));
                sourceFile.renameTo(newFile);
            }

        } else {
            // 普通文件
            if (sourceFile.getName().contains("xxx") || sourceFile.getName().contains("XXX")) {
                File newFile = new File(sourceFile.getParentFile(), sourceFile.getName().replace("xxx", name));
                sourceFile.renameTo(newFile);
                sourceFile = newFile;
            }
            handleFile(sourceFile, placeholder);
        }
    }


    private static void handleFile(File sourceFile, Map<String, String> placeholder) throws IOException {
        if (notIsSrcFile(sourceFile)) {
            //不是源文件
            return;
        }
        BufferedReader in = new BufferedReader(new FileReader(sourceFile));
        File tempFile = new File(sourceFile.getParentFile(), "temp" + sourceFile.getName());
        BufferedWriter out = new BufferedWriter(new FileWriter(sourceFile));
        while (in.ready()) {
            String line = in.readLine();
            line = replace(line, placeholder);
            out.write(line + '\n');
        }
        in.close();
        out.close();
        sourceFile.delete();
        tempFile.renameTo(sourceFile);

    }


    /**
     * 判断是否不源码文件
     *
     * @param sourceFile 文件
     * @return false：是源码
     */
    private static boolean notIsSrcFile(File sourceFile) {
        if (sourceFile.getName().endsWith(".java")) {
            return false;
        }
        if (sourceFile.getName().endsWith(".xml")) {
            return false;
        }
        if (sourceFile.getName().equals("Dockerfile")) {
            return false;
        }
        if (sourceFile.getName().endsWith(".md")) {
            return false;
        }

        return true;

    }


    private static String replace(String context, Map<String, String> placeholder) {
        for (String key : placeholder.keySet()) {
            if (context.contains(key)) {
                context = context.replace(key, placeholder.get(key));
            }
        }
        return context;
    }

    private static Map<String, String> getPlaceHolder(String projectName) {
        Map<String, String> placeholder = new HashMap<>();
        placeholder.put("xxx", projectName);
        placeholder.put("XXX", projectName.substring(0, 1).toUpperCase() + projectName.substring(1));

        return placeholder;
    }
}
