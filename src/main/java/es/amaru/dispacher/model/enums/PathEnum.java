package es.amaru.dispacher.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum PathEnum {
    EXP("exp"),
    CONQ("conq"),
    CONS("cons"),
    REFX("refx"),
    MINI("mini");

    private String desc;

    private static final Map<String, PathEnum> lookup = new HashMap<>();

    static {
        for (PathEnum p : values()) {
            lookup.put(p.desc.toLowerCase(), p);
        }
    }

    PathEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public static String fromDesc(String desc) {
        PathEnum match = lookup.get(desc.toLowerCase());
        if (match == null) throw new IllegalArgumentException("No enum with desc: " + desc);
        return match.name();
    }
}
