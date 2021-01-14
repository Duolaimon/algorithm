/**
 * Leetcode - binary_prefix_divisible_by_5
 */
package com.duol.leetcode.y21.m1.d14.no1018.binary_prefix_divisible_by_5;

import java.util.*;
import com.duol.common.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.duol.util.ArrayUtil;
import com.google.common.collect.Lists;
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
             {ArrayUtil.newOneIntArray("[0,1,1]"), Lists.newArrayList(true,false,false)},     // test case 1 (init parameters below: {para1,
                // para2, expected})
             {ArrayUtil.newOneIntArray("[1,1,1]"), Lists.newArrayList(false,false,false)},     // test case 2 (init
                // parameters below: {para1, para2, expected})
             {ArrayUtil.newOneIntArray("[0,1,1,1,1,1]"), Lists.newArrayList(true,false,false,false,true,false)}      // test case 3 (init parameters below: {para1, para2, expected})
        });
    }

    /**=========================== for each test case ============================== */

    /** 
     * Parameters for each test (initialized in testcases() method) 
     * You can change the type of parameters
     */
    
    private int[] para1;
    private List<Boolean> expected;                    // parameter 4 (expected answer)

    /** This constructor must be provided to run parameterized test. */
    public Tester(
            int[] para1,
            List<Boolean> expected
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
        List<Boolean> actual = solution.prefixesDivBy5(para1);
        
        assertThat(actual, is(equalTo(expected)));
        
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("prefixesDivBy5() pass unit test!");
        }
    }

    /** Execute after each test method in this class is executed. */
    @After
    public void tearDown() throws Exception {}

}
