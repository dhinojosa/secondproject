package org.frb.kc.iloveotters.sports;

public class JerseyNumber {
    private String value;

    public JerseyNumber(String value) {
        int num = Integer.parseInt(value);
        if (num < 0 || num > 99)
            throw new IllegalArgumentException("Jersey Number invalid");
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
