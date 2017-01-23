package com.someyahtzee.www.yahtzee;

import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;
/**
 *  Program that rolls dice for Yahtzee on android.
 * */

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    int i = 0;
    ImageView i_1, i_2, i_3, i_4, i_5, i_6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button)this.findViewById(R.id.Roll);
        b.setOnClickListener(this);
    }

    /**
     *  Calls the roll  method when the button is clicked.
     * */


    public void onClick(View v)
    {
       roll();
    }

    /**
     *  Generates random numbers and displays the dice with those numbers.
     * */


    public void roll()
    {
        Random rand = new Random();
        int[] number = new int[5];

        i_1 = (ImageView)findViewById(R.id.one_side);
        i_2 = (ImageView)findViewById(R.id.two_side);
        i_3 = (ImageView)findViewById(R.id.three_side);
        i_4 = (ImageView)findViewById(R.id.four_side);
        i_5 = (ImageView)findViewById(R.id.five_side);
        i_6 = (ImageView)findViewById(R.id.six_side);

        i_1.setVisibility(View.INVISIBLE);
        i_2.setVisibility(View.INVISIBLE);
        i_3.setVisibility(View.INVISIBLE);
        i_4.setVisibility(View.INVISIBLE);
        i_5.setVisibility(View.INVISIBLE);
        i_6.setVisibility(View.INVISIBLE);

        for(i = 0; i < 5; i++)
        {
            number[i] = rand.nextInt((6 - 1) + 1) + 1;

            System.out.println(number[i]);

            if(number[i] == 1)
            {
                i_1.setVisibility(View.VISIBLE);
            }
            if(number[i] == 2)
            {
                i_2.setVisibility(View.VISIBLE);
            }
            if(number[i] == 3)
            {
                i_3.setVisibility(View.VISIBLE);
            }
            if(number[i] == 4)
            {
                i_4.setVisibility(View.VISIBLE);
            }
            if(number[i] == 5)
            {
                i_5.setVisibility(View.VISIBLE);
            }
            if(number[i] == 6)
            {
                i_6.setVisibility(View.VISIBLE);
            }
        }
    }

}
