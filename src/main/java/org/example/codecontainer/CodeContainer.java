package org.example.codecontainer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeContainer {
    private String fileName;
    private String packageName;

    public CodeContainer(String content) {
        this.fileName = extractFileName(content);
        this.packageName = extractPackageName(content);
    }

    private String extractFileName(String content) {
        Pattern pattern = Pattern.compile("class\\s+(\\w+)");
        Matcher matcher = pattern.matcher(content);

        if (matcher.find()) {
            return matcher.group(1) + ".java";
        } else {
            throw new RuntimeException("No class declaration found");
        }
    }

    private String extractPackageName(String content) {
        Pattern pattern = Pattern.compile("package\\s+([\\w\\.]+)\\s*;");
        Matcher matcher = pattern.matcher(content);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "";
        }
    }

    public String getFileName() {
        return fileName;
    }

    public String getPackageName() {
        return packageName;
    }
}