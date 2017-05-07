package mitru.com.mvvmapplication.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Observable;
import java.util.Observer;

import mitru.com.mvvmapplication.R;

public class PeopleActivity extends AppCompatActivity implements Observer{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
