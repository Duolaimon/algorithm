package code;

/**
 * @Author HeJiageng
 * @Date 2019-06-02
 * @Desc
 */
public class EnumTest {
    public static void main(String[] args) {
        MyEnum my = MyEnum.SUCCESS;
        switch (my) {
            case FAILED:
                System.out.println(-1);
                break;
            case SUCCESS:
                System.out.println(1);
                break;
            default:
                System.out.println(0);
        }
    }

    enum MyEnum {
        SUCCESS(0, "成功"),
        FAILED(-1, "失败");
        int code;
        String result;

        MyEnum(int code, String result) {
            this.code = code;
            this.result = result;
        }
    }
}
