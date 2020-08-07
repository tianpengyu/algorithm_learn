package org.baymax.interview.algorithm.DynamicProgramming;

/**
 * 通过求解 斐波那契数列 和 了解 普通递归解法在运行时的 计算过程找到可以优化的地方 进而理解 动态规划
 *
 * 求解方法
 * 1. 简单的递归: solution_1_recursion
 * 2. 记忆化搜索: solution_2_memory_search
 * 3. 动态规划法: solution_3_dp
 *
 *
 * 1. 简单的递归：（）
 *  包含大量的重复计算，为了降低重复计算，可以 设置一个变量保存计算过的 n ，下次再遇到 直接获取即可，这就是得到的第二种解法 - 记忆化搜索
 *
 *
 * 2. 记忆化搜索：（调用次数 2n - 1 次 而不是 n 次）
 *    实际上，是在递归（递归是自上而下地解决问题）的基础上 添加记忆化的过程，换句话说，我们在使用记忆化搜索时，没有从最基本的问题开始解决
 *  相反，我们假设基本问题都解决了 （也就是 假设我们会求 f(n-1）和 f(n-2) 了，自上而下解决问题
 *
 *  一个问题 如果能 自上而下 地解决，那么也就可以 自下而上地解决
 *
 *  自上而下地思考问题 更容易
 *
 *  3. 动态规划法： 自下而上地解决问题 （调用 n 次）
 *
 *  因为没有递归的调用 所以时间和空间 都更节省
 *
 *
 *
 *
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/7 14:28
 */
public class FibonacciSequence {

  public int solution_1_recursion(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1 || n == 2) {
      return 1;
    }

    return solution_1_recursion(n - 1) + solution_1_recursion(n - 2);
  }


  private int[] memo;

  public int solution_2_memory_search(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1 || n == 2) {
      return 1;
    }

    memo = new int [n + 1];

    return memorySearch(n);
  }

  private int memorySearch(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1 || n == 2) {
      return 1;
    }

    if (memo[n] == 0) {
      memo[n] = memorySearch(n-1) + memorySearch(n-2);
    }

    return memo[n];
  }



  public int solution_3_dp(int n) {
    if (n == 0) {
      return 0;
    }

    int [] memo = new int [n + 1];

    memo [0] = 0;
    memo [1] = 1;

    for (int i = 2; i <= n; i++) {
      memo[i] = memo[i - 1] + memo[i - 2];
    }

    return memo[n];
  }


  public static void main(String[] args) {
    FibonacciSequence demo = new FibonacciSequence();

    System.out.println(demo.solution_2_memory_search(4));
    System.out.println(demo.solution_3_dp(4));

  }


}
