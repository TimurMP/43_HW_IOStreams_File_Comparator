package telran.filecomparator.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileComparator {
    public static void main(String[] args) {
        argsChecker(args);
        fileComparator(args[0], args[1]);

    }

    public static void fileComparator(String file1, String file2) {
        try (FileInputStream fin1 = new FileInputStream(file1);
             FileInputStream fin2 = new FileInputStream(file2)) {
            byte[] arr1 = new byte[fin1.available()];
            byte[] arr2 = new byte[fin2.available()];
            if (arr1.length != arr2.length) {
                System.out.println("Comparison failed, files are different");
                return;
            }
            fin1.read(arr1);
            fin2.read(arr2);
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] != arr2[i]) {
                    System.out.println("Comparison failed, files are not same.");
                    return;
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Comparison completed, no diffs found");

    }

    public static void argsChecker(String[] args) {
        if (args.length != 2) {
            System.out.println("Wrong args number!");
            System.exit(1);
        }

    }


}
