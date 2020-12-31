/**
 * Leetcode - non_overlapping_intervals
 */
package com.duol.leetcode.y20.m12.d31.no435.non_overlapping_intervals;

import java.util.*;

import com.duol.common.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RunWith(Parameterized.class)
public class Tester {

    /**
     * =========================== static for every test cases ==============================
     */

    // Solution instance to test
    private static Solution solution;
    // use this Object to print the log (call from slf4j facade)
    private static final Logger LOGGER = LoggerFactory.getLogger(TesterRunner.class);

    /**
     * Execute once before any of the test methods in this class.
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        /* uncomment to switch solutions */
        solution = new Solution1();
        // solution = new Solution2();
    }

    /**
     * Execute once after all of the test methods are executed in this class.
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * Initialize test cases
     */
    @Parameters
    public static Collection<Object[]> testcases() {
        return Arrays.asList(new Object[][]{
                {new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}, 1},     // test case 1 (init parameters below: {para1, para2,
                // expected})
                {new int[][]{{1, 2}, {1, 2}, {1, 2}}, 2},     // test case 2 (init parameters below: {para1, para2, expected})
                {new int[][]{{-100, -87}, {-99, -44}, {-98, -19}, {-97, -33}, {-96, -60}, {-95, -17}, {-94,
                        -44}, {-93, -9}, {-92, -63}, {-91, -76}, {-90, -44}, {-89, -18}, {-88, 10}, {-87,
                        -39}, {-86, 7}, {-85, -76}, {-84, -51}, {-83, -48}, {-82, -36}, {-81, -63}, {-80,
                        -71}, {-79, -4}, {-78, -63}, {-77, -14}, {-76, -10}, {-75, -36}, {-74, 31}, {-73, 11},
                        {-72, -50}, {-71, -30}, {-70, 33}, {-69, -37}, {-68, -50}, {-67, 6}, {-66, -50}, {-65, -26},
                        {-64, 21}, {-63, -8}, {-62, 23}, {-61, -34}, {-60, 13}, {-59, 19}, {-58, 41}, {-57, -15},
                        {-56, 35}, {-55, -4}, {-54, -20}, {-53, 44}, {-52, 48}, {-51, 12}, {-50, -43}, {-49, 10},
                        {-48, -34}, {-47, 3}, {-46, 28}, {-45, 51}, {-44, -14}, {-43, 59}, {-42, -6}, {-41, -32},
                        {-40, -12}, {-39, 33}, {-38, 17}, {-37, -7}, {-36, -29}, {-35, 24}, {-34, 49}, {-33, -19},
                        {-32, 2}, {-31, 8}, {-30, 74}, {-29, 58}, {-28, 13}, {-27, -8}, {-26, 45}, {-25, -5}, {-24, 45},
                        {-23, 19}, {-22, 9}, {-21, 54}, {-20, 1}, {-19, 81}, {-18, 17}, {-17, -10}, {-16, 7}, {-15, 86},
                        {-14, -3}, {-13, -3}, {-12, 45}, {-11, 93}, {-10, 84}, {-9, 20}, {-8, 3}, {-7, 81}, {-6, 52},
                        {-5, 67}, {-4, 18}, {-3, 40}, {-2, 42}, {-1, 49}, {0, 7}, {1, 104}, {2, 79}, {3, 37}, {4, 47},
                        {5, 69}, {6, 89}, {7, 110}, {8, 108}, {9, 19}, {10, 25}, {11, 48}, {12, 63}, {13, 94}, {14, 55},
                        {15, 119}, {16, 64}, {17, 122}, {18, 92}, {19, 37}, {20, 86}, {21, 84}, {22, 122}, {23, 37}, {24, 125},
                        {25, 99}, {26, 45}, {27, 63}, {28, 40}, {29, 97}, {30, 78}, {31, 102}, {32, 120}, {33, 91},
                        {34, 107}, {35, 62}, {36, 137}, {37, 55}, {38, 115}, {39, 46}, {40, 136}, {41, 78}, {42, 86}, {43, 106}, {44, 66}, {45, 141}, {46, 92}, {47, 132}, {48, 89}, {49, 61}, {50, 128}, {51, 155}, {52, 153}, {53, 78}, {54, 114}, {55, 84}, {56, 151}, {57, 123}, {58, 69}, {59, 91}, {60, 89}, {61, 73}, {62, 81}, {63, 139}, {64, 108}, {65, 165}, {66, 92}, {67, 117}, {68, 140}, {69, 109}, {70, 102}, {71, 171}, {72, 141}, {73, 117}, {74, 124}, {75, 171}, {76, 132}, {77, 142}, {78, 107}, {79, 132}, {80, 171}, {81, 104}, {82, 160}, {83, 128}, {84, 137}, {85, 176}, {86, 188}, {87, 178}, {88, 117}, {89, 115}, {90, 140}, {91, 165}, {92, 133}, {93, 114}, {94, 125}, {95, 135}, {96, 144}, {97, 114}, {98, 183}, {99, 157}}, 187},     // test case 2 (init parameters below: {para1, para2, expected})
                {new int[][]{{1, 2}, {2, 3}}, 0}      // test case 3 (init parameters below: {para1, para2, expected})
        });
    }

    /**=========================== for each test case ============================== */

    /**
     * Parameters for each test (initialized in testcases() method)
     * You can change the type of parameters
     */

    private int[][] para1;
    private int expected;                    // parameter 4 (expected answer)

    /**
     * This constructor must be provided to run parameterized test.
     */
    public Tester(
            int[][] para1,
            int expected
    ) {
        // initialize test parameters
        this.para1 = para1;
        this.expected = expected;
    }

    /**
     * Execute before each test method in this class is executed.
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Executed as a test case.
     */
    @Test
    public void test() {
        //
        int actual = solution.eraseOverlapIntervals(para1);

        assertThat(actual, is(equalTo(expected)));

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("eraseOverlapIntervals() pass unit test!");
        }
    }

    /**
     * Execute after each test method in this class is executed.
     */
    @After
    public void tearDown() throws Exception {
    }

}
