package captainhampton.pi.trainer;

import captainhampton.pi.trainer.R;
import captainhampton.pi.trainer.R.color;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Train extends Activity implements OnClickListener {

	Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bDecimal;
	EditText etPi;
	TextView tvHighScore, tvHighestScore, tvCurrentDigit;
	Vibrator vibrator;
	
	SharedPreferences prefs; 
	
	final Context context = this;
	
	String userInput = "";
	String pi = "3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428810975665933446128475648233786783165271201909145648566923460348610454326648213393607260249141273724587006";
	int count = 0;
	int highScore = 0, highestScore = 0;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train);
        setupVariables();
    }
    
    private void setupVariables() {
    	
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
	}
	
	
	private void updateHighScore() {
        
		if (count > highScore) {
			highScore = count;
			tvHighScore.setText(Integer.toString(highScore));
		}
		
	}
	
}
