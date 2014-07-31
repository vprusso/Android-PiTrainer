package captainhampton.pi.trainer;


import captainhampton.pi.trainer.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Pi_TrainerActivity extends Activity implements OnClickListener {
	
	Button bTrainer, bMarathon, bMemorize, bAbout;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setupVariables();
    }
    
    private void setupVariables() {
		
    //	AdView ad = (AdView)findViewById(R.id.adMain);
    //	ad.loadAd(new AdRequest());
    	
		bMarathon = (Button)findViewById(R.id.bMarathon);
		bMarathon.setOnClickListener(this);
		
		bTrainer = (Button)findViewById(R.id.bTrainer);
		bTrainer.setOnClickListener(this);
		
		bMemorize = (Button)findViewById(R.id.bMemorize);
		bMemorize.setOnClickListener(this);
    	
    	bAbout = (Button)findViewById(R.id.bAbout);
		bAbout.setOnClickListener(this);

		
    }

	public void onClick(View v) {
		
		if (bMarathon.isPressed()) {
			Intent marathonIntent = new Intent("android.intent.action.MARATHON");
			startActivity(marathonIntent);
		}
		
		if (bTrainer.isPressed()) {
			Intent trainerIntent = new Intent("android.intent.action.TRAIN");
			startActivity(trainerIntent);
		}
		
		if (bMemorize.isPressed()) {
			Intent memorizeIntent = new Intent("android.intent.action.MEMORIZE");
			startActivity(memorizeIntent);
		}
		
		if(bAbout.isPressed()) {
			Intent aboutIntent = new Intent("android.intent.action.ABOUT");
			startActivity(aboutIntent);
		}
						
	}
}