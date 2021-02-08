/**
 * Leetcode - longest_turbulent_subarray
 */
package com.duol.leetcode.y21.m2.d8.no978.longest_turbulent_subarray;

import java.util.*;
import com.duol.common.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.duol.util.ArrayUtil;
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
             {ArrayUtil.newOneIntArray("[9,4,2,10,7,8,8,1,9]"), 5},     // test case 1 (init parameters below: {para1,
                // para2, expected})
             {ArrayUtil.newOneIntArray("[0,1,1,0,1,0,1,1,0,0]"), 5},     // test case 2 (init parameters below:
                // {para1, para2,
                // expected})
             {ArrayUtil.newOneIntArray("[30,100,100,100,100]"), 2}      // test case 3 (init parameters below:
                // {para1,
                // para2,
                // expected})
        });
    }

    /**=========================== for each test case ============================== */

    /** 
     * Parameters for each test (initialized in testcases() method) 
     * You can change the type of parameters
     */
    
    private int[] para1;
    private int expected;                    // parameter 4 (expected answer)

    /** This constructor must be provided to run parameterized test. */
    public Tester(
            int[] para1,
            int expected
        ) {
           // initialize test parameters
            this.para1 = para1;
         this.expected = expected;
    }

    /** Execute before each test method in this class is executed. */
    @Before
    public void setUp() throws Exception {}

    /** Executed as a test case. */
    @Test
    public void test() {
        //
        int actual = solution.maxTurbulenceSize(para1);
        
        assertThat(actual, is(equalTo(expected)));
        
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("maxTurbulenceSize() pass unit test!");
        }
    }

    /** Execute after each test method in this class is executed. */
    @After
    public void tearDown() throws Exception {}

}
