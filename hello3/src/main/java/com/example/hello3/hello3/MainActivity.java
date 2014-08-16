package com.example.hello3.hello3;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    public static final String EXTRA_MESSAGE = "com.example.hello3.MESSAGE";
    public boolean show = true;
    private GestureDetectorCompat mDetector;

    private int[] order = {190,120,75};
    private ImageView[][] current = new ImageView[4][4];
    private int[][] colorStates = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            super.setContentView(R.layout.activity_main);

            current[0][0] = (ImageView)(findViewById(R.id.button00));
            current[0][1] = (ImageView)(findViewById(R.id.button01));
            current[0][2] = (ImageView)(findViewById(R.id.button02));
            current[0][3] = (ImageView)(findViewById(R.id.button03));
            current[1][0] = (ImageView)(findViewById(R.id.button10));
            current[1][1] = (ImageView)(findViewById(R.id.button11));
            current[1][2] = (ImageView)(findViewById(R.id.button12));
            current[1][3] = (ImageView)(findViewById(R.id.button13));
            current[2][0] = (ImageView)(findViewById(R.id.button20));
            current[2][1] = (ImageView)(findViewById(R.id.button21));
            current[2][2] = (ImageView)(findViewById(R.id.button22));
            current[2][3] = (ImageView)(findViewById(R.id.button23));
            current[3][0] = (ImageView)(findViewById(R.id.button30));
            current[3][1] = (ImageView)(findViewById(R.id.button31));
            current[3][2] = (ImageView)(findViewById(R.id.button32));
            current[3][3] = (ImageView)(findViewById(R.id.button33));
        }

        public int[] findCoor(ImageView v){
            for(int i = 0; i<4; i++){
                for(int j = 0; j<4; j++){
                    if(current[i][j].equals(v)){
                        return new int[] {i,j};
                    }
                }
            }

            return new int[] {0,0};
        }

        public void onClick(View view) {
            ((Button) view).setText("*");
            ((Button) view).setEnabled(false);
        }

    public void clickImage(View view){
        if(view instanceof ImageView){
            ((ImageView) view).setColorFilter(Color.argb(255,order[2],order[2],order[2]));
            int[] coor = findCoor((ImageView) view);
            int col = 0;
            if(colorStates[coor[0]][coor[1]] < 2) {
                if (coor[0] + 1 < 4) {
                    if(colorStates[coor[0] + 1][coor[1]] < 2) {
                        colorStates[coor[0] + 1][coor[1]]++;
                        col = colorStates[coor[0] + 1][coor[1]];
                    }else{
                        colorStates[coor[0] + 1][coor[1]] = 0;
                        col = colorStates[coor[0] + 1][coor[1]];
                    }
                    current[coor[0] + 1][coor[1]].setColorFilter(Color.argb(255, order[col], order[col], order[col]));
                }

                if (coor[0] - 1 >= 0) {
                    if(colorStates[coor[0] - 1][coor[1]] < 2) {
                        colorStates[coor[0] - 1][coor[1]]++;
                        col = colorStates[coor[0] - 1][coor[1]];
                    }else{
                        colorStates[coor[0] - 1][coor[1]] = 0;
                        col = colorStates[coor[0] - 1][coor[1]];
                    }
                    current[coor[0] - 1][coor[1]].setColorFilter(Color.argb(255, order[col], order[col], order[col]));
                }

                if (coor[1] + 1 < 4) {
                    if(colorStates[coor[0]][coor[1] + 1] < 2) {
                        colorStates[coor[0]][coor[1] + 1]++;
                        col = colorStates[coor[0]][coor[1] + 1];
                    }else{
                        colorStates[coor[0]][coor[1] + 1] = 0;
                        col = colorStates[coor[0]][coor[1] + 1];
                    }
                    current[coor[0]][coor[1] + 1].setColorFilter(Color.argb(255, order[col], order[col], order[col]));
                }

                if (coor[1] - 1 >= 0){
                    if(colorStates[coor[0]][coor[1] - 1] < 2) {
                        colorStates[coor[0]][coor[1] - 1]++;
                        col = colorStates[coor[0]][coor[1] - 1];
                    }else{
                        colorStates[coor[0]][coor[1] - 1] = 0;
                        col = colorStates[coor[0]][coor[1] - 1];
                    }
                    current[coor[0]][coor[1] - 1].setColorFilter(Color.argb(255, order[col], order[col], order[col]));
                }
                colorStates[coor[0]][coor[1]] = 2;
            }else{
                ((ImageView) view).setColorFilter(Color.argb(255,order[0],order[0],order[0]));
                if (coor[0] + 1 < 4) {
                    if(colorStates[coor[0] + 1][coor[1]] < 2) {
                        colorStates[coor[0] + 1][coor[1]]++;
                        col = colorStates[coor[0] + 1][coor[1]];
                    }else{
                        colorStates[coor[0] + 1][coor[1]] = 0;
                        col = colorStates[coor[0] + 1][coor[1]];
                    }
                    current[coor[0] + 1][coor[1]].setColorFilter(Color.argb(255, order[col], order[col], order[col]));
                }

                if (coor[0] - 1 >= 0) {
                    if(colorStates[coor[0] - 1][coor[1]] < 2) {
                        colorStates[coor[0] - 1][coor[1]]++;
                        col = colorStates[coor[0] - 1][coor[1]];
                    }else{
                        colorStates[coor[0] - 1][coor[1]] = 0;
                        col = colorStates[coor[0] - 1][coor[1]];
                    }
                    current[coor[0] - 1][coor[1]].setColorFilter(Color.argb(255, order[col], order[col], order[col]));
                }

                if (coor[1] + 1 < 4) {
                    if(colorStates[coor[0]][coor[1] + 1] < 2) {
                        colorStates[coor[0]][coor[1] + 1]++;
                        col = colorStates[coor[0]][coor[1] + 1];
                    }else{
                        colorStates[coor[0]][coor[1] + 1] = 0;
                        col = colorStates[coor[0]][coor[1] + 1];
                    }
                    current[coor[0]][coor[1] + 1].setColorFilter(Color.argb(255, order[col], order[col], order[col]));
                }

                if (coor[1] - 1 >= 0){
                    if(colorStates[coor[0]][coor[1] - 1] < 2) {
                        colorStates[coor[0]][coor[1] - 1]++;
                        col = colorStates[coor[0]][coor[1] - 1];
                    }else{
                        colorStates[coor[0]][coor[1] - 1] = 0;
                        col = colorStates[coor[0]][coor[1] - 1];
                    }
                    current[coor[0]][coor[1] - 1].setColorFilter(Color.argb(255, order[col], order[col], order[col]));
                }

                colorStates[coor[0]][coor[1]] = 0;
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

   /* public void sendMessage(){
        Intent intent = new Intent(this,DisplayMessageActivity.class);
        EditText editText = (EditText)findViewById(R.id.editText1);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }*/


    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        private static final String DEBUG_TAG = "Gestures";

        @Override
        public boolean onDown(MotionEvent event){
          Log.d(DEBUG_TAG,"onDown: "+ event.toString());
           return true;
        }

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY){
            Log.d(DEBUG_TAG, "onFling: " + event1.toString() + event2.toString());
            return true;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Opening Settings...", Toast.LENGTH_LONG).show();
            return true;
        }

        if(id == R.id.action_search){
            Toast.makeText(this,"Opening Search...",Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
