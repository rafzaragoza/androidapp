package net.androidbootcamp.weddingphotographyapp;

//import android.support.v7.app.ActionBarActivity;import android.app.Activity;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends Activity {
	Integer[] Wedding ={R.drawable.cave, R.drawable.garden, R.drawable.hallway, R.drawable.hug, R.drawable.post};
		//R.drawable.queen, R.drawable.sitting, R.drawable.sunset, R.drawable.umbrella, R.drawable.walking};
	ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gr = (GridView)findViewById(R.id.gridView1);
        final ImageView pic = (ImageView)findViewById(R.id.imgLarge);
        gr.setAdapter(new ImageAdapter(this));
        gr.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arag0,View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
			Toast.makeText(getBaseContext(), "Selected Wedding Picture" + (arg2 +1), Toast.LENGTH_SHORT).show();	
			pic.setImageResource(Wedding[arg2]);
			}
        	
        });
    }
    public class ImageAdapter extends BaseAdapter{
    	private Context context;
		public ImageAdapter( Context c) {
			// TODO Auto-generated constructor stub
			context = c;
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return Wedding.length;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			// TODO Auto-generated method stub
			pic = new ImageView (context);
			pic.setImageResource(Wedding[arg0]);
			pic.setScaleType(ImageView.ScaleType.FIT_XY);
			pic.setLayoutParams(new GridView.LayoutParams(188,200));
			return pic;
		}
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
