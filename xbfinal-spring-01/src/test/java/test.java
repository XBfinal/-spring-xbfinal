import org.junit.Test;

/**
 * @version 1.0
 * @Author 笑霸final
 * @Date 2023/10/12 15:44
 * @注释
 */
public class test {
    @Test
    public void test(){
        String name = "UserService.class";
        String[] split = name.split("\\.");

        for (String s : split) {
            System.out.println(s);
        }
    }
}
