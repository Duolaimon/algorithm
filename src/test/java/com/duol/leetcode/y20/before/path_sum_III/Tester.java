/**
 * Leetcode - path_sum_III
 */
package com.duol.leetcode.y20.before.path_sum_III;

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
                {TreeNode.newTree(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1}), 8, 3},     // test case 1 (init parameters below: {para1, para2, expected})
                {null, 1, 0},     // test case 2 (init parameters below: {para1, para2, expected})
                {TreeNode.newTree(new Integer[]{-191, 563, 664, -875, 988, 198, -505, -420, 795, 957, null, 536, -995, -681, 821, 381, -852, -506, -786, 964, 392, -675, -654, -717, 479, -402, -223, -666, null, 249, null, null, null, 714, 164, null, null, null, null, -580, null, null, 652, -153, 144, 142, -776, 906, -665, 194, null, null, null, null, null, 382, null, 25, 118, null, 433, -754, 53, 701, null, -496, 837, null, null, 994, -440, null, -98, -456, 852, -237, -159, null, 92, 628, -681, null, null, 547, null, null, 600, null, null, null, null, null, null, null, null, null, null, 237, -127, 795, null, null, null, 316, 53, -191, 628, 3, 357, 474, null, null, null, null, null, null, null, null, null, -746, -650, null, 805, -201, 750, null, null, null, null, -925, -237, null, -147, 629, -769, null, null, null, -846, null, -776, null, null, null, null, null, null, null, null, null, null, -906, 552, null, null, null, null, 675, -832, 594, null, -61, null, null, null, -291, -783, null, null, -660, null, 789, null, null, -786, -853, null, -534, -321, -564, -398, 358, -874, null, null, null, null, null, null, null, null, null, null, null, null, null, -598, null, null, null, null, null, 593}), 830, 10}      // test case 3 (init parameters below: {para1, para2, expected})
        });
    }

    /**=========================== for each test case ============================== */

    /**
     * Parameters for each test (initialized in testcases() method)
     * You can change the type of parameters
     */

    private TreeNode para1;
    private int para2;
    private int expected;                    // parameter 4 (expected answer)

    /**
     * This constructor must be provided to run parameterized test.
     */
    public Tester(
            TreeNode para1,
            int para2,
            int expected
    ) {
        // initialize test parameters
        this.para1 = para1;
        this.para2 = para2;
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
        int actual = 0;
        try {
            actual = solution.pathSum(para1, para2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertThat(actual, is(equalTo(expected)));

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("pathSum() pass unit test!");
        }
    }

    /**
     * Execute after each test method in this class is executed.
     */
    @After
    public void tearDown() throws Exception {
    }

}
