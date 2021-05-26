package utils;


import java.util.HashMap;
import java.util.Map;

public enum ConstEnum {
    LOAD_TIMEOUT(30),
    BASIC_WAIT_TIME_IN_SECONDS(60),
    REFRESH_RATE(2);

    private int value;
    private static Map<Integer, ConstEnum> map = new HashMap<>();

    private ConstEnum(int value) {
        this.value = value;
    }

    static {
        for (ConstEnum constant : ConstEnum.values()) {
            map.put(constant.value, constant);
        }
    }

    public static ConstEnum valueOf(int constant) {
        return (ConstEnum) map.get(constant);
    }

    public int getValue() {
        return value;
    }

}
