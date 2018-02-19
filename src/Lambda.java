public class Lambda {
    public static void main(String[] args) {
        Run<String> rs = () -> "Hello";
        Run<Integer> ri = () -> 2;
        System.out.println(rs.run()+"\n"+ri.run());
    }
}

@FunctionalInterface
interface Run<R> {
    R run();
}