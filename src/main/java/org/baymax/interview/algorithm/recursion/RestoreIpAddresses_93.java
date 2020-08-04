package org.baymax.interview.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/4 09:50
 */
public class RestoreIpAddresses_93 {
  private List<String> res;
  private String dot = ".";

  public List<String> restoreIpAddresses(String s) {
    if (s == null || s.length() < 4 || s.length() > 12) {
      return new ArrayList<>();
    }

    res = new ArrayList<>();
    List<Integer> dotIndexArr = new ArrayList<>();

    findIp(s, dotIndexArr);

    return res;
  }

  private void findIp(String s, List<Integer> dotIndexArray) {
    if (dotIndexArray.size() == 3) {
      StringBuilder processed = getIps(s, dotIndexArray);
      System.out.println("已经添加了 3 个 dot, 获取到的 待检测："+processed.toString());
      // 这里 不能 split(dot) 应该是 split("\\.") . 前者得到的是 空 数组
      if (isValid(processed.toString().split("\\."))) {
        System.out.println("找到了一组合法的ip: " + processed.toString() + ", dotIndex:" + dotIndexArray);
        res.add(processed.toString());
      }
      return;
    }
    int lastDotIndex = 0;
    if (dotIndexArray.size() != 0) {
      lastDotIndex = dotIndexArray.get(dotIndexArray.size() - 1);
    }

    // 第一次写 第一个 dot 没有进行遍历 补了上面的代码
    for (int i = lastDotIndex + 1; i < s.length(); i++) {
      dotIndexArray.add(i);
      System.out.println("正在添加第 " + dotIndexArray.size() + " 个 dot, 位置：" + i);
      findIp(s, dotIndexArray);
      dotIndexArray.remove(dotIndexArray.size()-1);
    }


  }

  private StringBuilder getIps(String s, List<Integer> dotIndexArray) {
    StringBuilder sb = new StringBuilder(s);
    for (int i = dotIndexArray.size() -1; i >=0; i--) {
      sb.insert(dotIndexArray.get(i),dot);
    }
    return sb;
  }

  private boolean isValid(String[] ips) {
    if (ips == null || ips.length != 4) {
      return false;
    }
    for (int i = 0; i <= 3; i++) {
      if (!isValidIpNumber(ips[i])) {
        return false;
      }
    }
    return true;
  }

  private boolean isValidIpNumber(String ipNumberStr) {
    // 大于一位时，不可以 以0开头
    if (ipNumberStr.length() > 1 && ipNumberStr.startsWith("0")) {
      return false;
    }
    int ipNumber = Integer.valueOf(ipNumberStr).intValue();

    return ipNumber >= 0 && ipNumber <= 255;
  }

  public static void main(String[] args) {
    String s = "25525511135";
    StringBuilder sb = new StringBuilder(s);
    sb.insert(1,".");
    System.out.println(sb.toString());
    RestoreIpAddresses_93 demo = new RestoreIpAddresses_93();
    List<String> res = demo.restoreIpAddresses(s);
    System.out.println(res);
  }

}

