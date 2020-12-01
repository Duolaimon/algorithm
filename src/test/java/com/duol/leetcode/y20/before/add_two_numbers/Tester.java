/**
 * Leetcode - add_two_numbers
 */
package com.duol.leetcode.y20.before.add_two_numbers;

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
                {ListNode.newListNode(2, 4, 3), ListNode.newListNode(5, 6, 4), ListNode.newListNode(7, 0, 8)},     // test case 1 (init parameters below: {para1, para2, expected})
                {ListNode.newListNode(2, 4), ListNode.newListNode(5, 6, 4), ListNode.newListNode(7, 0, 5)},     // test case 2 (init parameters below: {para1, para2, expected})
                {ListNode.newListNode(5), ListNode.newListNode(5), ListNode.newListNode(0, 1)}      // test case 3 (init parameters below: {para1, para2, expected})
        });
    }

    /**=========================== for each test case ============================== */

    /**
     * Parameters for each test (initialized in testcases() method)
     * You can change the type of parameters
     */

    private ListNode para1;
    private ListNode para2;
    private ListNode expected;                    // parameter 4 (expected answer)

    /**
     * This constructor must be provided to run parameterized test.
     */
    public Tester(
            ListNode para1,
            ListNode para2,
            ListNode expected
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
        ListNode actual = solution.addTwoNumbers(para1, para2);

        assertThat(actual, is(equalTo(expected)));

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("addTwoNumbers() pass unit test!");
        }
    }

    /**
     * Execute after each test method in this class is executed.
     */
    @After
    public void tearDown() throws Exception {
    }

}
