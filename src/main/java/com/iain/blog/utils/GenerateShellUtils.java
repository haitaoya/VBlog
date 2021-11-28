package com.iain.blog.utils;

import lombok.SneakyThrows;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class GenerateShellUtils {
    HashSet<String> ddlModifyTalbeSet = new LinkedHashSet<>();
    HashSet<String> dataModifyTalbeSet = new LinkedHashSet<>();
    HashSet<String> createTalbeSet = new LinkedHashSet<>();
    HashSet<String> dropTalbeSet = new LinkedHashSet<>();

    public static void main(String[] args) {
        GenerateShellUtils generateShellUtils = new GenerateShellUtils();
        generateShellUtils.preReadTabFile();
        generateShellUtils.generateBackupSh();
        generateShellUtils.generateRecoverSh();
    }

    @SneakyThrows
    protected void preReadTabFile() {
        File ddlModifyTabFile = ResourceUtils.getFile("classpath:ddlModifyTable.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(ddlModifyTabFile))) {
            String tabNam;
            while ((tabNam = bufferedReader.readLine()) != null) {
                ddlModifyTalbeSet.add(tabNam);
            }
        }
        File createTableFile = ResourceUtils.getFile("classpath:createTable.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(createTableFile))) {
            String tabNam;
            while ((tabNam = bufferedReader.readLine()) != null) {
                createTalbeSet.add(tabNam);
            }
        }

        File dataModifyTabFile = ResourceUtils.getFile("classpath:dataModifyTable.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dataModifyTabFile))) {
            String tabNam;
            while ((tabNam = bufferedReader.readLine()) != null) {
                if (!ddlModifyTalbeSet.contains(tabNam) && !createTalbeSet.contains(tabNam)) {
                    dataModifyTalbeSet.add(tabNam);
                }
            }
        }


        File dropTableFile = ResourceUtils.getFile("classpath:dropTable.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(dropTableFile))) {
            String tabNam;
            while ((tabNam = bufferedReader.readLine()) != null) {
                dropTalbeSet.add(tabNam);
            }
        }
    }

    @SneakyThrows
    void generateBackupSh() {
        File backUpSh = new File("backup.sh");
        String absolutePath = backUpSh.getAbsolutePath();
        System.out.println(absolutePath);
        BufferedWriter backupBufferedWriter = new BufferedWriter(new FileWriter(backUpSh));

        writeToFile(backupBufferedWriter, "# !/bin/sh");
        writeToFile(backupBufferedWriter, "# mkdir log");

        writeToFile(backupBufferedWriter, "# 表变更 备份表结构");

        ddlModifyTalbeSet.forEach(ddlModifyTabNam -> {
            writeToFile(backupBufferedWriter, getDdlBackupSql(ddlModifyTabNam));
        });

        writeToFile(backupBufferedWriter, "# 表drop 备份表结构");

        dropTalbeSet.forEach(dropTabNam -> {
            writeToFile(backupBufferedWriter, getDdlBackupSql(dropTabNam));
        });
        writeToFile(backupBufferedWriter, "# 表变更 备份数据");

        ddlModifyTalbeSet.forEach(ddlModifyTabNam -> {
            writeToFile(backupBufferedWriter, getDataBackupSql(ddlModifyTabNam));
        });

        writeToFile(backupBufferedWriter, "# 表drop 备份数据");
        dropTalbeSet.forEach(dropTabNam -> {
            writeToFile(backupBufferedWriter, getDataBackupSql(dropTabNam));
        });

        writeToFile(backupBufferedWriter, "# 数据变更 备份数据");
        dataModifyTalbeSet.forEach(dataModifyTabNam -> {
            writeToFile(backupBufferedWriter, getDataBackupSql(dataModifyTabNam));
        });


        writeToFile(backupBufferedWriter, "echo $?");

        writeToFile(backupBufferedWriter, "exit $?");

        backupBufferedWriter.flush();


    }

    /**
     * 回退脚本
     */
    @SneakyThrows
    void generateRecoverSh() {
        File recoverSh = new File("recover.sh");
        String absolutePath1 = recoverSh.getAbsolutePath();
        System.out.println(absolutePath1);
        BufferedWriter recoverBufferedWriter = new BufferedWriter(new FileWriter(recoverSh));
        writeToFile(recoverBufferedWriter, "test");
        writeToFile(recoverBufferedWriter, "# drop 新增的表");
        createTalbeSet.forEach(createTabNam -> {
            writeToFile(recoverBufferedWriter, getTableDropSql(createTabNam));
        });
        writeToFile(recoverBufferedWriter, "# drop 有表结构变更的表");

        ddlModifyTalbeSet.forEach(ddlModifyTabNam -> {
            writeToFile(recoverBufferedWriter, getTableDropSql(ddlModifyTabNam));

        });

        writeToFile(recoverBufferedWriter, "# 重建 有表结构变更的表");

        ddlModifyTalbeSet.forEach(ddlModifyTabNam -> {
            writeToFile(recoverBufferedWriter, getTableCreateSql(ddlModifyTabNam));
        });
        writeToFile(recoverBufferedWriter, "# 重建 有drop变更的表");
        dropTalbeSet.forEach(dropTabNam -> {
            writeToFile(recoverBufferedWriter, getTableCreateSql(dropTabNam));
        });
        writeToFile(recoverBufferedWriter, "#重连数据库");
        writeToFile(recoverBufferedWriter, "db2 connect to mlcsdb");
        writeToFile(recoverBufferedWriter, "db2 set current schema db2mlcs");
        writeToFile(recoverBufferedWriter, "# 重新导入结构有变更表的数据");
        ddlModifyTalbeSet.forEach(ddlModifyTabNam -> {
            writeToFile(recoverBufferedWriter, getDataImportSql(ddlModifyTabNam));
        });
        writeToFile(recoverBufferedWriter, "# 重新导入有drop变更表的数据");
        dropTalbeSet.forEach(dropTabNam -> {
            writeToFile(recoverBufferedWriter, getDataImportSql(dropTabNam));
        });
        writeToFile(recoverBufferedWriter, "# 清除数据变更的表数据");
        dataModifyTalbeSet.forEach(dataModifyTabNam -> {
            writeToFile(recoverBufferedWriter, getDataDeleSql(dataModifyTabNam));
        });
        writeToFile(recoverBufferedWriter, "# 重新导入数据变更的表数据");
        dataModifyTalbeSet.forEach(dataModifyTabNam -> {
            writeToFile(recoverBufferedWriter, getDataImportSql(dataModifyTabNam));
        });
        recoverBufferedWriter.flush();
    }


    private void writeToFile(BufferedWriter writer, StringBuilder builder) {
        try {
            writer.write(builder.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeToFile(BufferedWriter writer, String str) {
        try {
            writer.write(str);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private StringBuilder getDdlBackupSql(String tabNam) {
        return new StringBuilder().append("db2look -d mlcsdb -e -t ")
                .append(tabNam)
                .append(" ./backup/")
                .append(tabNam)
                .append(".sql;");
    }

    private StringBuilder getDataBackupSql(String tabNam) {
        return new StringBuilder().append("db2 \"export to ./backupixf/")
                .append(tabNam)
                .append(".ixf of ixf SELECT * from ")
                .append(tabNam)
                .append("\";");
    }

    private StringBuilder getTableDropSql(String tabNam) {
        return new StringBuilder().append("db2 \"drop table DB2MLCS.")
                .append(tabNam)
                .append("\";");
    }

    private StringBuilder getTableCreateSql(String tabNam) {
        return new StringBuilder().append("db2 -tvf ./backup/")
                .append(tabNam)
                .append(".sql;");
    }

    private StringBuilder getDataImportSql(String tabNam) {
        return new StringBuilder().append("import from ./backupixf/")
                .append(tabNam)
                .append(".ixf of ixf INSERT INTO ")
                .append(tabNam)
                .append("\";");
    }

    private StringBuilder getDataDeleSql(String tabNam) {
        return new StringBuilder().append("db2 \"delete ")
                .append(tabNam)
                .append("\";");
    }
}
