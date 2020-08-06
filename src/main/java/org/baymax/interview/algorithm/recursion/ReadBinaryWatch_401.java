package org.baymax.interview.algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tianpengyu
 * @version 1.0
 * @date 2020/8/6 15:11
 */
public class ReadBinaryWatch_401 {

  public List<String> readBinaryWatch(int num) {
    List<String> res = new ArrayList<>();
    for(int h = 0; h < 12; h++){
      for(int m = 0; m < 60; m++){
        if(getLightNumByNumber(h) + getLightNumByNumber(m) == num){
          StringBuilder time = new StringBuilder();
          time.append(h);
          time.append(":");
          time.append(String.format("%02d", m));
          res.add(time.toString());
        }
      }
    }
    return res;
  }
  public int getLightNumByNumber(int number){
    int lightNum = 0;
    while(number != 0){
      number = number & (number - 1);
      lightNum++;
    }
    return lightNum;
  }

//  private List<String> res;
//
//  public List<String> readBinaryWatch(int num) {
//
//    res = new ArrayList<>();
//
//    if (num < 0 || num >= 10) {
//      return res;
//    }
//
//    if (num == 0) {
//      res.add("0:00");
//      return res;
//    }
//
//    int [] allHours = {1,2,4,8};
//
//    int [] allMinutes = {1,2,4,8,16,32};
//
//    int maxHourNum = Math.min(3, num);
//
//    for (int hourNum = 0; hourNum <= maxHourNum; hourNum++) {
//      int minuteNum = num - hourNum;
//      if (inValid(minuteNum)) {
//        continue;
//      }
//
//      List<Integer> hourResult = new ArrayList<>();
//      findCombinations(hourNum, allHours, 0, 0, hourResult, true, 0);
//
//      List<Integer> minuteResult = new ArrayList<>();
//      findCombinations(minuteNum, allMinutes, 0, 0, minuteResult, false, 0);
//
//      addToRes(hourResult, minuteResult);
//
//    }
//
//    return res;
//  }
//
//  private void addToRes(List<Integer> hourResult, List<Integer> minuteResult) {
//
//    if (hourResult.size() == 0) {
//      hourResult.add(0);
//    }
//
//    if (minuteResult.size() == 0) {
//      minuteResult.add(0);
//    }
//    for (Integer hour : hourResult) {
//      for (Integer minute : minuteResult) {
//        res.add(hour + ":" + String.format("%02d", minute));
//      }
//    }
//  }
//
//  private void findCombinations(int targetNum, int[] arr, int begin, int sum, List<Integer> hourResult, boolean hourFlag, int usedNum) {
//    if (begin >= targetNum) {
//      return;
//    }
//
//    for (int i = begin; i < arr.length; i++) {
//
//      int newSum = sum + arr[i];
//
//      if (hourFlag) {
//        if (newSum > 11) {
//          break;
//        }
//      } else {
//        if (newSum > 59) {
//          break;
//        }
//      }
//
//      if (usedNum + 1 ==targetNum) {
//        hourResult.add(newSum);
//        continue;
//      }
//      findCombinations(targetNum, arr, i + 1, newSum, hourResult, hourFlag, usedNum + 1);
//    }
//
//  }
//
//  private boolean inValid(int minuteNum) {
//    return minuteNum >= 6;
//  }
//
//  public static void main(String[] args) {
//    int num = 5;
//    System.out.println("init num: " + num);
//    int count = 0;
//    while (num != 0) {
//      num = num & (num - 1);
//      count++;
//      System.out.println("第 "+ count +" 次操作后， num: " + num );
//    }
//    System.out.println("end");
//
//  }


}
