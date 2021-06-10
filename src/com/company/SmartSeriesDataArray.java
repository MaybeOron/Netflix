package com.company;

public class SmartSeriesDataArray {

    // private String seriesName;
    private SeriesDataType[] myArray;
    private int elementCount;

    public SmartSeriesDataArray() {
        this.myArray = new SeriesDataType[0];
        this.elementCount = 0;
    }

    public void insert(SeriesDataType sData) {
        if (elementCount == myArray.length) {
            SeriesDataType[] newArray = new SeriesDataType[(int) Math.floor(myArray.length * 1.5) + 1];
            for (int i = 0; i < myArray.length; i++) {
                newArray[i] = myArray[i];
            }
            myArray = newArray;
        }

        for (int i = 0; i < myArray.length; i++) {

            if (myArray[i] != null) {
                if (myArray[i].getSName().equals(sData.getSName())) {
                    break;
                }
            } else {
                myArray[elementCount] = sData;
                elementCount++;
                break;
            }
        }
    }

    public SeriesDataType getElement(int index) {
        return myArray[index];
    }

    public int getElementCount() {
        return elementCount;
    }

}
