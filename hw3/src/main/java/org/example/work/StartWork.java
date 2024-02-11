package org.example.work;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

import java.util.*;


public class StartWork implements Runnable{
    private static final String MERGED_FILE_NAME = "mergedFile.txt";
    private static final String FORBIDDEN_WORDS_FILE = "forbiddenWords.txt";
    @Override
    public void run() {
        try {
            exercise1();
            exercise2();
            exercise3();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void exercise1() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        int[] array = new int[10];
        Thread fillArrayThread = new Thread(() -> {
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                array[i] = random.nextInt(100);
            }
            System.out.println("Massive is filled: ");
            for (int value : array) {
                System.out.print(value + " ");
            }
            System.out.println();
            latch.countDown(); //
        });
        Thread sumThread = new Thread(() -> {
            try {
                latch.await();
                int sum = 0;
                for (int value : array) {
                    sum += value;
                }
                System.out.println("Sum of elements of massive: " + sum);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread averageThread = new Thread(() -> {
            try {
                latch.await(); // Ожидаем заполнения массива
                int sum = 0;
                for (int value : array) {
                    sum += value;
                }
                double average = (double) sum / array.length;
                System.out.println("Среднеарифметическое элементов массива: " + average);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        fillArrayThread.start();
        sumThread.start();
        averageThread.start();

        fillArrayThread.join();
        sumThread.join();
        averageThread.join();
    }
    private void exercise2() throws IOException {
        System.out.println("Path to file");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.next();
        CountDownLatch latch = new CountDownLatch(1);

        Thread fillFile = new Thread(()->
        {
            FileWriter writer = null;
            try {
                writer = new FileWriter(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                try {
                    writer.write(random.nextInt(100));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("File is filled");
            latch.countDown();
        });
        Thread simpleNum = new Thread(()->
        {
            try {
                latch.await();
                try {
                    FileReader fr = new FileReader(path);
                    Scanner scan = new Scanner(fr);
                    System.out.println("Simple numbers: ");
                    while (scanner.hasNext()) {
                        if (scanner.hasNextInt()) {
                            int a = scan.nextInt();
                            boolean f = false;
                            for(int i = 2; i<a;i++)
                            {
                                if(a%i==0)
                                {
                                    f=true;
                                    break;
                                }
                            }
                            if(!f)
                            {
                              System.out.println(a);
                            }
                        } else {
                            scanner.next(); // Пропускаем нечисловые токены
                        }
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread factorialNum = new Thread(()->
        {
            try {
                latch.await(); // Ожидаем завершения генерации чисел
                List<Integer> numbers = readNumbersFromFile(path);
                List<String> factorials = new ArrayList<>();
                for (int number : numbers) {
                    factorials.add(number + "! = " + factorial(number));
                }
                for (String string : factorials) {
                    System.out.println(string);
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        });
        fillFile.start();
        simpleNum.start();
        factorialNum.start();
        try {
            fillFile.join();
            simpleNum.join();
            factorialNum.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static long factorial(int number) {
        long result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }
    private static List<Integer> readNumbersFromFile(String filePath) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        }
        return numbers;
    }
    private void exercise3()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write path of old directory: ");
        Path sourceDirectory = Paths.get(scanner.nextLine());
        System.out.print("Write path of new directory: ");
        Path targetDirectory = Paths.get(scanner.nextLine());
        Thread copyThread = new Thread(() -> {
            try {
                Files.walkFileTree(sourceDirectory, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                        Path targetDir = targetDirectory.resolve(sourceDirectory.relativize(dir));
                        Files.createDirectories(targetDir);
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        Files.copy(file, targetDirectory.resolve(sourceDirectory.relativize(file)), StandardCopyOption.REPLACE_EXISTING);
                        return FileVisitResult.CONTINUE;
                    }
                });
                System.out.println("Copy is end.");
            } catch (IOException e) {
                System.err.println("Error while was copying " + e.getMessage());
            }
        });
        copyThread.start();

        try {
            copyThread.join();

            // Подсчет файлов и директорий в целевой директории (примерный подход)

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void exercise4() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write path to directory: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Word for search: ");
        String searchWord = scanner.nextLine();
        Thread t = new Thread(()->
        {
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(MERGED_FILE_NAME))) {
                Files.walk(Paths.get(directoryPath))
                        .filter(Files::isRegularFile)
                        .forEach(filePath -> {
                            try {
                                Files.lines(filePath)
                                        .filter(line -> line.contains(searchWord))
                                        .forEach(line -> {
                                            try {
                                                writer.write(line);
                                                writer.newLine();
                                            } catch (IOException e) {
                                                e.printStackTrace();
                                            }
                                        });
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->
        {
            Set<String> forbiddenWords = new HashSet<>();
            try {
                // Считываем запрещенные слова
                List<String> allLines = Files.readAllLines(Paths.get(FORBIDDEN_WORDS_FILE));
                forbiddenWords.addAll(allLines);

                // Считываем содержимое исходного файла
                String content = new String(Files.readAllBytes(Paths.get(MERGED_FILE_NAME)));
                for (String word : forbiddenWords) {
                    content = content.replaceAll("\\b" + word + "\\b", "");
                }

                // Перезаписываем файл без запрещенных слов
                Files.write(Paths.get(MERGED_FILE_NAME), content.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        t.start();
        t.join();
        t2.start();
        t2.join();
    }
}
