package com.joansala.game.oware;

import java.io.FileInputStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.*;
import com.joansala.engine.Board;
import com.joansala.engine.BoardContract;
import com.joansala.game.othello.OthelloBoard;
import com.joansala.util.suites.Suite;
import com.joansala.util.suites.SuiteReader;


/**
 *
 */
@DisplayName("Othello board")
public class OthelloBoardTest implements BoardContract {

    /** Test suite file path */
    private static String SUITE_PATH = "/othello-test.suite";


    /**
     * {@inheritDoc}
     */
    @Override
    public Board newInstance() {
        return new OthelloBoard();
    }


    /**
     * Stream of game suites to test.
     */
    public static Stream<Suite> suites() throws Exception {
        String path = getResourcePath(SUITE_PATH);
        FileInputStream input = new FileInputStream(path);
        SuiteReader reader = new SuiteReader(input);

        return reader.stream();
    }


    /**
     * Obtain a path to the given resource file.
     */
    private static String getResourcePath(String path) {
        return BoardContract.class.getResource(path).getFile();
    }
}
