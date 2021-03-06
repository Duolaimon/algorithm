package com.duol.leetcode.y21.m3.d19.no1603.design_parking_system;

/**
 * 1603. 设计停车系统
 * <p>
 * 请你给一个停车场设计一个停车系统。停车场总共有三种不同大小的车位：大，中和小，每种尺寸分别有固定数目的车位。
 * <p>
 * 请你实现ParkingSystem类：
 * <p>
 * ParkingSystem(int big, int medium, int small)初始化ParkingSystem类，三个参数分别对应每种停车位的数目。
 * bool addCar(int carType)检查是否有carType对应的停车位。carType有三种类型：大，中，小，分别用数字1，2和3表示。
 * 一辆车只能停在carType对应尺寸的停车位中。如果没有空车位，请返回false，否则将该车停入车位并返回true。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
 * [[1, 1, 0], [1], [2], [3], [1]]
 * 输出：
 * [null, true, true, false, false]
 * <p>
 * 解释：
 * ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
 * parkingSystem.addCar(1); // 返回 true ，因为有 1 个空的大车位
 * parkingSystem.addCar(2); // 返回 true ，因为有 1 个空的中车位
 * parkingSystem.addCar(3); // 返回 false ，因为没有空的小车位
 * parkingSystem.addCar(1); // 返回 false ，因为没有空的大车位，唯一一个大车位已经被占据了
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= big, medium, small <= 1000
 * carType取值为1，2或3
 * 最多会调用addCar函数1000次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-parking-system
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ParkingSystem {
    private int bigCount;
    private int mediumCount;
    private int smallCount;

    public ParkingSystem(int big, int medium, int small) {
        this.bigCount = big;
        this.mediumCount = medium;
        this.smallCount = small;
    }

    public boolean addCar(int carType) {
        if (carType == 3) {
            if (smallCount > 0) {
                smallCount--;
                return true;
            } else {
                return false;
            }
        }
        if (carType == 2) {
            if (mediumCount > 0) {
                mediumCount--;
                return true;
            } else {
                return false;
            }
        }
        if (carType == 1) {
            if (bigCount > 0) {
                bigCount--;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
