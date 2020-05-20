package threadlocal;

/**
 * ThreadLocal用法2：避免传递参数的麻烦
 *
 * 无需synchrnzied，可以在不影响性能的情况下
 * 也无需传递参数，就可达到保存当前线程对应的用户信息的目的
 */
public class ThreadLocalNormalUsage06 {


    public static void main(String[] args) {
        new Service1().process();
    }


}


class Service1 {
    public void process(){
        User user = new User("超哥");
        UserContextHolder.holder.set(user);
        new Service2().process();
    }
}
class Service2 {
    public void process(){
        System.out.println("Service2：" + UserContextHolder.holder.get().name);
        new Service3().process();
    }
}
class Service3 {
    public void process(){
        System.out.println("Service3：" + UserContextHolder.holder.get().name);
    }
}

class UserContextHolder {
    public static ThreadLocal<User> holder  = new ThreadLocal<>();

}


class User {
    String name;

    public User(String name) {
        this.name = name;
    }
}