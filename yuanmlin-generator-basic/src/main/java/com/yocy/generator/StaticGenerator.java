package com.yocy.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

/**
 * @author <a href="https://github.com/youngccy">YounGCY</a>
 * @description
 */
public class StaticGenerator {

    public static void main(String[] args) {
        // 获取整个项目的根路径
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        // 输入文件路径：ACM 示例代码模板目录
        String inputFile = new File(parentFile, "yuanmlin-generator-demo-projects/acm-template").getAbsolutePath();
        // 输出路径：直接输出到项目的根目录
        String outputPath = projectPath;
        copyFilesByHutool(inputFile, outputPath);
    }

    /**
     * 拷贝文件（Hutool 实现，将会输入目录完整拷贝到输出目录下）
     * @param inputPath
     * @param outputPath
     */
    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }
    
    public static void copyFiles(String inputPath, String outputPath) {
        File inputFile = new File(inputPath);
        File outputFile = new File(outputPath);
        try {
            copyFile(inputFile, outputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 拷贝文件
     * 思路：
     * - 文件A => 目录B，则文件A直接放在目录B下
     * - 文件A => 文件B，则文件A直接覆盖文件B
     * - 目录A => 目录B，则目录A放在目录B下
     * @param inputFile
     * @param outputFile
     * @throws IOException
     */
    private static void copyFile(File inputFile, File outputFile) throws IOException {
        // 区分文件还是目录
        if (inputFile.isDirectory()) {
            System.out.println(inputFile.getName());
            File destOutputFile = new File(outputFile, inputFile.getName());
            // 如果是目录，且如果不存在，首先创建目标目录
            if (!destOutputFile.exists()) {
                destOutputFile.mkdirs();
            }
            // 获取目录下的所有文件和子目录
            File[] files = inputFile.listFiles();
            // 无子文件或目录，直接删除
            if (ArrayUtil.isEmpty(files)) {
                return;
            }
            for (File file : files) {
                // 递归拷贝下一级的文件
                copyFile(file, destOutputFile);
            }
        } else {
            // 如果是文件，则直接目标Path
            Path destPath = outputFile.toPath().resolve(inputFile.getName());
            // 如果文件已存在，采取直接覆盖的策略
            Files.copy(inputFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
