package captainhampton.pi.trainer;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONObject;

import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.Facebook.DialogListener;
import com.facebook.android.FacebookError;
import com.facebook.android.Util;

import captainhampton.pi.trainer.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Marathon extends Activity implements OnClickListener {

	Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bDecimal;
	EditText etPi;
	TextView tvHighScore, tvHighestScore, tvCurrentDigit;
	Vibrator vibrator;
	

	Facebook fb;	
	SharedPreferences sp; 
	AsyncFacebookRunner asyncRunner; 
	
	final Context context = this;
	
	String userInput = "";
	String pi = "3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648566923460348610454326648213393607260249141273724587006";
	int count = 0;
	int highScore = 0, highestScore = 0;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.marathon);
        setupVariables();
    }
    
    private void setupVariables() {
    	
    	String APP_ID = getString(R.string.APP_ID);
    	Utility.fb = new Facebook(APP_ID);   
    	Utility.asyncRunner = new AsyncFacebookRunner(fb);
    	
    	sp = getPreferences(MODE_PRIVATE);
    	String access_token = sp.getString("access_token", null);
    	long expires = sp.getLong("access_expires", 0);
    	
    	if (access_token != null) {
    		Utility.fb.setAccessToken(access_token);
    	}
    	
    	if (expires != 0) {
    		Utility.fb.setAccessExpires(expires);
    	}
    	    	
    	b0 = (Button)findViewById(R.id.b0);
    	b0.setOnClickListener(this);
    	
    	b1 = (Button)findViewById(R.id.b1);
    	b1.setOnClickListener(this);
    	
    	b2 = (Button)findViewById(R.id.b2);
    	b2.setOnClickListener(this);
    	
    	b3 = (Button)findViewById(R.id.b3);
    	b3.setOnClickListener(this);
    	
    	b4 = (Button)findViewById(R.id.b4);
    	b4.setOnClickListener(this);
    	
    	b5 = (Button)findViewById(R.id.b5);
    	b5.setOnClickListener(this);
    	
    	b6 = (Button)findViewById(R.id.b6);
    	b6.setOnClickListener(this);
    	
    	b7 = (Button)findViewById(R.id.b7);
    	b7.setOnClickListener(this);
    	
    	b8 = (Button)findViewById(R.id.b8);
    	b8.setOnClickListener(this);
    	
    	b9 = (Button)findViewById(R.id.b9);
    	b9.setOnClickListener(this);
    	
    	bDecimal = (Button)findViewById(R.id.bDecimal);
    	bDecimal.setOnClickListener(this);
    
    	etPi = (EditText)findViewById(R.id.etPi);			
   
    	tvHighScore = (TextView)findViewById(R.id.tvHighScore);
    	tvCurrentDigit = (TextView)findViewById(R.id.tvCurrentDigit);
    	//tvHighestScore = (TextView)findViewById(R.id.tvHighestScore);
    	
    	vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
    	      	  	
    }



	public void onClick(View v) {
		
		
		if (b0.isPressed()) {
			if (isCorrectInput('0')) {
				userInput += "0";
				etPi.setText(userInput);
			} else {
				incorrectInput('0');
			}
		}
		
		if (b1.isPressed()) {
			if (isCorrectInput('1')) {
				userInput += "1";
				etPi.setText(userInput);
			} else {
				incorrectInput('1');
			}
		}
		
		if (b2.isPressed()) {
			if (isCorrectInput('2')) {
				userInput += "2";
				etPi.setText(userInput);
			} else {
				incorrectInput('2');
			}
		}
		
		if (b3.isPressed()) {
			if (isCorrectInput('3')) {
				userInput += "3";
				etPi.setText(userInput);
			} else {
				incorrectInput('3');
			}
		}
		
		if (b4.isPressed()) {
			if (isCorrectInput('4')) {
				userInput += "4";
				etPi.setText(userInput);
			} else {
				incorrectInput('4');
			}
		}
		
		if (b5.isPressed()) {
			if (isCorrectInput('5')) {
				userInput += "5";
				etPi.setText(userInput);
			} else {
				incorrectInput('5');
			}
		}
		
		if (b6.isPressed()) {
			if (isCorrectInput('6')) {
				userInput += "6";
				etPi.setText(userInput);
			} else {
				incorrectInput('6');
			}
		}
		
		if (b7.isPressed()) {
			if (isCorrectInput('7')) {
				userInput += "7";
				etPi.setText(userInput);
			} else {
				incorrectInput('7');
			}
		}
		
		if (b8.isPressed()) {
			if (isCorrectInput('8')) {
				userInput += "8";
				etPi.setText(userInput);
			} else {
				incorrectInput('8');
			}
		}
		
		if (b9.isPressed()) {
			if (isCorrectInput('9')) {
				userInput += "9";
				etPi.setText(userInput);
			} else {
				incorrectInput('9');
			}
		}
		
		if (bDecimal.isPressed()) {
			if (isCorrectInput('.')) {
				userInput += ".";
				etPi.setText(userInput);
			} else {
				incorrectInput('.');
			}
		}
		
		etPi.setSelection(etPi.getText().length());
	}
		
	private boolean isCorrectInput(Character piDigit) {
		
		if (piDigit == pi.charAt(count)) {
			count++;
			tvCurrentDigit.setText(Integer.toString(count));
			return true;
		}	
		return false;
	}
		
	private void incorrectInput(Character incorrectDigit) {
		
		// Vibrate phone to indicate loss.
		vibrator.vibrate(500);

		
		// Display dialog allowing user to try again.
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
		
		alertDialogBuilder.setTitle("Try Again?");
		alertDialogBuilder.setMessage("Score: "+count+"\n" + "You entered "+ incorrectDigit +", instead of " + pi.charAt(count)  + " \n").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int id) {
				updateHighScore();
				etPi.setText("");
				userInput = "";
				count = 0;
			}
		}).setNeutralButton("Post to Facebook", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				
				etPi.setText("");
				userInput = "";
				int fbCount = count;
				count = 0;
								
				// Post score to High Score to Facebook
				if (Utility.fb.isSessionValid()) {
					//button close our session - log out of facebook
					try {
						Utility.fb.logout(getApplicationContext());
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					// login to facebook
										
					
					Bundle params = new Bundle();
					params.putString("name", "Download Pi Trainer");
					params.putString("caption", "Pi Trainer - by captainhampton");
					params.putString("description", "Was able to recite "+Integer.toString(fbCount)+" digits of Pi. Wow! You must get all the ladies!");
					params.putString("link", "https://play.google.com/store/apps/details?id=captainhampton.pi.trainer&hl=en");
					params.putString("picture", "https://lh5.ggpht.com/hA5Q_91wpB9ibgA9-MdxlWwFaU8PjS5Jwm_yVZ6vShqLB4cSa5GM0jWnOjM_QaBgU7M=w124");
					
					
					Utility.fb.dialog(Marathon.this, "feed", params, new DialogListener() {

						public void onComplete(Bundle values) {
							Editor editor = sp.edit();
							editor.putString("access_token", Utility.fb.getAccessToken());
							editor.putLong("access_expires", Utility.fb.getAccessExpires());
							editor.commit();
						}

						public void onFacebookError(FacebookError e) {
							//Toast.makeText(Marathon.this, "fbError", Toast.LENGTH_SHORT).show();
							
						}

						public void onError(DialogError e) {
							//Toast.makeText(Marathon.this, "onError", Toast.LENGTH_SHORT).show();
							
						}

						public void onCancel() {
							//Toast.makeText(Marathon.this, "onCancel", Toast.LENGTH_SHORT).show();
							
						}
					
					});
				}
			}
		})
		.setNegativeButton("No", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				Marathon.this.finish();				
			}
		}); 
		
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Utility.fb.authorizeCallback(requestCode, resultCode, data);
	}
	
	private void updateHighScore() {
	
    	//SharedPreferences.Editor editor = prefs.edit();
    	//editor.putInt("highestScore", highScore);
    	//editor.commit();
        
		if (count > highScore) {
			highScore = count;
			tvHighScore.setText(Integer.toString(highScore));
		}
		
	}
	
}
