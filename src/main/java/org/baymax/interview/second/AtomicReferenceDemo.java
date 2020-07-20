package org.baymax.interview.second;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/7/18 18:42
 */
public class AtomicReferenceDemo {

  public static void main(String[] args) {

    User z3 = new User("z3" , 22);
    User li4 = new User("li4", 25);

    AtomicReference<User> atomicUser = new AtomicReference<>();
    atomicUser.set(z3);

    System.out.println(atomicUser.compareAndSet(z3, li4) + "\t" + atomicUser.get().toString());

    System.out.println(atomicUser.compareAndSet(z3, li4) + "\t" + atomicUser.get().toString());


  }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
class User {
  String userName;
  int age;
}