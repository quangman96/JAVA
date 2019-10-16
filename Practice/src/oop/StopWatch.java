package oop;

import array.Function;

public class StopWatch {
    private long starTime;
    private long endTime;

    public StopWatch() {
    }

    public void setStar(long starTime) {
        this.starTime = starTime;
    }

    public void setStop(long endTime) {
        this.endTime = endTime;
    }

    public long getStarTime() {
        return this.starTime;
    }

    public long getEndTime() {
        return this.endTime;
    }
    public void starTime() {
        long now = System.currentTimeMillis();
        setStar(now);
    }
    public void endTime() {
        long now = System.currentTimeMillis();
        setStop(now);
    }
    public long getElapsedTime() {
        return this.endTime - this.starTime;
    }

    public static void main(String[] args) {
        int[]arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random()*100);
        }
    
    //selection Sort
        int minIndex=0,temp;
        for (int i=0; i <arr.length-1; i++) {
            minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[minIndex])
                    minIndex = j;

                temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
            }
        Function.show(arr);
        }

        }




