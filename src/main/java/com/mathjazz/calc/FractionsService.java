package com.mathjazz.calc;

import org.springframework.stereotype.Service;

@Service
public class FractionsService {
    
    int wholeNumber, numerator, denominator, NWW, temp;
    String myError=null;
            
    public int nwd(int m, int n) {
              while (m!=n) {
                if (m>n)
                    m-=n;
                else
                    n-=m;
                }
        return m;
    }
    
    public int nww(int m, int n) {
        return (m*n)/nwd(m, n);
    }
    
    public void shorten(int num, int den) {
        if (nwd(num, den)>1) {
            temp=nwd(num, den);
            this.numerator=num/temp;
            this.denominator=den/temp;
        }
    }
       
    public void doMixedNumber(int whole, int num, int den) {
        if (num==den) {
            whole+=1;
            num=0;
        }    
        else {
            whole+=num/den;
            num%=den;
        }
        this.numerator=num;
        this.wholeNumber=whole;
    }
    
    public String add(int a, int b, int c, int x, int y, int z) {
        if (c!=0 && z!=0) {
            wholeNumber=a+x;
            NWW=nww(c, z);
            b*=NWW/c;
            y*=NWW/z;

            numerator=b + y;
            denominator=NWW;

            if (nwd(numerator, denominator)>1)
                shorten(numerator, denominator);


            if (numerator>=denominator) 
                doMixedNumber(wholeNumber, numerator, denominator);

            this.wholeNumber=wholeNumber;
            this.numerator=numerator;
            this.denominator=denominator;
            myError=null;
            
        }
        else {myError="Mianownik nie może być zerem!";}
        
        return myError;
    }
        
    public String subtract(int a, int b, int c, int x, int y, int z) {
        if (c!=0 && z!=0) {
            b=c*a+b;
            y=z*x+y;
            NWW=nww(c, z);
            b*=NWW/c;
            y*=NWW/z;
            wholeNumber=0;
            numerator=b-y;
            denominator=NWW;

            if (nwd(numerator, denominator)>1)
                shorten(numerator, denominator);

            if (numerator>=denominator) 
                doMixedNumber(wholeNumber, numerator, denominator);

            this.wholeNumber=wholeNumber;
            this.numerator=numerator;
            this.denominator=denominator;
            myError=null;
        }
        else {myError="Mianownik nie może być zerem!";}
        
        return myError;
    }
    
    public String multiply(int a, int b, int c, int x, int y, int z) {
        if (c!=0 && z!=0) {
            b=c*a+b;
            y=z*x+y;
            numerator=b*y;
            denominator=c*z;
            wholeNumber=0;

            if (nwd(numerator, denominator)>1)
                shorten(numerator, denominator);

            if (numerator>=denominator) 
                doMixedNumber(wholeNumber, numerator, denominator);

            this.wholeNumber=wholeNumber;
            this.numerator=numerator;
            this.denominator=denominator;
            myError=null;
        }
        else {myError="Mianownik nie może być zerem!";}
        
        return myError;
    }
        
    public String division(int a, int b, int c, int x, int y, int z) {
        if (c!=0 && z!=0) {
            b=c*a+b;
            y=z*x+y;
            numerator=b*z;
            denominator=c*y;
            wholeNumber=0;

            if (nwd(numerator, denominator)>1)
                shorten(numerator, denominator);


            if (numerator>=denominator) 
                doMixedNumber(wholeNumber, numerator, denominator);

            this.wholeNumber=wholeNumber;
            this.numerator=numerator;
            this.denominator=denominator;
            myError=null;
        }
        else {myError="Mianownik nie może być zerem!";}
        
        return myError;
    }
    
    public void calculate(int a, int b, int c, int x, int y, int z, String operation) {
        switch(operation) {
            case "+":
                add(a, b, c, x, y, z);
            case "-":
                subtract(a, b, c, x, y, z);
            case "*":
                multiply(a, b, c, x, y, z);
            case "/":
                division(a, b, c, x, y, z);
            
                
       }
        throw new IllegalArgumentException("Nieznana operacja: " +operation);
        
    }   
}

