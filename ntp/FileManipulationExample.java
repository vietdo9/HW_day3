package ntp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class FileManipulationExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String folderPath = "C:/exampleFolder"; // Specify the folder path here

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Tao file");
            System.out.println("2. Luu file");
            System.out.println("3. ghi du lieu vao file");
            System.out.println("4. Doc file");
            System.out.println("5. Lay Duong Dan file");
            System.out.println("6. xoa file");
            System.out.println("7. tao folder");
            System.out.println("8. Exit");
            System.out.print("Enter your choice (1-8): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the file name: ");
                    String fileName = scanner.nextLine();
                    createNewFile(folderPath, fileName);
                    break;
                case 2:
                    System.out.print("Enter the source file path: ");
                    String sourceFilePath = scanner.nextLine();
                    System.out.print("Enter the destination file path: ");
                    String destinationFilePath = scanner.nextLine();
                    saveFile(sourceFilePath, destinationFilePath);
                    break;
                case 3:
                    System.out.print("Enter the file path: ");
                    String filePath = scanner.nextLine();
                    System.out.print("Enter the data to write: ");
                    String data = scanner.nextLine();
                    writeToFile(filePath, data);
                    break;
                case 4:
                    System.out.print("Enter the file path: ");
                    filePath = scanner.nextLine();
                    readFile(filePath);
                    break;
                case 5:
                    System.out.print("Enter the file path: ");
                    filePath = scanner.nextLine();
                    getFilePath(filePath);
                    break;
                case 6:
                    System.out.print("Enter the file path: ");
                    filePath = scanner.nextLine();
                    deleteFile(filePath);
                    break;
                case 7:
                    System.out.print("Enter the folder name: ");
                    String folderName = scanner.nextLine();
                    createFolder(folderPath, folderName);
                    break;
                case 8:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        }
    }

    public static void createNewFile(String folderPath, String fileName) {
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        File file = new File(folderPath, fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error creating the file: " + e.getMessage());
        }
    }

    public static void saveFile(String sourceFilePath, String destinationFilePath) {
        Path sourcePath = Path.of(sourceFilePath);
        Path destinationPath = Path.of(destinationFilePath);

        try {
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving the file: " + e.getMessage());
        }
    }

    public static void writeToFile(String filePath, String data) {
        try {
            Files.writeString(Path.of(filePath), data);
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }

    public static void readFile(String filePath) {
        try {
            String content = Files.readString(Path.of(filePath));
            System.out.println("File content:");
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void getFilePath(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            String absolutePath = file.getAbsolutePath();
            System.out.println("File path: " + absolutePath);
        } else {
            System.out.println("File does not exist.");
        }
    }

    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Error deleting the file.");
            }
        } else {
            System.out.println("File does not exist.");
        }
    }

    public static void createFolder(String folderPath, String folderName) {
        File folder = new File(folderPath, folderName);
        if (folder.mkdirs()) {
            System.out.println("Folder created successfully.");
        } else {
            System.out.println("Error creating the folder.");
        }
    }
}