package com.company;

public class SmartUsersArray {

    private NetflixUser[] myArray;
    private int elementCount;

    public SmartUsersArray() {
        this.myArray = new NetflixUser[0];
        this.elementCount = 0;
    }

    public void insert(NetflixUser user) {
        if (elementCount == myArray.length) {
            NetflixUser[] newArray = new NetflixUser[(int) Math.floor(myArray.length * 1.5) + 1];
            for (int i = 0; i < myArray.length; i++) {
                newArray[i] = myArray[i];
            }
            myArray = newArray;
        }
        myArray[elementCount] = user;
        elementCount++;
    }

    public NetflixUser getElement(int index) {
        return myArray[index];
    }

    public int getElementCount() {
        return elementCount;
    }

}
