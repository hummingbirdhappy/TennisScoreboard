package com.example.android.tennisscoreboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.tennisscoreboard.R;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int scorePlayer1 = 0;
    int scorePlayer2 = 0;
    int setScorePlayer1 = 0;
    int setScorePlayer2 = 0;
    int setNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if((savedInstanceState != null)) {
            // if it was not null retrieve stored int variable and set it again for team 1 and team 2.
            scorePlayer1 = savedInstanceState.getInt("scorePlayer1");
            scorePlayer2 = savedInstanceState.getInt("scorePlayer2");
            setScorePlayer1 = savedInstanceState.getInt("setScorePlayer1");
            setScorePlayer2 = savedInstanceState.getInt("setScorePlayer2");
            setNumber = savedInstanceState.getInt("setNumber");
        }
        setContentView(R.layout.activity_main);
        // display initial or current scores
        displayForPlayer1(scorePlayer1);
        displayForPlayer2(scorePlayer2);
        // display initial or current set scores
        displayPlayer1SetScore(setScorePlayer1);
        displayPlayer2SetScore(setScorePlayer2);

    }
    /*
    *Save UI state changes to the savedInstanceState.
    *This bundle will be passed to onCreate if the process is
    * killed and restarted.
    */
    @Override
    protected void onSaveInstanceState(Bundle vars){
        super.onSaveInstanceState(vars);
        vars.putInt("scorePlayer1",scorePlayer1);
        vars.putInt("scorePlayer2",scorePlayer2);
        vars.putInt("setScorePlayer1",setScorePlayer1);
        vars.putInt("setScorePlayer2",setScorePlayer2);
        vars.putInt("setNumber",setNumber);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForPlayer1(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player1_score);
        scoreView.setText(String.format("%02d", score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForPlayer2(int score) {
        TextView scoreView = (TextView) findViewById(R.id.player2_score);
        scoreView.setText(String.format("%02d", score));
    }

    /*
    * This method displays Advantage for Player 1.
     */
    public void displayAdPlayer1() {
        TextView scoreView1 = (TextView) findViewById(R.id.player1_score);
        scoreView1.setText("AD");
        TextView scoreView2 = (TextView) findViewById(R.id.player2_score);
        scoreView2.setText("");
    }

    /*
    * This method displays Advantage for Player 1.
     */
    public void displayAdPlayer2() {
        TextView scoreView1 = (TextView) findViewById(R.id.player1_score);
        scoreView1.setText("");
        TextView scoreView2 = (TextView) findViewById(R.id.player2_score);
        scoreView2.setText("AD");
    }
    /*
    * This method displays the new set score for Player 1.
     */
    public void displayPlayer1SetScore(int score) {
        if (setNumber==1) {
            TextView scoreView = (TextView) findViewById(R.id.player1_set1_score);
            scoreView.setText(String.format(String.valueOf(score)));
        }
        if (setNumber==2) {
            TextView scoreView = (TextView) findViewById(R.id.player1_set2_score);
            scoreView.setText(String.format(String.valueOf(score)));
        }
        if (setNumber==3) {
            TextView scoreView = (TextView) findViewById(R.id.player1_set3_score);
            scoreView.setText(String.format(String.valueOf(score)));
        }
        if (setNumber==4) {
            TextView scoreView = (TextView) findViewById(R.id.player1_set4_score);
            scoreView.setText(String.format(String.valueOf(score)));
        }
        if (setNumber==5) {
            TextView scoreView = (TextView) findViewById(R.id.player1_set5_score);
            scoreView.setText(String.format(String.valueOf(score)));
        }
    }

    /*
    * This method displays the new set score for Player 1.
     */
    public void displayPlayer2SetScore(int score) {
        if (setNumber==1) {
            TextView scoreView = (TextView) findViewById(R.id.player2_set1_score);
            scoreView.setText(String.format(String.valueOf(score)));
        }
        if (setNumber==2) {
            TextView scoreView = (TextView) findViewById(R.id.player2_set2_score);
            scoreView.setText(String.format(String.valueOf(score)));
        }
        if (setNumber==3) {
            TextView scoreView = (TextView) findViewById(R.id.player2_set3_score);
            scoreView.setText(String.format(String.valueOf(score)));
        }
        if (setNumber==4) {
            TextView scoreView = (TextView) findViewById(R.id.player2_set4_score);
            scoreView.setText(String.format(String.valueOf(score)));
        }
        if (setNumber==5) {
            TextView scoreView = (TextView) findViewById(R.id.player2_set5_score);
            scoreView.setText(String.format(String.valueOf(score)));
        }
    }
    /**
     * This method increases the score of Player 1 by 1 point.
     */
    public void addPointPlayer1(View view) {
        if (scorePlayer1<30) {
            scorePlayer1 = scorePlayer1 + 15;
            displayForPlayer1(scorePlayer1);
        }
        else if (scorePlayer1==30) {
            scorePlayer1 = scorePlayer1 + 10;
            displayForPlayer1(scorePlayer1);
        }
        else if (scorePlayer1==40 && scorePlayer2<40) {
            testSetNumber();
            setScorePlayer1 = setScorePlayer1 + 1;
            displayPlayer1SetScore(setScorePlayer1);
            scorePlayer1 = 0;
            scorePlayer2 = 0;
            displayForPlayer1(scorePlayer1);
            displayForPlayer2(scorePlayer2);
        }
        else if (scorePlayer1==40 && scorePlayer2==40)  {
            scorePlayer1 = scorePlayer1 + 1;
            displayAdPlayer1();
        }
        else if (scorePlayer1==41 && scorePlayer2==40)  {
            testSetNumber();
            setScorePlayer1 = setScorePlayer1 + 1;
            displayPlayer1SetScore(setScorePlayer1);
            scorePlayer1 = 0;
            scorePlayer2 = 0;
            displayForPlayer1(scorePlayer1);
            displayForPlayer2(scorePlayer2);
        }
        else if (scorePlayer1==40 && scorePlayer2==41)  {
            scorePlayer2 = scorePlayer2 - 1;
            displayForPlayer1(scorePlayer1);
            displayForPlayer2(scorePlayer2);
        }
    }

    /**
     * This method decreases the score of Player 1 by 1 point.
     */
    public void subtractPointPlayer1(View view){
        if (scorePlayer1<=0){
            scorePlayer1 = 0;
            displayForPlayer1(scorePlayer1);
        }
        else if (scorePlayer1 > 0 && scorePlayer1<=30){
            scorePlayer1 = scorePlayer1 - 15;
            displayForPlayer1(scorePlayer1);
        }
        else if (scorePlayer1==40){
            scorePlayer1 = scorePlayer1 - 10;
            displayForPlayer1(scorePlayer1);
        }
        else if (scorePlayer1==41){
            scorePlayer1 = scorePlayer1 - 1;
            displayForPlayer1(scorePlayer1);
            displayForPlayer2(scorePlayer2);
        }
    }

    /**
     * This method increases the score of Player 2 by 1 point.
     */
    public void addPointPlayer2(View view) {
        if (scorePlayer2<30) {
            scorePlayer2 = scorePlayer2 + 15;
            displayForPlayer2(scorePlayer2);
        }
        else if (scorePlayer2==30) {
            scorePlayer2 = scorePlayer2 + 10;
            displayForPlayer2(scorePlayer2);
        }
        else if (scorePlayer2==40 && scorePlayer1<40) {
            testSetNumber();
            setScorePlayer2 = setScorePlayer2 + 1;
            displayPlayer2SetScore(setScorePlayer2);
            scorePlayer1 = 0;
            scorePlayer2 = 0;
            displayForPlayer1(scorePlayer1);
            displayForPlayer2(scorePlayer2);
        }
        else if (scorePlayer1==40 && scorePlayer2==40)  {
            scorePlayer2 = scorePlayer2 + 1;
            displayAdPlayer2();
        }
        else if (scorePlayer1==40 && scorePlayer2==41)  {
            testSetNumber();
            setScorePlayer2 = setScorePlayer2 + 1;
            displayPlayer2SetScore(setScorePlayer2);
            scorePlayer1 = 0;
            scorePlayer2 = 0;
            displayForPlayer1(scorePlayer1);
            displayForPlayer2(scorePlayer2);
        }
        else if (scorePlayer1==41 && scorePlayer2==40)  {
            scorePlayer1 = scorePlayer1 - 1;
            displayForPlayer1(scorePlayer1);
            displayForPlayer2(scorePlayer2);
        }
    }

    /**
     * This method decreases the score of Player 2 by 1 point.
     */
    public void subtractPointPlayer2(View view){
        if (scorePlayer2<=0){
            scorePlayer2 = 0;
            displayForPlayer2(scorePlayer2);
        }
        else if (scorePlayer2 > 0 && scorePlayer2<=30){
            scorePlayer2 = scorePlayer2 - 15;
            displayForPlayer2(scorePlayer2);
        }
        else if (scorePlayer2==40){
            scorePlayer2 = scorePlayer2 - 10;
            displayForPlayer2(scorePlayer2);
        }
        else if (scorePlayer2==41){
            scorePlayer2 = scorePlayer2 - 1;
            displayForPlayer1(scorePlayer1);
            displayForPlayer2(scorePlayer2);
        }
    }

    public void testSetNumber(){
        if ((setScorePlayer1==6 && setScorePlayer1 - setScorePlayer2>=2) ||
                (setScorePlayer2==6 && setScorePlayer2 - setScorePlayer1>=2)){
            setNumber = setNumber + 1;
            setScorePlayer1 = 0;
            setScorePlayer2 = 0;
        }
        else if ((setScorePlayer1==7 && setScorePlayer1 - setScorePlayer2<=2) ||
                (setScorePlayer2==7 && setScorePlayer2 - setScorePlayer1<=2)) {
            setNumber = setNumber + 1;
            setScorePlayer1 = 0;
            setScorePlayer2 = 0;
        }
    }

    public void resetMatchScore(View view){
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        displayForPlayer1(scorePlayer1);
        displayForPlayer2(scorePlayer2);
        for (int x = 1; x <= 5; x++){
            setNumber = x;
            setScorePlayer1 = 0;
            setScorePlayer2 = 0;
            displayPlayer1SetScore(setScorePlayer1);
            displayPlayer2SetScore(setScorePlayer2);
        }
        setNumber = 1;
    }
}
