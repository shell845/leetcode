package main.java.fundamental;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author YC (shell845)
 * @date 13/2/2021 10:55 PM
 */

class SortingTest {
    Sorting s;

    @BeforeEach
    public void setUp() {
        this.s = new Sorting();
    }

    @AfterEach
    public void tearDown() {
        this.s = null;
    }

    @Test
    void quickSort() {
        int[] answer = new int[]{1,2,2,2,4,5,6,9};
        assertArrayEquals(answer, s.quickSort(new int[]{9,2,5,2,1,6,2,4}));
    }

    @Disabled
    @Test
    void quickSortSkip() {
        int[] answer = new int[]{1,2,3};
        assertArrayEquals(answer, s.quickSort(new int[]{3,2,1}));
    }

}