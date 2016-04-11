package bfergus.androidruler.Main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView;

import bfergus.androidruler.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView{

    MainPresenter presenter;

    @Bind(R.id.inchesTV)
    TextView inchTextView;

    @Bind(R.id.milimetersTV)
    TextView mmTextView;

    @Bind(R.id.centimetersTV)
    TextView cmTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenterImpl(this);
    }

    public void setInchTextView(String s) {
        inchTextView.setText(s);
    }

    public void setCmTextView(String s) {
       cmTextView.setText(getString(R.string.centimeter_calculation, ":", s));
    }

    public void setMmTextView(String s) {
        mmTextView.setText(getString(R.string.millimeter_calculation, ":", s));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        presenter.getTouchHorizontalLocation(event.getX());
        return true;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
