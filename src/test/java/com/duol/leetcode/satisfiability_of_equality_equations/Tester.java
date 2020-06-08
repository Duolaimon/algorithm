/**
 * Leetcode - satisfiability_of_equality_equations
 */
package com.duol.leetcode.satisfiability_of_equality_equations;

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
                {new String[]{"a==b", "b!=a"}, false},     // test case 1 (init parameters below: {para1, para2, expected})
                {new String[]{"b==a", "a==b"}, true},     // test case 2 (init parameters below: {para1, para2,
                // expected})
                {new String[]{"a==b", "b==c", "a==c"}, true},      // test case 3 (init parameters below: {para1, para2,
                // expected})
                {new String[]{"a==b", "b!=c", "c==a"}, false},     // test case 3 (init parameters below: {para1, para2, expected})
                {new String[]{"c==c", "b==d", "x!=z"}, true}      // test case 3 (init parameters below: {para1, para2,
                // expected})
        });
    }

    /**=========================== for each test case ============================== */

    /**
     * Parameters for each test (initialized in testcases() method)
     * You can change the type of parameters
     */

    private String[] para1;
    private boolean expected;                    // parameter 4 (expected answer)

    /**
     * This constructor must be provided to run parameterized test.
     */
    public Tester(
            String[] para1,
            boolean expected
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
        boolean actual = solution.equationsPossible(para1);

        assertThat(actual, is(equalTo(expected)));

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("equationsPossible() pass unit test!");
        }
    }

    /**
     * Execute after each test method in this class is executed.
     */
    @After
    public void tearDown() throws Exception {
    }

}
