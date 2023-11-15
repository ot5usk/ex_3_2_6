package org.ot5usk;

import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class BoundaryServiceTest {
    private final BoundaryService boundaryService = new BoundaryService();


    @DisplayName("Finding the min mark")
    @Description("Must return the min mark")
    @ParameterizedTest(name = "from {0}")
    @MethodSource("arraysOfMarks")
    void testFindMin(int[] marks) {
        assertEquals(Arrays.stream(marks).min().getAsInt(), boundaryService.findMin(marks));
    }

    static Stream<int[]> arraysOfMarks() {
        return Stream.of(new int[]{1, 1, 0, 2, 0, 7, 7, 15}, new int[]{-1, 1, 0, 0, 11, -11, -1, 9});
    }
}