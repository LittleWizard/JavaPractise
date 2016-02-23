package generics;


public class Dollar implements Comparable<Dollar> {

    private String country;
    private Integer value;

    public int compareTo(Dollar dollar) {
        if (!getCountry().equals(dollar.getCountry()))
            throw new RuntimeException("Those dollars countries doesn't match");
        if (getValue() - dollar.getValue() > 0)
            return 1;
        if (getValue() - dollar.getValue() < 0)
            return -1;
        return 0;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getValue() + "$";
    }
}
