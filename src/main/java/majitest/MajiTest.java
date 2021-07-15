package majitest;

import java.util.Objects;

public class MajiTest {
    public static void main(String[] args) {

        String sql = "233";
        String countSql = "select count(0) from (" + sql + ") as total";
        String countSql2 = new StringBuilder().append("select count(0) from (").append(sql).append(") as total").toString();
        System.out.println(Objects.equals(countSql, countSql2));
    }

}
