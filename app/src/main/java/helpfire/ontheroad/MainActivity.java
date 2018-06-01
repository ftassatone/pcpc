package helpfire.ontheroad;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.compila_report, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == android.R.id.home){
            Intent vaiReport = NavUtils.getParentActivityIntent(this);
            /*vaiReport.putExtra("Materia", HomeClasse.materia);
            vaiReport.putExtra("Classe", HomeClasse.classe);*/
            if (NavUtils.shouldUpRecreateTask(this, vaiReport)) {
                TaskStackBuilder.create(this).addNextIntentWithParentStack(vaiReport).startActivities();
            } else {
                NavUtils.navigateUpTo(this, vaiReport);
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
