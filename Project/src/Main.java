import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {
	
	
	static double interval=0;
	static int n=0;
	static long costtime;
	static spot[] coordinates= new spot[1000];
	static int[] cos;
	static int xPos;
	static int yPos;
	
	public static void main(String[] args) {
		for(int i=0;i<7;i++) {
			long start = System.currentTimeMillis() ; 
			read("input"+i+".txt");
			interval = 10000;
			permute(0,0);
			System.out.println(interval);
			for(int j=0;j<n;j++) {
				System.out.print(cos[j]+" ");
			}
			System.out.print(cos[0]+" ");
			long end = System.currentTimeMillis(); 
			
         
		}
	}
	public static void swap(int k, int i) {
		spot itmp;
		itmp = coordinates[k];
		coordinates[k] = coordinates[i];
		coordinates[i] = itmp;
}
	public static void permute(int k,double total) {
		if(interval < total) {
			return;
		}
		else if(k == n) {
			total += distanceFrom(k-1,0);
			if(interval > total) {
				interval = total;
			for(int i=0;i<n;i++) 
				cos[i]=coordinates[i].num;
			
		  }
		}else {	
		for(int i=k;i<n;i++) {
			swap(k,i);
			permute(k+1,total+distanceFrom(k-1,k));
			swap(k,i);
		  }
		}
	}
	
	public static void read(String file) {
		 try{
	            Scanner scanner = new Scanner(new File(file));
	            n = scanner.nextInt(); 
	            coordinates = new spot[n];
	            cos = new int[n];
	            for(int j=0;j<n;j++) {
	            	xPos = scanner.nextInt();
	            	yPos = scanner.nextInt();
	            	coordinates[j] = new spot(xPos,yPos,j);
	            }
	            scanner.close();
	        }
		 catch (NullPointerException npe) {
	            // TODO: handle exception
	        }catch(IOException e){
	            System.out.println(e);
	        }
	}
	public static double distanceFrom(int i,int j) {
	if(i==-1) {
		return 0;
	}
		double deltaXSq = coordinates[i].x-coordinates[j].x;
		double deltaYSq = coordinates[i].y-coordinates[j].y;

		double distance = Math.sqrt((Math.pow(deltaXSq, 2) + Math.pow(deltaYSq, 2)));
		
		return distance;
		
	}
	
}



