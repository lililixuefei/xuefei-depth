/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package daily.test;

/**
 * 评估介质枚举
 *
 * @author xinyeguo
 * @created 2020/9/2
 */
public enum AssessmentMediumEnum {
    /** 大纲 */
    OUTLINE(1, "大纲"),
    /** 剧本 */
    SCREENPLAY(2, "剧本"),
    /** 成片 */
    COMPLETE_VIDEO(3, "成片");

    /** 枚举值 */
    private int value;
    /** 枚举描述 */
    private String desc;

    AssessmentMediumEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static AssessmentMediumEnum getEnumByValue(int value) {
        for (AssessmentMediumEnum item : AssessmentMediumEnum.values()) {
            if (value == item.getValue()) {
                return item;
            }
        }
        throw new IllegalArgumentException("评估介质错误");
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}