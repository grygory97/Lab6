package lh.grzegorzszawula.lab5;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                //TODO:zmiana koloru on fly dla widocznego fragmentu
               /* FragmentManager fragment = (FragmentManager) getFragmentManager().
                        findFragmentById(R.id.nav_host_fragment);
                if (fragment==null) {
                    fragment.getView().setBackgroundColor();
                }
                }*/

                FragmentManager f=getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment).getChildFragmentManager();
                List<Fragment> frag=f.getFragments();
                String str="";
                for (Fragment fragment : frag)
                {
                    if(fragment.isVisible())
                    {
                        fragment.getView().setBackgroundColor(getRandomColor());
                        str=fragment.getChildFragmentManager().toString();
                        if(fragment.getChildFragmentManager().toString().contains("SecondFragment"))
                        {
                            str="SecondFragment";
                        }
                        if(fragment.getChildFragmentManager().toString().contains("FirstFragment"))
                        {
                            str="FirstFragment";
                        }
                        if(fragment.getChildFragmentManager().toString().contains("ThirdFragment"))
                        {
                            str="ThirdFragment";

                        }
                    }
                }
            }

            public int getRandomColor() {
                Random rnd = new Random();
                return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            }
        });
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

        switch (id) {
            case R.id.action_frag1:
                NavHostFragment.findNavController(getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).navigate(R.id.action_show_f1);
                return true;
            case R.id.action_frag2:
                NavHostFragment.findNavController(getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).navigate(R.id.action_show_f2);
                return true;
            case R.id.action_frag3:
                NavHostFragment.findNavController(getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).navigate(R.id.action_show_f3);
                return true;
            case R.id.action_info:
                Snackbar.make(this.findViewById(R.id.id_layout), getText(R.string.snackbar_info_autor), Snackbar.LENGTH_LONG).show();
                return true;
            case R.id.action_settings:
                Snackbar.make(this.findViewById(R.id.id_layout), getText(R.string.snackbar_settings), Snackbar.LENGTH_LONG).show();
                return true;
            case R.id.action_finish:
                Snackbar.make(this.findViewById(R.id.id_layout), getText(R.string.snackbar_finish_app), Snackbar.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
