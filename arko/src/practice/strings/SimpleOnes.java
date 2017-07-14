package practice.strings;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import practice.linkedList.Node;

public class SimpleOnes {

	public static void main(String[] args) {
//		LinkedListNode x1 = new LinkedListNode();
//		x1.item =6;
//		LinkedListNode x = new LinkedListNode();
//		x.item =4;
//		x.next = x1;
//		LinkedListNode y1 = new LinkedListNode();
//		y1.item =2;
//		LinkedListNode y = new LinkedListNode();
//		y.item =1;
//		y.next = y1;
//		
//		LinkedListNode res = merge(x,y);
//		while(res!=null){
//			System.out.println(res.item);
//			res = res.next;
//		}
		
		Integer arr[][] =  new Integer[2][2];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.println(arr[i][j]);
			}
		}
		
	}
	
	private static LinkedListNode merge(LinkedListNode x, LinkedListNode y) {
		LinkedListNode xTemp = x;
		LinkedListNode yTemp = y;
		LinkedListNode sumNode = new LinkedListNode();
		sumNode.item = x.item+y.item;
		xTemp = xTemp.next;
		yTemp =yTemp.next;
		LinkedListNode sumNodeTemp = sumNode;
		while(xTemp!=null && yTemp!=null){
			LinkedListNode t = new LinkedListNode();
			t.item =xTemp.item+yTemp.item;
			sumNodeTemp.next = t;
			sumNodeTemp = t;
			xTemp = xTemp.next;
			yTemp = yTemp.next;
		}
		
		xTemp = x;
		sumNodeTemp = sumNode;
		LinkedListNode res = null;
		if(xTemp.item<sumNodeTemp.item){
			res = xTemp;
			xTemp = xTemp.next;
		}
		else{
			res = sumNodeTemp;
			sumNodeTemp = sumNodeTemp.next;
		}
		LinkedListNode resTemp = res;
		while(xTemp!=null && sumNodeTemp!=null){
			if(xTemp.item<sumNodeTemp.item){
				resTemp.next = xTemp;
				xTemp = xTemp.next;
			}
			else{
				resTemp.next = sumNodeTemp;
				sumNodeTemp = sumNodeTemp.next;
			}
			resTemp = resTemp.next;
		}
		resTemp.next = xTemp==null?sumNodeTemp:xTemp;
		
		
		xTemp = res;
		yTemp = y;
		res = null;
		if(xTemp.item<yTemp.item){
			res = xTemp;
			xTemp = xTemp.next;
		}
		else{
			res = yTemp;
			yTemp = yTemp.next;
		}
		resTemp = res;
		while(xTemp!=null && yTemp!=null){
			if(xTemp.item<yTemp.item){
				resTemp.next = xTemp;
				xTemp = xTemp.next;
			}
			else{
				resTemp.next = yTemp;
				yTemp = yTemp.next;
			}
			resTemp = resTemp.next;
		}
		resTemp.next = xTemp==null?yTemp:xTemp;
		return res;
	}

	static class LinkedListNode {
	     int item;
	     LinkedListNode next;
	}
}
