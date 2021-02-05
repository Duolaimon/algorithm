/**
 * Leetcode - get_equal_substrings_within_budget
 */
package com.duol.leetcode.y21.m2.d5.no1208.get_equal_substrings_within_budget;

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

    /**=========================== static for every test cases ============================== */

    // Solution instance to test
    private static Solution solution;
    // use this Object to print the log (call from slf4j facade)
    private static final Logger LOGGER = LoggerFactory.getLogger(TesterRunner.class);

    /** Execute once before any of the test methods in this class. */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        /* uncomment to switch solutions */
        solution = new Solution1();
        // solution = new Solution2();
    }

    /** Execute once after all of the test methods are executed in this class. */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {}

    /** Initialize test cases */
    @Parameters
    public static Collection<Object[]> testcases() {
        return Arrays.asList(new Object[][]{
             {"ad", "bc", 0, 0},     // test case 1 (init parameters below: {para1, para2, expected})
             {"krrgw", "zjxss", 19, 2},     // test case 2 (init parameters below: {para1, para2, expected})
             {"abcd", "acde", 0, 1}      // test case 3 (init parameters below: {para1, para2, expected})
        });
    }

    /**=========================== for each test case ============================== */

    /** 
     * Parameters for each test (initialized in testcases() method) 
     * You can change the type of parameters
     */
    
    private String para1;
    private String para2;
    private int para3;
    private int expected;                    // parameter 4 (expected answer)

    /** This constructor must be provided to run parameterized test. */
    public Tester(
            String para1,
            String para2,
            int para3,
            int expected
        ) {
           // initialize test parameters
            this.para1 = para1;
            this.para2 = para2;
            this.para3 = para3;
         this.expected = expected;
    }

    /** Execute before each test method in this class is executed. */
    @Before
    public void setUp() throws Exception {}

    /** Executed as a test case. */
    @Test
    public void test() {
        //
        int actual = solution.equalSubstring(para1, para2, para3);
        
        assertThat(actual, is(equalTo(expected)));
        
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("equalSubstring() pass unit test!");
        }
    }

    /** Execute after each test method in this class is executed. */
    @After
    public void tearDown() throws Exception {}

}
