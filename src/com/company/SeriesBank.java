package com.company;
public class SeriesBank {

    private final static Episode[] peleg1Eps = {
            new Episode("P11", "The Start of PELEG", "01/01/2021"),
            new Episode("P12", "The Middle of PELEG", "01/02/2021"),
            new Episode("P13", "The End of PELEG", "01/03/2021")
    };
    private final static Episode[] peleg2Eps = {
            new Episode("P21", "The Start of PELEG", "01/04/2021"),
            new Episode("P22", "The Middle of PELEG", "01/05/2021"),
            new Episode("P23", "The End of PELEG", "01/06/2021")
    };
    private final static Episode[] peleg3Eps = {
            new Episode("P31", "The Start of PELEG", "01/07/2021"),
            new Episode("P32", "The Middle of PELEG", "01/08/2021"),
            new Episode("P33", "The End of PELEG", "01/09/2021")
    };

    private final static Series peleg1 = new Series("Peleg1", peleg1Eps);
    private final static Series peleg2 = new Series("Peleg2", peleg2Eps);
    private final static Series peleg3 = new Series("Peleg3", peleg3Eps);


     private final static Series[] seriesBank = {peleg1, peleg2, peleg3};

     public static Series[] getSeriesBank(){
         return seriesBank;
     }

}
