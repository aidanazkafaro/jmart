package com.AidanAzkafaroDesonJmartFH;


/**
 * kelas untuk rating produk
 * @author Aidan Azkafaro Deson
 * @version 1.0
 * @since 18 Desember 2021
 */
public class ProductRating
{
    // instance variables - replace the example below with your own
    private long total;
    private long count;

    /**
     * Constructor untuk object dari kelas ProductRating
     */
    public ProductRating()
    {
        // initialise instance variables
        this.total = 0;
        this.count = 0;
    }

    /**
     * memasukkan nilai rating ke produk
     * @param rating
     */
    public void insert(int rating)
    {
        // put your code here
        this.total = total + rating;
        this.count = count + 1;
    }
    
    /**
     * mengembalikan rata-rata rating (total rating dibagi jumlah produk)
     * @return
     */
    public double getAverage()
    {
        if(count == 0)
        {
            return 0.0;
        }
        return (double)(total/count);
    }
    
    public long getCount()
    {
        return count;
    }

    public long getTotal()
    {
        return total;
    }
}
