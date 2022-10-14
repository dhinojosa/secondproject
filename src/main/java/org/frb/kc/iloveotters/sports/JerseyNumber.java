package org.frb.kc.iloveotters.sports;

import java.util.Objects;

public class JerseyNumber {
    private String value;

    public JerseyNumber(String value) {
        Objects.requireNonNull(value, "Jersey number cannot be null");
        int num = Integer.parseInt(value);
        if (num < 0 || num > 99)
            throw new IllegalArgumentException("Jersey Number invalid");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JerseyNumber that = (JerseyNumber) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
