package main;

import santa.Santa;
import santatodo.SantaList;
import checker.Checker;
import common.Constants;

import fileio.Input;
import fileio.InputLoader;
import fileio.Writer;
import santatodo.ShareGifts;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.Objects;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {
        createOutput();
        Checker.calculateScore();

    }

    /**
     *
     * @throws IOException
     */
    public static void createOutput() throws IOException {
        File directory = new File(Constants.TEST_PATH);
        Path path = Paths.get(Constants.OUTPUT_DIR_PATH);
        if (!Files.exists(path)) {
            Files.createDirectories(path);
        }

        for (File file : Objects.requireNonNull(directory.listFiles())) {

            String filepath = Constants.OUTPUT_PATH + file.getName().substring(Constants.TEST);
            File out = new File(filepath);
            out.delete();
            boolean isCreated = out.createNewFile();
            if (isCreated) {
                action(file.getAbsolutePath(), filepath);
            }
        }
    }

    private static void action(final String filePath1, final String filePath2) throws IOException {
        InputLoader inputLoader = new InputLoader(filePath1);
        Input input = inputLoader.readData();
        SantaList santaList = new SantaList(input);

        // we create only one instance of the class Santa
        Santa santa = Santa.getInstance();

        // we add the data to Santa's list the given number of years
        santaList.add(santa);
        Writer fileWriter = new Writer(filePath2);

        ShareGifts shareGifts = new ShareGifts(santa);
        shareGifts.share(fileWriter);

        santa.getChildren().clear();
        santa.getGifts().clear();
        santa.getAnnualChanges().clear();
        santa.getCities().clear();
    }
}
